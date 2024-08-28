SELECT * FROM member
join  damoim.membership_user_list using(id);

SELECT * FROM member;

DROP TABLE damoim;


SELECT * FROM membership;

UPDATE membership
SET membership_date = '2026-02-15'
WHERE membership_code = 27;