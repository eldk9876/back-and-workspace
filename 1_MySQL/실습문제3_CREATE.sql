DROP TABLE rent;
DROP TABLE member;
DROP TABLE book;
DROP TABLE publisher;

SELECT *
FROM rent;
SELECT *
FROM member;
SELECT *
FROM book;
SELECT *
FROM publisher;
-- 실습 문제
-- 도서관리 프로그램을 만들기 위한 테이블 만들기

-- 1. 출판사들에 대한 데이터를 담기 위한 출판사 테이블(publisher) 
--    컬럼 : pub_no(출판사번호) -- 기본 키
--           pub_name(출판사명) -- NOT NULL
--           phone(전화번호)

	CREATE TABLE publisher (
			pub_no INT PRIMARY KEY AUTO_INCREMENT,
            pub_name VARCHAR(20) NOT NULL,
            phone VARCHAR(20)
	
    );
    INSERT INTO publisher ( pub_name, phone) values('프리렉','032-326-7282');
    INSERT INTO publisher ( pub_name, phone) VALUES('인사이트','02-322-5143');
    INSERT INTO publisher ( pub_name, phone) VALUES('길벗','02-332-0931');
    
    SELECT * FROM publisher;
    
-- 강사님 코드
CREATE TABLE publisher (
	pub_no INT PRIMARY KEY AUTO_INCREMENT,
    pub_name VARCHAR(20) NOT NULL,
    phone VARCHAR(20)
);
	INSERT INTO publisher (pub_name, phone) VALUES ('프리렉','032-326-7282');
	INSERT INTO publisher (pub_name, phone) VALUES ('인사이트','02-322-5143');
	INSERT INTO publisher (pub_name, phone) VALUES ('길벗','02-332-0931');



-- 2. 도서들에 대한 데이터를 담기 위한 도서 테이블 (book)
--    컬럼 : bk_no (도서번호) -- 기본 키
--           bk_title (도서명) -- NOT NULL
--           bk_author(저자명) -- NOT NULL
--           bk_price(가격)
--           bk_pub_no(출판사 번호) -- 외래 키(publisher 테이블을 참조하도록)
--    조건 : 이때 참조하고 있는 부모 데이터 삭제 시 자식 데이터도 삭제 되도록 옵션 지정


	CREATE TABLE book (
			bk_no INT PRIMARY KEY AUTO_INCREMENT, 
            bk_title VARCHAR(30) NOT NULL,
            bk_author VARCHAR(20) NOT NULL,
            bk_price VARCHAR (10) ,
			bk_pub_no INT ,
			FOREIGN KEY (bk_pub_no) REFERENCES publisher(pub_no) ON DELETE CASCADE
    );
    INSERT INTO book ( bk_title, bk_author, bk_price, bk_pub_no) 
    VALUES('개발자를 위한 생각의 정리,문서 작성법', '카이마이 미즈히로', '20000', 1);
    INSERT INTO book ( bk_title, bk_author, bk_price,  bk_pub_no)
    VALUES('1일 1로그 100일 완성 IT 지식', '브라이언 W. 커니핸', '200000', 2);
    INSERT INTO book ( bk_title, bk_author, bk_price,  bk_pub_no)
    VALUES('개발자가 영어도 잘해야 되나요?','최희철','27000','3');
    INSERT INTO book ( bk_title, bk_author, bk_price,  bk_pub_no)
    VALUES('피플웨어','톰 드마르코','16800','2');
    INSERT INTO book ( bk_title, bk_author, bk_price,  bk_pub_no)
    VALUES('그로스 해킹','라이언 홀리데이','13800','3');
    
    ALTER TABLE book rename column  bk_pub_no TO pub_no;
	
    SELECT * FROM book;
    
-- 강사님 코드
	CREATE TABLE book(
		bk_no INT PRIMARY KEY AUTO_INCREMENT,
        bk_title VARCHAR(50) NOT NULL,
        bk_author VARCHAR(20) NOT NULL,
        bk_price INT,
        bk_pub_no INT ,
        CONSTRAINT pub_no_fk FOREIGN KEY (bk_pub_no) REFERENCES publisher(pub_no) ON DELETE CASCADE
    );

	INSERT INTO book (bk_title, bk_author, bk_price, bk_pub_no)
     VALUES('개발자를 위한 생각의 정리,문서 작성법', '카이마이 미즈히로', 20000, 1);
    INSERT INTO book ( bk_title, bk_author, bk_price,  bk_pub_no)
    VALUES('1일 1로그 100일 완성 IT 지식', '브라이언 W. 커니핸', 200000, 2);
    INSERT INTO book ( bk_title, bk_author, bk_price,  bk_pub_no)
    VALUES('개발자가 영어도 잘해야 되나요?','최희철',27000,3);
    INSERT INTO book ( bk_title, bk_author, bk_price,  bk_pub_no)
    VALUES('피플웨어','톰 드마르코',16800,2);
    INSERT INTO book ( bk_title, bk_author, bk_price,  bk_pub_no)
    VALUES('그로스 해킹','라이언 홀리데이',13800,3);

    

