DROP DATABASE Library;
CREATE DATABASE library;

USE library;

CREATE TABLE librarian (
    `NAME` VARCHAR(25) NOT NULL,
    `ID` INT NOT NULL,
    `USERNAME` VARCHAR(20) NOT NULL,
    `EMAIL` VARCHAR(25) NOT NULL,
    `PASSWORD` VARCHAR(20) NOT NULL,
    PRIMARY KEY (ID)
);

INSERT INTO librarian
VALUES ('Librarian', 0001, 'librarian', 'librarian@uni.com', 'librarian');

INSERT INTO librarian
VALUES ('LibrarianTest', 0002, 'librariantest', 'test@uni.com', 'librarianTest');

CREATE TABLE student (
    `NAME` VARCHAR(255) NOT NULL,
    `REG_NO` VARCHAR(50) NOT NULL,
    `USERNAME` VARCHAR(50),
    `PASSWORD` VARCHAR(50) NOT NULL,
    `EMAIL` VARCHAR(255),
    `DEPARTMENT` VARCHAR(25),
    `DOB` DATE,
    `SEX` VARCHAR(10) NOT NULL,
    `CONTACT` VARCHAR(20),
    `IMAGE` VARCHAR(50),
    `JOINED_YEAR` DATE NOT NULL,
    PRIMARY KEY (REG_NO)
);

INSERT INTO student
VALUES ("Student", "G30/GV/44428/2020", "student", "student", "student@uni.com", "COMPUTER SCIENCE", "2001-11-29", "MALE", "0700000000", "student.jpg", "2020-10-13");

INSERT INTO student
VALUES ("Second Student", "X37/44284/2019", "student2", "student2", "student2@uni.com", "EDUCATION ARTS",
"1999-05-17", "FEMALE", "0700000001", "student2.jpg", "2019-01-18");

CREATE TABLE login (
    `USERNAME` VARCHAR(50) NOT NULL,
    `PASSWORD` VARCHAR(100) NOT NULL
);

INSERT INTO login
VALUES ("admin", "admin");
