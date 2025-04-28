--

create table DB2INST1.EMP_RESUME
(
    EMPNO         CHARACTER(6) not null
        constraint FK_EMP_RESUME references DB2INST1.EMPLOYEE,
    RESUME_FORMAT VARCHAR(10)  not null,
    RESUME        CLOB(5120),
    constraint PK_EMP_RESUME primary key (EMPNO, RESUME_FORMAT)
);


-- --------------------------------------------------------------------------------------------------------------- EMPNO

-- ------------------------------------------------------------------------------------------------------- RESUME_FORMAT
SELECT DISTINCT RESUME_FORMAT
FROM EMP_RESUME
ORDER BY RESUME_FORMAT ASC
;

-- -------------------------------------------------------------------------------------------------------------- RESUME