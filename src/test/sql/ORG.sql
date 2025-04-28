-- https://www.ibm.com/docs/en/db2/12.1.0?topic=samples-sample-database#r0001094__os2org__title__1

-- ------------------------------------------------------------------------------------------------------------ DEPTNUMB
SELECT DEPTNUMB, COUNT(1)
FROM ORG
GROUP BY DEPTNUMB
;

SELECT o.DEPTNUMB, d.MGRNO
FROM ORG AS o
         LEFT OUTER JOIN DEPARTMENT AS d ON o.DEPTNUMB = d.MGRNO
WHERE d.DEPTNO IS NOT NULL
LIMIT 10
;

SELECT o.DEPTNUMB, o.DEPTNAME, o.MANAGER, d.DEPTNO, d.DEPTNAME, d.MGRNO, d.DEPTNAME
FROM ORG AS o
         LEFT OUTER JOIN DEPARTMENT AS d ON o.DEPTNUMB = d.MGRNO
WHERE d.DEPTNO IS NOT NULL
LIMIT 10
;

SELECT o.DEPTNUMB, d.DEPTNO
FROM ORG AS o
         LEFT OUTER JOIN DEPARTMENT AS d ON o.DEPTNUMB = d.MGRNO
WHERE d.DEPTNO IS NULL
LIMIT 10
;

-- ------------------------------------------------------------------------------------------------------------ DEPTNAME

-- ------------------------------------------------------------------------------------------------------------- MANAGER
SELECT o.MANAGER, e.EMPNO
FROM ORG AS o
         LEFT OUTER JOIN EMPLOYEE AS e ON e.EMPNO = o.MANAGER
WHERE e.EMPNO IS NOT NULL
LIMIT 10
;
SELECT o.MANAGER, e.EMPNO
FROM ORG AS o
         LEFT OUTER JOIN EMPLOYEE AS e ON e.EMPNO = o.MANAGER
WHERE e.EMPNO IS NULL
LIMIT 10
;

-- ------------------------------------------------------------------------------------------------------------ DIVISION

-- ------------------------------------------------------------------------------------------------------------ LOCATION


SELECT DEPTNUMB, MANAGER, COUNT(1)
FROM ORG
GROUP BY DEPTNUMB, MANAGER
-- HAVING COUNT(1) > 1
;

SELECT DIVISION, DEPTNUMB, COUNT(1)
FROM ORG
GROUP BY ORG.DIVISION, ORG.DEPTNUMB
-- HAVING COUNT(1) > 1
;