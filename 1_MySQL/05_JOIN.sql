/*
	************** JOIN ********
    - 두 개 이상의 테이블에서 데리터를 조회하고자 할 때 사용하는 구문 
    - 조회 결과는 하나의 결과물(RESULT SET)으로 나옴
    - 관계형 데이터베이스는 최소한의 데이터로 각각의 테이블에 담고 있음
	 (중복을 최소화하기 위해 최대한 쪼개서 관리)
     부서 데이터는 부서 테이블, 사원에 대한 데이터는 사원 데이터, 직급 테이블 등.... 
     
     만약 어떤 사원이 어떤 부서에 속해있는지 부서명과 같이 조회하고 싶다면? 
     만약 어떤 사원이 어떤 직급인지 직급명과 같이 조회하고 싶다면?
     
     => 즉, 관계형 데이터베이스에서 SQL 문을 이용한 테이블 간에 "관계"를 맺어 원하는 데이터만 조회하는 방법
*/

/*
	1. 내부 조인(INNER JOIN) ********* 조인중에는 이것만 일단 알고 있으면 됌(시험 범위)
    - 연결시키는 컬럼의 값이 일치하는 행들만 조인되어 조회 (일치하는 값이 없는 행은 조회 X)
    
    1) WHERE 구문
    SELECT 컬럼1, 컬럼, ...
    FROM 테이블1, 테이블2
    WHERE 테이블1. 컬럼명 = 테이블2.컬럼명;
    
    - FROM 절에 조회하고자 하는 테이블들을 콤마(,)로 구분하여 나열
    - WHERE 절에 매칭시킬 컬럼명에 대한 조건 제시
    
    2) ANSI(미국국립표준협회 : 산업표준을 제정하는 단체) 표준 구문 -> 다른 DB에서도 사용 가능! 
    SELECT 컬럼1, 컬럼2, ...
    FROM 테이블1 
    [INNER] JOIN 테이블 2 ON (테이블1.컬럼명 = 테이블2.컬럼명);
    
    - FROM 절에서 기준이 되는 테이블을 기술
    - JOIN 절에서 조회하고자 하는 테이블을 기술 후 매칭 시킬 컬럼에 대한 조건을 기술 (ON, USING)
    - 연결에 사용하려는 컬럼명이 같은 경우 ON 구문 대신 USING(컬럼명) 구문 사용
*/

-- 1) 연결할 두 컬럼명이 다른 경우 (employee : dept_code <-> department : dept_id)
-- 사번(emp_id), 사원명(emp_name), 부서코드(dept_code), 부서명(dept_title) 조회
	SELECT  emp_id, emp_name, dept_code, dept_title  
    FROM employee, department
    WHERE dept_code = dept_id;
    -- WHERE employee.dept_code = department.dept_id;

-- >> ANSI 구문
	SELECT emp_id, emp_name, dept_code, dept_title
    FROM employee
    JOIN department ON (dept_code = dept_id);

-- 일치하는 값이 없는 행은 조회에서 제외된 것 확인!
-- dept_code가 null일 사원 조회 X

-- 2) 연결할 두 컬럼명이 같은 경우 (employee : job_code - job_code)
-- 사번, 사원명, 직급코드, 직급명 조회 
	SELECT emp_id, emp_name, job_code, job_name
    FROM employee, job
	WHERE job_code = job_code; -- ambiguous : 애매한, 모호한 / 에러 발생!
    
-- 해결방법 1) 테이블명 이용
	SELECT emp_id, emp_name, job_name
    FROM employee, job
	WHERE employee.job_code = job.job_code;
    
-- 해결방법 2) 테이블에 별칭 부여해서 이용
	SELECT emp_id, emp_name, e.job_code, job_name
    FROM employee e, job j
	WHERE e.job_code = j.job_code;

-- >> ANSI 구문
	SELECT emp_id, emp_name, e.job_code, job_name
    FROM employee e 
    JOIN job j ON (e.job_code = j.job_code);

