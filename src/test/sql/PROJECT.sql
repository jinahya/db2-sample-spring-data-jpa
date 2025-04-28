create table DB2INST1.PROJECT
(
    PROJNO   CHARACTER(6)           not null constraint PK_PROJECT
            primary key,
    PROJNAME VARCHAR(24) default '' not null,
    DEPTNO   CHARACTER(3)           not null constraint FK_PROJECT_1
            references DB2INST1.DEPARTMENT,
    RESPEMP  CHARACTER(6)           not null constraint FK_PROJECT_2
            references DB2INST1.EMPLOYEE,
    PRSTAFF  DECIMAL(5, 2),
    PRSTDATE DATE,
    PRENDATE DATE,
    MAJPROJ  CHARACTER(6) constraint RPP
            references DB2INST1.PROJECT
            on delete cascade
);

create index DB2INST1.XPROJ2
    on DB2INST1.PROJECT (RESPEMP);



-- ------------------------------------------------------------------------------------------------------------ PROJNO
-- ------------------------------------------------------------------------------------------------------------ PROJNAME
-- ------------------------------------------------------------------------------------------------------------ DEPTNO
-- ------------------------------------------------------------------------------------------------------------ RESPEMP
-- ------------------------------------------------------------------------------------------------------------ PRSTAFF
-- ------------------------------------------------------------------------------------------------------------ PRSTDATE
-- ------------------------------------------------------------------------------------------------------------ PRENDATE
-- ------------------------------------------------------------------------------------------------------------ MAJPROJ