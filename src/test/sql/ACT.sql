-- -- DB2INST1.ACT definition
--
-- CREATE TABLE "DB2INST1"."ACT"
-- (
--     "ACTNO"   SMALLINT           NOT NULL,
--     "ACTKWD"  CHAR(6 OCTETS)     NOT NULL,
--     "ACTDESC" VARCHAR(20 OCTETS) NOT NULL
-- )
--     IN "USERSPACE1"
--     ORGANIZE BY ROW;
--
-- CREATE UNIQUE INDEX "DB2INST1"."XACT2" ON "DB2INST1"."ACT"
--     ("ACTNO" ASC,
--      "ACTKWD" ASC)
--     COMPRESS NO
--     INCLUDE NULL KEYS ALLOW REVERSE SCANS;
--
-- ALTER TABLE "DB2INST1"."ACT"
--     ADD CONSTRAINT "PK_ACT" PRIMARY KEY
--         ("ACTNO")
--     ENFORCED;
--
-- ALTER TABLE "DB2INST1"."ACT"
--     ADD CONSTRAINT "RPAA" FOREIGN KEY
--         ("ACTNO")
--         REFERENCES "DB2INST1"."ACT"
--             ("ACTNO")
--         ON DELETE RESTRICT
--         ON UPDATE NO ACTION
--         ENFORCED
--         ENABLE QUERY OPTIMIZATION;
--
-- GRANT CONTROL ON TABLE "DB2INST1"."ACT" TO USER "DB2INST1";
--
-- GRANT CONTROL ON INDEX "DB2INST1"."PK_ACT" TO USER "DB2INST1";
--
-- GRANT CONTROL ON INDEX "DB2INST1"."XACT2" TO USER "DB2INST1";


SELECT *
FROM ACT
;

SELECT ACTNO, ACTKWD, COUNT(1) AS c
FROM ACT
GROUP BY ACTNO, ACTKWD
HAVING COUNT(1) > 1
;


-- --------------------------------------------------------------------------------------------------------------- ACTNO
SELECT a1.ACTNO, a2.ACTNO
FROM ACT AS a1
         LEFT OUTER JOIN ACT AS a2
                         ON a1.ACTNO = a2.ACTNO
;

-- -------------------------------------------------------------------------------------------------------------- ACTKWD

-- ------------------------------------------------------------------------------------------------------------- ACTDESC