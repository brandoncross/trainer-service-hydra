--------------------------------------------------------
--  
--------------------------------------------------------
DROP TABLE IF EXISTS HYDRA_TRAINER;
CREATE TABLE HYDRA_TRAINER(
	TRAINER_ID INT(10) PRIMARY KEY,
	EMAIL VARCHAR(30) UNIQUE NOT NULL,
	NAME VARCHAR(30),
	TITLE VARCHAR(30),
	TIER VARCHAR(30),
	RESUME VARCHAR(30)
);

DROP TABLE IF EXISTS USER;
CREATE TABLE USER(
	USER_ID INT(10) PRIMARY KEY,
	PASSWORD VARCHAR(30),
	BACKUP_PASSWORD VARCHAR(30),
	EMAIL VARCHAR(30) UNIQUE NOT NULL,
	FIRST_NAME VARCHAR(30),
	MIDDLE_NAME VARCHAR(30),
	LAST_NAME VARCHAR(30),
	ROLE INT(10),
	HOME_PHONE VARCHAR(30),
	MOBILE_PHONE VARCHAR(30),
	TOKEN VARCHAR(260)
);

DROP TABLE IF EXISTS TRAINER;
CREATE TABLE TRAINER(
	TRAINER_ID INT(10) PRIMARY KEY,
	TITLE VARCHAR(30) NOT NULL,
	USER_ID INT(10)
);

DROP TABLE IF EXISTS ROLES;
CREATE TABLE ROLES(
	ROLE_ID INT(10) PRIMARY KEY,
	ROLE VARCHAR(30) NOT NULL
);

DROP TABLE IF EXISTS HYDRA_CERTIFICATION;
CREATE TABLE HYDRA_CERTIFICATION(
	CERT_ID INT(10) PRIMARY KEY,
	URL VARCHAR(200),
	NAME VARCHAR(30)
);

DROP TABLE IF EXISTS TRAINER_CERT;
CREATE TABLE TRAINER_CERT(
	t_id INT(10) REFERENCES HYDRA_TRAINER (TRAINER_ID),
	c_id INT(10) REFERENCES HYDRA_CERTIFICATION (CERT_ID),
	CONSTRAINT TRAINER_CERT_PK PRIMARY KEY (t_id, c_id)
);

DROP TABLE IF EXISTS TRAINER_SKILL;
CREATE TABLE TRAINER_SKILL(
	t_id INT(10) REFERENCES HYDRA_TRAINER (TRAINER_ID),
	skill_id int(10)
);
--------------------------------------------------------
--  DDL for Sequence TRAINER_ID_SEQUENCE
--------------------------------------------------------
DROP SEQUENCE IF EXISTS TRAINER_ID_SEQUENCE;
CREATE SEQUENCE IF NOT EXISTS TRAINER_ID_SEQUENCE MINVALUE 1 INCREMENT BY 1 START WITH 1;
DROP SEQUENCE IF EXISTS CERT_ID_SEQUENCE;
CREATE SEQUENCE IF NOT EXISTS CERT_ID_SEQUENCE MINVALUE 1 INCREMENT BY 1 START WITH 1;
DROP SEQUENCE IF EXISTS USER_ID_SEQ;
CREATE SEQUENCE IF NOT EXISTS USER_ID_SEQ MINVALUE 3 INCREMENT BY 1 START WITH 3;
DROP SEQUENCE IF EXISTS TRAINER_ID_SEQ;
CREATE SEQUENCE IF NOT EXISTS TRAINER_ID_SEQ MINVALUE 3 INCREMENT BY 1 START WITH 3;

