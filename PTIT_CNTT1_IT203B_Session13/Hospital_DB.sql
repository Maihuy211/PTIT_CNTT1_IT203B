DROP DATABASE IF EXISTS hospital_db;
CREATE DATABASE hospital_db;
USE hospital_db;

-- =========================
-- BÀI 1: CẤP PHÁT THUỐC
-- =========================
CREATE TABLE Medicine_Inventory (
    medicine_id INT PRIMARY KEY AUTO_INCREMENT,
    medicine_name VARCHAR(255),
    quantity INT
);

CREATE TABLE Patients (
    patient_id INT PRIMARY KEY AUTO_INCREMENT,
    patient_name VARCHAR(255),
    age INT,
    status VARCHAR(50)
);

CREATE TABLE Prescription_History (
    id INT PRIMARY KEY AUTO_INCREMENT,
    patient_id INT,
    medicine_id INT,
    date DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- dữ liệu mẫu
INSERT INTO Medicine_Inventory VALUES (1,'Paracetamol',100);
INSERT INTO Patients VALUES (1,'Nguyen Van A',30,'sađá');

-- =========================
-- BÀI 2: THANH TOÁN
-- =========================
CREATE TABLE Patient_Wallet (
    wallet_id INT PRIMARY KEY AUTO_INCREMENT,
    patient_id INT,
    balance DOUBLE
);

CREATE TABLE Invoices (
    invoice_id INT PRIMARY KEY AUTO_INCREMENT,
    patient_id INT,
    amount DOUBLE,
    status VARCHAR(50)
);

-- thêm bảng sai tên để match Java (Invoicess)
CREATE TABLE Invoicess (
    invoice_id INT PRIMARY KEY AUTO_INCREMENT,
    patient_id INT,
    amount DOUBLE,
    status VARCHAR(50)
);
CREATE TABLE Beds (
    bed_id INT PRIMARY KEY,
    patient_id INT,
    status VARCHAR(50)
);


-- dữ liệu mẫu
INSERT INTO Patient_Wallet VALUES (1,1,1000000);
INSERT INTO Invoices VALUES (1,1,500000,'UNPAID');
INSERT INTO Invoicess VALUES (1,1,500000,'UNPAID');
INSERT INTO Beds VALUES (1, 1, 'Đang sử dụng');
