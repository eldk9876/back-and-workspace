SELECT * FROM sign_up;

INSERT INTO sign_up
VALUES("asd123", '123','서울','010-0000-0000', "asd123@naver.com" ,"홍길동", 20, 'M', true);

INSERT INTO sign_up
VALUES("asd1123", '123','부산','010-0000-0001', "asd1123@naver.com" ,"임꺽정", 20, 'M', false);

INSERT INTO sign_up
VALUES("asd1223", '123','경기','010-0000-0001', "asd1223@naver.com" ,"자두", 25, 'F', true);

INSERT INTO sign_up
VALUES("asd1323", '123','대전','010-0000-0001', "asd1323@naver.com" ,"수박", 26, 'M', true);

INSERT INTO sign_up
VALUES("asd5123", '123','대구','010-0000-0001', "asd5123@naver.com" ,"딸기", 30, 'F', true);

INSERT INTO sign_up
VALUES("asd1823", '123','광주','010-0000-0001', "asd1823@naver.com" ,"메론", 45, 'M', true);

INSERT INTO sign_up
VALUES("asd1173", '123','서울','010-0000-0001', "asd1173@naver.com" ,"망고", 27, 'F', true);

SELECT * FROM user;

INSERT INTO user(id, user_name,user_hobby,user_info, user_location, user_type)
VALUES("asd123" , "홍시" , "축구" , "안녕하세요 축구를 좋아하는 홍시입니다", "서울 강남", "#축구 #농구");

INSERT INTO user(id, user_name,user_hobby,user_info, user_location, user_type)
VALUES("asd1223" , "자두에이드" , "맛집탐방" , "안녕하세요 음료를 좋아하는 자두에이드입니다", "경기 성남", "#커피 #에이드");

INSERT INTO user(id, user_name,user_hobby,user_info, user_location, user_type)
VALUES("asd1323" , "수박무침" , "맛집탐방" , "안녕하세요 먹을것을 좋아하는 수박무침입니다", "대전 유성", "#돈까스 #제육");

INSERT INTO user(id, user_name,user_hobby,user_info, user_location, user_type)
VALUES("asd5123" , "일본딸기" , "여행" , "안녕하세요 일본여행을 좋아하는 홍시입니다", "대구 중구", "#일본 #오사카");

INSERT INTO user(id, user_name,user_hobby,user_info, user_location, user_type)
VALUES("asd1823" , "메로나" , "야구" , "안녕하세요 야구를 좋아하는 메로나입니다", "광주 서구", "#야구");

INSERT INTO user(id, user_name,user_hobby,user_info, user_location, user_type)
VALUES("asd1173" , "애플망고" , "과일" , "안녕하세요 과일을 좋아하는 애플망고입니다", "서울 강북", "#과일 #비건");

SELECT * 
FROM sign_up
JOIN user USING(id);

SELECT * FROM membership;

INSERT INTO membership(membership_Name, membership_img, membership_info, membership_max )
VALUES("대한축구협회" , "/1q2w3e.png" , "축구를 좋아하는 사람들의 모임입니다" , 10);

INSERT INTO membership(membership_Name, membership_img, membership_info, membership_max )
VALUES("대한맛집탐방협회" , "/1q2w3e3.png" , "캠핑를 좋아하는 사람들의 모임입니다" , 15);

INSERT INTO membership(membership_Name, membership_img, membership_info, membership_max )
VALUES("해외여행장려협회" , "/1q2w1233e.png" , "해외여행을 좋아하는 사람들의 모임입니다" , 100);

SELECT * FROM membership_user_list;

INSERT INTO membership_user_list(list_grade, user_code, membership_code)
VALUES("호스트", 1 , 1);

INSERT INTO membership_user_list(list_grade, user_code, membership_code)
VALUES("호스트", 2 , 2);

INSERT INTO membership_user_list(list_grade, user_code, membership_code)
VALUES("일반회원", 3 , 2);

INSERT INTO membership_user_list(list_grade, user_code, membership_code)
VALUES("호스트", 4 , 3);

INSERT INTO membership_user_list(list_grade, user_code, membership_code)
VALUES("비회원", 5 , 1);

INSERT INTO membership_user_list(list_grade, user_code, membership_code)
VALUES("관리자", 6 , 2);

SELECT * 
FROM membership_user_list
JOIN user USING(user_code)
JOIN membership USING(membership_code)
JOIN sign_up USING(id)
WHERE user_name = "메로나";