/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author giasutinhoc.vn
 */
public class JDBCPreparedStatementExample {
 // SQL Server JDBC connection string
 static final String DB_URL = "jdbc:sqlserver://localhost;databaseName=EMPDB;user=sa;password=123456";
 public static void main(String[] args) {
 Connection conn = null;
 PreparedStatement stmt = null;
 try {
   //Open a connection
   System.out.println("Connecting to database...");
   conn = DriverManager.getConnection(DB_URL);
   //Execute a query
   System.out.println("Creating statement...");
   String sql = "UPDATE Employees set age=? WHERE id=?";
   stmt = conn.prepareStatement(sql);
   //Bind values into the parameters.
   stmt.setInt(1, 35); // This would set age
   stmt.setInt(2, 100); // This would set ID
   // Let us update age of the record with ID = 100;
   int rows = stmt.executeUpdate();
   System.out.println("Rows impacted : " + rows);
   // Let us select all the records and display them.
   sql = "SELECT id, first, last, age FROM Employees";
   stmt = conn.prepareStatement(sql);
   ResultSet rs = stmt.executeQuery();
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
     se2.printStackTrace();
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
