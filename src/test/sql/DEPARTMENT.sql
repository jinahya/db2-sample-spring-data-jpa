-- -- DB2INST1.DEPARTMENT definition
--
-- CREATE TABLE "DB2INST1"."DEPARTMENT"
-- (
--     "DEPTNO"   CHAR(3 OCTETS)     NOT NULL,
--     "DEPTNAME" VARCHAR(36 OCTETS) NOT NULL,
--     "MGRNO"    CHAR(6 OCTETS),
--     "ADMRDEPT" CHAR(3 OCTETS)     NOT NULL,
--     "LOCATION" CHAR(16 OCTETS)
-- )
--     IN "USERSPACE1"
--     ORGANIZE BY ROW;
--
-- CREATE INDEX "DB2INST1"."XDEPT2" ON "DB2INST1"."DEPARTMENT"
--     ("MGRNO" ASC)
--     COMPRESS NO
--     INCLUDE NULL KEYS ALLOW REVERSE SCANS;
--
-- CREATE INDEX "DB2INST1"."XDEPT3" ON "DB2INST1"."DEPARTMENT"
--     ("ADMRDEPT" ASC)
--     COMPRESS NO
--     INCLUDE NULL KEYS ALLOW REVERSE SCANS;
--
-- ALTER TABLE "DB2INST1"."DEPARTMENT"
--     ADD CONSTRAINT "PK_DEPARTMENT" PRIMARY KEY
--         ("DEPTNO")
--     ENFORCED;
--
-- CREATE ALIAS "DB2INST1"."DEPT" FOR TABLE "DB2INST1"."DEPARTMENT";
--
-- ALTER TABLE "DB2INST1"."DEPARTMENT"
--     ADD CONSTRAINT "RDE" FOREIGN KEY
--         ("MGRNO")
--         REFERENCES "DB2INST1"."EMPLOYEE"
--             ("EMPNO")
--         ON DELETE SET NULL
--         ON UPDATE NO ACTION
--         ENFORCED
--         ENABLE QUERY OPTIMIZATION;
--
-- ALTER TABLE "DB2INST1"."DEPARTMENT"
--     ADD CONSTRAINT "ROD" FOREIGN KEY
--         ("ADMRDEPT")
--         REFERENCES "DB2INST1"."DEPARTMENT"
--             ("DEPTNO")
--         ON DELETE CASCADE
--         ON UPDATE NO ACTION
--         ENFORCED
--         ENABLE QUERY OPTIMIZATION;
--
-- GRANT CONTROL ON TABLE "DB2INST1"."DEPARTMENT" TO USER "DB2INST1";
--
-- GRANT CONTROL ON INDEX "DB2INST1"."PK_DEPARTMENT" TO USER "DB2INST1";
--
-- GRANT CONTROL ON INDEX "DB2INST1"."XDEPT2" TO USER "DB2INST1";
--
-- GRANT CONTROL ON INDEX "DB2INST1"."XDEPT3" TO USER "DB2INST1";


-- -------------------------------------------------------------------------------------------------------------- DEPTNO

-- ------------------------------------------------------------------------------------------------------------ DEPTNAME

-- --------------------------------------------------------------------------------------------------------------- MGRNO

-- ------------------------------------------------------------------------------------------------------------ ADMRDEPT
SELECT DEPTNO, ADMRDEPT
FROM DEPARTMENT
WHERE ADMRDEPT = DEPTNO
;

SELECT d1.DEPTNO, d1.DEPTNAME, d1.ADMRDEPT, d2.DEPTNO, d2.DEPTNAME, d2.ADMRDEPT
FROM DEPARTMENT AS d1
         LEFT OUTER JOIN DEPARTMENT AS d2 ON d1.ADMRDEPT = d2.DEPTNO
;

SELECT d1.ADMRDEPT, d2.DEPTNO
FROM DEPARTMENT AS d1
         LEFT OUTER JOIN DEPARTMENT AS d2 ON d1.ADMRDEPT = d2.DEPTNO
WHERE d2.DEPTNO IS NULL
;

-- ------------------------------------------------------------------------------------------------------------ LOCATION