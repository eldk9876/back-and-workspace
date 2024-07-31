CREATE TABLE sign_up ( -- 회원가입
    id VARCHAR(50) PRIMARY KEY, -- 아이디
    pwd VARCHAR(255) NOT NULL, -- 비밀번호
    addr VARCHAR(255), -- 주소
    phone VARCHAR(20), -- 전화번호
    email VARCHAR(100), -- 이메일
    name VARCHAR(50), -- 이름
    age INT, -- 나이
    gender CHAR(1) -- 성별
);
-- 필요기능 아이디 잊어버렸을때 전화번호나 이메일로 코드 보내서 일치하면 찾을수 있게 
-- 비밀번호 잊어버렸을때 아이디와 이메일을 입력해서 이메일로 코드 받은 후 받은 코드 사용하면 재설정 가능하게(임시 비밀번호발급도 가능)
-- 비밀번호, 주소, 이메일 변경가능하게 만들기 


CREATE TABLE main_category ( -- 유형대분류
    MC_code INT PRIMARY KEY auto_increment, -- 대분류코드 mc 메인카테고리 줄임말
    MC_name VARCHAR(50) -- 대분류이름
);
-- 대분류,소분류 분류별로 선택 가능하게(중복선택도 가능??위치는 중복설정 불가능하게) 


CREATE TABLE sub_category  ( -- 유형소분류
    SC_code INT PRIMARY KEY auto_increment, -- 소분류코드
    SC_Name VARCHAR(50), -- 소분류이름
    MC_code INT, -- 대분류코드 /외래키
    FOREIGN KEY (MC_code) REFERENCES main_category(MC_code) -- 외래키지정
);
CREATE TABLE main_location ( -- 위치대분류
    ML_code INT PRIMARY KEY auto_increment, -- 위치대분류코드 -- 대분류코드 ml 메인지역 줄임말
    ML_name VARCHAR(50) -- 위치대분류이름
);
CREATE TABLE sub_location ( -- 위치소분류
    SL_code INT PRIMARY KEY auto_increment, -- 위치소분류코드
    SL_name VARCHAR(50), -- 위치소분류이름
    ML_code INT, -- 위치대분류코드 /외래키
    FOREIGN KEY (ML_code) REFERENCES main_location(ML_code) -- 외래키지정
);
CREATE TABLE mypage ( -- 마이페이지
    mypage_code INT PRIMARY KEY auto_increment, -- 마이페이지코드
    id VARCHAR(50), -- 유저아이디 /외래키
    user_rating DECIMAL(2,2), -- 유저온도 0.00 ~ 99.99까지가능
    nickname VARCHAR(50), -- 닉네임
    profile_picture VARCHAR(255), -- 유저프로필사진
    user_hobby TEXT, -- 유저 관심사
    user_introduction TEXT, -- 유저 간단한 자기소개
    user_special_notes TEXT, -- 유저 특이사항
    preferred_location VARCHAR(100), -- 유저선호지역
    preferred_meeting_type VARCHAR(100), -- 유저 선호만남유형
    FOREIGN KEY (id) REFERENCES sign_up (id) -- 외래키 지정
);

-- 프로필 사진,관심사,자기소개,특이사항,선호지역,선호만남유형 변경 가능하게(선호지역과 손호 만남은 중복가능하게?? ) 


CREATE TABLE clubs (
    club_code INT PRIMARY KEY auto_increment, -- 클럽코드
    club_Name VARCHAR(100), -- 클럽이름
    SC_code INT, -- 소분류유형코드 /외래키
    SL_code INT, -- 소분류지역코드 /외래키
    club_picture VARCHAR(255), -- 클럽메인사진
    club_create_date DATE, -- 클럽생성날짜
    club_max_members INT, -- 클럽최대인원
    club_guide TEXT, -- 클럽소개
    club_rules TEXT, -- 클럽가입조건?유형?
    FOREIGN KEY (SC_code) REFERENCES sub_category(SC_code), -- 외래키 지정
    FOREIGN KEY (SL_code) REFERENCES sub_location(SL_code) -- 외래키 지정
);
CREATE TABLE club_members ( -- 클럽유저정보
    club_members_code INT PRIMARY KEY auto_increment, -- 클럽가입한 멤버코드
    id VARCHAR(50), -- 유저아이디 /외래키
    club_code INT, -- 클럽코드 /외래키
    join_date DATE, -- 가입날짜
    membership_type VARCHAR(50), -- 멤버등급
    FOREIGN KEY (id) REFERENCES sign_up(id), -- 외래키 지정
    FOREIGN KEY (club_code) REFERENCES clubs(club_code) -- 외래키 지정
);
CREATE TABLE club_channels ( -- 클럽채널
    channel_code INT PRIMARY KEY auto_increment, -- 클럽채널코드
    channel_name VARCHAR(100), -- 채널명
    channel_picture VARCHAR(255), -- 채널 사진
    id VARCHAR(50), -- 유저아이디 /외래키
    club_code INT, -- 클럽코드 /외래키
    FOREIGN KEY (club_code) REFERENCES clubs(club_code), -- 외래키 지정
    FOREIGN KEY (id) REFERENCES mypage(id) -- 외래키 지정
);
CREATE TABLE club_meetings ( -- 클럽모임게시판
    club_meeting_code INT PRIMARY KEY auto_increment, -- 모임게시판코드
    club_code INT, -- 클럽코드 /외래키
    calendar DATE, -- 캘린더
    entry BOOLEAN, -- 참여여부
    location TEXT, -- 모임개최지역
    FOREIGN KEY (club_code) REFERENCES clubs(club_code) -- 외래키지정
);
CREATE TABLE club_bulletin_board ( -- 클럽홍보게시판
    bulletin_code INT PRIMARY KEY auto_increment, -- 홍보게시판코드
    club_code INT, -- 클럽코드 /외래키
    title VARCHAR(255), -- 홍보글제목
    content TEXT, -- 홍보내용
    views INT, -- 조회수
    created_date DATE, -- 홍보글게시날짜
    picture VARCHAR(255), -- 홍보사진
    FOREIGN KEY (club_code) REFERENCES clubs(club_code) -- 외래키 지정
);
CREATE TABLE bulletin_board_comments (
    comment_code INT PRIMARY KEY auto_increment, -- 댓글코드
    bulletin_code INT, -- 클럽코드 /외래키
   id VARCHAR(50), -- 유저아이디 / 외래키
    comment_text TEXT, -- 홍보게시판 댓글 내용
    comment_date DATE, -- 댓글 게시시간
    FOREIGN KEY (bulletin_code) REFERENCES club_bulletin_board(bulletin_code), -- 외래키지정
   FOREIGN KEY (id) REFERENCES mypage(id) -- 외래키지정
);
CREATE TABLE picture (
    picture_code INT PRIMARY KEY auto_increment, -- 사진코드
	picture_URL VARCHAR(255), -- 사진
    club_meeting_code INT, -- 모임게시판코드 / 외래키
    bulletin_code INT, -- 홍보게시판코드 / 외래키
    FOREIGN KEY (club_meeting_code) REFERENCES club_meetings(club_meeting_code), -- 외래키지정
    FOREIGN KEY (bulletin_code) REFERENCES club_bulletin_board(bulletin_code) -- 외래키지정
);