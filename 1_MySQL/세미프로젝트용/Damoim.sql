-- drop schema damoim;
-- create schema damoim;
-- INSERT INTO member(id,pwd,addr,phone,email,name,age,gender) VALUES ('asd','123','경기도','010-1111-2222','sdm@gmail.com','감자',22 ,'M');

-- _은 자바 타입으로 매핑 해줘야 한다 

INSERT INTO member(id,pwd,addr,phone,email,name,age,gender) VALUES ('asd','123','경기도','010-1111-2222','sdm@gmail.com','감자',22 ,'M');

-- _은 자바 타입으로 매핑 해줘야 한다 

CREATE TABLE member ( -- 회원가입
    id VARCHAR(50) PRIMARY KEY, -- 아이디
    pwd VARCHAR(255) NOT NULL, -- 비밀번호
    addr VARCHAR(255), -- 주소
    phone VARCHAR(20), -- 전화번호
    email VARCHAR(100), -- 이메일
    name VARCHAR(50), -- 이름
    age INT, -- 나이
    gender CHAR(1), -- 성별 M/F
    status BOOLEAN DEFAULT TRUE, -- 유저 가입,탈퇴 여부
	member_manner DECIMAL(4,2) DEFAULT (36.50), -- 유저온도 0.00 ~ 99.99까지가능
    nickname VARCHAR(50) UNIQUE, -- 닉네임
    member_img VARCHAR(255), -- 유저프로필사진
    member_hobby TEXT, -- 유저 관심사
    member_info TEXT -- 유저 간단한 자기소개

    
    
);

CREATE TABLE type_category ( -- 유형 분류
    type_code INT PRIMARY KEY auto_increment, -- 소분류코드
    type_la_name VARCHAR(50),
    type_s_name VARCHAR(50) -- 소분류이름
);

CREATE TABLE location_category ( -- 위치 분류
    loc_code INT PRIMARY KEY auto_increment, -- 위치 분류 코드
	loc_la_name VARCHAR(50), -- ex) 서울 , 경기, 부산, 강원
    loc_s_name VARCHAR(50) -- 위치소분류 ex) 서울이면 강남구, 서초구  경기면 성남시, 부천시 이런식으로
);
CREATE TABLE membership ( -- 클럽
    membership_code INT PRIMARY KEY auto_increment, -- 클럽코드
    membership_name VARCHAR(100) UNIQUE, -- 클럽이름
    membership_img TEXT, -- 클럽메인사진
	membership_info TEXT, -- 클럽소개
    membership_date DATE DEFAULT(current_date), -- 클럽생성날짜
    membership_grade DECIMAL(2,1) DEFAULT(0), -- 클럽 별점
    membership_max INT -- 클럽최대인원
);
CREATE TABLE membership_type  ( -- 클럽 유형 리스트
    mem_type_code INT PRIMARY KEY auto_increment, -- 클럽 유형 리스트 코드
    type_code INT, -- 소분류이름 / 외래키
    membership_code INT -- 클럽 /외래키
);
CREATE TABLE membership_location  ( -- 클럽 지역 리스트
    mem_loc_code INT PRIMARY KEY auto_increment, -- 클럽 지역 리스트 코드
    loc_code INT, -- 소분류 / 외래키
    membership_code INT -- 클럽 /외래키
);


CREATE TABLE membership_user_list( -- 클럽유저정보
    list_code INT PRIMARY KEY auto_increment, -- 클럽가입한 멤버코드
    list_grade VARCHAR(50), -- 멤버등급 호스트, 관리자, 일반회원, 비회원(신청만한사람)
    id VARCHAR(50), -- 유저코드 /외래키
    membership_code INT -- 클럽코드 /외래키
);


CREATE TABLE channel ( -- 클럽채널
    chan_code INT PRIMARY KEY auto_increment, -- 클럽채널코드
    chan_name VARCHAR(100), -- 채널명
    chan_img TEXT, -- 채널 사진
    id VARCHAR(50), -- 유저코드 /외래키
    membership_code INT -- 클럽코드 /외래키
);



CREATE TABLE membership_meetings ( -- 클럽모임게시판
    meet_code INT PRIMARY KEY auto_increment, -- 모임게시판코드
    membership_code INT, -- 클럽코드 /외래키
    meet_date_start DATE, -- 모임 시작일
    meet_date_end DATE, -- 모임 종료일
    meet_agree_code INT, -- 참여여부 테이블 연결
    meet_info longTEXT, -- 모임관련 정보
    meet_creat_date DATE default(current_date),
    id VARCHAR(50),
    color VARCHAR(50)
);

CREATE TABLE meetings_agree (-- 클럽 모임게시판 - 클럽 회원 리스트 참여여부 테이블 
	meet_agree_code INT PRIMARY KEY auto_increment,
    meet_agree_yn BOOLEAN DEFAULT(false),
    id VARCHAR(50),
    meet_code INT
);



