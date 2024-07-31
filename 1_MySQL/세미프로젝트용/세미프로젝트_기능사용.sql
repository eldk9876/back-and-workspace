-- 회원가입 기능

-- 로그인 기능

-- 아이디 및 패스워드 찾기 기능

-- 비밀번호, 주소등 변경 가능해야 할 목록 확인 후 기능 구현





-- 회원 가입 & 유저
SELECT * 
FROM sign_up
JOIN user using(id);

-- 기능




/* 필수정보 sign_up
추가정보- 유저관련 정보(닉네임은 필수)
유저 로그인(아이디 비밀번호 일치시)
세션에 유저 정보 유저저장
아이디 ,비밀번호 찾기 기능???(문답형???이메일??*/

SELECT * 
FROM metting_borad;


-- 모임 게시판 & 유저
SELECT * 
FROM user
JOIN metting_borad on(user_code = met_code);