-- 두 컬럼명이 같을 때만 USING 구문 사용 가능!
    SELECT emp_id, emp_name, job_code, job_name
    FROM employee 
    JOIN job USING (job_code); 
    
-- 자연조인(NATURAL JOIN) : 각 테이블마다 동일한 컬럼이 한 개만 존재할 경우
-- 주의사항! 쓰지 마세요..!!
	SELECT emp_id, emp_name, job_code, job_name
    FROM employee 
    NATURAL JOIN job;
    
-- 직급이 대리인 사원의 사번(emp_id), 이름(emp_name), 직급명(job_name), 급여(salary) 조회
	SELECT emp_id, emp_name, job_name, salary
    FROM employee e, job j
    WHERE job_name = '대리' AND e.job_code = j.job_code;
    
-- 강사님 코드 WHERE
	SELECT emp_id, emp_name, job_name, salary
    FROM employee e, job j
    WHERE e.job_code = j.job_code AND job_name = '대리' ;
    
-- 강사님 코드 USING
	SELECT emp_id, emp_name, job_name, salary
    FROM employee
    JOIN job USING(job_code) 
    WHERE job_name = '대리' ;

-- 실습문제 -- 
-- 1. 부서가 인사관리부인 사원들의 사번, 이름, 보너스 조회 (employee, department)
	SELECT emp_id, emp_name, bonus
    FROM employee 
    JOIN department on (dept_code = dept_id)
    WHERE dept_title = '인사관리부';
    
-- >>강사님 코드 where 구문
	SELECT emp_id, emp_name, bonus
    FROM employee , department
	WHERE dept_code = dept_id AND dept_title = '인사관리부';


-- >>강사님 코드 ANSI 구문
    SELECT emp_id, emp_name, bonus
    FROM employee 
    JOIN department on (dept_code = dept_id)
    WHERE dept_title = '인사관리부';
    
-- 2. 전체 부서의 부서코드, 부서명, 지역코드, 지역명 조회 (department, location)
	SELECT dept_id, dept_title, local_code, local_name-- national_code
    FROM department
    JOIN location on (location_id = local_code);
    
-- 강사님 코드
	SELECT dept_id, dept_title, local_code, local_name
    FROM department
    JOIN location on (location_id = local_code);
   
-- 3. 보너스를 받는 사원들의 사번, 사원명, 보너스, 부서명 조회 (employee, department)
	SELECT emp_id '사번', emp_name '사원명', bonus '보너스', dept_title '부서명'
    FROM employee
	JOIN department on (dept_code = dept_id)
	WHERE bonus IS NOT NULL;
    
-- 강사님 코드
    SELECT emp_id '사번', emp_name '사원명', bonus '보너스', dept_title '부서명'
    FROM employee
    JOIN department on (dept_code = dept_id)
    WHERE bonus IS NOT NULL;
    
-- 4. 부서가 총무가 아닌 사원들의 사원명, 급여 조회 (employee, department)  
	SELECT emp_name '이름', salary '월급', dept_title '부서'
    FROM employee
	JOIN department on (dept_code = dept_id)
    WHERE dept_title != '총무부';

-- 강사님 코드
	SELECT emp_name, salary , dept_title
    FROM employee
	JOIN department on (dept_code = dept_id)
    WHERE dept_title != '총무부';

/*
	2. 외부 조인(OUTER JOIN) : MySQL은 ANSI 구문만 가능
    - 두 테이블 간의 JOIN시 일치하지 않는 행도 포함시켜서 조회가 가능하다.
    - 단, 반드시 기준이 되는 테이블(컬럼)을 지정해야 한다. (LEFT, RIGHT, FULL)
*/
-- 사원명, 부서명, 급여, 연봉(급여 * 12)조회
	SELECT emp_name, dept_title, salary, salary * 12 '연봉'
    FROM employee
    JOIN department on (dept_code = dept_id);
