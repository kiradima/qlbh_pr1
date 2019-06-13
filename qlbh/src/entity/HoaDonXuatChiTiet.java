/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import command_pattern.HoaDonNhap;
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
public class HoaDonXuatChiTiet {

    private int maXuat;
    private int maMayTinhChiTiet;
    private int soLuong;
    private double tongTien;

    public HoaDonXuatChiTiet(int maXuat, int maMayTinhChiTiet, int soLuong, double tongTien) {
        this.maXuat = maXuat;
        this.maMayTinhChiTiet = maMayTinhChiTiet;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
    }

    public HoaDonXuatChiTiet() {
    }

    public int getMaXuat() {
        return maXuat;
    }

    public void setMaXuat(int maXuat) {
        this.maXuat = maXuat;
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

    public static ArrayList<HoaDonXuatChiTiet> getAll(int maHoaDonNhap) {
        ArrayList<HoaDonXuatChiTiet> list = new ArrayList<>();
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            ResultSet re = connectDatabase.getConnection().
                    createStatement().executeQuery("select * from hoadonxuatchitiet where maXuat = " + maHoaDonNhap);
            while (re.next()) {
                list.add(new HoaDonXuatChiTiet(re.getInt("maXuat"),
                        re.getInt("maMayTinhChiTiet"),
                        re.getInt("soLuong"),
                        re.getDouble("tongTien")));
            }
            connectDatabase.close();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonXuatChiTiet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static int insert(HoaDonXuatChiTiet o) {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            // nếu trả về 1 là thành công
            int re = connectDatabase.getConnection().createStatement().executeUpdate(
                    "insert into hoadonxuatchitiet values("
                    + o.getMaXuat() + ", "
                    + o.getMaMayTinhChiTiet() + ", "
                    + o.getSoLuong() + ", "
                    + o.getSoLuong() * MayTinhChiTiet.get(o.getMaMayTinhChiTiet()).getGiaBan() + ")");
            updateTongTienHDX();
            return re;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi insert CSDL");
            Logger.getLogger(HoaDonXuatChiTiet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static int update(HoaDonXuatChiTiet o) {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            // nếu trả về 1 là thành công
            int re = connectDatabase.getConnection().createStatement().executeUpdate(
                    "update hoadonxuatchitiet set soLuong = " + o.getSoLuong()
                    + ", tongTien = " + o.getSoLuong() * MayTinhChiTiet.get(o.getMaMayTinhChiTiet()).getGiaBan()
                    + "where maXuat = " + o.getMaXuat()
                    + " and maMayTinhChiTiet = " + o.getMaMayTinhChiTiet());
            updateTongTienHDX();
            return re;
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonXuatChiTiet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static int delete(int maXuat, int maMayTinhChiTiet) {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            // nếu trả về 1 là thành công
            int re = connectDatabase.getConnection().createStatement().executeUpdate(
                    "delete from hoadonxuatchitiet where maXuat = "
                    + maXuat + " and maMayTinhChiTiet = " + maMayTinhChiTiet);
            updateTongTienHDX();
            return re;
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static ArrayList<HoaDonXuatChiTiet> search(String search, String type, int maHDX) {
        ArrayList<HoaDonXuatChiTiet> list = new ArrayList<>();
        ConnectDatabase connectDatabase = new ConnectDatabase();
        String sql = "select * from hoadonxuatchitiet where maXuat = " + maHDX;
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
                list.add(new HoaDonXuatChiTiet(re.getInt("maXuat"),
                        re.getInt("maMayTinhChiTiet"),
                        re.getInt("soLuong"),
                        re.getDouble("tongTien")));
            }
            connectDatabase.close();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonXuatChiTiet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static ArrayList<TK> thongKe(String thuocTinh, int maHDX) throws SQLException {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        ArrayList<TK> list = new ArrayList<>();
        String sql;
        ResultSet re;
        switch (thuocTinh) {
            case "Mã máy tính chi tiết":
                sql = "select maMayTinhChiTiet,count(*) from hoadonxuatchitiet where maXuat = "
                        + maHDX + " group by maMayTinhChiTiet";
                re = connectDatabase.getConnection().
                        createStatement().executeQuery(sql);
                while (re.next()) {
                    list.add(new TK(re.getInt("maMayTinhChiTiet") + "",
                            re.getInt("count(*)")));
                }
                connectDatabase.close();
                break;
            case "Số lượng":
                sql = "select soLuong,count(*) from hoadonxuatchitiet where maXuat = "
                        + maHDX + " group by soLuong";
                re = connectDatabase.getConnection().
                        createStatement().executeQuery(sql);
                while (re.next()) {
                    list.add(new TK(re.getInt("soLuong") + "",
                            re.getInt("count(*)")));
                }
                connectDatabase.close();
                break;
            case "Tổng tiền":
                sql = "select tongTien,count(*) from hoadonxuatchitiet where maXuat = "
                        + maHDX + " group by tongTien";
                re = connectDatabase.getConnection().
                        createStatement().executeQuery(sql);
                while (re.next()) {
                    list.add(new TK(new DecimalFormat("###,###").format(re.getDouble("tongTien")) + "",
                            re.getInt("count(*)")));
                }
                connectDatabase.close();
                break;
        }

        return list;
    }

    public static void updateTongTienHDX() {
        ArrayList<HoaDonXuat> hoaDonXuats = HoaDonXuat.getAll();
        for (HoaDonXuat hoaDonXuat : hoaDonXuats) {
            double tongTien = 0;
            ArrayList<HoaDonXuatChiTiet> hoaDonXuatChiTiets = getAll(hoaDonXuat.getMaXuat());
            for (HoaDonXuatChiTiet hoaDonXuatChiTiet : hoaDonXuatChiTiets) {
                tongTien += hoaDonXuatChiTiet.getTongTien();
            }
            hoaDonXuat.setTongTien(tongTien);
            HoaDonXuat.update(hoaDonXuat);
        }
    }

}
