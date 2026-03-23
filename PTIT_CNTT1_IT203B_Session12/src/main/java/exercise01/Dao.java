package exercise01;

import btapthuchanh1.DB_Conncetion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {
    public static boolean loginDoctor(String doctorCode , String password){
        boolean check = false;
        try (
                Connection connection = DBConnect.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM doctors WHERE doctor_code = ? AND password = ?");
                ){
            preparedStatement.setString(1,doctorCode);
            preparedStatement.setString(2,password);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                check = true;
            }
        }catch (Exception e){
            System.out.println("Lỗi: " + e.getMessage());
        }
        return check;
    }
}
