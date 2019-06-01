/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import helper.ConnectDatabase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Kira
 */
public class HoaDonNhapChiTiet {

    private int maNhap;
    private int maMayTinhChiTiet;
    private int soLuong;
    private double tongTien;

    public HoaDonNhapChiTiet() {
    }

    public HoaDonNhapChiTiet(int maNhap, int maMayTinhChiTiet, int soLuong, double tongTien) {
        this.maNhap = maNhap;
        this.maMayTinhChiTiet = maMayTinhChiTiet;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
    }

    public int getMaNhap() {
        return maNhap;
    }

    public void setMaNhap(int maNhap) {
        this.maNhap = maNhap;
    }

    public int getMaMayTinhChiTiet() {
        return maMayTinhChiTiet;
    }

    public void setMaMayTinhChiTiet(int maMayTinhChiTiet) {
        this.maMayTinhChiTiet = maMayTinhChiTiet;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public static ArrayList<HoaDonNhapChiTiet> getAll(int maHoaDonNhap) {
        ArrayList<HoaDonNhapChiTiet> list = new ArrayList<>();
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            ResultSet re = connectDatabase.getConnection().
                    createStatement().executeQuery("select * from hoadonnhapchitiet where maNhap = " + maHoaDonNhap);
            while (re.next()) {
                list.add(new HoaDonNhapChiTiet(re.getInt("maNhap"),
                        re.getInt("maMayTinhChiTiet"),
                        re.getInt("soLuong"),
                        re.getDouble("tongTien")));
            }
            connectDatabase.close();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonNhapChiTiet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static int insert(HoaDonNhapChiTiet o) {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            // nếu trả về 1 là thành công
            return connectDatabase.getConnection().createStatement().executeUpdate(
                    "insert into hoadonnhapchitiet values("
                    + o.getMaNhap() + ", "
                    + o.getMaMayTinhChiTiet() + ", "
                    + o.getSoLuong() + ", "
                    + o.getSoLuong() * MayTinhChiTiet.get(o.getMaMayTinhChiTiet()).getGiaNhap() + ")");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi insert CSDL");
            Logger.getLogger(HoaDonNhapChiTiet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static int update(HoaDonNhapChiTiet o) {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            // nếu trả về 1 là thành công
            return connectDatabase.getConnection().createStatement().executeUpdate(
                    "update hoadonnhapchitiet set soLuong = " + o.getSoLuong()
                    + ", tongTien = " + o.getSoLuong() * MayTinhChiTiet.get(o.getMaMayTinhChiTiet()).getGiaNhap()
                    + "where maNhap = " + o.getMaNhap()
                    + " and maMayTinhChiTiet = " + o.getMaMayTinhChiTiet());
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonNhapChiTiet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static int delete(int maNhap, int maMayTinhChiTiet) {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            // nếu trả về 1 là thành công
            return connectDatabase.getConnection().createStatement().executeUpdate(
                    "delete from hoadonnhapchitiet where maNhap = "
                    + maNhap + " and maMayTinhChiTiet = " + maMayTinhChiTiet);
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static ArrayList<HoaDonNhapChiTiet> search(String search, String type, int maHDN) {
        ArrayList<HoaDonNhapChiTiet> list = new ArrayList<>();
        ConnectDatabase connectDatabase = new ConnectDatabase();
        String sql = "select * from hoadonnhapchitiet where maNhap = " + maHDN;
        switch (type) {
            case "Mã máy tính chi tiết":
                sql += " and maMayTinhChiTiet like '%" + search + "%'";
                break;
            case "Số lượng":
                sql += " and soLuong like '%" + search + "%'";
                break;
            case "Tổng tiền":
                sql += " and tongTien like '%" + search + "%'";
                break;
        }
        try {
            ResultSet re = connectDatabase.getConnection().
                    createStatement().executeQuery(sql);
            while (re.next()) {
                list.add(new HoaDonNhapChiTiet(re.getInt("maNhap"),
                        re.getInt("maMayTinhChiTiet"),
                        re.getInt("soLuong"),
                        re.getDouble("tongTien")));
            }
            connectDatabase.close();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonNhapChiTiet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static ArrayList<TK> thongKe(String thuocTinh, int maHDN) throws SQLException {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        ArrayList<TK> list = new ArrayList<>();
        String sql;
        ResultSet re;
        switch (thuocTinh) {
            case "Mã máy tính chi tiết":
                sql = "select maMayTinhChiTiet,count(*) from hoadonnhapchitiet where maNhap = "
                        + maHDN + " group by maMayTinhChiTiet";
                re = connectDatabase.getConnection().
                        createStatement().executeQuery(sql);
                while (re.next()) {
                    list.add(new TK(re.getInt("maMayTinhChiTiet") + "",
                            re.getInt("count(*)")));
                }
                connectDatabase.close();
                break;
            case "Số lượng":
                sql = "select soLuong,count(*) from hoadonnhapchitiet where maNhap = "
                        + maHDN + " group by soLuong";
                re = connectDatabase.getConnection().
                        createStatement().executeQuery(sql);
                while (re.next()) {
                    list.add(new TK(re.getInt("soLuong") + "",
                            re.getInt("count(*)")));
                }
                connectDatabase.close();
                break;
            case "Tổng tiền":
                sql = "select tongTien,count(*) from hoadonnhapchitiet where maNhap = "
                        + maHDN + " group by tongTien";
                re = connectDatabase.getConnection().
                        createStatement().executeQuery(sql);
                while (re.next()) {
                    list.add(new TK(new DecimalFormat("###.#").format(re.getDouble("tongTien")) + "",
                            re.getInt("count(*)")));
                }
                connectDatabase.close();
                break;
        }

        return list;
    }
}
