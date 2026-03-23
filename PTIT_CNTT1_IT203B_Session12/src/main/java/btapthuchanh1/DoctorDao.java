package btapthuchanh1;

import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDao {

    public static List<Doctors> findDoctorBySpecialty(String specialty){
        List<Doctors> doctors = new ArrayList<>();
        try (
                 Connection connection = DB_Conncetion.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement("select * from Doctors where specialty = ?" )
                 ){
            preparedStatement.setString(1,specialty);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                Doctors doctor = new Doctors();
                doctor.setId(rs.getInt("doctor_id"));
                doctor.setFullName(rs.getString("full_name"));
                doctor.setSpecialty(rs.getString("specialty"));
                doctor.setExpYears(rs.getInt("experience_years"));
                doctor.setBaseSalary(rs.getDouble("base_salary"));
                doctor.setPassword(rs.getString("password"));
                doctors.add(doctor);
            }
         }catch (Exception e){
             System.out.println("Lỗi: " + e.getMessage());
         }
        return doctors;
    }

    public static boolean updatePassword(int id, String newPass){
        boolean check = false;
        try (
                Connection connection = DB_Conncetion.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Doctors SET password = ? WHERE doctor_id = ?");
                ) {
            preparedStatement.setString(1,newPass);
            preparedStatement.setInt(2,id);
            int rs = preparedStatement.executeUpdate();
            return rs > 0;
        }catch (Exception e){
            System.out.println("Lỗi" + e.getMessage());
        }
        return check;
    }

    public static double calculateDutyFee(int doctor_id){
        double fee = 0;
        try(
                Connection connection = DB_Conncetion.getConnection();
                CallableStatement callableStatement = connection.prepareCall("{call calculate_duty_fee(?, ?)}")
                ){
                callableStatement.setInt(1, doctor_id);
                callableStatement.registerOutParameter(2, Types.DOUBLE);
                callableStatement.execute();
                fee =  callableStatement.getDouble(2);
        }catch (Exception e){
            System.out.println("Lỗi " + e.getMessage());
        }
        return fee;
    }

    public static boolean checkDoctorId(int doctorId){
        boolean check = false;
        try(
                Connection connection = DB_Conncetion.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT doctor_id FROM Doctors WHERE doctor_id = ?")
                ){
                preparedStatement.setInt(1, doctorId);
                ResultSet rs = preparedStatement.executeQuery();
                if (rs.next()) {
                    check = true;
                }
        } catch (Exception e){
            System.out.println("Lỗi: " + e.getMessage());
        }
        return check;
    }
}