----------- OLD TRAINER TABLE -------------
--INSERT INTO HYDRA_TRAINER(TRAINER_ID, EMAIL, NAME, TITLE, TIER, RESUME) VALUES( TRAINER_ID_SEQUENCE.NEXTVAL, 'patrick.walsh@revature.com', 'Patrick Walsh', 'Lead Trainer', 'ROLE_VP', 'resume1');
--INSERT INTO HYDRA_TRAINER(TRAINER_ID, EMAIL, NAME, TITLE, TIER, RESUME) VALUES( TRAINER_ID_SEQUENCE.NEXTVAL, 'pjw6193@hotmail.com', 'Dan Pickles', 'Lead Trainer', 'ROLE_VP', 'resume2');
--INSERT INTO HYDRA_TRAINER(TRAINER_ID, EMAIL, NAME, TITLE, TIER, RESUME) VALUES( TRAINER_ID_SEQUENCE.NEXTVAL, 'ravi.singh@revature.com', 'Ravi Singh', 'Vice President of Technology', 'ROLE_VP', 'resume3');
--INSERT INTO HYDRA_TRAINER(TRAINER_ID, EMAIL, NAME, TITLE, TIER, RESUME) VALUES( TRAINER_ID_SEQUENCE.NEXTVAL, 'karan.dhirar@revature.com', 'Karan Dhirar', 'Technology Manager', 'ROLE_VP', 'resume4');
--INSERT INTO HYDRA_TRAINER(TRAINER_ID, EMAIL, NAME, TITLE, TIER, RESUME) VALUES( TRAINER_ID_SEQUENCE.NEXTVAL, 'brian.connolly@revature.com', 'Brian Connolly', 'Senior Java Developer', 'ROLE_VP', 'resume5');
--INSERT INTO HYDRA_TRAINER(TRAINER_ID, EMAIL, NAME, TITLE, TIER, RESUME) VALUES( TRAINER_ID_SEQUENCE.NEXTVAL, 'genesis.bonds@revature.com', 'Genesis Bonds', 'Trainer', 'ROLE_TRAINER', 'resume6');
--INSERT INTO HYDRA_TRAINER(TRAINER_ID, EMAIL, NAME, TITLE, TIER, RESUME) VALUES( TRAINER_ID_SEQUENCE.NEXTVAL, 'ankit.garg@revature.com', 'Ankit Garg', 'Lead Trainer', 'ROLE_TRAINER', 'resume7');
--INSERT INTO HYDRA_TRAINER(TRAINER_ID, EMAIL, NAME, TITLE, TIER, RESUME) VALUES( TRAINER_ID_SEQUENCE.NEXTVAL, 'ryan.lessley@revature.com', 'Ryan Lessley', 'Senior Trainer', 'ROLE_TRAINER', 'resume8');
--INSERT INTO HYDRA_TRAINER(TRAINER_ID, EMAIL, NAME, TITLE, TIER, RESUME) VALUES( TRAINER_ID_SEQUENCE.NEXTVAL, 'steven.kelsey@revature.com', 'Steven Kelsey', 'Senior Trainer', 'ROLE_TRAINER', 'resume9');
--INSERT INTO HYDRA_TRAINER(TRAINER_ID, EMAIL, NAME, TITLE, TIER, RESUME) VALUES( TRAINER_ID_SEQUENCE.NEXTVAL, 'emily.higgins@revature.com', 'Emily Higgins', 'Trainer', 'ROLE_TRAINER', 'resume10');
--INSERT INTO HYDRA_TRAINER(TRAINER_ID, EMAIL, NAME, TITLE, TIER, RESUME) VALUES( TRAINER_ID_SEQUENCE.NEXTVAL, 'taylor.kemper@revature.com', 'Taylor Kemper', 'Senior Trainer', 'ROLE_TRAINER', 'resume11');
--INSERT INTO HYDRA_TRAINER(TRAINER_ID, EMAIL, NAME, TITLE, TIER, RESUME) VALUES( TRAINER_ID_SEQUENCE.NEXTVAL, 'richard.orr@revature.com', 'Richard Orr', 'Trainer', 'ROLE_TRAINER', 'resume12');
--INSERT INTO HYDRA_TRAINER(TRAINER_ID, EMAIL, NAME, TITLE, TIER, RESUME) VALUES( TRAINER_ID_SEQUENCE.NEXTVAL, 'nickolas.jurczak@revature.com', 'Nickolas Jurczak', 'Trainer', 'ROLE_TRAINER', 'resume13');
--INSERT INTO HYDRA_TRAINER(TRAINER_ID, EMAIL, NAME, TITLE, TIER, RESUME) VALUES( TRAINER_ID_SEQUENCE.NEXTVAL, 'august.duet@revature.com', 'August Duet', 'Trainer', 'ROLE_TRAINER', 'resume14');
--INSERT INTO HYDRA_TRAINER(TRAINER_ID, EMAIL, NAME, TITLE, TIER, RESUME) VALUES( TRAINER_ID_SEQUENCE.NEXTVAL, 'yuvarajd@revature.com', 'Yuvaraj Damodaran', 'Lead Trainer', 'ROLE_TRAINER', 'resume15');
--INSERT INTO HYDRA_TRAINER(TRAINER_ID, EMAIL, NAME, TITLE, TIER, RESUME) VALUES( TRAINER_ID_SEQUENCE.NEXTVAL, 'fred.belotte@revature.com', 'Fred Belotte', 'Senior Trainer', 'ROLE_TRAINER', 'resume16');
--INSERT INTO HYDRA_TRAINER(TRAINER_ID, EMAIL, NAME, TITLE, TIER, RESUME) VALUES( TRAINER_ID_SEQUENCE.NEXTVAL, 'mehrab.rahman@revature.com', 'Mehrab Rahman', 'Trainer', 'ROLE_TRAINER', 'resume17');
--INSERT INTO HYDRA_TRAINER(TRAINER_ID, EMAIL, NAME, TITLE, TIER, RESUME) VALUES( TRAINER_ID_SEQUENCE.NEXTVAL, 'peter.alagna@revature.com', 'Peter Alagna', 'Trainer', 'ROLE_TRAINER', 'resume18');
--INSERT INTO HYDRA_TRAINER(TRAINER_ID, EMAIL, NAME, TITLE, TIER, RESUME) VALUES( TRAINER_ID_SEQUENCE.NEXTVAL, 'stanleym@revature.com', 'Stanley Medikonda', 'Staging Manager', 'ROLE_STAGING', 'resume19');
--INSERT INTO HYDRA_TRAINER(TRAINER_ID, EMAIL, NAME, TITLE, TIER, RESUME) VALUES( TRAINER_ID_SEQUENCE.NEXTVAL, 'grawyne@gmail.com', 'Gray Wynne', 'Trainer', 'ROLE_TRAINER', 'resume20');
--INSERT INTO HYDRA_TRAINER(TRAINER_ID, EMAIL, NAME, TITLE, TIER, RESUME) VALUES(TRAINER_ID_SEQUENCE.NEXTVAL, 'owallace@mailinator.com', 'Orson Wallace', 'Trainer', 'ROLE_TRAINER', 'resume21');
--INSERT INTO HYDRA_TRAINER(TRAINER_ID, EMAIL, NAME, TITLE, TIER, RESUME) VALUES(TRAINER_ID_SEQUENCE.NEXTVAL, 'slevinson@mailinator.com', 'Shelby Levinson', 'Trainer', 'ROLE_TRAINER', 'resume22');
--INSERT INTO HYDRA_TRAINER(TRAINER_ID, EMAIL, NAME, TITLE, TIER, RESUME) VALUES(TRAINER_ID_SEQUENCE.NEXTVAL, 'wpayne@mailinator.com', 'Walter Payne', 'Trainer', 'ROLE_TRAINER', 'resume23');
INSERT INTO HYDRA_TRAINER(TRAINER_ID, EMAIL, NAME, TITLE, TIER, RESUME) VALUES(TRAINER_ID_SEQUENCE.NEXTVAL, 'nchurch@mailinator.com', 'Natalie Church', 'Trainer', 'ROLE_TRAINER', 'resume24');
INSERT INTO HYDRA_TRAINER(TRAINER_ID, EMAIL, NAME, TITLE, TIER, RESUME) VALUES(TRAINER_ID_SEQUENCE.NEXTVAL, 'aradcliff@mailinator.com', 'Archer Radcliff', 'Trainer', 'ROLE_TRAINER', 'resume25');
--------------------------------------------------------------------------------------------------------------------MAKE PANEL ROLE
INSERT INTO HYDRA_TRAINER(TRAINER_ID, EMAIL, NAME, TITLE, TIER, RESUME) VALUES( TRAINER_ID_SEQUENCE.NEXTVAL, 'rajeshy@revature.com', 'Rajesh Yamunachari', 'Senior Technical Manager', 'ROLE_PANEL', 'resume26');
INSERT INTO HYDRA_TRAINER(TRAINER_ID, EMAIL, NAME, TITLE, TIER, RESUME) VALUES( TRAINER_ID_SEQUENCE.NEXTVAL, 'raghavan@revature.com', 'Raghavan Swaminathan', 'Senior Technical Manager', 'ROLE_PANEL', 'resume27');
-------------OLD TRAINER END-------------

