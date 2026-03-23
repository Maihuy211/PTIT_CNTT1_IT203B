package exercise06.dao;

import exercise06.database.DBConnect;
import exercise06.model.Medicine;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicineDAO {
    public static boolean updateMedicineStock(int id, int addedQuantity){
        boolean check = false;
        try(
                Connection conn = DBConnect.getConnection();
                PreparedStatement ps = conn.prepareStatement("UPDATE medicines SET stock = stock + ? WHERE id = ?");
                ){
            ps.setInt(1, addedQuantity);
            ps.setInt(2, id);
            int rs = ps.executeUpdate();
            return rs > 0;
        }catch(Exception e){
            System.out.println("Lỗi: " + e.getMessage());
        }
        return check;
    }

    public static List<Medicine> findByPrice(double min, double max){
        List<Medicine> list = new ArrayList<>();
        try(
                Connection conn = DBConnect.getConnection();
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM medicines WHERE price BETWEEN ? AND ?");
                ){
            ps.setDouble(1, min);
            ps.setDouble(2, max);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Medicine medicine = new Medicine();
                medicine.setId(rs.getInt("id"));
                medicine.setName(rs.getString("name"));
                medicine.setPrice(rs.getDouble("price"));
                medicine.setStock(rs.getInt("stock"));

                list.add(medicine);
            }
        }catch(Exception e){
            System.out.println("Lỗi: " + e.getMessage());
        }
        return list;
    }

    public static double calculateTotal(int id){
        double total = 0;
        try(
                Connection conn = DBConnect.getConnection();
                CallableStatement cs = conn.prepareCall("{CALL CalculatePrescriptionTotal(?, ?)}");
                ){
            cs.setInt(1, id);
            cs.registerOutParameter(2, Types.DOUBLE);
            cs.execute();
            total = cs.getDouble(2);
        }catch(Exception e){
            System.out.println("Lỗi: " + e.getMessage());
        }
        return total;
    }

    public static double getRevenue(String date){
        double revenue = 0;
        try(
                Connection conn = DBConnect.getConnection();
                CallableStatement cs = conn.prepareCall("{CALL GetDailyRevenue(?, ?)}");
                ){
            cs.setString(1, date);
            cs.registerOutParameter(2, Types.DOUBLE);
            cs.execute();
            revenue = cs.getDouble(2);
        }catch(Exception e){
            System.out.println("Lỗi: " + e.getMessage());
        }
        return revenue;
    }

}
