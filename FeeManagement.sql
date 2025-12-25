CREATE DATABASE fee_management;

USE fee_management;

CREATE TABLE students(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    roll VARCHAR(20),
    course VARCHAR(30),
    total_fee INT,
    paid_fee INT,
    balance INT
);