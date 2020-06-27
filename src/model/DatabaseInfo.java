package model;

import java.sql.Connection;
import java.sql.DriverManager;

public interface DatabaseInfo {
    public static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String dbURL = "jdbc:sqlserver://Localhost:1433;databaseName=FuLib;";
    public static String userDB = "sa";
    public static String passDB = "123456";
}
