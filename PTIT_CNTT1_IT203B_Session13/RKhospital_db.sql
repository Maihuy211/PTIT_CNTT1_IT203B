
DROP DATABASE IF EXISTS RKhospital_db;
CREATE DATABASE RKhospital_db;
USE RKhospital_db;

-- =========================
-- BẢNG BỆNH NHÂN
-- =========================
CREATE TABLE BenhNhan (
    maBenhNhan INT PRIMARY KEY,
    tenBenhNhan VARCHAR(255)
);

-- =========================
-- BẢNG DỊCH VỤ SỬ DỤNG
-- =========================
CREATE TABLE DichVuSuDung (
    maDichVu INT PRIMARY KEY,
    tenDichVu VARCHAR(255),
    maBenhNhan INT
);

-- =========================
-- DỮ LIỆU MẪU
-- =========================

-- bệnh nhân
INSERT INTO BenhNhan VALUES 
(1, 'Nguyen Van A'),
(2, 'Tran Thi B'),
(3, 'Le Van C');  -- ❗ bệnh nhân chưa có dịch vụ

-- dịch vụ
INSERT INTO DichVuSuDung VALUES 
(1, 'Tiêm thuốc', 1),
(2, 'Xét nghiệm', 1),
(3, 'Chụp X-quang', 2);

-- =========================
-- TEST QUERY (JOIN)
-- =========================
SELECT bn.maBenhNhan, bn.tenBenhNhan, dv.maDichVu, dv.tenDichVu
FROM BenhNhan bn
LEFT JOIN DichVuSuDung dv
ON bn.maBenhNhan = dv.maBenhNhan;