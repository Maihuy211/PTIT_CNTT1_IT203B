create database if not exists Hospital_DB;
use Hospital_DB;

drop table if exists Pharmacy;
drop table if exists Beds;
drop table if exists Patients;
drop table if exists Doctors;

create table Pharmacy (
    id int primary key auto_increment,
    medicine_name VARCHAR(100) not null,
    stock int not null
);

create table Beds (
    bed_id varchar(20) primary key,
    bed_status varchar(20) not null
);

create table Patients (
    id int primary key auto_increment,
    full_name varchar(100),
    age INT
);

create table Doctors (
    doctor_id varchar(20) primary key,
    full_name varchar(100),
    specialty varchar(50)
);

insert into Pharmacy (medicine_name, stock) values
('Paracetamol', 100),
('Aspirin', 50),
('Vitamin C', 200),
('Amoxicillin', 75),
('Ibuprofen', 120);

insert into Beds (bed_id, bed_status) values
('Bed_001', 'Empty'),
('Bed_002', 'Empty'),
('Bed_003', 'Occupied');

insert into Patients (full_name, age) values
('Nguyen Van A', 30),
('Tran Thi B', 25),
('Le Van C', 40);

insert into Doctors (doctor_id, full_name, specialty) values
('D001', 'Nguyen Van A', 'Cardiology'),
('D002', 'Tran Thi B', 'Neurology'),
('D003', 'Le Van C', 'Cardiology'),
('D004', 'Pham Thi D', 'Pediatrics'),
('D005', 'Hoang Van E', 'Orthopedics');

select * from Pharmacy;
select * from Beds;
select * from Patients;
SELECT * FROM Doctors;