-- 3. 회원에 대한 데이터를 담기 위한 회원 테이블 (member)
--    컬럼 : member_no(회원번호) -- 기본 키
--           member_id(아이디)   -- 중복 금지
--           member_pwd(비밀번호) -- NOT NULL
--           member_name(회원명) -- NOT NULL
--           gender(성별)        -- 'M' 또는 'F'로 입력되도록 제한
--           address(주소)       
--           phone(연락처)       
--           status(탈퇴여부)     -- 기본값 'N' / 'Y' 혹은 'N'만 입력되도록 제약조건
--           enroll_date(가입일)  -- 기본값 현재날짜

	CREATE TABLE member (
		member_no int primary KEY AUTO_INCREMENT,
        member_id VARCHAR(20) NOT NULL UNIQUE ,
        member_pwd VARCHAR(20) NOT NULL,
        member_name VARCHAR(20) NOT NULL,
        gender VARCHAR(5),
        address VARCHAR(20),
        phone	VARCHAR(20),
        status CHAR(5) DEFAULT 'N' ,
        enroll_date DATE DEFAULT(current_date),
		CONSTRAINT gender_check CHECK (gender IN ('M','F')),
        CONSTRAINT gender_not_check CHECK (gender IS NOT NULL),
		CONSTRAINT status_check CHECK (status IN ('N','Y')),
		CONSTRAINT status_not_check CHECK (gender IS NOT NULL)

    
    );
	INSERT INTO member ( member_id, member_pwd, member_name, gender, address, phone, status) 
    VALUES('user01', 'pass01', '가나다', 'M','서울시 강남구','010-1111-2222','N');
    INSERT INTO member ( member_id, member_pwd, member_name, gender, address, phone, status) 
    VALUES('user02', 'pass02', '라마바', 'M','서울시 서초구','010-3333-4444','N');
    INSERT INTO member ( member_id, member_pwd, member_name, gender, address, phone, status) 
    VALUES('user03', 'pass03', '사아자', 'F','경기도 광주시','010-4444-5555','N');
    

  SELECT * FROM member;
  
-- 강사님 코드

CREATE TABLE member (
		member_no INT PRIMARY KEY AUTO_INCREMENT,
        member_id VARCHAR(20) UNIQUE ,
        member_pwd VARCHAR(20) NOT NULL,
        member_name VARCHAR(20) NOT NULL,
        gender CHAR(1) CHECK (gender IN ('M','F')),
        address VARCHAR(50),
        phone	VARCHAR(20),
        status CHAR(1) CHECK (status IN ('N','Y')) DEFAULT 'N' ,
        enroll_date DATE DEFAULT(current_date)
    
    );
	INSERT INTO member ( member_id, member_pwd, member_name, gender, address, phone) 
    VALUES('user01', 'pass01', '가나다', 'M','서울시 강남구','010-1111-2222');
    INSERT INTO member ( member_id, member_pwd, member_name, gender, address, phone) 
    VALUES('user02', 'pass02', '라마바', 'M','서울시 서초구','010-3333-4444');
    INSERT INTO member ( member_id, member_pwd, member_name, gender, address, phone) 
    VALUES('user03', 'pass03', '사아자', 'F','경기도 광주시','010-4444-5555');



-- 4. 도서를 대여한 회원에 대한 데이터를 담기 위한 대여 목록 테이블(rent)
--    컬럼 : rent_no(대여번호) -- 기본 키
--           rent_mem_no(대여 회원번호) -- 외래 키(member와 참조)
--           rent_book_no(대여 도서번호) -- 외래 키(book와 참조)
--           rent_date(대여일) -- 기본값 현재날짜
--    조건 : 이때 부모 데이터 삭제 시 NULL 값이 되도록 옵션 설정