-- > 부서 배치가 안된 사원 2명에 대한 정보 조회 X
-- > 부서에 배정된 사원이 없는 부서도 정보 조회 X

-- 1) LEFT JOIN : 두 테이블 중 왼쪽에 기술된 테이블을 기준으로 JOIN
	SELECT emp_name, dept_title, salary, salary * 12 '연봉'
    FROM employee
    LEFT JOIN department on (dept_code = dept_id);

-- 2) RIGHT JOIN : 두 테이블 중 오른쪽에 기술된 테이블을 기준으로 JOIN
	SELECT emp_name, dept_title, salary, salary * 12 '연봉'
    FROM employee
    LEFT JOIN department on (dept_code = dept_id);
    
-- 3) FULL JOIN : 두 테이블이 가진 모든 행을 조회할 수 있음 -MySQL X

/*
	3. 비등가 조인 (NON EQUAL JOIN)
    - 매칠시킬 컬럼에 대한 조건 작성시 '='(등호)를 사용하진 않는 조인문
    - 값의 범위에 포함되는 행들을 연결하는 방식
    - ANSI 구문으로는 JOIN ON만 사용 가능! (USING 사용 불가)
*/
	SELECT * FROM employee; -- emp_name, salary
    SELECT * FROM sal_grade; -- 급여 등급 테이블 : sal_level, min_sal, max_sal -> salary와 연관!
    
-- 사원명, 급여, 급여 레벨 조회
	SELECT emp_name, salary, sal_level
    FROM employee
    JOIN sal_grade on (min_sal <= salary AND salary <= max_sal);
    
    SELECT emp_name, salary, sal_level
    FROM employee, sal_grade
    WHERE salary BETWEEN min_sal AND max_sal;
    
/*
	4. 자체 조인(SELF JOIN)
	- 같은 테이블을 다시 한번 조인하는 경우 (자기 자신과 조인)
*/
	SELECT * FROM employee;
    
-- 전체 사원의 사원사번(emp_id), 사원명(emp_name), 사원부서코드(dept_code), 사수사번(manager_id)
-- 			사수사번(emp_id), 사수명(emp_name), 사수부서코드(dept_code) 조회
	
    SELECT e.emp_id"사원사번",e.emp_name"사원사명",e.dept_code"사원부서코드",e.manager_id"사수사번",
		   m.emp_id"사수사번",m.emp_name"사수사명",m.dept_code"사수부서코드"
    FROM employee e
    LEFT JOIN employee m ON(m.emp_id=e.manager_id);
    
/*
	5. 카테시안곱(CARTESIAN PRODUCT) / 교차 조인 (CROSS JOIN)
    - 조인되는 모든 테이블의 각 행들이 서로서로 모두 매핑된 데이터가 검색된다. (곱집합)
    - 두 테이블의 행들이 모두 곱해진 행들의 조합이 출력 -> 방대한 데이터 출력 -> 과부하 위험
*/
-- 사원명, 부서명 조회 (employee - emp_name, department - dept_title)
-- >> WHERE
	SELECT emp_name, dept_title
    FROM employee, department;
    
-- >> ANSI 구문
	SELECT emp_name, dept_title
    FROM employee CROSS JOIN department;
    
/*
	6. 다중 JOIN
    -여러 개의 테이블을 조인하는 경우 
*/
-- 사번, 사원명, 부서명, 직급명 조회
	SELECT * FROM employee; -- emp_id, emp_name, dept_code, job_code <-foreign key(외래키)
    SELECT * FROM department; -- dept_title		 dept_id          	 <-primary key(주요키)
    SELECT * FROM job; -- job_name							job_code  <-primary key(주요키)
	
    SELECT emp_id, emp_name ,dept_title, job_name
    FROM employee
    JOIN department on (dept_code = dept_id)
    JOIN job USING (job_code);
    
