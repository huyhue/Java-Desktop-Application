package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

import java.sql.PreparedStatement;//Just use for PreparedStatement
import java.sql.CallableStatement;//Just use for CallableStatement

public class JDBCDemo {    
    public static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=FULib;";
    public static String userDB = "sa";
    public static String passDB = "123456";

    public JDBCDemo() {
    }        
    //connect to database
    public static Connection getConnection() {
        Connection conn = null;
        try {
            //load JDBC driver
            Class.forName(driverName);
            //connect to database
            conn = DriverManager.getConnection(dbURL, userDB, passDB);
            System.out.println("Connect successfully!");
        } catch (Exception ex) {
            System.out.println("Connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }

    // get books (Statement)
    public static void getBooks(){
        try {
            // connnect to database 
            Connection conn = getConnection();
            // create statement and execute query
            String sql = "select * from books";
            Statement stmt = conn.createStatement();           
            ResultSet rs = stmt.executeQuery(sql);
            // show data
            while (rs.next()) {
                System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) 
                        + "  " + rs.getString(4)+ "  " + rs.getString(5));
            }
            // close connection
            conn.close();
        } catch (Exception ex) {
            System.out.println("Get books failure!");       
            ex.printStackTrace();
        }
    } 
    
    //get books (CallableStatement)
//    public static void getBooks(){
//        try {
//            // connnect to database 
//            Connection conn = getConnection();
//            // create statement and execute query
//            String sql = "{call getBooks()}";
//            CallableStatement cstm = conn.prepareCall(sql);          
//            ResultSet rs = cstm.executeQuery();
//            // show data
//            while (rs.next()) {
//                System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) 
//                        + "  " + rs.getString(4)+ "  " + rs.getString(5));
//            }
//            // close connection
//            conn.close();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
    
    
    
    //insert a new book (Statement)
//    public static void insertBook(String aBookID, String aTitle, String aAuthor, String aCategory, String aKeyword){
//        try {            
//            // connnect to database 
//            Connection conn = getConnection();
//            // create statement
//            String sql = "INSERT INTO books(BookID, Title, Author, Category,Keyword) VALUES('" + aBookID + "','" + aTitle + "','" + aAuthor + "','" + aCategory + "','" + aKeyword+ "')";
//            Statement stmt= conn.createStatement();
//            // execute sql
//            stmt.executeUpdate(sql); 
//            //stmt.execute(sql); 
//            // close connection
//            conn.close();
//            System.out.println("Insert Book successfully!"); 
//        } catch (Exception ex) {
//            System.out.println("Insert Book failure!");
//            ex.printStackTrace();
//        }    
//    }      
    
    //insert a new book (PreparedStatement)
    public static void insertBook(String aBookID, String aTitle, String aAuthor, String aCategory, String aKeyword){
        try {                   
            // connnect to database         
            Connection conn = getConnection();      
            // create statement 
            String sql = "INSERT INTO books(BookID, Title, Author, Category,Keyword) VALUES(?,?,?,?,?);";   
            PreparedStatement stmt = conn.prepareStatement(sql);    
            // set parameter values 
            stmt.setString(1,aBookID);  
            stmt.setString(2,aTitle);   
            stmt.setString(3,aAuthor);  
            stmt.setString(4,aCategory);    
            stmt.setString(5,aKeyword);               
            // execute sql              
            stmt.executeUpdate();       
            //a=stmt.execute();     
            // close connection     
            conn.close();       
            System.out.println("Insert Book successfully!"); 
        } catch (Exception ex) {
            System.out.println("Insert book failure!");
            ex.printStackTrace();
        }    
    }      
    
     //insert a new book (CallableStatement)
//    public static void insertBook(String aBookID, String aTitle, String aAuthor, String aCategory, String aKeyword){
//        try {            
//            // connnect to database 
//            Connection conn = getConnection();
//            // create statement
//            String sql = "{call insertBook(?,?,?,?,?)}";            
//            CallableStatement stmt = conn.prepareCall(sql);
//            // set parameter values
//            stmt.setString(1,aBookID);
//            stmt.setString(2,aTitle);
//            stmt.setString(3,aAuthor);
//            stmt.setString(4,aCategory);
//            stmt.setString(5,aKeyword);
//            // execute sql
//            stmt.execute();
//            // close connection
//            conn.close();
//            System.out.println("Insert Book successfully!"); 
//        } catch (Exception ex) {
//            System.out.println("Insert Book failure!");
//            ex.printStackTrace();
//        }    
//    }      
    
    //update a book
    public static void updateBook(String aBookID, String aTitle, String aAuthor, String aCategory, String aKeyword){
        try {            
            // connnect to database 
            Connection conn = getConnection();
            // create statement
            String sql = "Update Books set title=?,author=?,category=?,keyword=? where BookID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            // set parameter values
            stmt.setString(1,aTitle);
            stmt.setString(2,aAuthor);
            stmt.setString(3,aCategory);
            stmt.setString(4,aKeyword); 
            stmt.setString(5,aBookID);            
            // execute sql          
            stmt.executeUpdate();        
            // close connection
            conn.close();
            System.out.println("Update Book successfully!"); 
        } catch (Exception ex) {
            System.out.println("Update Book failure!");        
            ex.printStackTrace();
        }    
    }  
    
    //Delete a book
    public static void deleteBook(String aBookID){        
        try {
             // connnect to database 
            Connection conn = getConnection();
            // create statement
            String sql = "Delete from Books where BookID= '"+aBookID+"' ";
            Statement stmt = conn.createStatement();
            // execute sql
            stmt.executeUpdate(sql); 
            // close connection
            conn.close();
            System.out.println("Delete Book successfully!");            
        } catch (Exception ex) {
            System.out.println("Delete Book failure!"); 
            ex.printStackTrace();
        }       
    }
    
    public static void main(String[] args) {        
        getBooks();
        insertBook("B0004","Lap trinh PHP","Hoang Anh","LT","PHP");
        getBooks();
       
        updateBook("B0004","Lap trinh PHP","Hoang Nhật Anh","LT","PHP");
        getBooks();
        
        deleteBook("B0004");
        getBooks();
    } 
    
}