-- ALTER로 FOREIGN KEY만 관리
		CREATE TABLE rent(
			rent_no INT PRIMARY KEY AUTO_INCREMENT,
			rent_mem_no INT,
            rent_book_no INT ,
			rent_date DATE DEFAULT(current_date),
			FOREIGN KEY (rent_mem_no) REFERENCES member(member_no) ON DELETE SET NULL,
			FOREIGN KEY (rent_book_no) REFERENCES book(bk_no) ON DELETE SET NULL
        );
	INSERT INTO rent (rent_mem_no, rent_book_no) VALUES('1','2');
	INSERT INTO rent (rent_mem_no, rent_book_no) VALUES('1','3');
	INSERT INTO rent (rent_mem_no, rent_book_no) VALUES('2','1');
	INSERT INTO rent (rent_mem_no, rent_book_no) VALUES('2','2');
	INSERT INTO rent (rent_mem_no, rent_book_no) VALUES('1','5');

	 ALTER TABLE rent rename column  rent_mem_no TO member_no;
	 ALTER TABLE rent rename column  rent_book_no TO bk_no;
     
     SELECT * FROM rent;
     
-- 강사님 코드

CREATE TABLE rent(
			rent_no INT PRIMARY KEY AUTO_INCREMENT,
			rent_mem_no INT,
            rent_book_no INT ,
			rent_date DATE DEFAULT(current_date)
        );
	-- ALTER로 FOREIGN KEY만 관리
        ALTER TABLE rent ADD CONSTRAINT member_no_kr
			FOREIGN KEY (rent_mem_no) REFERENCES member (member_no) ON DELETE SET NULL;
		ALTER TABLE rent ADD CONSTRAINT member_no_kr
			FOREIGN KEY (rent_book_no) REFERENCES book(bk_no) ON DELETE SET NULL;
  
	INSERT INTO rent (rent_mem_no, rent_book_no) VALUES(1, 2);
	INSERT INTO rent (rent_mem_no, rent_book_no) VALUES(1, 3);
	INSERT INTO rent (rent_mem_no, rent_book_no) VALUES(2, 1);
	INSERT INTO rent (rent_mem_no, rent_book_no) VALUES(2, 2);
	INSERT INTO rent (rent_mem_no, rent_book_no) VALUES(1, 5);

	 ALTER TABLE rent rename column  rent_mem_no TO member_no;
	 ALTER TABLE rent rename column  rent_book_no TO bk_no;
	
    


-- 5. 2번 도서를 대여한 회원의 이름, 아이디, 대여일, 반납 예정일(대여일 + 7일)을 조회하시오.
	/*SELECT *
    FROM member 
    JOIN rent USING (member_no) 
    ;
	*/
    SELECT DISTINCT member_name '회원이름', member_id '아이디', rent_date '대여일',  ADDDATE(rent_date, INTERVAL 7 day) '반납예정일'
    FROM member 
    JOIN rent USING (member_no) 
    WHERE bk_no = 2;
    ;
    
SELECT * FROM rent;
SELECT * FROM member ;
SELECT * FROM book;
SELECT * FROM publisher;


-- 강사님 코드

SELECT member_name '회원이름', member_id '아이디', rent_date '대여일',  
		ADDDATE(rent_date, INTERVAL 7 day) '반납예정일'
FROM rent
	JOIN member ON (member_no = rent_mem_no)
    WHERE rent_book_no = 2;



-- 6. 회원번호가 1번인 회원이 대여한 도서들의 도서명, 출판사명, 대여일, 반납예정일을 조회하시오.
/*	SELECT *
    FROM member 
    JOIN rent USING (member_no)
    JOIN book USING (bk_no)
    JOIN publisher USING (pub_no)
    ;
 */   
    SELECT bk_title '도서명' , pub_name '출판사명' , rent_date'대여일', ADDDATE(rent_date, INTERVAL 7 day)'반납예정일'
    FROM member 
    JOIN rent USING (member_no)
    JOIN book USING (bk_no)
    JOIN publisher USING (pub_no)
    WHERE member_id = 'user01'
    ;
    
SELECT * FROM rent;
SELECT * FROM member ;
SELECT * FROM book;
SELECT * FROM publisher;

 SELECT bk_title '도서명' , pub_name '출판사명' , rent_date'대여일', ADDDATE(rent_date, INTERVAL 7 day)'반납예정일'
    FROM member 
    JOIN rent USING (member_no)
    JOIN book USING (bk_no)
    JOIN publisher USING (pub_no)
    WHERE member_id = 'user01'
    ;
    
-- 강사님 코드
	SELECT  bk_title '도서명' , pub_name '출판사명' , rent_date'대여일',
			ADDDATE(rent_date, INTERVAL 7 day)'반납예정일'
    FROM rent
		JOIN book ON (rent_book_no = bk_no)
        JOIN publisher ON (bk_pub_no = pub_no);
		WHERE rent_mem_no = 1;

