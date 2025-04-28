--
-- ----------------------------------------------------------------------------------------------------------------- PID
SELECT ps.PID, p.PID
FROM PRODUCTSUPPLIER AS ps
         LEFT OUTER JOIN PRODUCT AS p ON ps.PID = p.PID
WHERE p.PID IS NULL
;

-- ----------------------------------------------------------------------------------------------------------------- SID
SELECT ps.PID, s.SID
FROM PRODUCTSUPPLIER AS ps
         LEFT OUTER JOIN DB2INST1.SUPPLIERS AS s ON ps.PID = s.SID
WHERE s.SID IS NULL
;