-- 실습 문제---------------------------------------------------------------------------------------------------------
--  각 코드 연결 키
			SELECT *  FROM employee;  -- dept_code(D1,D2), job_code(J1,J2)
        SELECT * FROM department; -- *부서명* dept_id(D1,D2)location_id(L1,L2) 
         SELECT * FROM job;       -- *직책*job_code(J1)
         SELECT* FROM location;   -- * 국가*local_code (L1,L2) national_code(KO,)
          SELECT* FROM national;  -- *국가*national_code(KO,)
           SELECT* FROM sal_grade; --  *민 맥스*sal_level(S1,S2)

-- 1. 직급이 대리면서 ASIA 지역에서 근무하는 직원들의 사번(emp_id), 직원명(emp_name), 직급명(job_name), 부서명(dept_title), 근무지역(local_name), 급여(salary) 조회 
		SELECT emp_id, emp_name, job_name, dept_title, local_name, salary 
        FROM employee
		JOIN job USING (job_code)
        JOIN department on (dept_code = dept_id)
        JOIN location on (location_id =  local_code)
        WHERE job_name = '대리' AND local_name like 'ASIA%';
        -- WHERE job_name = '대리' AND local_name = 'ASIA_';
        
-- 강사님 코드 ----
        SELECT emp_id, emp_name, job_name, dept_title, local_name, salary 
        FROM employee
        JOIN job USING (job_code)
        JOIN department ON (dept_code = dept_id)
        JOIN location ON (location_id =  local_code)
        WHERE job_name = '대리' AND local_name LIKE 'ASIA%';
   

-- 2. 70년대생 이면서 여자이고, 성이 전 씨인 직원들의 직원명, 주민번호, 부서명, 직급명 조회
		SELECT emp_name, emp_no, dept_title, job_name
        FROM employee
        JOIN job using (job_code)
        JOIN department on (dept_code = dept_id)
		WHERE emp_no LIKE '7%' AND SUBSTR(emp_no, 8, 1) IN (2, 4) AND emp_name LIKE '전%';
        
-- 강사님 코드 ----
        SELECT emp_name, emp_no, dept_title, job_name
        FROM employee
        JOIN job using (job_code)
        JOIN department on (dept_code = dept_id)
        -- WHERE SUBSTR(emp_no, 1, 1) IN ('7') /* 동문님*/  AND SUBSTR(emp_no, 8, 1) IN (2, 4)
        WHERE emp_no LIKE '7_____-2%' AND emp_name LIKE '전%';
        
-- 3. 보너스를 받은 직원들의 직원명, 보너스, 연봉, 부서명, 근무지역 조회 
--    부서가 없는 직원들도 나타내고 싶다면 LEFT JOIN (employee 테이블이 왼쪽에 있을때) 
		SELECT emp_name'직원명', bonus'보너스', format((salary + salary * bonus)*12,0 )'연봉', dept_title'부서명', local_name'근무지역'
		FROM employee
        JOIN department on (dept_code = dept_id)
        JOIN location on (location_id =  local_code)
        WHERE bonus IS NOT NULL; 
		        
-- 강사님 코드 ----
        SELECT emp_name'직원명', bonus, format((salary + salary * bonus)*12,0 )'연봉' , dept_title'부서명', local_name'근무지역'
		FROM employee
        LEFT JOIN department on (dept_code = dept_id)
        LEFT JOIN location on (location_id =  local_code)
         WHERE bonus IS NOT NULL; 
         
         
-- 강사님 코드2 ------
        
-- 4. 한국과 일본에서 근무하는 직원들의 직원명, 부서명, 근무지역(local_name), 근무국가(national_code) 조회
		SELECT emp_name'직원명', dept_title'부서명', local_name'근무지역', national_name'근무국가'
        FROM employee 
        JOIN department on (dept_code = dept_id)
        JOIN location on (location_id =  local_code)
        JOIN national USING(national_code)
        WHERE national_code = 'KO' OR national_code = 'JP'
        ORDER BY local_name;
        