-- 클럽 모임 게시판에 댓글기능 추가 
CREATE TABLE meetings_comment (
    meet_comment_code INT PRIMARY KEY auto_increment, -- 댓글코드
    meet_comment_text TEXT, -- 모임게시판 댓글 내용
    meet_comment_date DATE DEFAULT(current_date), -- 댓글 게시시간
	id VARCHAR(50), --  /외래키  누가 ?
	meet_code INT, -- /왜래키 어떤클럽 홍보 게시판?
	meet_parents_comment_code INT -- /대댓글

);



-- 확정
CREATE TABLE main_comment (
    main_comment_code INT PRIMARY KEY auto_increment, -- 댓글코드
    main_comment_text TEXT, -- 홍보게시판 댓글 내용
    main_comment_date DATE DEFAULT(current_date), -- 댓글 게시시간
	id VARCHAR(50), --  /외래키  누가 ?
	membership_code INT, -- /왜래키 어떤클럽 홍보 게시판?
	main_parents_comment_code INT -- /대댓글

);







ALTER TABLE membership_type ADD  FOREIGN KEY (type_code) REFERENCES type_category(type_code);
ALTER TABLE membership_type ADD  FOREIGN KEY (membership_code) REFERENCES membership(membership_code);

ALTER TABLE membership_location ADD  FOREIGN KEY (loc_code) REFERENCES location_category(loc_code);
ALTER TABLE membership_location ADD  FOREIGN KEY (membership_code) REFERENCES membership(membership_code);

ALTER TABLE membership_user_list ADD  FOREIGN KEY (id) REFERENCES member(id);
ALTER TABLE membership_user_list ADD  FOREIGN KEY (membership_code) REFERENCES membership(membership_code);

ALTER TABLE channel ADD  FOREIGN KEY (id) REFERENCES member(id);
ALTER TABLE channel ADD  FOREIGN KEY (membership_code) REFERENCES membership(membership_code);

ALTER TABLE membership_meetings ADD  FOREIGN KEY (membership_code) REFERENCES membership(membership_code);
ALTER TABLE membership_meetings ADD  FOREIGN KEY (meet_agree_code) REFERENCES meetings_agree(meet_agree_code);

ALTER TABLE meetings_agree ADD  FOREIGN KEY (list_code) REFERENCES membership_user_list(list_code);

ALTER TABLE meetings_comment ADD  FOREIGN KEY (id) REFERENCES member(id);
ALTER TABLE meetings_comment ADD  FOREIGN KEY (meet_code) REFERENCES membership_meetings(meet_code) ON DELETE CASCADE;
ALTER TABLE meetings_comment ADD  FOREIGN KEY (meet_parents_comment_code) REFERENCES meetings_comment(meet_comment_code);


ALTER TABLE main_comment ADD  FOREIGN KEY (id) REFERENCES member(id);
ALTER TABLE main_comment ADD  FOREIGN KEY (membership_code) REFERENCES membership(membership_code);
ALTER TABLE main_comment ADD  FOREIGN KEY (main_parents_comment_code) REFERENCES main_comment(main_comment_code);



ALTER TABLE image ADD  FOREIGN KEY (meet_code) REFERENCES membership_meetings(meet_code);
ALTER TABLE image ADD  FOREIGN KEY (membership_code) REFERENCES membership(membership_code);

ALTER TABLE membership_meetings ADD list_code INT;

ALTER TABLE membership_meetings ADD  FOREIGN KEY (list_code) REFERENCES membership_user_list(list_code);
-- 지피티 구문
-- membership_type 테이블의 외래 키 제약 조건 추가 (type_code 참조)
ALTER TABLE membership_type
ADD FOREIGN KEY (type_code) REFERENCES type_category(type_code);

-- membership_type 테이블의 외래 키 제약 조건 추가 (membership_code 참조)
ALTER TABLE membership_type
ADD FOREIGN KEY (membership_code) REFERENCES membership(membership_code);

-- membership_location 테이블의 외래 키 제약 조건 추가 (loc_code 참조)
ALTER TABLE membership_location
ADD FOREIGN KEY (loc_code) REFERENCES location_category(loc_code);

-- membership_location 테이블의 외래 키 제약 조건 추가 (membership_code 참조)
ALTER TABLE membership_location
ADD FOREIGN KEY (membership_code) REFERENCES membership(membership_code);

-- membership_user_list 테이블의 외래 키 제약 조건 추가 (id 참조)
ALTER TABLE membership_user_list
ADD FOREIGN KEY (id) REFERENCES member(id);

-- membership_user_list 테이블의 외래 키 제약 조건 추가 (membership_code 참조)
ALTER TABLE membership_user_list
ADD FOREIGN KEY (membership_code) REFERENCES membership(membership_code);

