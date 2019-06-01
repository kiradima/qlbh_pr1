/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import static entity.KhachHang.COL_NGAY_SINH_KHACH_HANG;
import java.sql.ResultSet;
import helper.ConnectDatabase;
import helper.ExcelHelper;
import helper.TinhThanhPho;
import helper.WordHelper;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ui.HoaDonNhapUI;

/**
 *
 * @author Kira
 */
public class HoaDonNhap {

//    maNhap, maNhanVien, maNhaCungCap, thoiGian, tongTien
    final static String HOA_DON_NHAP = "hoadonnhap";

    final static String COL_MA_NHAP = "maNhap";
    final static String COL_MA_NHAN_VIEN = "maNhanVien";
    final static String COL_MA_NHA_CUNG_CAP = "maNhaCungCap";
    final static String COL_THOI_GIAN = "thoiGian";
    final static String COL_TONG_TIEN = "tongTien";

    public final static String TT_MA_NHAP = "Mã nhập";
    public final static String TT_MA_NHAN_VIEN = "Mã nhân viên";
    public final static String TT_MA_NHA_CUNG_CAP = "Mã nhà cung cấp";
    public final static String TT_THOI_GIAN = "Thời gian";
    public final static String TT_TONG_TIEN = "Tổng tiền";

//    public final static String TT_THANH_PHO = "Thành phố";
    private int maNhap;
    private int maNhanVien;
    private int maNhaCungCap;
    private Date thoiGian;
    private double tongTien;

    public HoaDonNhap() {
    }

    public HoaDonNhap(int maNhap, int maNhanVien, int maNhaCungCap, Date thoiGian, double tongTien) {
        this.maNhap = maNhap;
        this.maNhanVien = maNhanVien;
        this.maNhaCungCap = maNhaCungCap;
        this.thoiGian = thoiGian;
        this.tongTien = tongTien;
    }

    public int getMaNhap() {
        return maNhap;
    }

    public void setMaNhap(int maNhap) {
        this.maNhap = maNhap;
    }

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public int getMaNhaCungCap() {
        return maNhaCungCap;
    }

    public void setMaHoaDonNhap(int maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }

