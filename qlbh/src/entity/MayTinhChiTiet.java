/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import helper.ConnectDatabase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kira
 */
public class MayTinhChiTiet {

    private int maMayTinhChiTiet;
    private int maMayTinh;
    private String moTa;
    private double giaNhap;
    private double giaBan;
    private String cauHinh;
    private String mauSac;
    private int soLuongTonKho;

    public MayTinhChiTiet() {
    }

    public MayTinhChiTiet(int maMayTinhChiTiet, int maMayTinh, String moTa, double giaNhap, double giaBan, String cauHinh, String mauSac, int soLuongTonKho) {
        this.maMayTinhChiTiet = maMayTinhChiTiet;
        this.maMayTinh = maMayTinh;
        this.moTa = moTa;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.cauHinh = cauHinh;
        this.mauSac = mauSac;
        this.soLuongTonKho = soLuongTonKho;
    }

    public int getMaMayTinhChiTiet() {
        return maMayTinhChiTiet;
    }

    public void setMaMayTinhChiTiet(int maMayTinhChiTiet) {
        this.maMayTinhChiTiet = maMayTinhChiTiet;
    }

    public int getMaMayTinh() {
        return maMayTinh;
    }

    public void setMaMayTinh(int maMayTinh) {
        this.maMayTinh = maMayTinh;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public String getCauHinh() {
        return cauHinh;
    }

    public void setCauHinh(String cauHinh) {
        this.cauHinh = cauHinh;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public int getSoLuongTonKho() {
        return soLuongTonKho;
    }

    public void setSoLuongTonKho(int soLuongTonKho) {
        this.soLuongTonKho = soLuongTonKho;
    }

    public static ArrayList<MayTinhChiTiet> getAll() {
        ArrayList<MayTinhChiTiet> list = new ArrayList<>();
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            ResultSet re = connectDatabase.getConnection().
                    createStatement().executeQuery("select * from maytinhchitiet");
            while (re.next()) {
                list.add(new MayTinhChiTiet(re.getInt("maMayTinhChiTiet"),
                        re.getInt("maMayTinh"),
                        re.getString("moTa"),
                        re.getDouble("giaNhap"),
                        re.getDouble("giaBan"),
                        re.getString("cauHinh"),
                        re.getString("mauSac"),
                        re.getInt("soLuongTonKho")));
            }
            connectDatabase.close();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static int add(MayTinhChiTiet o) throws ClassNotFoundException {
        String sql = "insert into  maytinhchitiet values("
                + o.getMaMayTinhChiTiet() + ", '"
                + o.getMaMayTinh() + "',' "
                + o.getMoTa() + "', '"
                + o.getGiaNhap() + "', '"
                + o.getGiaBan() + "', '"
                + o.getCauHinh() + "', '"
                + o.getMauSac() + "', '"
                + o.getSoLuongTonKho() + "'"
                + ");";
        return interact(sql);
    }

    public static int interact(String sql) throws ClassNotFoundException {
        int result = -1;
        try {
            ConnectDatabase ketNoiQLTV = new ConnectDatabase();
            Connection connection = ketNoiQLTV.getConnection();
            Statement statement = connection.createStatement();
            result = statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static MayTinhChiTiet get(int ma) {
        MayTinhChiTiet o = null;
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            ResultSet re = connectDatabase.getConnection().
                    createStatement().executeQuery("SELECT * FROM qlbh.maytinhchitiet "
                            + "where maMayTinhChiTiet = " + ma);
            while (re.next()) {
                o = new MayTinhChiTiet(re.getInt("maMayTinhChiTiet"),
                        re.getInt("maMayTinh"),
                        re.getString("moTa"),
                        re.getDouble("giaNhap"),
                        re.getDouble("giaBan"),
                        re.getString("cauHinh"),
                        re.getString("mauSac"),
                        re.getInt("soLuongTonKho"));
            }
            connectDatabase.close();
        } catch (SQLException ex) {
            Logger.getLogger(MayTinhChiTiet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return o;
    }
}
