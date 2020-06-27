package AppStudent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class StudentManager implements DatabaseInfo{

    public StudentManager() {
    }

    private Connection connection;

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
    
    public Vector getAll() {
        Vector students = new Vector();

        try {
            String sql = "SELECT * FROM Students";
            connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Vector v = new Vector<>();
                v.add(resultSet.getString(1));
                v.add(resultSet.getString(2));
                v.add(resultSet.getString(3));
                v.add(resultSet.getString(4));
                v.add(resultSet.getString(5));
                v.add(resultSet.getString(6));
                students.add(v);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public boolean checkStudent(String Sno) throws SQLException, ClassNotFoundException {
        // Kết nối database
        connection = getConnection();

        // Kiểm tra sinh viên có trong database hay chưa
        String sql = "Select * from Students where Sno = '" + Sno + "'";
        Statement stm1 = connection.createStatement();
        ResultSet rs = stm1.executeQuery(sql);

        // Trả về kết quả
        if (!rs.next()) {
            connection.close();
            return false;
        }
        connection.close();
        return true;
    }

    

    public int update(String Sno, String Sname, String Sgender, String Sclass, String Sadress, String Semail)
            throws ClassNotFoundException, SQLException {
        int updateStatus = 0;
        // Kết nối database
        Connection conn = getConnection();

        // Tạo câu lệnh SQL
        String sql = "UPDATE Students set Sname='" + Sname + "',Sgender'" + Sgender + "',Sclass='" + Sclass + "',Semail ='"
                + Semail + "',Sadress='" + Sadress + "' WHERE Sno='" + Sno + "'";
        Statement stm1 = conn.createStatement();
        updateStatus = stm1.executeUpdate(sql);
        conn.close();
        return updateStatus;
    }

    public void addNew(String Sno, String Sname, String Sgender, String Sclass, String Sadress, String Semail)
            throws ClassNotFoundException, SQLException {
        // Kết nối database
        connection = getConnection();

        // Tạo câu lệnh SQL (Cách 2: sử dụng PreparedStatement)
        String sql = "INSERT INTO Students(Sno,Sname,Sgender,Sclass,Sadress,Semail) VALUES(?,?,?,?,?,?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, Sno);
        stmt.setString(2, Sname);
        stmt.setString(3, Sgender);
        stmt.setString(4, Sclass);
        stmt.setString(5, Sadress);
        stmt.setString(6, Semail);

        // Thực hiện lệnh SQL
        stmt.executeUpdate();

        // Đóng kết nối
        connection.close();
    }

    public int delete(String Sno) throws SQLException, ClassNotFoundException {
        int deleteStatus = 0;

        // Kết nối database
        connection = getConnection();

        // Xóa sinh viên
        String sql = "DELETE FROM STUDENTS WHERE Sno='" + Sno + "'";
        Statement stm1 = connection.createStatement();
        deleteStatus = stm1.executeUpdate(sql);

        // Trả về kết quả int (có xóa thành công hay không)
        connection.close();
        return deleteStatus;
    }
}