-- 강사님 코드 ----
        SELECT emp_name'직원명', dept_title'부서명', local_name'근무지역', national_name'근무국가'
        FROM employee 
        JOIN department on (dept_code = dept_id)
        JOIN location on (location_id =  local_code)
        JOIN national USING(national_code)
        WHERE national_name IN ('한국','일본')
        ;
-- 5. 각 부서별 평균 급여를 조회하여 부서명, 평균 급여 조회
	SELECT dept_title'부서명', format(avg(salary),0) '평균급여'
    FROM employee
    JOIN department on (dept_code = dept_id)
    GROUP BY dept_title 
  ;      
-- 강사님 코드 ----
	SELECT dept_title'부서명', format(avg(salary),0) '평균급여'
    FROM employee
    JOIN department on (dept_code = dept_id)
    GROUP BY dept_title  -- dept_code도 사용 가능한데 PRIMARY KEY라서 사용가능
  ;      
        
-- 6. 각 부서별 총 급여의 합이 1000만원 이상인 부서명, 급여 합 조회
	SELECT dept_title'부서명', format(SUM(salary),0) '평균급여'
    FROM employee
    JOIN department on (dept_code = dept_id)
    GROUP BY dept_title
    having SUM(salary) >= 10000000;
         
-- 강사님 코드 ----
        SELECT dept_title'부서명', format(SUM(salary),0) '평균급여'
    FROM employee
    JOIN department on (dept_code = dept_id)
    GROUP BY dept_title
    having SUM(salary) >= 10000000;
           
-- 7. 사번, 직원명, 직급명, 급여등급, 구분조회 
--  	이때 구분에 해당하는 값은 아래 참고!
-- 		급여 등급이 S1, S2인 경우 '고급'
-- 		급여 등급이 S3, S4인 경우 '중급'
-- 		급여 등급이 S5, S6인 경우 '초급'
	SELECT emp_id,emp_name, dept_title, sal_level '등급', format(salary,'0') ,
	CASE 
		 WHEN sal_level  IN('S1' , 'S2')  then '고급'
		 WHEN sal_level  IN('S3' , 'S4')  then '중급'
         WHEN sal_level  IN('S5' , 'S6')  then '초급'
      /*
		 WHEN sal_level = 'S1' then '고급'
         WHEN sal_level = 'S2' then '고급'
         WHEN sal_level = 'S3' then '중급'
         WHEN sal_level = 'S4' then '중급'
         WHEN sal_level = 'S5' then '초급'
         WHEN sal_level = 'S6' then '초급'*/
          END '구분 조회'
     FROM employee
      JOIN department on (dept_code = dept_id)
	JOIN sal_grade on (min_sal <= salary AND salary <= max_sal); -- 비등가

        
-- 강사님 코드 IF----
		SELECT emp_id,emp_name, dept_title, sal_level '등급', format(salary,'0') ,
        IF(sal_level IN('S1','S2'), '고급', 
        IF(sal_level IN('S3','S4'),'중급','초급'))
		FROM employee
      JOIN department on (dept_code = dept_id)
	JOIN sal_grade on (salary BETWEEN min_sal AND max_sal); -- 비등가

-- 강사님 코드 CASE WHEN----        
   SELECT emp_id,emp_name, dept_title, sal_level '등급', format(salary,'0') ,
   CASE 
		 WHEN sal_level   In('S1' , 'S2')  then '고급'
		 WHEN sal_level  IN('S3' , 'S4')  then '중급'
		 ELSE'초급'
		 END '구분 2'
     FROM employee
      JOIN department on (dept_code = dept_id)
	JOIN sal_grade on (min_sal <= salary AND salary <= max_sal);
    
