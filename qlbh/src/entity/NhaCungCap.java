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
 * @author hantr
 */
public class NhaCungCap {

    private int maNhaCungCap;
    private String tenNhaCungCap;
    private String dienThoai;
    private String diaChi;
    private String email;

    public NhaCungCap() {
    }

    public NhaCungCap(int maNhaCungCap, String tenNhaCungCap, String dienThoai, String diaChi, String email) {
        this.maNhaCungCap = maNhaCungCap;
        this.tenNhaCungCap = tenNhaCungCap;
        this.dienThoai = dienThoai;
        this.diaChi = diaChi;
        this.email = email;
    }

    public int getMaNhaCungCap() {
        return maNhaCungCap;
    }

    public void setMaNhaCungCap(int maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }

    public String getTenNhaCungCap() {
        return tenNhaCungCap;
    }

    public void setTenNhaCungCap(String tenNhaCungCap) {
        this.tenNhaCungCap = tenNhaCungCap;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static ArrayList<NhaCungCap> getAll() {
        ArrayList<NhaCungCap> listNhaCC = new ArrayList<>();
        try {

            String sql = "select * from nhacungcap ;";
            ConnectDatabase ketNoiQLBH = new ConnectDatabase();
            Connection connection = ketNoiQLBH.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                listNhaCC.add(new NhaCungCap(
                        resultSet.getInt("maNhaCungCap"),
                        resultSet.getString("tenNhaCungCap"),
                        resultSet.getString("dienThoai"),
                        resultSet.getString("diaChi"),
                        resultSet.getString("email")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listNhaCC;
    }

    public static int add(NhaCungCap o) throws ClassNotFoundException {
        String sql = "insert into  nhacungcap values("
                + o.getMaNhaCungCap() + ", '"
                + o.getTenNhaCungCap() + "',' "
                + o.getDienThoai() + "', '"
                + o.getDiaChi() + "', '"
                + o.getEmail() + "'"
                + ");";
        return interact(sql);
    }

    public static int interact(String sql) throws ClassNotFoundException {
        int result = -1;
        try {
            ConnectDatabase ketNoiQLBH = new ConnectDatabase();
            Connection connection = ketNoiQLBH.getConnection();
            Statement statement = connection.createStatement();
            result = statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static NhaCungCap get(int ma) {
        NhaCungCap o = null;
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            ResultSet resultSet = connectDatabase.getConnection().
                    createStatement().executeQuery("select * from nhacungcap where maNhaCungCap = " + ma);
            while (resultSet.next()) {
                o = new NhaCungCap(
                        resultSet.getInt("maNhaCungCap"),
                        resultSet.getString("tenNhaCungCap"),
                        resultSet.getString("dienThoai"),
                        resultSet.getString("diaChi"),
                        resultSet.getString("email")
                );
            }
            connectDatabase.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return o;
    }

}
