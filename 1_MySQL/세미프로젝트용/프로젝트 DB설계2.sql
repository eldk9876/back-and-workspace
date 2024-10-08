-- drop schema pro;
-- create schema pro;
DROP TABLE sign_up;
DROP TABLE type_category_large;
DROP TABLE type_category_small;
DROP TABLE location_category_large;
DROP TABLE location_category_small;
DROP TABLE user;
DROP TABLE membership;
DROP TABLE membership_type;
DROP TABLE membership_location;
DROP TABLE membership_user_list;
DROP TABLE channel;
DROP TABLE meetings;
DROP TABLE main;
DROP TABLE comment;
DROP TABLE img;

SELECT * FROM sign_up;
SELECT * FROM type_category_large;
SELECT * FROM type_category_small;
SELECT * FROM location_category_large;
SELECT * FROM location_category_small;
SELECT * FROM user;
SELECT * FROM membership;
SELECT * FROM membership_type;
SELECT * FROM membership_location;
SELECT * FROM membership_user_list;
SELECT * FROM channel;
SELECT * FROM meetings;
SELECT * FROM main;
SELECT * FROM comment;
SELECT * FROM img;



CREATE TABLE sign_up ( -- 회원가입
    id VARCHAR(50) PRIMARY KEY, -- 아이디
    pwd VARCHAR(255) NOT NULL, -- 비밀번호
    addr VARCHAR(255), -- 주소
    phone VARCHAR(20), -- 전화번호
    email VARCHAR(100) UNIQUE, -- 이메일
    name VARCHAR(50), -- 이름
    age INT, -- 나이
    gender CHAR(1), -- 성별 M/F
    status BOOLEAN DEFAULT TRUE -- 유저 가입,탈퇴 여부
);

-- 회원가입
-- 필요기능 아이디 잊어버렸을때 전화번호나 이메일로 코드 보내서 일치하면 찾을수 있게 
-- 비밀번호 잊어버렸을때 아이디와 이메일을 입력해서 이메일로 코드 받은 후 받은 코드 사용하면 재설정 가능하게(임시 비밀번호발급도 가능)
-- 비밀번호, 주소, 이메일 변경가능하게 만들기 



CREATE TABLE type_category_large ( -- 유형대분류
    type_la_code INT PRIMARY KEY auto_increment, -- 대분류코드 mc 메인카테고리 줄임말
    type_la_name VARCHAR(50) UNIQUE -- 대분류이름
);
SELECT * 
FROM type_category_large;

CREATE TABLE type_category_small  ( -- 유형소분류
    type_s_code INT PRIMARY KEY auto_increment, -- 소분류코드
    type_s_name VARCHAR(50) UNIQUE, -- 소분류이름
    type_la_code INT -- 대분류코드 /외래키
    
);
-- 위치,유형 대분류 소분류
-- 대분류,소분류 분류별로 선택 가능하게(중복선택도 가능??위치는 중복설정 불가능하게) 

CREATE TABLE location_category_large ( -- 위치대분류
    loc_la_code INT PRIMARY KEY auto_increment, -- 위치대분류코드 -- 대분류코드 ml 메인지역 줄임말
    loc_la_name VARCHAR(50) -- 위치대분류이름
);
CREATE TABLE location_category_small ( -- 위치소분류
    loc_s_code INT PRIMARY KEY auto_increment, -- 위치소분류코드
    loc_s_name VARCHAR(50), -- 위치소분류이름
    loc_la_code INT -- 위치대분류코드 /외래키
);


CREATE TABLE user ( -- 유저
    user_code INT PRIMARY KEY auto_increment, -- 유저코드
    id VARCHAR(50), -- 유저아이디 /외래키
    user_manner DECIMAL(4,2) DEFAULT (36.50), -- 유저온도 0.00 ~ 99.99까지가능
    user_name VARCHAR(50), -- 닉네임
    user_img VARCHAR(255), -- 유저프로필사진
    user_hobby TEXT, -- 유저 관심사
    user_info TEXT, -- 유저 간단한 자기소개
    user_location VARCHAR(100), -- 유저선호지역
    user_type VARCHAR(100) -- 유저 선호만남유형
);
-- 프로필 사진,관심사,자기소개,선호지역,선호만남유형 변경 가능하게(선호지역과 손호 만남은 중복가능하게?? )

CREATE TABLE membership ( -- 클럽
    membership_code INT PRIMARY KEY auto_increment, -- 클럽코드
    membership_Name VARCHAR(100) UNIQUE, -- 클럽이름
    membership_img TEXT, -- 클럽메인사진
	membership_info TEXT, -- 클럽소개
    membership_DATE DATE DEFAULT(current_date), -- 클럽생성날짜
    membership_grade DECIMAL(2,1) DEFAULT(0), -- 클럽 별점
    membership_max INT -- 클럽최대인원

);


CREATE TABLE membership_type  ( -- 클럽 유형 리스트
    mem_type_code INT PRIMARY KEY auto_increment, -- 클럽 유형 리스트 코드
    type_s_code INT, -- 소분류이름 / 외래키
    membership_code INT -- 클럽 /외래키
);


