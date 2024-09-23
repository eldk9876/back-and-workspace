SELECT * FROM damoim.membership;

SELECT *
		FROM
		membership_user_list
		JOIN membership USING (membership_code)
		JOIN member
		USING (id)
		WHERE list_grade = "host";

DESC membership;

SELECT * FROM membership_user_list
where id = "user099";
SELECT * FROM membership;
DELETE FROM membership_user_list where membership_code = 85;
DELETE FROM membership where membership_code = 85;
SHOW CREATE TABLE membership_code;




SELECT *
		FROM membership_user_list
		JOIN membership USING
		(membership_code)
		JOIN member USING (id)
		WHERE list_grade = "host";
        
        SELECT * FROM membership_user_list ;
		SELECT * FROM membership ;
        
        SELECT *
		FROM membership_user_list
		JOIN membership USING
		(membership_code)
		JOIN member USING (id)
		WHERE membership_code =
		"5" AND list_grade = "host";
        
        
        UPDATE membership
			SET membership_name = '김치조앙' , 
				membership_img = null,
				membership_info = '어쩌꾸',
				membership_max = 3,
				memership_accession_text = '어쩌꾸',
				memership_simple_text = '어쩌꾸',
				memership_secret_text = '어쩌꾸'
			WHERE  membership_code = 86 ;
			select * from membership;
            select membership_code from membership where membership_name like"%모험가%";
            update membership
            set membership_name="대격변"
            where membership_code=84;
           
			SELECT * FROM membership_user_list where membership_code='88';
            
            SELECT * FROM damoim.membership;
             SELECT * FROM damoim.membership_location;
                SELECT * FROM damoim.location_category;
                
                
                SELECT * FROM damoim.membership;
            SELECT * FROM damoim.type_category;
			SELECT * FROM damoim.membership_type;      
            
	select * from member;
    select * from member;
    
	SELECT *
    FROM membership_location
    join location_category using(loc_code)
    join membership_type using(membership_code)
    join type_category using(type_code);
    
    
    select * from membership_user_list;
    select * from member;
    
    -- 방에 있는사람
	select * from membership_user_list
    join membership using(membership_code);
    
    -- 유저 정보
    select * from member
    join membership_location using(member_location);
    
    select * from member;
    
    
	select * from membership
	join membership_location USING(membership_code)
	join location_category USING(loc_code)
	join membership_type USING(membership_code)
	join type_category USING(type_code)
	join membership_user_list using(membership_code);
    
    SELECT loc_s_name,char_length(loc_s_name) FROM location_category;
    261 220 250 in
   
	
    
    select * from membership_user_list
	join membership using(membership_code)
    where list_code = 'host';

    
    select membership_code,loc_la_name,loc_s_name from membership
    join membership_location using(membership_code)
    join location_category using (loc_code)
    where membership_code = 277;
    
    select membership_code,type_la_name,type_s_name from membership
    join membership_type using(membership_code)
    join type_category using (type_code)
    where membership_code = 277;

    select * from membership_user_list where membership_code =;
	
    
    
    
    SELECT * FROM membership;
	SELECT *  FROM membership_location ;
    SELECT *  FROM membership_type ;
	SELECT *  FROM location_category ;
	SELECT *  FROM membership_type ;
	SELECT * FROM type_category ;    
    
    
    select * from membership
	join membership_location USING(membership_code)
	join location_category USING(loc_code)
	join membership_type USING(membership_code)
	join type_category USING(type_code);
    
    
    SELECT * from membership_location;
    
    
    -- 다 지우기
 --   ----------------------------------------------------------------
DELETE FROM membership_location where membership_code in ('51');
DELETE FROM membership_type where membership_code  in ('51');
DELETE FROM membership_user_list where membership_code in ('51');
DELETE FROM membership where membership_name LIKE '1232312';
DELETE FROM membership_user_list where id LIKE 'user050';
-- ---------------------------------------------------------------    
    
    
    
    
    
    SELECT * FROM membership_location;
    
    SELECT * FROM member where id ='Testyoung1';
    SELECT * FROM membership_user_list where list_grade='host';
	SELECT * FROM membership_user_list where membership_code= 102;
    select * from member where nickname = 'pqpqpq';
    
    
    
		SELECT loc_s_name
		FROM location_category
		WHERE loc_la_name = '부산광역시';
    
    
    select membership_code from membership
    where membership_code = '1';
    desc membership;
    select * from location_category;
    select * from membership;
    select * from membership_type;
    select * from membership_location;
    
    SELECT * FROM member_location;
    DESCRIBE membership_user_list;
    
    
    
    
    
-- 클럽 생성 : membership, membership_location, membership_type

SELECT * FROM membership; -- membership_name, membership_img, membership_info, membership_max, membership_accession_text, membership_simple_text
SELECT * FROM membership_location; -- loc_code, membership_code <-- membership_code 가 memberhsip 추가 후에 나오지 않아요?
SELECT * FROM membership_type; -- type_code, membership_code

SELECT loc_code FROM location_category
WHERE loc_la_name = '서울' AND loc_s_name = '종로구';
SELECT type_code FROM type_category
WHERE type_la_name = '종교' AND type_s_name = '기독교';

SELECT * FROM membership WHERE membership_code = 145;
    
    