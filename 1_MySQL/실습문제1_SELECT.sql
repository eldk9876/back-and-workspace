-- sakila, 정렬은 결과 화면대로
-- 1. actor 테이블에서 first_name이 A로 시작하는 배우들만 조회
	SELECT *
    FROM actor
	WHERE first_name LIKE 'A%';
            
-- 강사님 코드 ----
	SELECT *
    FROM actor
	WHERE first_name LIKE 'A%';    
        
-- 2. film_list 테이블에서 Category가 Sci-Fi 또는 Family면서 rating이 PG면서 영화 제목(title)에 GO가 포함되는 영화 제목 조회
	SELECT title
    FROM film_list
    WHERE Category in ('Sci-Fi', 'Family') AND  rating = 'PG' AND title LIKE '%GO%' ;
            
-- 강사님 코드 ----
	SELECT title
    FROM film_list 
    -- WHERE (Category = 'Sci-Fi' OR Category = 'Family') AND rating = 'PG' AND title LIKE '%GO%';    
	 WHERE Category in ('Sci-Fi', 'Family') AND  rating = 'PG' AND title LIKE '%GO%' ;
     
-- 3. film_list 테이블에서 fid가 7 이하면서 4, 6은 아닌 fid, title 조회
	SELECT fid , title
    FROM film_list
    WHERE 7 >= fid  AND fid != 4 AND fid != 6; -- 지문에 부합되는 경우
	-- WHERE 7 > fid  AND fid != 4 AND fid != 6; -- PDF 이미지가 부합되는 경우
          
-- 강사님 코드 ----
	SELECT fid , title
    FROM film_list
    WHERE fid <= 7 -- AND (fid !=4 AND fid != 6);
					  AND fid NOT IN (4 ,6);
-- 4.  film_list 테이블에서 가격(price)은 2 이상 4 이하이면서 category가 Documentary거나
--  Animation이고 배우들(actors) 중 BOB가 포함되어 있는 영화 제목(title)만 조회
	SELECT title
	FROM film_list
    WHERE price BETWEEN 2 AND  4 AND category in ('Documentary', 'Animation') AND actors LIKE '%BOB%';
           
-- 강사님 코드 ----
	SELECT title
	FROM film_list
    -- WHERE price >= 2 AND price <= 4;   
	WHERE price BETWEEN 2 AND  4 AND category in ('Documentary', 'Animation') AND actors LIKE '%BOB%';
    
-- 5. address 테이블에서 district가 비어있지 않고 앞에 숫자 제외 주소만 10개 조회
	SELECT   -- address,  instr(address, ' '),-- TRIM(LEADING ' ' FROM address) '주소만', ceil(address),
    /*ceil(REPLACE (address, SUBSTR(address, instr(address, ' '), 1),' ')),
		SUBSTR(address , 1, instr(address, ' ') +1),
	REPLACE(address, SUBSTR(address ,instr(address, ' '), 1) ,'          '),
    REPLACE(address, SUBSTR(address ,instr(address, ' '), 1) ,LTRIM(' --  '))*/
    --  if (REPLACE(address, SUBSTR(address ,instr(address, ' '), 1), ' ', if () ))
   SUBSTR(address , instr(address, ' '), 99 +1) 'address' ,
   district ' ' 
     
    FROM address
    WHERE district != ''
	order by district
	LIMIT 10;
          
-- 강사님 코드 ----
	SELECT substr(address, instr(address, ' ')+1 ) address, district ''
    FROM address
    WHERE district !=''
	ORDER BY 2,1 desc
    LIMIT 0, 10 ; 
-- 강사님 코드2 --수강생 질문--
    SELECT address, trim(regexp_replace(address,'[0-9]+', ""))  -- 자바코드 regexp_replace(컬럼, 정규표현식, 대체되는글자) 
    FROM address
    ;
          
          
-- 6. customer_list 테이블에서 id가 6인 사람부터 10명 조회
	SELECT id, name -- , SUBSTR(id ,6, 10)
    FROM customer_list
	ORDER BY id
    LIMIT 5, 10;
           
-- 강사님 코드 ----
	SELECT id, name
    FROM customer_list
    ORDER BY id
    LIMIT 5, 10;
                 
-- 7. actor 테이블에서 J로 시작하는 이름과 글자수 조회 (공백 X, 정렬은 글자수가 많은 사람 순으로)
	SElECT CONCAT(first_name," ", last_name)"이름", CHAR_LENGTH(first_name) + CHAR_LENGTH(last_name) '글자수'
    FROM actor
    WHERE CONCAT(first_name," ", last_name) LIKE 'J%'
    ORDER BY 글자수 desc
	-- WHERE CONCAT('first_name','last_name') LIKE 'J%';
     LIMIT 10;
            
-- 강사님 코드 ----
	SELECT 
		CONCAT(first_name,' ',last_name) '이름',
        char_length(concat(first_name,last_name)) '글자수'
    FROM actor
    WHERE first_name LIKE 'J%'
    ORDER BY 글자수 DESC;
         
-- 8. film 테이블에서 description에서 of 이전 문장만 중복 없이 10개만 추출해서 조회
	SELECT DISTINCT SUBSTR(description , 1, instr(description, 'of') -1) 'of이전문장'
    FROM film
    ORDER BY of이전문장 desc
	LIMIT 10;
            
-- 강사님 코드 ----
        SELECT DISTINCT substr(description, 1, instr(description, 'of') -2) 'of 이전 문장'
        FROM film
        ORDER BY 1 DESC
        LIMIT 0, 10;
        
        
-- 9. film 테이블에서 replacement_cost 최소 비용과 최대 비용 조회
	SELECT
		MIN(replacement_cost),
        MAX(replacement_cost)
    FROM film;
            
-- 강사님 코드 ----
	SELECT
		MIN(replacement_cost) "최소 비용",
        MAX(replacement_cost) "최대 비용"
    FROM film;
        