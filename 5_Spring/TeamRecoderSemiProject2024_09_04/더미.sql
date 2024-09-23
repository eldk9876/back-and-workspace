
select * from membership_user_list;

SELECT *
FROM type_category;

SELECT *
FROM membership_location;

SELECT *
FROM location_category;

select * 
from membership_meetings;
SELECT id, member_manner, last_recommendation_time
FROM member
WHERE id IN('user010', 'user006');
UPDATE member 
	SET member_manner = member_manner - 0.5
	WHERE id = user006;
    
select * from membership_user_list 
where id = 'user037';

delete from membership_user_list
where list_code = 37;

select *
from member 
where id = 'user037';

select * 
from member
where status = 0;
-- 5
select * 
from meetings_agree
where id = 'user010';
/*
select * 
from meetings_agree
join member using(id)
join membership_user_list using(id)
where meet_code  = #{meetCode}
and meet_agree_yn = 1;
*/
		SELECT list_grade, id, membership_code 
		FROM membership_user_list
		WHERE id = 'asd123';
select* 
FROM main_comment;
select * from membership;
		SELECT
		count(*)
		FROM meetings_agree
		JOIN membership_meetings USING (meet_code)
		WHERE meetings_agree.id = 'user077'
		AND meet_agree_yn = 1
		AND meet_date_end
		> now(); 
select *from member 

where id = 'user087';
select meet_title, meet_date_start, meet_creat_date, membership_name
from meetings_agree
join membership_meetings using(meet_code)
join membership using(membership_code)
where meetings_agree.id = 'user077' and meet_agree_yn = 1;

select * from meetings_agree
where id = 'user077';


ALTER TABLE membership
DROP COLUMN memership_secret_text;

ALTER TABLE membership
CHANGE COLUMN memership_accession_text membership_accession_text text;

create table test_col(
	info text
);
select * from test_col;
drop table test_col;

INSERT INTO test_col(info)
SELECT
    membership_info
FROM
    membership
WHERE
    membership_info != 0;
    
UPDATE membership
SET membership_simple_text = membership_info; 

update membership 
set membership_info = null
where membership_code in (6,7,10,20,64);

insert into membership_type(type_code, membership_code)
values(65,135);

select * from membership_location;
select * from membership_type;
select * from location_category;
select * from type_category;
select * from membership;


SHOW COLUMNS FROM membership;

SELECT *
FROM membership_user_list
JOIN membership USING (membership_code)
JOIN member USING (id)
WHERE membership_code = 1;

SELECT * FROM membership_user_list;

SELECT count(membership_code) as count
FROM membership_user_list
WHERE membership_code = 1
GROUP BY membership_code;

insert into member (id, pwd, addr, phone, email, name, age, gender, nickname, member_img, member_hobby, member_info, member_location, member_type)
values ('asd123', '123' , '감자왕국',"010-0000-1234",'감자',5,'M','감자대마왕', '');

insert into user (id, user_name, user_info)
values ('asd123','감자대마왕', '저는감자를좋아해요');

SELECT * FROM membership_us;

 SELECT
            ms.membership_code AS membershipCode,
            ms.Membership_name AS membershipName,
            ms.Membership_img AS membershipImg,
            ms.Membership_info AS membershipInfo,
            ms.Membership_date AS membershipDate,
            ms.Membership_grade AS membershipGrade,
            ms.Membership_max AS membershipMax,
            COUNT(mul.membership_code) AS count,
            host.id AS hostId,
            host.name AS hostName,
            host.nickname AS hostNickname,
            host.member_img AS hostMemberImg
        FROM
            membership ms
        LEFT JOIN
            membership_user_list mul ON ms.membership_code = mul.membership_code
            AND mul.list_grade = 'member'
        LEFT JOIN
            membership_user_list host_ul ON ms.membership_code = host_ul.membership_code
            AND host_ul.list_grade = 'host'
        LEFT JOIN
            member host ON host_ul.id = host.id
        GROUP BY
            ms.membership_code,
            ms.Membership_name,
            ms.Membership_img,
            ms.Membership_info,
            ms.Membership_date,
            ms.Membership_grade,
            ms.Membership_max,
            host.id,
            host.name,
            host.nickname,
            host.member_img
