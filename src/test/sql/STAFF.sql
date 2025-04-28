
-- https://www.ibm.com/docs/en/db2/12.1.0?topic=samples-sample-database#r0001094__os2staf__title__1

-- ------------------------------------------------------------------------------------------------------------------ ID
SELECT ID, COUNT(ID)
FROM STAFF
GROUP BY ID
HAVING COUNT(ID) > 1
ORDER BY COUNT(ID) DESC
;

SELECT s.ID, e.EMPNO
FROM STAFF AS s
         LEFT OUTER JOIN EMPLOYEE AS e ON ID = e.EMPNO
WHERE e.EMPNO IS NOT NULL
LIMIT 10
;
SELECT s.ID, e.EMPNO
FROM STAFF AS s
         LEFT OUTER JOIN EMPLOYEE AS e ON ID = e.EMPNO
WHERE e.EMPNO IS NULL
LIMIT 10
;

SELECT s.ID, LPAD(s.ID, 6, '0'), e.EMPNO
FROM STAFF AS s
         LEFT OUTER JOIN EMPLOYEE AS e ON LPAD(s.ID, 6, '0') = e.EMPNO
WHERE e.EMPNO IS NOT NULL
LIMIT 10
;
SELECT s.ID, LPAD(s.ID, 6, '0'), e.EMPNO
FROM STAFF AS s
         LEFT OUTER JOIN EMPLOYEE AS e ON LPAD(s.ID, 6, '0') = e.EMPNO
WHERE e.EMPNO IS NULL
LIMIT 10
;

-- ---------------------------------------------------------------------------------------------------------------- NAME

-- ---------------------------------------------------------------------------------------------------------------- DEPT

-- ----------------------------------------------------------------------------------------------------------------- JOB

-- --------------------------------------------------------------------------------------------------------------- YEARS

-- -------------------------------------------------------------------------------------------------------------- SALARY

-- ---------------------------------------------------------------------------------------------------------------- COMM