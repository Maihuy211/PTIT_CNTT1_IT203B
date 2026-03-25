package exercise03.dao;

import exercise03.database.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HospitalDAO {
    public void xuatVienVaThanhToan(int maBenhNhan, double tienVienPhi) {
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            conn.setAutoCommit(false);

            // Bẫy 1: kiểm tra số dư
            String sql1 = "SELECT balance FROM Patient_Wallet WHERE patient_id = ?";
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ps1.setInt(1, maBenhNhan);
            ResultSet rs = ps1.executeQuery();

            if (!rs.next()) {
                throw new Exception("Không tìm thấy bệnh nhân");
            }
            double balance = rs.getDouble("balance");
            if (balance < tienVienPhi) {
                throw new Exception("Không đủ tiền"); // Bẫy 1
            }
            // trừ tiền
            String sql2 = "UPDATE Patient_Wallet SET balance = balance - ? WHERE patient_id = ?";
            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ps2.setDouble(1, tienVienPhi);
            ps2.setInt(2, maBenhNhan);
            int r1 = ps2.executeUpdate();

            // cập nhật giường
            String sql3 = "UPDATE Beds SET status = 'Trống', patient_id = NULL WHERE patient_id = ?";
            PreparedStatement ps3 = conn.prepareStatement(sql3);
            ps3.setInt(1, maBenhNhan);
            int r2 = ps3.executeUpdate();

            // cập nhật bệnh nhân
            String sql4 = "UPDATE Patients SET status = 'Đã xuất viện' WHERE patient_id = ?";
            PreparedStatement ps4 = conn.prepareStatement(sql4);
            ps4.setInt(1, maBenhNhan);
            int r3 = ps4.executeUpdate();

            // Bẫy 2: không có dòng nào update
            if (r1 == 0 || r2 == 0 || r3 == 0) {
                throw new Exception("Update thất bại"); // Bẫy 2
            }

            conn.commit();
            System.out.println("Thành công");

        } catch (Exception e) {
            try {
                if (conn != null) conn.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            System.out.println("Lỗi: " + e.getMessage());

        } finally {
            try {
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
