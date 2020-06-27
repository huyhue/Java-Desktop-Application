package jdbc;
import java.sql.*;
public class Test {
    static ConnectionDB kn = new ConnectionDB();
    
    public static void main(String[] args) {
        
        Connection cn = kn.getConnectDB();
        Statement stm = null;
        ResultSet rs = null;
        String sql = "select * from login";
        
        try {
            stm = cn.createStatement();
            rs = stm.executeQuery(sql);
            while(rs.next()){
                System.out.println("id: " + rs.getString(1) + "\tName: " + rs.getString(2) + "\tPass: " + rs.getString(3));
            }
        } catch (Exception e) {
            System.out.println("Loi gi do roi" + e);
        }
        
    }
}
