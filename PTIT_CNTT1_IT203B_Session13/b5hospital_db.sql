DROP DATABASE IF EXISTS b5hospital_db;
CREATE DATABASE b5hospital_db;
USE b5hospital_db;

CREATE TABLE Patients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    age INT
);

CREATE TABLE Beds (
    id INT PRIMARY KEY,
    status VARCHAR(50)
);

CREATE TABLE Finance (
    id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT,
    amount DOUBLE
);

-- dữ liệu mẫu
INSERT INTO Beds VALUES 
(1,'Trống'),
(2,'Trống'),
(3,'Đã có người');