-------------ROLES--------------------

INSERT INTO ROLES(ROLE_ID, ROLE) VALUES(1, 'Trainer');
INSERT INTO ROLES(ROLE_ID, ROLE) VALUES(2, 'Panel');
INSERT INTO ROLES(ROLE_ID, ROLE) VALUES(3, 'Staging');
INSERT INTO ROLES(ROLE_ID, ROLE) VALUES(4, 'VP');
INSERT INTO ROLES(ROLE_ID, ROLE) VALUES(5, 'INACTIVE');


--------------USERS------------------

INSERT INTO USER(USER_ID, PASSWORD, BACKUP_PASSWORD, EMAIL, FIRST_NAME, MIDDLE_NAME, LAST_NAME, ROLE, HOME_PHONE, MOBILE_PHONE, TOKEN) VALUES( USER_ID_SEQ.NEXTVAL,  'pass', 'pass2', 'bsmalls@email.com', 'Brandon', 'Jerome', 'Smalls', 1, null, '8034144427', null);
INSERT INTO USER(USER_ID, PASSWORD, BACKUP_PASSWORD, EMAIL, FIRST_NAME, MIDDLE_NAME, LAST_NAME, ROLE, HOME_PHONE, MOBILE_PHONE, TOKEN) VALUES( USER_ID_SEQ.NEXTVAL,  'pass3', 'pass4', 'b@email.com', 'Brandon', 'Jerome', 'Smalls', 2, null, '8034144427', null);

