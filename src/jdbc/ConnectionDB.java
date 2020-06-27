package jdbc;
import java.sql.*;
public class ConnectionDB {
    Connection con = null;
    public  Connection getConnectDB(){
         try {
            String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String dbURL = "jdbc:sqlserver://Localhost:1433;databaseName=test";
            String user = "sa";
            String pass = "123456";
            //load JDBC Driver
            Class.forName(driverName);
            //connect to database 
            con = DriverManager.getConnection(dbURL, user, pass);
            System.out.println("Thanh cong");
        } catch (Exception ex) {
            System.out.println("That bai");
            ex.printStackTrace();
        }
         return con;
    }
}
