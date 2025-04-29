--
-- https://www.ibm.com/docs/en/db2/12.1.0?topic=samples-sample-database#r0001094__xmpsal__title__1

SELECT *
FROM SALES
LIMIT 10
;

SELECT SALES_DATE, SALES_PERSON, REGION, COUNT(1)
FROM SALES
GROUP BY SALES_DATE, SALES_PERSON, REGION
HAVING COUNT(1) > 2
;

-- ---------------------------------------------------------------------------------------------------------- SALES_DATE
-- -------------------------------------------------------------------------------------------------------- SALES_PERSON
SELECT s.SALES_PERSON, e.LASTNAME
FROM SALES AS s
         LEFT OUTER JOIN EMPLOYEE AS e ON s.SALES_PERSON = e.LASTNAME
WHERE e.LASTNAME IS NOT NULL
LIMIT 10
;

SELECT s.SALES_PERSON, e.LASTNAME
FROM SALES AS s
         LEFT OUTER JOIN EMPLOYEE AS e ON s.SALES_PERSON = e.LASTNAME
WHERE e.LASTNAME IS NULL
LIMIT 10
;
-- -------------------------------------------------------------------------------------------------------- REGION
-- -------------------------------------------------------------------------------------------------------- SALES


