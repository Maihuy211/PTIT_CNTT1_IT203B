package exercise03.dao;


import exercise03.database.DBConnect;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

public class SurgeryDAO {
    public static double calculateSurgerFee(int surgeryId){
        double fee = 0;
        try(
                Connection connection = DBConnect.getConnection();
                CallableStatement callableStatement = connection.prepareCall("{CALL GET_SURGERY_FEE(?, ?)}");
                ){
            callableStatement.setInt(1,surgeryId);
            callableStatement.registerOutParameter(2, Types.DECIMAL);
            callableStatement.execute();
            fee = callableStatement.getDouble(2);
        }catch (Exception e){
            System.out.println("Lỗi: " + e.getMessage());
        }
        return  fee;
    }
}
