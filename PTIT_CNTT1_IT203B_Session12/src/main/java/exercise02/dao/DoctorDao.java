package exercise02.dao;

import exercise02.database.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DoctorDao {
    public static boolean update(double temperature, int heartRate, int patientId) {
        boolean check = false;
        try (
                Connection connection = DBConnect.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE patients SET temperature = ?, heart_rate = ? WHERE id = ?");
        ) {
            preparedStatement.setDouble(1, temperature);
            preparedStatement.setInt(2, heartRate);
            preparedStatement.setInt(3, patientId);

            int rs = preparedStatement.executeUpdate();
            return rs > 0;

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
        return check;
    }
}
