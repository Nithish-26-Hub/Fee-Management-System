package db;
import java.sql.*;

public class DBConnection {

    private static Connection con;

    public static Connection getConnection() {

        try {
            if (con == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");

                con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/fee_management",
                        "root",
                        "root26@kncet"
                );
            }
        } catch (Exception e) {
            System.out.println("Database Connection Error: " + e);
        }

        return con;
    }
}
