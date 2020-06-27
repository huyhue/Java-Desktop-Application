package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

public class BookDB {
    //--------------------------------------------------------------------

    public static Book getBook(String ebookID) {
        Book b = null;
        try {
            Connection conn;
            conn = ConnectDB.getConnection();
            String sql = "Select * from Books where BookID='" + ebookID + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                String bookID = rs.getString(1);
                String title = rs.getString(2);
                String author = rs.getString(3);
                String category = rs.getString(4);
                String keyword = rs.getString(5);
                b = new Book(bookID, title, author, category, keyword);
            }
            conn.close();
//            System.out.println("Info book: " + b );
            System.out.println("Get book successfully!");
        } catch (Exception e) {
            System.out.println("Get book failure!");
        }
        return b;
    }

    public Vector<Book> getList() {
        Vector books = new Vector();
        try {
            String sql = "SELECT * FROM Books";
            Connection conn;
            conn = ConnectDB.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Vector v = new Vector<>();
                v.add(resultSet.getString(1));
                v.add(resultSet.getString(2));
                v.add(resultSet.getString(3));
                v.add(resultSet.getString(4));
                v.add(resultSet.getString(5));
                books.add(v);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
    //-------------------------------------------------------------------- 

    public static Vector<Book> searchByBookID(String id) {
        Vector aBook = new Vector<>();
        try {
            Connection conn;
            conn = ConnectDB.getConnection();

            String sql = "Select * from Books where BookID='" + id + "'";
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
            System.out.println("Get books by book ID successfully!");
        } catch (SQLException e) {
            System.out.println("Get books by book ID failure!");
        }
        return aBook;
    }

    public ArrayList<Book> getAllBooks() {
        ArrayList<Book> allBooks = new ArrayList<>();
        try {
            Connection conn;
            conn = ConnectDB.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from Books");
            if (rs.next()) {
                String bookID = rs.getString(1);
                String title = rs.getString(2);
                String author = rs.getString(3);
                String category = rs.getString(4);
                String keyword = rs.getString(5);
                Book b = new Book(bookID, title, author, category, keyword);
                allBooks.add(b);
            }
            conn.close();
            System.out.println("Get all of books successfully!");
        } catch (Exception e) {
            System.out.println("Get all of books failure!");
        }
        return allBooks;
    }
    //--------------------------------------------------------------------   

    public static Vector<Book> searchByCategory(String cat) {
        Vector aBook = new Vector<>();
        try {
            Connection conn;
            conn = ConnectDB.getConnection();

            String sql = "Select * from Books where Category='" + cat + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Vector v = new Vector<>();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                aBook.add(v);
            }
//            System.out.println("Info by cato: "+aBook);
            conn.close();
            System.out.println("Get books by Category successfully!");
        } catch (SQLException e) {
            System.out.println("Get books by Category failure!");
        }
        return aBook;
    }

    //--------------------------------------------------------------------   
    public static Vector<Book> searchByAuthod(String aAuthor) {
        Vector aBook = new Vector<>();
        try {
            Connection conn;
            conn = ConnectDB.getConnection();

            String sql = "Select * from Books where Author='" + aAuthor + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Vector v = new Vector<>();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                aBook.add(v);
            }
            conn.close();
            System.out.println("Get books by Author successfully!");
        } catch (SQLException e) {
            System.out.println("Get books by Author failure!");
        }
        return aBook;
    }
    //--------------------------------------------------------------------   
    public static Vector<Book> searchByKeyword(String key) {
        Vector aBook = new Vector<>();
        try {
            Connection conn;
            conn = ConnectDB.getConnection();

            String sql = "Select * from Books where Keyword='" + key + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Vector v = new Vector<>();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                aBook.add(v);
            }
            conn.close();
            System.out.println("Get books by Keyword successfully!");
        } catch (SQLException e) {
            System.out.println("Get books by Keyword failure!");
        }
        return aBook;
    }
    
    //--------------------------------------------------------------------   

    public static int addNewBook(String abookID, String title, String author, String category, String keyword) {
        int rc = 0;
        try {
            Connection conn;
            conn = ConnectDB.getConnection();
            String sql = "INSERT INTO Books(BookID, Title, Author, Category, Keyword) VALUES(?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, abookID);
            stmt.setString(2, title);
            stmt.setString(3, author);
            stmt.setString(4, category);
            stmt.setString(5, keyword);
            rc = stmt.executeUpdate();
            conn.close();
            System.out.println("Add Book successfully!");
        } catch (SQLException e) {
            System.out.println("Add Book failure!");
        }
        return rc;
    }

    //-------------------------------------------------------------------- 
    public static void updateBook(String aBookID, String aTitle, String aAuthor, String aCategory, String aKeyword) {
        try {
            // connnect to database 
            Connection conn;
            conn = ConnectDB.getConnection();
            // create statement
            String sql = "Update Books set title=?,author=?,category=?,keyword=? where BookID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            // set parameter values
            stmt.setString(1, aTitle);
            stmt.setString(2, aAuthor);
            stmt.setString(3, aCategory);
            stmt.setString(4, aKeyword);
            stmt.setString(5, aBookID);
            // execute sql          
            stmt.executeUpdate();
            // close connection
            conn.close();
            System.out.println("Update Book successfully!");
        } catch (SQLException ex) {
            System.out.println("Update Book failure!");
            ex.printStackTrace();
        }
    }
    //--------------------------------------------------------------------   
    //Delete a book

    public static void deleteBook(String aBookID) {
        try {
            // connnect to database 
            Connection conn;
            conn = ConnectDB.getConnection();
            // create statement
            String sql = "Delete from Books where BookID= '" + aBookID + "' ";
            Statement stmt = conn.createStatement();
            // execute sql
            stmt.executeUpdate(sql);
            // close connection
            conn.close();
            System.out.println("Delete Book successfully!");
        } catch (SQLException ex) {
            System.out.println("Delete Book failure!");
            ex.printStackTrace();
        }
    }
    //--------------------------------------------------------------------   

    public static Vector<Vector> searchByTitle(String aTitle) {
        Vector<Vector> aBook = new Vector<Vector>();
        try {
            Connection conn;
            conn = ConnectDB.getConnection();

            String sql = "Select * from Books where Title='" + aTitle + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Vector v = new Vector<>();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                aBook.add(v);
            }
            conn.close();
            System.out.println("Get books by Title successfully!");
        } catch (SQLException e) {
            System.out.println("Get books by Title failure!");
        }
        return aBook;
    }
    //--------------------------------------------------------------------   
//    public static Vector<Vector> searchByTitle(String aTitle) {
//        Vector<Vector> aBook = new Vector<Vector>();
//        try {
//            Connection conn;
//            conn = ConnectDB.getConnection();
//
//            String sql = "Select * from Books where Title='" + aTitle + "'";
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//            while (rs.next()) {
//                String bookID = rs.getString(1);
//                String title = rs.getString(2);
//                String author = rs.getString(3);
//                String category = rs.getString(4);
//                String keyword = rs.getString(5);
//                Book b = new Book(bookID, title, author, category, keyword);
//                aBook.add(aBook);
//            }
//            conn.close();
//            System.out.println("Get books by Title successfully!");
//        } catch (Exception e) {
//            System.out.println("Get books by Title failure!");
//        }
//        return aBook;
//    }
}
