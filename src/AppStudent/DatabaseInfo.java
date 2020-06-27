/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppStudent;

/**
 *
 * @author ASUS
 */
public interface DatabaseInfo {

    String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    //localhost:<PORT>  databaseName=<Tên của database vừa tạo>
    String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=University";

    //Username và Password chừa trống, trong phần mềm sẽ nhập sau
    public static final String dbUser = "sa";
    public static final String dbPass = "123456";
}
