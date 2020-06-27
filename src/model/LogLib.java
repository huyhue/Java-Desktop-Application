package model;

import java.sql.Date;

public class LogLib {
    private String UserID, BookID;
    private Date NgayDat, NgayMuon, NgayPtra, NgayTra;
    private String MaNV;
    private int LogID;

    public LogLib() {
    }

    public LogLib(String UserID, String BookID, Date NgayDat, Date NgayMuon, Date NgayPtra, Date NgayTra, String MaNV, int LogID) {
        this.UserID = UserID;
        this.BookID = BookID;
        this.NgayDat = NgayDat;
        this.NgayMuon = NgayMuon;
        this.NgayPtra = NgayPtra;
        this.NgayTra = NgayTra;
        this.MaNV = MaNV;
        this.LogID = LogID;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public String getBookID() {
        return BookID;
    }

    public void setBookID(String BookID) {
        this.BookID = BookID;
    }

    public Date getNgayDat() {
        return NgayDat;
    }

    public void setNgayDat(Date NgayDat) {
        this.NgayDat = NgayDat;
    }

    public Date getNgayMuon() {
        return NgayMuon;
    }

    public void setNgayMuon(Date NgayMuon) {
        this.NgayMuon = NgayMuon;
    }

    public Date getNgayPtra() {
        return NgayPtra;
    }

    public void setNgayPtra(Date NgayPtra) {
        this.NgayPtra = NgayPtra;
    }

    public Date getNgayTra() {
        return NgayTra;
    }

    public void setNgayTra(Date NgayTra) {
        this.NgayTra = NgayTra;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public int getLogID() {
        return LogID;
    }

    public void setLogID(int LogID) {
        this.LogID = LogID;
    }

    @Override
    public String toString() {
        return "LogLib{" + "UserID=" + UserID + ", BookID=" + BookID + ", NgayDat=" + NgayDat + ", NgayMuon=" + NgayMuon + ", NgayPtra=" + NgayPtra + ", NgayTra=" + NgayTra + ", MaNV=" + MaNV + ", LogID=" + LogID + '}';
    }
    
    
}
