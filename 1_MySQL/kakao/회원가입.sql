drop table member;

CREATE TABLE member ( -- 회원가입
	no int PRIMARY KEY auto_increment,
    id VARCHAR(50) , -- 아이디
    password VARCHAR(255) NOT NULL, -- 비밀번호
    phone VARCHAR(20), -- 전화번호
    email VARCHAR(100), -- 이메일
    name VARCHAR(50), -- 이름
    age INT, -- 나이
    gender CHAR(1), -- 성별 M/F
    status BOOLEAN DEFAULT TRUE, -- 유저 가입,탈퇴 여부
    nickname VARCHAR(50) UNIQUE, -- 닉네임 -- join 
    member_img VARCHAR(255), -- 유저프로필사진
    member_info TEXT -- 유저 간단한 자기소개
  
);