-- channel 테이블의 외래 키 제약 조건 추가 (id 참조)
ALTER TABLE channel
ADD FOREIGN KEY (id) REFERENCES member(id);

-- channel 테이블의 외래 키 제약 조건 추가 (membership_code 참조)
ALTER TABLE channel
ADD FOREIGN KEY (membership_code) REFERENCES membership(membership_code);

-- membership_meetings 테이블의 외래 키 제약 조건 추가 (membership_code 참조)
ALTER TABLE membership_meetings
ADD FOREIGN KEY (membership_code) REFERENCES membership(membership_code);


-- meetings_agree 테이블의 외래 키 제약 조건 추가 (list_code 참조) -- 변경 id 참조
ALTER TABLE meetings_agree
ADD FOREIGN KEY (id) REFERENCES member(id);

-- meetings_comment 테이블의 외래 키 제약 조건 추가 (id 참조)
ALTER TABLE meetings_comment
ADD FOREIGN KEY (id) REFERENCES member(id);

-- meetings_comment 테이블의 외래 키 제약 조건 추가 (meet_code 참조)
ALTER TABLE meetings_comment
ADD FOREIGN KEY (meet_code) REFERENCES membership_meetings(meet_code);

-- meetings_comment 테이블의 외래 키 제약 조건 추가 (meet_parents_comment_code 참조)
ALTER TABLE meetings_comment
ADD FOREIGN KEY (meet_parents_comment_code) REFERENCES meetings_comment(meet_comment_code);

-- main_comment 테이블의 외래 키 제약 조건 추가 (id 참조)
ALTER TABLE main_comment
ADD FOREIGN KEY (id) REFERENCES member(id);

-- main_comment 테이블의 외래 키 제약 조건 추가 (membership_code 참조)
ALTER TABLE main_comment
ADD FOREIGN KEY (membership_code) REFERENCES membership(membership_code);

-- main_comment 테이블의 외래 키 제약 조건 추가 (main_parents_comment_code 참조)
-- ALTER TABLE main_comment
-- ADD FOREIGN KEY (main_parents_comment_code) REFERENCES main_comment(main_comment_code);

-- SELECT * FROM information_schema.table_constraints WHERE CONSTRAINT_SCHEMA = 'damoim' AND TABLE_NAME = 'main_comment';
-- ALTER TABLE main_comment DROP CONSTRAINT main_comment_ibfk_3;

DELETE FROM main_comment WHERE main_comment_code = 1;

SELECT * FROM main_comment;


-- image 테이블의 외래 키 제약 조건 추가 (meet_code 참조)
ALTER TABLE image
ADD FOREIGN KEY (meet_code) REFERENCES membership_meetings(meet_code);

-- image 테이블의 외래 키 제약 조건 추가 (membership_code 참조)
ALTER TABLE image
ADD FOREIGN KEY (membership_code) REFERENCES membership(membership_code);

-- membership_meetings 테이블에 list_code 컬럼 추가
ALTER TABLE membership_meetings
ADD id VARCHAR(50);

-- membership_meetings 테이블의 외래 키 제약 조건 추가 (list_code 참조)
ALTER TABLE membership_meetings
ADD FOREIGN KEY (id) REFERENCES member(id);

-- meetings_agree 테이블에 외래키 제약 조건 추가 (membership_meetings의 meet_code)
ALTER TABLE meetings_agree
ADD FOREIGN KEY (meet_code) 
REFERENCES membership_meetings (meet_code)
ON DELETE CASCADE;

ALTER TABLE membership
ADD column membership_accession_text text,
ADD column membership_simple_text VARCHAR(255);


ALTER TABLE membership DROP COLUMN memership_main_text;
ALTER TABLE membership_meetings
ADD column meet_title VARCHAR(50);

ALTER TABLE member
ADD COLUMN last_recommendation_time TIMESTAMP NULL DEFAULT NULL;
 
 -- 이메일에 유니크 제약 조건 추가 -- 
 alter table member ADD unique key (email);
 
 
 
 
update member
set last_recommendation_time = now()
where id = 'user001';

select * from member where id = 'user001';
CREATE EVENT update_recommendations_test2
ON SCHEDULE EVERY 1 day
DO
  UPDATE member
  SET last_recommendation_time = NULL
  WHERE last_recommendation_time IS NOT NULL
    AND last_recommendation_time < NOW() - INTERVAL 1 day;


SHOW VARIABLES LIKE 'event%';
SELECT * FROM information_schema.events;

SELECT * FROM membership_meetings;
show variables like '%dir';

SELECT count(*) FROM main_comment 
WHERE main_parents_comment_code = 4;

ALTER TABLE membership
MODIFY COLUMN membership_info LONGTEXT;

