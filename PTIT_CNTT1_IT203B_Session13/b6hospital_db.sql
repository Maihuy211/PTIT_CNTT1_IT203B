DROP DATABASE IF EXISTS b6hospital_db;
CREATE DATABASE b6hospital_db;
USE b6hospital_db;

-- PATIENTS
CREATE TABLE Patients (
    id int PRIMARY KEY,
    name VARCHAR(255),
    status VARCHAR(50)
);

-- BEDS
CREATE TABLE Beds (
    id VARCHAR(10) PRIMARY KEY,
    patient_id INT,
    status VARCHAR(50)
);

-- INVOICES
CREATE TABLE Invoices (
    id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT,
    amount DOUBLE,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- dữ liệu mẫu
INSERT INTO Patients VALUES (101, 'Nguyen Van A', 'Đang điều trị');

INSERT INTO Beds VALUES ('G01', 101, 'Đang sử dụng');