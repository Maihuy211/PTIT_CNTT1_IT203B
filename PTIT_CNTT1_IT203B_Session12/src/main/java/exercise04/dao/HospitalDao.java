package exercise04.dao;

import exercise06.database.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class HospitalDao {
    public static void insertBatch(){
        try(
                Connection connection = DBConnect.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO lab_results (patient_id, test_type, result_value) VALUES (?, ?, ?)");
                ){
            for (int i = 0; i < 1000; i++) {
                preparedStatement.setInt(1, i);
                preparedStatement.setString(2, "Blood Test");
                preparedStatement.setDouble(3, Math.random() * 10);
                preparedStatement.executeUpdate();
            }
            System.out.println("Thêm máu thành công");
        }catch (Exception e){
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}
