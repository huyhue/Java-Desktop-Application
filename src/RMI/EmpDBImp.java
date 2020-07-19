package RMI;
//gom co  5 class EmpDB + EmpDBImp + ConnectDB + ClientDB + ServerDB
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class EmpDBImp extends UnicastRemoteObject implements EmpDB {

    Connection connection = null;

    public EmpDBImp() throws RemoteException {
        super();
    }
    
    @Override
    public Vector<Employee> getList() throws RemoteException {
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

    @Override
    public int newEmp(String empID, String lastName, String firstName, String gender, String email) throws RemoteException {
        int rc = 0;
        try {
            String sql = "INSERT INTO Emp_ID (empID, lastName, firstName, gender, email) VALUES (?, ?, ?, ?, ?)";

            connection = ConnectDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, empID);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, firstName);
            preparedStatement.setString(4, gender);
            preparedStatement.setString(5, email);
            rc = preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rc;
    }

    @Override
    public Vector<Employee> searchByID(String id) throws RemoteException {
        Vector aBook = new Vector<>();
        try {
            Connection conn;
            conn = ConnectDB.getConnection();

            String sql = "Select * from Emp_ID where empID='" + id + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                Vector v = new Vector<>();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                aBook.add(v);
            }
            conn.close();
            System.out.println("Get Employee by  ID successfully!");
        } catch (SQLException e) {
            System.out.println("Get Employee by  ID failure!");
        }
        return aBook;
    }
    
}


