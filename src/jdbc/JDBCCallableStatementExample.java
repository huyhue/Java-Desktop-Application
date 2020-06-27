/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author giasutinhoc.vn
 */
public class JDBCCallableStatementExample {
 // SQL Server JDBC connection string
 static final String DB_URL = "jdbc:sqlserver://localhost;databaseName=EMPDB;user=sa;password=123456";
 public static void main(String[] args) {
  Connection conn = null;
  CallableStatement stmt = null;
  try {
    //Open a connection
    System.out.println("Connecting to database...");
    conn = DriverManager.getConnection(DB_URL);
    //Execute a query
    System.out.println("Creating statement...");
    String sql = "{call getEmpName (?, ?)}";
    stmt = conn.prepareCall(sql);
    //Bind IN parameter first, then bind OUT parameter
    int empID = 100;
    stmt.setInt(1, empID); // This would set ID as 100
    // Because second parameter is OUT so register it
    stmt.registerOutParameter(2, java.sql.Types.NVARCHAR);
    //Use execute method to run stored procedure.
    System.out.println("Executing stored procedure...");
    stmt.execute();
    //Retrieve employee name with getXXX method
    String empName = stmt.getString(2);
    System.out.println("Emp name with ID (" + empID + ") is " + empName);
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
    }
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