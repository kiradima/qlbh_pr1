package entity;

import helper.ConnectDatabase;
import helper.ExcelHelper;
import helper.WordHelper;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ui.MayTinhUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hantr
 */
public class MayTinh {

    final static String MAY_TINH = "maytinh";
    final static String HOA_DON_XUAT = "hoadonxuat";
    final static String HOA_DON_NHAP = "hoadonnhap";

    final static String COL_MA_MAY_TINH = "maMayTinh";
    final static String COL_TEN_MAY_TINH = "tenMayTinh";
    final static String COL_NHA_SAN_XUAT = "nhaSanXuat";
    final static String COL_NAM_SAN_XUAT = "namSanXuat";
    final static String COL_THOI_GIAN_BAO_HANH = "thoiGianBaoHanh";
//    final static String COL_NGAY_SINH_KHACH_HANG = "ngaySinh";
//    final static String COL_GIOI_TINH_KHACH_HANG = "gioiTinh";
//    final static String COL_EMAIL_KHACH_HANG = "emailMayTinh";

    public final static String TT_MA = "Mã";
    public final static String TT_TEN = "Tên";
    public final static String TT_NHA_SAN_XUAT = "Nhà sản xuất";
    public final static String TT_NAM_SAN_XUAT = "Năm sản xuất";
    public final static String TT_THOI_GIAN_BAO_HANH = "Thời gian bảo hành";
//    public final static String TT_NGAY_SINH = "Ngày sinh";
//    public final static String TT_GIOI_TINH = "Giới tính";
//    public final static String TT_EMAIL = "Email";

//    public final static String TT_THANH_PHO = "Thành phố";
    //cac thuoc tinh 
    private int maMayTinh;
    private String tenMayTinh;
    private String nhaSanXuat;
    private int namSanXuat;
    private int thoiGianBaoHanh;
    //constructor 

    public MayTinh() {
    }

    public MayTinh(int maMayTinh, String tenMayTinh, String nhaSanXuat, int namSanXuat, int thoiGianBaoHanh) {
        this.maMayTinh = maMayTinh;
        this.tenMayTinh = tenMayTinh;
        this.nhaSanXuat = nhaSanXuat;
        this.namSanXuat = namSanXuat;
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }
    //setter va getter

    public int getMaMayTinh() {
        return maMayTinh;
    }

    public void setMaMayTinh(int maMayTinh) {
        this.maMayTinh = maMayTinh;
    }

    public String getTenMayTinh() {
        return tenMayTinh;
    }