CREATE TABLE membership_location  ( -- 클럽 지역 리스트
    mem_loc_code INT PRIMARY KEY auto_increment, -- 클럽 지역 리스트 코드
    loc_s_code INT, -- 소분류 / 외래키
    membership_code INT -- 클럽 /외래키
);


CREATE TABLE membership_user_list( -- 클럽유저정보
    list_code INT PRIMARY KEY auto_increment, -- 클럽가입한 멤버코드
    list_grade VARCHAR(50), -- 멤버등급 호스트, 관리자, 일반회원, 비회원(신청만한사람)
    user_code INT, -- 유저코드 /외래키
    membership_code INT -- 클럽코드 /외래키
);


CREATE TABLE channel ( -- 클럽채널
    chan_code INT PRIMARY KEY auto_increment, -- 클럽채널코드
    chan_name VARCHAR(100), -- 채널명
    chan_img TEXT, -- 채널 사진
    user_code INT, -- 유저코드 /외래키
    membership_code INT -- 클럽코드 /외래키
);



CREATE TABLE meetings ( -- 클럽모임게시판
    meet_code INT PRIMARY KEY auto_increment, -- 모임게시판코드
    membership_code INT, -- 클럽코드 /외래키
    meet_calendar DATE, -- 캘린더
    meet_yn BOOLEAN, -- 참여여부
    meet_info TEXT -- 모임관련 정보
);
-- 클럽 모임 게시판
-- 조회수나 추천 수가 많을 경우 상단으로 올라가게??

CREATE TABLE main ( -- 클럽홍보게시판
	main_code INT PRIMARY KEY auto_increment, -- 홍보게시판코드
    membership_code INT UNIQUE, -- 클럽코드 /외래키
    main_name VARCHAR(255), -- 홍보글제목
    main_text TEXT, -- 홍보내용
    main_views INT, -- 조회수
    main_date DATE DEFAULT(current_date), -- 홍보글게시날짜
    user_code INT  -- 유저 코드 / 외래키

);
-- 조회수나 추천 수가 많을 경우 상단으로 올라가게??

-- 확정
CREATE TABLE comment (
    comment_code INT PRIMARY KEY auto_increment, -- 댓글코드
    comment_text TEXT, -- 홍보게시판 댓글 내용
    comment_date DATE DEFAULT(current_date), -- 댓글 게시시간
	user_code INT, --  /외래키  누가 ?
	main_code INT, -- /왜래키 어떤클럽 홍보 게시판?
	parents_comment_code INT -- /대댓글

);

 -- 확정
CREATE TABLE img ( -- 사진 테이블
    img_code INT PRIMARY KEY auto_increment, -- 사진코드
	img_url VARCHAR(255), -- 사진
	main_code INT, -- 홍보게시판코드 / 외래키
    meet_code INT -- 모임게시판코드 / 외래키
);

-- 조회수나 추천 수가 많을 경우 상단으로 올라가게??

ALTER TABLE user ADD FOREIGN KEY (id) REFERENCES sign_up (id);

ALTER TABLE type_category_small ADD FOREIGN KEY (type_la_code) REFERENCES type_category_large(type_la_code); 

ALTER TABLE location_category_small ADD FOREIGN KEY (loc_la_code) REFERENCES location_category_large(loc_la_code);


ALTER TABLE membership_type ADD  FOREIGN KEY (type_s_code) REFERENCES type_category_small(type_s_code);
ALTER TABLE membership_type ADD  FOREIGN KEY (membership_code) REFERENCES membership(membership_code);

ALTER TABLE membership_location ADD  FOREIGN KEY (loc_s_code) REFERENCES location_category_small(loc_s_code);
ALTER TABLE membership_location ADD  FOREIGN KEY (membership_code) REFERENCES membership(membership_code);

ALTER TABLE membership_user_list ADD  FOREIGN KEY (user_code) REFERENCES user(user_code);
ALTER TABLE membership_user_list ADD  FOREIGN KEY (membership_code) REFERENCES membership(membership_code);

ALTER TABLE channel ADD  FOREIGN KEY (user_code) REFERENCES user(user_code);
ALTER TABLE channel ADD  FOREIGN KEY (membership_code) REFERENCES membership(membership_code);

ALTER TABLE meetings ADD  FOREIGN KEY (membership_code) REFERENCES membership(membership_code);

ALTER TABLE main ADD  FOREIGN KEY (membership_code) REFERENCES membership(membership_code);
ALTER TABLE main ADD  FOREIGN KEY (user_code) REFERENCES user(user_code);

ALTER TABLE comment ADD  FOREIGN KEY (user_code) REFERENCES user(user_code);
ALTER TABLE comment ADD  FOREIGN KEY (main_code) REFERENCES main(main_code);
ALTER TABLE comment ADD  FOREIGN KEY (parents_comment_code) REFERENCES comment(comment_code);

ALTER TABLE img ADD  FOREIGN KEY (meet_code) REFERENCES meetings(meet_code);
ALTER TABLE img ADD  FOREIGN KEY (main_code) REFERENCES main(main_code);




SELECT *
FROM member;

SELECT * 
FROM membership
JOIN membership_user_list USING(membership_code);

-- JOIN channel using(membership_code);