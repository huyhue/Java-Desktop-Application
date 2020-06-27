package Employee;

public interface DatabaseInfo {
    String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String dbURL = "jdbc:sqlserver://localhost:1433;databaseName= PRJ321_ID;";
    String dbUser = "sa";
    String dbPass = "123456";
}
