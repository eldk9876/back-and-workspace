drop Table sign_up;

CREATE TABLE sign_up ( -- 회원가입
	id VARCHAR(20) PRIMARY KEY, -- 아이디
	pwd VARCHAR(20) NOT NULL, -- 비밀번호
    addr VARCHAR(100) NOT NULL, -- 주소
    phone VARCHAR(20) NOT NULL, -- 전화번호
    email VARCHAR(100) NOT NULL, -- 이메일
    name VARCHAR(20) NOT NULL, -- 이름
    age INT NOT NULL, -- 나이
    gender CHAR(1) NOT NULL -- 성별
);


SELECT *  --  회원가입 쿼리
FROM sign_up;

INSERT INTO sign_up Values(1,1,1,1,1,1,1,1);


SELECT phone  -- 아이디를 까먹었을때 전화번호와 이메일 사용해서 찾음
FROM sign_up;

-- 대분류 8가지 운동 여행 스터디 동물농장(반려동물) 푸드파이터(음식) 원예 음악 예술