------------NEW TRAINER---------------

INSERT INTO TRAINER(TRAINER_ID, TITLE, USER_ID) VALUES(TRAINER_ID_SEQUENCE.NEXTVAL, 'Trainer', 3);
------- CERTIFICATION TABLE ---------
INSERT INTO HYDRA_CERTIFICATION(CERT_ID, URL, NAME) VALUES (CERT_ID_SEQUENCE.NEXTVAL, 'URL1', 'CERT1');
INSERT INTO HYDRA_CERTIFICATION(CERT_ID, URL, NAME) VALUES (CERT_ID_SEQUENCE.NEXTVAL, 'URL2', 'CERT2');
INSERT INTO HYDRA_CERTIFICATION(CERT_ID, URL, NAME) VALUES (CERT_ID_SEQUENCE.NEXTVAL, 'URL3', 'CERT3');
---------- RELATION TABLE ------------
INSERT INTO TRAINER_CERT(T_ID, C_ID) VALUES (1, 1);
INSERT INTO TRAINER_CERT(T_ID, C_ID) VALUES (1, 2);
INSERT INTO TRAINER_CERT(T_ID, C_ID) VALUES (2, 2);
INSERT INTO TRAINER_CERT(T_ID, C_ID) VALUES (2, 3);
-------- CERTIFICATION END -----------

------ RELATION TABLE FOR SKILL ------
INSERT INTO TRAINER_SKILL(T_ID, SKILL_ID) VALUES (1, 1);
INSERT INTO TRAINER_SKILL(T_ID, SKILL_ID) VALUES (1, 5);
------------- SKILL END --------------

COMMIT;