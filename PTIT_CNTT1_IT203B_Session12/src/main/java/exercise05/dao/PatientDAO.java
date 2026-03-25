package exercise05.dao;

import exercise05.database.DBConnect;
import exercise05.model.Patients;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {
    public static List<Patients> getPatients(){
        List<Patients> list = new ArrayList<>();
        try(
                Connection connection = DBConnect.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM patients");
                ) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                Patients patient = new Patients();
                patient.setId(rs.getInt("id"));
                patient.setName(rs.getString("name"));
                patient.setAge(rs.getInt("age"));
                patient.setDepartment(rs.getString("department"));
                patient.setDisease(rs.getString("disease"));

                list.add(patient);
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
        return list;
    }

    public static boolean addPatients(Patients patient){
        boolean check = false;
        try(
                Connection connection = DBConnect.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO patients(name, age, department, disease) VALUES (?, ?, ?, ?)");
                ) {
            preparedStatement.setString(1, patient.getName());
            preparedStatement.setInt(2, patient.getAge());
            preparedStatement.setString(3, patient.getDepartment());
            preparedStatement.setString(4, patient.getDisease());
            int rs = preparedStatement.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
        return check;
    }

    public static boolean updatePatients(int id, String disease){
        boolean check = false;
        try(
                Connection connection = DBConnect.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE patients SET disease = ? WHERE id = ?");
                ) {
            preparedStatement.setString(1, disease);
            preparedStatement.setInt(2, id);
            int rs = preparedStatement.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
        return check;
    }

    public static double calculatePatientsFee(int id){
        double fee = 0;
        try(
                Connection connection = DBConnect.getConnection();
                java.sql.CallableStatement callableStatement = connection.prepareCall("{CALL CALCULATE_DISCHARGE_FEE(?, ?)}");
                 ) {
            callableStatement.setInt(1, id);
            callableStatement.registerOutParameter(2, Types.DOUBLE);
            callableStatement.execute();
            fee = callableStatement.getDouble(2);
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
        return fee;
    }
}