    public void setTenMayTinh(String tenMayTinh) {
        this.tenMayTinh = tenMayTinh;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    public int getNamSanXuat() {
        return namSanXuat;
    }

    public void setNamSanXuat(int namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public int getThoiGianBaoHanh() {
        return thoiGianBaoHanh;
    }

    public void setThoiGianBaoHanh(int thoiGianBaoHanh) {
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }

    public static ArrayList<MayTinh> getAll() {
        ArrayList<MayTinh> list = new ArrayList<>();
        try {

            String sql = "select * from " + MAY_TINH;
            ConnectDatabase connectDatabase = new ConnectDatabase();
            Connection connection = connectDatabase.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                list.add(new MayTinh(
                        resultSet.getInt(COL_MA_MAY_TINH),
                        resultSet.getString(COL_TEN_MAY_TINH),
                        resultSet.getString(COL_NHA_SAN_XUAT),
                        resultSet.getInt(COL_NAM_SAN_XUAT),
                        resultSet.getInt(COL_THOI_GIAN_BAO_HANH)
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MayTinh.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    /**
     *
     * @param ma
     * @return
     */
    public static MayTinh get(int ma) {
        MayTinh o = null;
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            ResultSet resultSet = connectDatabase.getConnection().
                    createStatement().executeQuery("select * from " + MAY_TINH + " where "
                            + COL_MA_MAY_TINH + " = " + ma);
            while (resultSet.next()) {
                o = new MayTinh(
                        resultSet.getInt(COL_MA_MAY_TINH),
                        resultSet.getString(COL_TEN_MAY_TINH),
                        resultSet.getString(COL_NHA_SAN_XUAT),
                        resultSet.getInt(COL_NAM_SAN_XUAT),
                        resultSet.getInt(COL_THOI_GIAN_BAO_HANH)
                );
            }
            connectDatabase.close();
        } catch (SQLException ex) {
            Logger.getLogger(MayTinh.class.getName()).log(Level.SEVERE, null, ex);
        }
        return o;
    }

    public static int insert(MayTinh o) {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            // nếu trả về 1 là thành công
            return connectDatabase.getConnection().createStatement().executeUpdate("insert into "
                    + MAY_TINH + " values('"
                    + o.getMaMayTinh() + "','"
                    + o.getTenMayTinh() + "','"
                    + o.getNhaSanXuat() + "','"
                    + o.getNamSanXuat() + "','"
                    + o.getThoiGianBaoHanh() + "')"
            );
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi insert CSDL");
            Logger.getLogger(MayTinh.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static int update(MayTinh o) {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            // nếu trả về 1 là thành công
            return connectDatabase.getConnection().createStatement().executeUpdate("update " + MAY_TINH
                    + " set " + COL_TEN_MAY_TINH + " = '"
                    + o.getTenMayTinh() + "'," + COL_NHA_SAN_XUAT + " = '"
                    + o.getNhaSanXuat() + "'," + COL_NAM_SAN_XUAT + " = '"
                    + o.getNamSanXuat() + "'," + COL_THOI_GIAN_BAO_HANH + " = '"
                    + o.getThoiGianBaoHanh() + "' where " + COL_MA_MAY_TINH + " = '"
                    + o.getMaMayTinh() + "'"
            );
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi update CSDL");
            Logger.getLogger(MayTinh.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static int delete(int ma) {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            // nếu trả về 1 là thành công
            return connectDatabase.getConnection().createStatement().executeUpdate("delete from "
                    + MAY_TINH + " where "
                    + COL_MA_MAY_TINH + " = " + ma);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi delete CSDL");
            Logger.getLogger(MayTinh.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static ArrayList<MayTinh> search(String search, String type) {
        ArrayList<MayTinh> list = new ArrayList<>();
        ConnectDatabase connectDatabase = new ConnectDatabase();
        String sql = "select * from qlbh." + MAY_TINH + " where ";
        switch (type) {
            case TT_MA:
                sql += COL_MA_MAY_TINH + " like '%" + search + "%'";
                break;
            case TT_TEN:
                sql += " lower(" + COL_TEN_MAY_TINH + ") like '%" + search.toLowerCase() + "%'";
                break;
            case TT_NHA_SAN_XUAT:
                sql += " lower(" + COL_NHA_SAN_XUAT + ") like '%" + search.toLowerCase() + "%'";
                break;
            case TT_NAM_SAN_XUAT:
                sql += COL_NAM_SAN_XUAT + " like '%" + search + "%'";
                break;
            case TT_THOI_GIAN_BAO_HANH:
                sql += COL_THOI_GIAN_BAO_HANH + " = '" + search + "'";
                break;
        }
        System.out.println(sql);

        try {
            ResultSet resultSet = connectDatabase.getConnection().
                    createStatement().executeQuery(sql);
            while (resultSet.next()) {
                list.add(new MayTinh(
                        resultSet.getInt(COL_MA_MAY_TINH),
                        resultSet.getString(COL_TEN_MAY_TINH),
                        resultSet.getString(COL_NHA_SAN_XUAT),
                        resultSet.getInt(COL_NAM_SAN_XUAT),
                        resultSet.getInt(COL_THOI_GIAN_BAO_HANH)
                ));
            }
            connectDatabase.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn CSDL");
            Logger.getLogger(MayTinh.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static ArrayList<TK> thongKe(String thuocTinh) {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        ArrayList<TK> list = new ArrayList<>();
        switch (thuocTinh) {
            case TT_MA:
                list = supportThongKe(COL_MA_MAY_TINH);
                break;
            case TT_TEN:
                list = supportThongKe(COL_TEN_MAY_TINH);
                break;
            case TT_NHA_SAN_XUAT:
                list = supportThongKe(COL_NHA_SAN_XUAT);
                break;
            case TT_NAM_SAN_XUAT:
                list = supportThongKe(COL_NAM_SAN_XUAT);
                break;
            case TT_THOI_GIAN_BAO_HANH:
                list = supportThongKe(COL_THOI_GIAN_BAO_HANH);
                break;
        }
        return list;

    }

    private static ArrayList<TK> supportThongKe(String column) {
        ArrayList<TK> list = new ArrayList<>();
        try {
            String sql = "select " + column + ",count(*) from qlbh."
                    + MAY_TINH + " group by " + column;
            ConnectDatabase connectDatabase = new ConnectDatabase();
            ResultSet re = connectDatabase.getConnection().
                    createStatement().executeQuery(sql);
            while (re.next()) {
                list.add(new TK(re.getString(column) + "",
                        re.getInt("count(*)")));
            }
            connectDatabase.close();
        } catch (SQLException ex) {
            Logger.getLogger(MayTinh.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static int importExcel(File file) {
        int re = -1;
        String type = file.getName().substring(file.getName().lastIndexOf(".") + 1);
        if (type.equals("xls") || type.equals("xlsx")) {
            ArrayList<MayTinh> list = new ArrayList<>();
            try {
                list = ExcelHelper.importMayTinh(file);
            } catch (Exception ex) {
                Logger.getLogger(MayTinh.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (MayTinh o : list) {
                re = MayTinh.insert(o);
                if (re != 1) {
                    break;
                }
            }
        }
        return re;
    }

    /**
     *
     * @param file
     * @param MayTinhs
     * @param export
     * @param tks
     * @param thuocTinh
     * @return
     */
    public static int exportDoc(File file, ArrayList<MayTinh> MayTinhs, int export,
            ArrayList<TK> tks, String thuocTinh) {
        try {
            switch (export) {
                // @export :
                //      1 : tất cả
                //      2 : thống kê
                //      3 : tìm kiếm
                case 1:
                    WordHelper.exportMayTinh(file, MayTinhs, "THÔNG TIN MÁY TÍNH");
                    break;
                case 2:
                    WordHelper.writeTK(file, tks, "THỐNG KÊ MÁY TÍNH", thuocTinh);
                    break;
                case 3:
                    WordHelper.exportMayTinh(file, MayTinhs, "TÌM KIẾM MÁY TÍNH");
                    break;
                case 0:
            }
            return 1;
        } catch (IOException ex) {
            Logger.getLogger(MayTinhUI.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

//    public static void main(String[] args) {
//
//        @test thongKe
//        ArrayList<TK> tks = thongKe(TT_THANH_PHO);
//        for (TK tk : tks) {
//            System.out.println(tk.getThuocTinh() + " - " + tk.getSoLuong());
//        }
//        @test getTongTienGiaoDich
//        System.out.println(getTongTienGiaoDich(4001));
//    }
}
