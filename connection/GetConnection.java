package connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;

public class GetConnection {
    public static final String DB_URL = "jdbc:sqlserver://LAPTOP-S31ERO96:1433;databaseName=QuanLyNhanVien;trustServerCertificate=true";
    public static final String DB_PASSWORD = "123";
    public static final String DB_NAME = "sa";
    public static Connection con = null;

    public Connection getConnection() throws SQLException {
        try {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            con = DriverManager.getConnection(DB_URL, DB_NAME, DB_PASSWORD);
            System.out.println("connect Success");
        } catch (SQLException e) {
            e.printStackTrace();
            // TODO: handle exception
        }
        return con;
    }
}
