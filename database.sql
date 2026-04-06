
------------------------SQL-Code-------------------------------

-- Database create
CREATE DATABASE employeemanagement;

-- Database select
USE employeemanagement;

-- Login table
CREATE TABLE login (
    username VARCHAR(50),
    password VARCHAR(50)
);

-- Default login user
INSERT INTO login (username, password)
VALUES ('gaurav','gaurav4898');

-- Employee table
CREATE TABLE employee (
    name VARCHAR(50),
    fname VARCHAR(50),
    dob VARCHAR(50),
    salary VARCHAR(20),
    address VARCHAR(100),
    phone VARCHAR(20),
    email VARCHAR(50),
    education VARCHAR(50),
    designation VARCHAR(50),
    aadhar VARCHAR(20),
    empId VARCHAR(20) PRIMARY KEY
);