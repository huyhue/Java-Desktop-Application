package Emp_Management;

import Employee.*;

public interface DatabaseInfo {
    String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String dbURL = "jdbc:sqlserver://localhost:1433;databaseName= EmpManagement;";
    String userDB = "sa";
    String passDB = "123456";
}
