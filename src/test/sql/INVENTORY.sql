--
-- ----------------------------------------------------------------------------------------------------------------- PID
SELECT i.PID, p.PID
FROM INVENTORY AS i
         LEFT OUTER JOIN PRODUCT AS p ON p.PID = i.PID
WHERE p.PID IS NOT NULL
LIMIT 10
;

SELECT i.PID, p.PID
FROM INVENTORY AS i
         LEFT OUTER JOIN PRODUCT AS p ON p.PID = i.PID
WHERE p.PID IS NULL
LIMIT 10
;

-- ------------------------------------------------------------------------------------------------------------ QUANTITY

-- ------------------------------------------------------------------------------------------------------------ LOCATION
SELECT DISTINCT LOCATION
FROM INVENTORY
;