package model;

import java.sql.Connection;
import java.sql.DriverManager;
import static model.DatabaseInfo.dbURL;
import static model.DatabaseInfo.driverName;
import static model.DatabaseInfo.passDB;
import static model.DatabaseInfo.userDB;

public class ConnectDB implements DatabaseInfo{
    //connect to database
    public static Connection getConnection() {
        Connection conn = null;
        try {
            //load JDBC driver
            Class.forName(driverName);
            //connect to database
            conn = DriverManager.getConnection(dbURL, userDB, passDB);
            System.out.println("Connect successfully!");
        } catch (Exception ex) {
            System.out.println("Connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
}
