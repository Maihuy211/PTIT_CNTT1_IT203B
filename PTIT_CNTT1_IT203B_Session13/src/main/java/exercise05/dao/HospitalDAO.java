package exercise05.dao;

import exercise05.database.DBConnect;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HospitalDAO {
    public List<String> getBeds() {
        List<String> list = new ArrayList<>();
        try(
                Connection conn = DBConnect.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM Beds");
                ) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                list.add("Giường " + rs.getInt("id") + " - " + rs.getString("status"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean tiepNhan(String name, int age, int bedId, double money) {
        Connection conn = null;

        try {
            conn = DBConnect.getConnection();
            conn.setAutoCommit(false);

            // 1. thêm bệnh nhân
            String sql1 = "INSERT INTO Patients(name, age) VALUES (?,?)";
            PreparedStatement ps1 = conn.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
            ps1.setString(1, name);
            ps1.setInt(2, age);
            ps1.executeUpdate();

            ResultSet rs = ps1.getGeneratedKeys();
            rs.next();
            int patientId = rs.getInt(1);

            // 2. update giường
            String sql2 = "UPDATE Beds SET status='Đã có người' WHERE id=? AND status='Trống'";
            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ps2.setInt(1, bedId);
            int r2 = ps2.executeUpdate();

            if (r2 == 0) throw new Exception("Giường đã có người!");

            // 3. thêm tài chính
            String sql3 = "INSERT INTO Finance(patient_id, amount) VALUES (?,?)";
            PreparedStatement ps3 = conn.prepareStatement(sql3);
            ps3.setInt(1, patientId);
            ps3.setDouble(2, money);
            ps3.executeUpdate();

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