    public Date getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Date thoiGian) {
        this.thoiGian = thoiGian;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public static ArrayList<HoaDonNhap> getAll() {
        ArrayList<HoaDonNhap> list = new ArrayList<>();
        try {

            String sql = "select * from " + HOA_DON_NHAP;
            ConnectDatabase connectDatabase = new ConnectDatabase();
            Connection connection = connectDatabase.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                list.add(new HoaDonNhap(
                        resultSet.getInt(COL_MA_NHAP),
                        resultSet.getInt(COL_MA_NHAN_VIEN),
                        resultSet.getInt(COL_MA_NHA_CUNG_CAP),
                        new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString(COL_THOI_GIAN)),
                        resultSet.getDouble(COL_TONG_TIEN)
                ));
            }
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(HoaDonNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    /**
     *
     * @param ma
     * @return HoaDonNhap
     */
    public static HoaDonNhap get(int ma) {
        HoaDonNhap o = null;
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            ResultSet resultSet = connectDatabase.getConnection().
                    createStatement().executeQuery("select * from " + HOA_DON_NHAP + " where "
                            + COL_MA_NHAP + " = " + ma);
            while (resultSet.next()) {
                o = new HoaDonNhap(
                        resultSet.getInt(COL_MA_NHAP),
                        resultSet.getInt(COL_MA_NHAN_VIEN),
                        resultSet.getInt(COL_MA_NHA_CUNG_CAP),
                        new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString(COL_THOI_GIAN)),
                        resultSet.getDouble(COL_TONG_TIEN)
                );
            }
            connectDatabase.close();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonNhap.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(HoaDonNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return o;
    }

    public static int insert(HoaDonNhap o) {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            // nếu trả về 1 là thành công
            return connectDatabase.getConnection().createStatement().executeUpdate("insert into "
                    + HOA_DON_NHAP + " values('"
                    + o.getMaNhap() + "','"
                    + o.getMaNhanVien() + "','"
                    + o.getMaNhaCungCap() + "','"
                    + new SimpleDateFormat("yyyy-MM-dd").format(o.getThoiGian()) + "','"
                    + o.getTongTien() + "')"
            );
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi insert CSDL");
            Logger.getLogger(HoaDonNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static int update(HoaDonNhap o) {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            // nếu trả về 1 là thành công
            return connectDatabase.getConnection().createStatement().executeUpdate("update "
                    + HOA_DON_NHAP + " set " + COL_MA_NHAN_VIEN + " = '"
                    + o.getMaNhanVien() + "'," + COL_MA_NHA_CUNG_CAP + " = '"
                    + o.getMaNhaCungCap() + "'," + COL_THOI_GIAN + " = '"
                    + new SimpleDateFormat("yyyy-MM-dd").format(o.getThoiGian()) + "'," + COL_TONG_TIEN + " = '"
                    + o.getTongTien() + "'where " + COL_MA_NHAP + " = '"
                    + o.getMaNhap() + "'"
            );
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi update CSDL");
            Logger.getLogger(HoaDonNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static int delete(int ma) {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            // nếu trả về 1 là thành công
            return connectDatabase.getConnection().createStatement().executeUpdate("delete from "
                    + HOA_DON_NHAP + " where "
                    + COL_MA_NHAP + " = " + ma);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi delete CSDL");
            Logger.getLogger(HoaDonNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static ArrayList<HoaDonNhap> search(String search, String type) {
        ArrayList<HoaDonNhap> list = new ArrayList<>();
        ConnectDatabase connectDatabase = new ConnectDatabase();
        String sql = "select * from qlbh." + HOA_DON_NHAP + " where ";
        switch (type) {
            case TT_MA_NHAP:
                sql += COL_MA_NHAP + " like '%" + search + "%'";
                break;
            case TT_MA_NHAN_VIEN:
                sql += COL_MA_NHAN_VIEN + " like '%" + search + "%'";
                break;
            case TT_MA_NHA_CUNG_CAP:
                sql += COL_MA_NHA_CUNG_CAP + " like '%" + search + "%'";
                break;
            case TT_THOI_GIAN:
                sql += COL_THOI_GIAN + " like '%" + search + "%'";
                break;
            case TT_TONG_TIEN:
                sql += COL_TONG_TIEN + " like '%" + search + "%'";
                break;
        }
        System.out.println(sql);

        try {
            ResultSet resultSet = connectDatabase.getConnection().
                    createStatement().executeQuery(sql);
            while (resultSet.next()) {
                list.add(new HoaDonNhap(
                        resultSet.getInt(COL_MA_NHAP),
                        resultSet.getInt(COL_MA_NHAN_VIEN),
                        resultSet.getInt(COL_MA_NHA_CUNG_CAP),
                        new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString(COL_THOI_GIAN)),
                        resultSet.getDouble(COL_TONG_TIEN)
                ));
            }
            connectDatabase.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn CSDL");
            Logger.getLogger(HoaDonNhap.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(HoaDonNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static ArrayList<TK> thongKe(String thuocTinh) {
        ArrayList<TK> list = new ArrayList<>();
        switch (thuocTinh) {
            case TT_MA_NHAP:
                list = supportThongKe(COL_MA_NHAP);
                break;
            case TT_MA_NHAN_VIEN:
                list = supportThongKe(COL_MA_NHAN_VIEN);
                break;
            case TT_MA_NHA_CUNG_CAP:
                list = supportThongKe(COL_MA_NHA_CUNG_CAP);
                break;
            case TT_THOI_GIAN:
                list = supportThongKe(COL_THOI_GIAN);
                break;
            case TT_TONG_TIEN:
                list = supportThongKe(COL_TONG_TIEN);
                break;
        }
        return list;
    }

    private static ArrayList<TK> supportThongKe(String column) {
        ArrayList<TK> list = new ArrayList<>();
        try {
            String sql = "select " + column + ",count(*) from qlbh."
                    + HOA_DON_NHAP + " group by " + column;
            ConnectDatabase connectDatabase = new ConnectDatabase();
            ResultSet re = connectDatabase.getConnection().
                    createStatement().executeQuery(sql);
            while (re.next()) {
                list.add(new TK(re.getString(column) + "",
                        re.getInt("count(*)")));
            }
            connectDatabase.close();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

//    public static long getTongTienGiaoDich(int ma) {
//        ConnectDatabase connectDatabase = new ConnectDatabase();
//        try {
//            ResultSet re = connectDatabase.getConnection().
//                    createStatement().executeQuery("select sum(tongTien) "
//                            + "from qlbh." + HOA_DON_NHAP
//                            + " where " + HoaDonNhap.COL_MA_NHAP + " = '" + ma + "'");
//            while (re.next()) {
//                return re.getLong("sum(tongTien)");
//            }
//            connectDatabase.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(HoaDonNhap.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return -1;
//    }
    public static int importExcel(File file) {
        int re = -1;
        String type = file.getName().substring(file.getName().lastIndexOf(".") + 1);
        if (type.equals("xls") || type.equals("xlsx")) {
            ArrayList<HoaDonNhap> list = new ArrayList<>();
            try {
                list = ExcelHelper.importHoaDonNhap(file);
            } catch (Exception ex) {
                Logger.getLogger(HoaDonNhap.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (HoaDonNhap o : list) {
                re = HoaDonNhap.insert(o);
                if (re != 1) {
                    break;
                }
            }
        }
        return re;
    }

    public static int exportDoc(File file, ArrayList<HoaDonNhap> hoaDonNhaps, int export,
            ArrayList<TK> tks, String thuocTinh) {
        try {
            switch (export) {
                // @export :
                //      1 : tất cả
                //      2 : thống kê
                //      3 : tìm kiếm
                case 1:
                    WordHelper.exportHoaDonNhap(file, hoaDonNhaps, "THÔNG TIN HÓA ĐƠN NHẬP");
                    break;
                case 2:
                    WordHelper.writeTK(file, tks, "THỐNG KÊ HÓA ĐƠN NHẬP", thuocTinh);
                    break;
                case 3:
                    WordHelper.exportHoaDonNhap(file, hoaDonNhaps, "TÌM KIẾM HÓA ĐƠN NHẬP");
                    break;
                case 0:
            }
            return 1;
        } catch (IOException ex) {
            Logger.getLogger(HoaDonNhapUI.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
}
