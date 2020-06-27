/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static jdbc.JDBCDemo.driverName;
/**
 *
 * @author giasutinhoc.vn
 */
public class JDBCStatementExample {
 // SQL Server JDBC connection string
 public static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
 public static String DB_URL = "jdbc:sqlserver://localhost;databaseName=EMPDB;";
 public static String userDB = "sa";
 public static String passDB = "123456";
 
 public static Connection getConnection(){
     Connection conn = null;
     try {
         //load jdbc
         Class.forName(driverName);
         //connect database
         conn = DriverManager.getConnection(DB_URL,userDB,passDB);
         System.out.println("Thanh cong");
     } catch (Exception e) {
         System.out.println("That bai roi");
         e.printStackTrace();
     }
     return conn;
 }
 
 public static void main(String[] args){
   Connection conn = null;
   Statement stmt = null;
   try {
     conn = getConnection();
     //Execute a query
     System.out.println("Creating statement...");
     stmt = conn.createStatement();
     String sql = "INSERT INTO Employees VALUES (100, 18, N'gia sư', N'tin học');";
     int rows = stmt.executeUpdate(sql);
     System.out.println("Rows impacted : " + rows);
     // Let us select all the records and display them.
     sql = "SELECT id, first, last, age FROM Employees";
     ResultSet rs = stmt.executeQuery(sql);
     //Extract data from result set
     while (rs.next()) {
       //Retrieve by column name
       int id = rs.getInt("id");
       int age = rs.getInt("age");
       String first = rs.getString("first");
       String last = rs.getString("last");
       //Display values
       System.out.print("ID: " + id);
       System.out.print(", Age: " + age);
       System.out.print(", First: " + first);
       System.out.println(", Last: " + last);
     }
     //Clean-up environment
     rs.close();
     stmt.close();
     conn.close();
   } catch (SQLException se) {
     //Handle errors for JDBC
     se.printStackTrace();
   } finally {
     //finally block used to close resources
     try {
       if (stmt != null) {
         stmt.close();
       }
     } catch (SQLException se2) {
     }// nothing we can do
     try {
       if (conn != null) {
         conn.close();
       }
     } catch (SQLException se) {
         se.printStackTrace();
     }//end finally try
    }//end try
   System.out.println("Done!");
 }
}
