package exercise01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConncet {
    private static final String DATABASE_NAME = "Hospital_DB";
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/" + DATABASE_NAME;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Mhuy2110";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = getConnection();
            System.out.println("Kết nối thành công!");
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
