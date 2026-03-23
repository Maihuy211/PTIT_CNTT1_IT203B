package exercise06;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentRepository {

    // Thêm
    public void addAppointment(Appointment ap) {
        String sql = "INSERT INTO appointments(patient_name, appointment_date, doctor_name, status) VALUES (?, ?, ?, ?)";

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setString(1, ap.getPatientName());
            stmt.setDate(2, ap.getAppointmentDate());
            stmt.setString(3, ap.getDoctorName());
            stmt.setString(4, ap.getStatus());

            stmt.executeUpdate();
            System.out.println("Them thanh cong!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update
    public void updateAppointment(Appointment ap) {
        String sql = "UPDATE appointments SET patient_name=?, appointment_date=?, doctor_name=?, status=? WHERE id=?";

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setString(1, ap.getPatientName());
            stmt.setDate(2, ap.getAppointmentDate());
            stmt.setString(3, ap.getDoctorName());
            stmt.setString(4, ap.getStatus());
            stmt.setInt(5, ap.getId());

            int rows = stmt.executeUpdate();
            System.out.println(rows > 0 ? "Cap nhat thanh cong!" : "Khong tim thay!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteAppointment(int id) {
        String sql = "DELETE FROM appointments WHERE id=?";

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();

            System.out.println(rows > 0 ? "Xoa thanh cong!" : "Khong tim thay!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Get by ID
    public Appointment getAppointmentById(int id) {
        String sql = "SELECT * FROM appointments WHERE id=?";

        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Appointment(
                        rs.getInt("id"),
                        rs.getString("patient_name"),
                        rs.getDate("appointment_date"),
                        rs.getString("doctor_name"),
                        rs.getString("status")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Get all
    public List<Appointment> getAllAppointments() {
        List<Appointment> list = new ArrayList<>();
        String sql = "SELECT * FROM appointments";

        try (
                Connection conn = DatabaseConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)
        ) {
            while (rs.next()) {
                list.add(new Appointment(
                        rs.getInt("id"),
                        rs.getString("patient_name"),
                        rs.getDate("appointment_date"),
                        rs.getString("doctor_name"),
                        rs.getString("status")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}