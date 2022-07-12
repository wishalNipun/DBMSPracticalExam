DROP DATABASE IF EXISTS IJSE;
CREATE DATABASE IF NOT EXISTS  IJSE;
SHOW DATABASES ;
USE  IJSE;
DROP TABLE IF EXISTS Student;

CREATE TABLE IF NOT EXISTS Student(
    student_id VARCHAR(45),
    student_name VARCHAR (45),
    email TEXT,
    contact VARCHAR (20),
    address TEXT,
    nic VARCHAR (45),
    CONSTRAINT PRIMARY KEY (student_id)
    );

DESC Student;

CREATE TABLE IF NOT EXISTS Teacher(
    teacher_id VARCHAR(45),
    name VARCHAR (45),
    nic VARCHAR (45),
    contact VARCHAR (45),
    address TEXT,
    CONSTRAINT PRIMARY KEY (teacher_id)
    );

DESC Teacher;

CREATE TABLE IF NOT EXISTS Subject(
    subject_id VARCHAR(45),
    subject_name VARCHAR (45),
    credit DOUBLE,
    teacher_id VARCHAR(45),
    CONSTRAINT PRIMARY KEY (subject_id),
    CONSTRAINT FOREIGN KEY (teacher_id) REFERENCES Teacher(teacher_id) ON DELETE CASCADE ON UPDATE CASCADE
    );
DESC Subject;


CREATE TABLE IF NOT EXISTS Course(
    course_id VARCHAR(45),
    course_name VARCHAR (45),
    cost DOUBLE,
    duration VARCHAR(45),
    subject_id VARCHAR(45),
    CONSTRAINT PRIMARY KEY (course_id),
    CONSTRAINT FOREIGN KEY (subject_id) REFERENCES Subject(subject_id) ON DELETE CASCADE ON UPDATE CASCADE
    );
DESC Course;

CREATE TABLE IF NOT EXISTS Intake(
    intake_id VARCHAR(45),
    start_date DATE,
    description VARCHAR(45),
    course_id VARCHAR(45),
    CONSTRAINT PRIMARY KEY (intake_id),
    CONSTRAINT FOREIGN KEY (course_id) REFERENCES Course(course_id) ON DELETE CASCADE ON UPDATE CASCADE
    );
DESC Intake;


CREATE TABLE IF NOT EXISTS Registration(
    registration_id VARCHAR(45),
    reg_date Date,
    student_id VARCHAR(45),
    intake_id VARCHAR(45),
    CONSTRAINT PRIMARY KEY (registration_id),
    CONSTRAINT FOREIGN KEY (student_id) REFERENCES Student(student_id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FOREIGN KEY (intake_id) REFERENCES Intake(intake_id) ON DELETE CASCADE ON UPDATE CASCADE
    );

DESC Registration;

CREATE TABLE IF NOT EXISTS Payment(
    payment_id VARCHAR(45),
    date Date,
    cost DOUBLE,
    registration_id VARCHAR(45),
    CONSTRAINT PRIMARY KEY (payment_id),
    CONSTRAINT FOREIGN KEY (registration_id) REFERENCES Registration(registration_id) ON DELETE CASCADE ON UPDATE CASCADE
    );
DESC Payment;


DESC Student;
DESC Subject;
DESC Course;
DESC Intake;
DESC Registration;
DESC Payment;


INSERT INTO Student VALUES ('S001','Wishal','wishal197@gmail.com','0701234567','moragall,Beruwala','200019600470');
INSERT INTO Student VALUES ('S002','Kamal','Kamal@gmail.com','0701234566','Beruwala','200012345678');
INSERT INTO Student VALUES ('S003','Nimal','Nimal@gmail.com','0701234565','Aluthgama','200012345677');
INSERT INTO Student VALUES ('S004','Amal','Amal@gmail.com','070123454','Panaduara','200012345676');
INSERT INTO Student VALUES ('S005','Nayana','Nayana@gmail.com','0701234563','Kaluthara','200012345675');

INSERT INTO Teacher VALUES('t001','Mr.Gayan','458956954v','0703574953','kalutara');
INSERT INTO Teacher VALUES('t002','Miss.Kamani','89654236v','0735896584','panadura');
INSERT INTO Teacher VALUES('t003','Mr.Prabath','965325457v','0749645893','galle');
INSERT INTO Teacher VALUES('t004','Mr.Nuwan','89213212v','0718955478','waskaduwa');
INSERT INTO Teacher VALUES('t005','Miss.Nimna','2356989v','0775696120','wadduwa');

INSERT INTO Subject VALUES('sb001','PRF',100.00,'t001');
INSERT INTO Subject VALUES('sb002','OOP',100.00,'t002');
INSERT INTO Subject VALUES('sb003','ORM',100.00,'t003');
INSERT INTO Subject VALUES('sb004','SQL',100.00,'t004');
INSERT INTO Subject VALUES('sb005','Layered_Architecture',100.00,'t005');

INSERT INTO Course VALUES('c001','gdse',132000.00,'3 years','sb001');
INSERT INTO Course VALUES('c002','gpe',145000.00,'2 years','sb002');
INSERT INTO Course VALUES('c003','cmjd',270000.00,'1 year','sb003');
INSERT INTO Course VALUES('c004','rmad',85000.00,'4 years','sb004');
INSERT INTO Course VALUES('c005','gdseII',95000.00,'1 year','sb005');

INSERT INTO Intake VALUES('i001','2022-07-13','sdjhfd','c001');
INSERT INTO Intake VALUES('i002','2022-07-15','dfsg','c002');
INSERT INTO Intake VALUES('i003','2022-07-19','sfgdfh','c003');
INSERT INTO Intake VALUES('i004','2022-07-20','ssdsdg','c004');
INSERT INTO Intake VALUES('i005','2022-07-26','dsfasg','c005');

INSERT INTO Registration VALUES('R001','2022-07-12','s001','i001');
INSERT INTO Registration VALUES('R002','2022-07-12','s002','i002');
INSERT INTO Registration VALUES('R003','2022-07-12','s003','i003');
INSERT INTO Registration VALUES('R004','2022-07-12','s004','i004');
INSERT INTO Registration VALUES('R005','2022-07-12','s005','i005');

INSERT INTO Payment VALUES('p001','2022-07-12',132000.00,'R001');
INSERT INTO Payment VALUES('p002','2022-07-12',128666.00,'R002');
INSERT INTO Payment VALUES('p003','2022-07-12',85000.00,'R003');
INSERT INTO Payment VALUES('p004','2022-07-12',90000.00,'R004');
INSERT INTO Payment VALUES('p005','2022-07-12',132000.00,'R005');