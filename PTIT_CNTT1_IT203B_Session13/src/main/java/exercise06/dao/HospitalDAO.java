package exercise06.dao;

import exercise06.database.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class HospitalDAO {

    public boolean xuatVien(int patientId, double amount) {
        Connection conn = null;

        try {
            conn = DBConnect.getConnection();
            conn.setAutoCommit(false);

            // 1. lập hóa đơn
            String sql1 = "INSERT INTO Invoices(patient_id, amount) VALUES (?,?)";
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ps1.setInt(1, patientId);
            ps1.setDouble(2, amount);
            ps1.executeUpdate();

            // 2. cập nhật bệnh nhân
            String sql2 = "UPDATE Patients SET status='Đã xuất viện' WHERE id=?";
            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ps2.setInt(1, patientId);
            int r2 = ps2.executeUpdate();

            if (r2 == 0) throw new Exception("Không tìm thấy bệnh nhân");

            // 3. giải phóng giường
            String sql3 = "UPDATE Beds SET status='Trống', patient_id=NULL WHERE patient_id=?";
            PreparedStatement ps3 = conn.prepareStatement(sql3);
            ps3.setInt(1, patientId);
            int r3 = ps3.executeUpdate();

            if (r3 == 0) throw new Exception("Không tìm thấy giường");

            conn.commit();
            return true;

        } catch (Exception e) {
            try {
                if (conn != null) conn.rollback();
            } catch (Exception ex) {}

            System.out.println("Lỗi: " + e.getMessage());
            return false;

        } finally {
            try {
                if (conn != null) conn.close();
            } catch (Exception e) {}
        }
    }
}