/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;
//gom co  5 class EmpDB + EmpDBImp + ConnectDB + ClientDB + ServerDB
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {

    static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static String dbURL = "jdbc:sqlserver://Localhost:1433;databaseName=PRJ321_ID;";
    static String dbUser = "sa";
    static String dbPass = "123456";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            //Tải driver
            Class.forName(driverName);
            //Kết nối
            connection = DriverManager.getConnection(dbURL, dbUser, dbPass);
            System.out.println("Connect database successful");
        } catch (Exception e) {
            System.out.println("Failure");
            e.printStackTrace();
        }
        return connection;
    }
}

class Employee  implements Serializable{

    private String empID;
    private String lastName;
    private String firstName;
    private String gender;
    private String email;

    public Employee() {
    }

    public Employee(String empID, String lastName, String firstName, String gender, String email) {
        this.empID = empID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.gender = gender;
        this.email = email;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}