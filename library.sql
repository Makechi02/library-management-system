DROP DATABASE library_management_system;
CREATE DATABASE library_management_system;

USE library_management_system;

CREATE TABLE librarians
(
    `ID`         INT(8)      NOT NULL,
    `NAME`       VARCHAR(25) NOT NULL,
    `EMAIL`      VARCHAR(25) NOT NULL,
    `PASSWORD`   VARCHAR(20) NOT NULL,
    `ADDED_DATE` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (ID)
);

INSERT INTO librarians (ID, NAME, EMAIL, PASSWORD)
VALUES (12345678, 'Mwaki Mwaki', 'librarian@uni.com', 'librarian');

CREATE TABLE students
(
    `REG_NO`      VARCHAR(50)  NOT NULL,
    `NAME`        VARCHAR(255) NOT NULL,
    `PASSWORD`    VARCHAR(50)  NOT NULL,
    `EMAIL`       VARCHAR(255),
    `DEPARTMENT`  VARCHAR(25),
    `DOB`         DATE,
    `GENDER`      VARCHAR(10)  NOT NULL,
    `CONTACT`     VARCHAR(20),
    `IMAGE`       VARCHAR(50),
    `DATE_JOINED` DATE DEFAULT (CURRENT_DATE),
    PRIMARY KEY (REG_NO)
);

INSERT INTO students (REG_NO, NAME, PASSWORD, EMAIL, DEPARTMENT, DOB, GENDER, CONTACT, IMAGE, DATE_JOINED)
VALUES ("G30/GV/44428/2020", "Makbe Mkuu", "student", "student@uni.com", "COMPUTER SCIENCE", "2001-11-29", "MALE",
        "0700000000", "student.jpg", "2020-10-13");

CREATE TABLE admin
(
    `ID`       INT AUTO_INCREMENT,
    `USERNAME` VARCHAR(50)  NOT NULL,
    `PASSWORD` VARCHAR(100) NOT NULL,
    PRIMARY KEY (`ID`)
);

INSERT INTO admin (USERNAME, PASSWORD)
VALUES ("admin", "admin");
