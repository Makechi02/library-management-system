DROP DATABASE library_management_system;
CREATE DATABASE library_management_system;

USE library_management_system;

CREATE TABLE librarians (
    id         INT(8)      NOT NULL,
    name       VARCHAR(25) NOT NULL,
    email      VARCHAR(25) NOT NULL,
    password   VARCHAR(20) NOT NULL,
    added_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

INSERT INTO librarians (id, name, email, password)
VALUES (12345678, 'Mwaki Mwaki', 'librarian@uni.com', 'librarian');

CREATE TABLE students (
    reg_no        VARCHAR(50)  NOT NULL,
    name          VARCHAR(255) NOT NULL,
    password      VARCHAR(50)  NOT NULL,
    email         VARCHAR(255),
    department    VARCHAR(25),
    date_of_birth DATE,
    gender        VARCHAR(10)  NOT NULL,
    contact       VARCHAR(20),
    image         VARCHAR(50),
    date_joined   DATE DEFAULT (CURRENT_DATE),
    PRIMARY KEY (reg_no)
);

INSERT INTO students (reg_no, name, password, email, department, date_of_birth, gender, contact, image, date_joined)
VALUES ("G30/GV/44428/2020", "Makbe Mkuu", "student", "student@uni.com", "COMPUTER SCIENCE", "2001-11-29", "MALE",
        "0700000000", "student.jpg", "2020-10-13");

CREATE TABLE admin (
    id       INT AUTO_INCREMENT,
    username VARCHAR(50)  NOT NULL,
    password VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO admin (username, password)
VALUES ("admin", "admin");
