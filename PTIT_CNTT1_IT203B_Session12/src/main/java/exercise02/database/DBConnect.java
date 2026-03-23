package exercise02.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
    private static final String DATABASE_NAME = "HospitalDB";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DATABASE_NAME;
    private static final String USER = "root";
    private static final String PASSWORD = "Mhuy2110";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
