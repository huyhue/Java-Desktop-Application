package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Vector;
import static jdbc.JDBCDemo.getConnection;

public class LogLibDB {
    
 //---------------------------------------------------------------------------------------
    public static LogLib getLog(int logID){
        LogLib l = null;
        try {
            Connection conn;
            conn = ConnectDB.getConnection();
            String sql = "Select * from LogLibs where LogID='" + logID + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                String UserID = rs.getString(1);
                String BookID = rs.getString(2);
                Date NgayDat = rs.getDate(3);
                Date NgayMuon = rs.getDate(4);
                Date NgayPtra = rs.getDate(5);
                Date NgayTra = rs.getDate(6);
                String MaNV = rs.getString(7);
                int LogID = rs.getInt(8);
                l = new LogLib(UserID, BookID, NgayDat, NgayMuon, NgayPtra, NgayTra, MaNV, LogID);
            }
            conn.close();
            System.out.println("Get LogLib successfully!");
        } catch (Exception e) {
            System.out.println("Get LogLib failure!");
        }
        return l;
    }
    
 //---------------------------------------------------------------------------------------
    public static void updateLog(LogLib log){
        try {            
            // connnect to database 
            Connection conn = getConnection();
            // create statement
            String sql = "Update LogLibs set UserID=?,BookID=?,NgayDat=?,NgayMuon=?,NgayPtra=?,NgayTra=?,MaNV=? where LogID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            // set parameter values
            stmt.setString(1,log.getUserID());
            stmt.setString(2,log.getBookID());
            stmt.setDate(3,log.getNgayDat());
            stmt.setDate(4,log.getNgayMuon());
            stmt.setDate(5,log.getNgayPtra());
            stmt.setDate(6,log.getNgayTra());
            stmt.setString(7,log.getMaNV());
            stmt.setInt(8,log.getLogID());
           
            // execute sql          
            stmt.executeUpdate();        
            // close connection
            conn.close();
            System.out.println("Update LogLib successfully!"); 
        } catch (Exception ex) {
            System.out.println("Update LogLib failure!");        
            ex.printStackTrace();
        }
    }
    
 //---------------------------------------------------------------------------------------
    public static int writeLog(LogLib log){
        int rc = 0;
        try {
            Connection conn;
            conn = ConnectDB.getConnection();
            String sql = "INSERT INTO Books(UserID, BookID, NgayDat, NgayMuon, NgayPtra, NgayTra, MaNV, LogID) VALUES(?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,log.getUserID());
            stmt.setString(2,log.getBookID());
            stmt.setDate(3,log.getNgayDat());
            stmt.setDate(4,log.getNgayMuon());
            stmt.setDate(5,log.getNgayPtra());
            stmt.setDate(6,log.getNgayTra());
            stmt.setString(7,log.getMaNV());
            stmt.setInt(8,log.getLogID());
            rc = stmt.executeUpdate();
            conn.close();
            System.out.println("Add Book successfully!");
        } catch (Exception e) {
            System.out.println("Add Book failure!");
        }
        return rc;
    }
    
 //---------------------------------------------------------------------------------------   
    public static Vector<Vector> viewLogByUser(String uid){
        Vector<Vector> lLib = new Vector<Vector>();
        try {
            Connection conn;
            conn = ConnectDB.getConnection();
            
            String sql = "Select * from LogLibs where UserID='"+uid+"'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String UserID = rs.getString(1);
                String BookID = rs.getString(2);
                Date NgayDat = rs.getDate(3);
                Date NgayMuon = rs.getDate(4);
                Date NgayPtra = rs.getDate(5);
                Date NgayTra = rs.getDate(6);
                String MaNV = rs.getString(7);
                int LogID = rs.getInt(8);
                LogLib l = new LogLib(UserID, BookID, NgayDat, NgayMuon, NgayPtra, NgayTra, MaNV, LogID);
                lLib.add(lLib);
            }
            System.out.println(lLib);
            conn.close();
            System.out.println("Get LogLibs by UserID successfully!");
        } catch (Exception e) {
            System.out.println("Get LogLibs by UserID failure!");
        }
        return lLib;
    }
    
 //---------------------------------------------------------------------------------------   
    public static ArrayList<LogLib> getLogsByUser(String uid){
        ArrayList<LogLib> lLib = new ArrayList<>();
        try {
            Connection conn;
            conn = ConnectDB.getConnection();
            
            String sql = "Select * from LogLibs where UserID='" + uid + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String UserID = rs.getString(1);
                String BookID = rs.getString(2);
                Date NgayDat = rs.getDate(3);
                Date NgayMuon = rs.getDate(4);
                Date NgayPtra = rs.getDate(5);
                Date NgayTra = rs.getDate(6);
                String MaNV = rs.getString(7);
                int LogID = rs.getInt(8);
                LogLib l = new LogLib(UserID, BookID, NgayDat, NgayMuon, NgayPtra, NgayTra, MaNV, LogID);
                lLib.add(l);
            } 
            conn.close();
            System.out.println("Get LogLibs by UserID successfully!");
        } catch (Exception e) {
            System.out.println("Get LogLibs by UserID failure!");
        }
        return lLib;
    }
    
}
