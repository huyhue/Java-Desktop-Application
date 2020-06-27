package Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class EmployeeDB {

    Connection connection = null;

    public EmployeeDB() {
    }

    public Vector<Employee> getList() {
        Vector employees = new Vector();

        try {
            String sql = "SELECT * FROM Emp_ID";
            connection = ConnectDB.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Vector v = new Vector<>();
                v.add(resultSet.getString(1));
                v.add(resultSet.getString(2));
                v.add(resultSet.getString(3));
                v.add(resultSet.getString(4));
                v.add(resultSet.getString(5));
                employees.add(v);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    //newEmp để thêm mới
    public int newEmp(String empID, String lastName, String firstName, String gender, String email) {
        int rc = 0;
        try {
            String sql = "INSERT INTO Emp_ID (empID, lastName, firstName, gender, email) VALUES (?, ?, ?, ?, ?)";

            connection = ConnectDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, empID);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3,firstName);
            preparedStatement.setString(4, gender);
            preparedStatement.setString(5, email);
            rc = preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rc;
    }

    public Employee getEmployee(String empID) {
        Employee ee = null;
        try {
            Connection conn;
            conn = ConnectDB.getConnection();
            String sql = "Select * from Emp_ID where empID='" + empID + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                String empid = rs.getString(1);
                String lastName = rs.getString(2);
                String firstName = rs.getString(3);
                String gender = rs.getString(4);
                String email = rs.getString(5);
                ee = new Employee(empid, lastName, firstName, gender, email);
            }
            conn.close();
//            System.out.println("Info employee: " + b );
            System.out.println("Get ID employee successfully!");
        } catch (Exception e) {
            System.out.println("Get ID employee failure!");
        }
        return ee;
    }

}