-- 8. 보너스를 받지 않은 직원들 중 직급 코드가 J4 또는 J7인 직원들의 직원명, 직급명, 급여 조회
	SELECT emp_name, job_name, FORMAT(salary,0)
    FROM employee
    JOIN job USING (job_code)
    WHERE  job_code IN ('J4', 'J7') AND bonus IS NULL;
        
-- 강사님 코드 ----
	SELECT emp_name, job_name, FORMAT(salary,0)
    FROM employee
    JOIN job USING (job_code)
    WHERE  job_code IN ('J4', 'J7') AND bonus IS NULL;
        
        
-- 9. 부서가 있는 직원들의 직원명, 직급명, 부서명, 근무지역 조회
-- 	  INNER JOIN을 하는 경우 null이 포함되어 있는 것처럼 일치하는 걸 못찾는다면 제외 
		SELECT  emp_name, job_name, dept_title'부서명', local_name -- dept_code,
		FROM employee
        JOIN job USING (job_code)
        JOIN department on (dept_code = dept_id)
        JOIN location on (location_id = local_code)
		WHERE dept_title IS NOT NULL;
         
-- 강사님 코드 ----
        SELECT emp_name, job_name, dept_title, local_name
        FROM employee
        JOIN job USING(job_code)
        JOIN department on (dept_code = dept_id)
        JOIN location on (location_id = local_code)
        WHERE dept_code IS NOT NULL;
        
        
-- 10. 해외영업팀에 근무하는 직원들의 직원명, 직급명, 부서코드, 부서명 조회
		SELECT emp_name, job_name, dept_id ,dept_title'부서명'
        FROM employee
        JOIN job USING (job_code)
        JOIN department on (dept_code = dept_id)
        WHERE dept_title like '해외영업%';
         
-- 강사님 코드 ----
        SELECT emp_name, job_name, dept_id ,dept_title
        FROM employee
        JOIN job USING (job_code)
        JOIN department on (dept_code = dept_id)
        WHERE dept_title like '해외영업%';
		

-- 11. 이름에 '형'자가 들어있는 직원들의 사번, 직원명, 직급명 조회
		SELECT emp_id, emp_name ,job_name
        FROM employee
        JOIN job USING(job_code)
        WHERE emp_name LIKE '%형%';
         
-- 강사님 코드 ----
        SELECT emp_id,emp_name,job_name
        FROM employee
        JOIN job USING(job_code)
        WHERE emp_name LIKE "%형%";
               
-- 12. 사번, 사원명, 부서명, 직급명, 지역명, 국가명, 급여등급 조회
-- 참고로 employee, ,job, department, location, national, sal_grade(비등가 사용)
		SELECT emp_id, emp_name,dept_title,job_name,national_name, sal_level ,salary
        FROM employee
        JOIN job USING(job_code)
        JOIN department on (dept_code = dept_id)
        JOIN location on (location_id =  local_code)
		 JOIN national USING(national_code)
         JOIN sal_grade on (min_sal <= salary AND salary <= max_sal);

        
-- 강사님 코드 ----
        SELECT emp_id, emp_name, job_name, local_name, national_name, sal_level
        FROM employee
        JOIN department on (dept_code = dept_id)
        JOIN job USING (job_code)
        JOIN location ON (location_id = local_code)
        JOIN national USING (national_code)
        JOIN sal_grade ON (salary BETWEEN min_sal AND max_sal);
        
        


--  각 코드 연결 키
			SELECT *  FROM employee;  -- dept_code(D1,D2), job_code(J1,J2)
        SELECT * FROM department; -- *부서명* dept_id(D1,D2) location_id(L1,L2) 
         SELECT * FROM job;       -- *직책*job_code(J1)
         SELECT* FROM location;   -- * 국가*local_code (L1,L2) national_code(KO,)
          SELECT* FROM national;  -- *국가*national_code(KO,)
           SELECT* FROM sal_grade; --  *민 맥스*sal_level(S1,S2)