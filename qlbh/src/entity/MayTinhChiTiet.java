/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import ui.MayTinhChiTietUI;

/**
 *
 * @author Kira
 */
public class MayTinhChiTiet {

    final static String MAY_TINH_CHI_TIET = "maytinhchitiet";
    final static String HOA_DON_XUAT = "hoadonxuat";
    final static String HOA_DON_NHAP = "hoadonnhap";

    final static String COL_MA_MAY_TINH_CHI_TIET = "maMayTinhChiTiet";
    final static String COL_MA_MAY_TINH = "maMayTinh";
    final static String COL_MO_TA = "moTa";
    final static String COL_GIA_NHAP = "giaNhap";
    final static String COL_GIA_BAN = "giaBan";
    final static String COL_CAU_HINH = "cauHinh";
    final static String COL_MAU_SAC = "mauSac";
    final static String COL_SO_LUONG_TON_KHO = "soLuongTonKho";

    public final static String TT_MA_MAY_TINH_CHI_TIET = "Mã";
    public final static String TT_MA_MAY_TINH = "Mã MT";
    public final static String TT_MO_TA = "Mô tả";
    public final static String TT_GIA_NHAP = "G.Nhập";
    public final static String TT_GIA_BAN = "G.Bán";
    public final static String TT_CAU_HINH = "C.Hình";
    public final static String TT_MAU_SAC = "M.Sắc";
    public final static String TT_SO_LUONG_TON_KHO = "SL T.KHo";

//    public final static String TT_THANH_PHO = "Thành phố";
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

    public static ArrayList<MayTinhChiTiet> getAll(int maMayTinh) {
        ArrayList<MayTinhChiTiet> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM qlbh." + MAY_TINH_CHI_TIET + " where maMayTinh = " + maMayTinh;
            ConnectDatabase connectDatabase = new ConnectDatabase();
            Connection connection = connectDatabase.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                list.add(new MayTinhChiTiet(
                        resultSet.getInt(COL_MA_MAY_TINH_CHI_TIET),
                        resultSet.getInt(COL_MA_MAY_TINH),
                        resultSet.getString(COL_MO_TA),
                        resultSet.getDouble(COL_GIA_NHAP),
                        resultSet.getDouble(COL_GIA_BAN),
                        resultSet.getString(COL_CAU_HINH),
                        resultSet.getString(COL_MAU_SAC),
                        resultSet.getInt(COL_SO_LUONG_TON_KHO)
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MayTinhChiTiet.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public static ArrayList<MayTinhChiTiet> getAll() {
        ArrayList<MayTinhChiTiet> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM qlbh." + MAY_TINH_CHI_TIET;
            System.out.println(sql);
            ConnectDatabase connectDatabase = new ConnectDatabase();
            Connection connection = connectDatabase.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                list.add(new MayTinhChiTiet(
                        resultSet.getInt(COL_MA_MAY_TINH_CHI_TIET),
                        resultSet.getInt(COL_MA_MAY_TINH),
                        resultSet.getString(COL_MO_TA),
                        resultSet.getDouble(COL_GIA_NHAP),
                        resultSet.getDouble(COL_GIA_BAN),
                        resultSet.getString(COL_CAU_HINH),
                        resultSet.getString(COL_MAU_SAC),
                        resultSet.getInt(COL_SO_LUONG_TON_KHO)
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MayTinhChiTiet.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public static ArrayList<Integer> getAllMaMayTinhChiTiets() {
        ArrayList<Integer> mas = new ArrayList<>();
        ArrayList<MayTinh> mayTinhs = MayTinh.getAll();
        for (MayTinh mayTinh : mayTinhs) {
            ArrayList<MayTinhChiTiet> mayTinhChiTiets = MayTinhChiTiet.getAll(mayTinh.getMaMayTinh());
            for (MayTinhChiTiet mayTinhChiTiet : mayTinhChiTiets) {
                mas.add(mayTinhChiTiet.getMaMayTinhChiTiet());
            }
        }
        return mas;
    }

    /**
     *
     * @param maMayTinhChiTiet
     * @return
     */
    public static MayTinhChiTiet get(int maMayTinhChiTiet) {
        MayTinhChiTiet o = null;
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            ResultSet resultSet = connectDatabase.getConnection().
                    createStatement().executeQuery("select * from " + MAY_TINH_CHI_TIET + " where "
                            + COL_MA_MAY_TINH_CHI_TIET + " = " + maMayTinhChiTiet);
            while (resultSet.next()) {
                o = new MayTinhChiTiet(
                        resultSet.getInt(COL_MA_MAY_TINH_CHI_TIET),
                        resultSet.getInt(COL_MA_MAY_TINH),
                        resultSet.getString(COL_MO_TA),
                        resultSet.getDouble(COL_GIA_NHAP),
                        resultSet.getDouble(COL_GIA_BAN),
                        resultSet.getString(COL_CAU_HINH),
                        resultSet.getString(COL_MAU_SAC),
                        resultSet.getInt(COL_SO_LUONG_TON_KHO)
                );
            }
            connectDatabase.close();
        } catch (SQLException ex) {
            Logger.getLogger(MayTinhChiTiet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return o;
    }

    public static int insert(MayTinhChiTiet o) {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            // nếu trả về 1 là thành công
            return connectDatabase.getConnection().createStatement().executeUpdate("insert into "
                    + MAY_TINH_CHI_TIET + " values('"
                    + o.getMaMayTinhChiTiet() + "','"
                    + o.getMaMayTinh() + "','"
                    + o.getMoTa() + "','"
                    + o.getGiaNhap() + "','"
                    + o.getGiaBan() + "','"
                    + o.getCauHinh() + "','"
                    + o.getMauSac() + "','"
                    + o.getSoLuongTonKho() + "')"
            );
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi insert CSDL");
            Logger.getLogger(MayTinhChiTiet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static int update(MayTinhChiTiet o) {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            // nếu trả về 1 là thành công
            return connectDatabase.getConnection().createStatement().executeUpdate("update " + MAY_TINH_CHI_TIET
                    + " set " + COL_MA_MAY_TINH + " = '"
                    + o.getMaMayTinh() + "'," + COL_MO_TA + " = '"
                    + o.getMoTa() + "'," + COL_GIA_NHAP + " = '"
                    + o.getGiaNhap() + "'," + COL_GIA_BAN + " = '"
                    + o.getGiaBan() + "'," + COL_CAU_HINH + " = '"
                    + o.getCauHinh() + "'," + COL_MAU_SAC + " = '"
                    + o.getMauSac() + "'," + COL_SO_LUONG_TON_KHO + " = '"
                    + o.getSoLuongTonKho() + "'where " + COL_MA_MAY_TINH_CHI_TIET + " = '"
                    + o.getMaMayTinhChiTiet() + "'"
            );
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi update CSDL");
            Logger.getLogger(MayTinhChiTiet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static int delete(int ma) {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            // nếu trả về 1 là thành công
            return connectDatabase.getConnection().createStatement().executeUpdate("delete from "
                    + MAY_TINH_CHI_TIET + " where "
                    + COL_MA_MAY_TINH_CHI_TIET + " = " + ma);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi delete CSDL");
            Logger.getLogger(MayTinhChiTiet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static ArrayList<MayTinhChiTiet> search(String search, String type, int maMayTinh) {
        ArrayList<MayTinhChiTiet> list = new ArrayList<>();
        ConnectDatabase connectDatabase = new ConnectDatabase();
        String sql = "select * from qlbh." + MAY_TINH_CHI_TIET
                + " where " + COL_MA_MAY_TINH + " = " + maMayTinh + " and ";
        switch (type) {
            case TT_MA_MAY_TINH_CHI_TIET:
                sql += COL_MA_MAY_TINH_CHI_TIET + " like '%" + search + "%'";
                break;
//            case TT_MA_MAY_TINH:
//                sql += COL_MA_MAY_TINH + " like '%" + search + "%'";
//                break;
            case TT_MO_TA:
                sql += "lower(" + COL_MO_TA + ") like '%" + search.toLowerCase() + "%'";
                break;
            case TT_GIA_NHAP:
                sql += COL_GIA_NHAP + " like '%" + search + "%'";
                break;
            case TT_GIA_BAN:
                sql += COL_GIA_BAN + " like '%" + search + "%'";
                break;
            case TT_CAU_HINH:
                sql += "lower(" + COL_CAU_HINH + ") like '%" + search.toLowerCase() + "%'";
                break;
            case TT_MAU_SAC:
                sql += "lower(" + COL_MAU_SAC + ") like '%" + search.toLowerCase() + "%'";
                break;
            case TT_SO_LUONG_TON_KHO:
                sql += COL_SO_LUONG_TON_KHO + " like '%" + search + "%'";
                break;
        }
        System.out.println(sql);

        try {
            ResultSet resultSet = connectDatabase.getConnection().
                    createStatement().executeQuery(sql);
            while (resultSet.next()) {
                list.add(new MayTinhChiTiet(
                        resultSet.getInt(COL_MA_MAY_TINH_CHI_TIET),
                        resultSet.getInt(COL_MA_MAY_TINH),
                        resultSet.getString(COL_MO_TA),
                        resultSet.getDouble(COL_GIA_NHAP),
                        resultSet.getDouble(COL_GIA_BAN),
                        resultSet.getString(COL_CAU_HINH),
                        resultSet.getString(COL_MAU_SAC),
                        resultSet.getInt(COL_SO_LUONG_TON_KHO)
                ));
            }
            connectDatabase.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn CSDL");
            Logger.getLogger(MayTinhChiTiet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static ArrayList<TK> thongKe(String thuocTinh, int maMayTinh) {
        ArrayList<TK> list = new ArrayList<>();
        switch (thuocTinh) {
            case TT_MA_MAY_TINH_CHI_TIET:
                list = supportThongKe(COL_MA_MAY_TINH_CHI_TIET, maMayTinh);
                break;
            case TT_MO_TA:
                list = supportThongKe(COL_MO_TA, maMayTinh);
                break;
            case TT_GIA_NHAP:
                list = supportThongKe(COL_GIA_NHAP, maMayTinh);
                break;
            case TT_GIA_BAN:
                list = supportThongKe(COL_GIA_BAN, maMayTinh);
                break;
            case TT_CAU_HINH:
                list = supportThongKe(COL_CAU_HINH, maMayTinh);
                break;
            case TT_MAU_SAC:
                list = supportThongKe(COL_MAU_SAC, maMayTinh);
                break;
            case TT_SO_LUONG_TON_KHO:
                list = supportThongKe(COL_SO_LUONG_TON_KHO, maMayTinh);
                break;
        }
        return list;

    }

    private static ArrayList<TK> supportThongKe(String column, int maMayTinh) {
        ArrayList<TK> list = new ArrayList<>();
        try {

            String sql = "select " + column + " ,count(*) "
                    + "from qlbh." + MAY_TINH_CHI_TIET
                    + " where " + COL_MA_MAY_TINH + " = '" + maMayTinh
                    + "' group by " + column;
            System.out.println(sql);
            ConnectDatabase connectDatabase = new ConnectDatabase();
            ResultSet re = connectDatabase.getConnection().
                    createStatement().executeQuery(sql);
            while (re.next()) {
                list.add(new TK(re.getString(column) + "",
                        re.getInt("count(*)")));
            }
            connectDatabase.close();
        } catch (SQLException ex) {
            Logger.getLogger(MayTinhChiTiet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static int importExcel(File file) {
        int re = -1;
        String type = file.getName().substring(file.getName().lastIndexOf(".") + 1);
        if (type.equals("xls") || type.equals("xlsx")) {
            ArrayList<MayTinhChiTiet> list = new ArrayList<>();
            try {
                list = ExcelHelper.importMayTinhChiTiet(file);
            } catch (Exception ex) {
                Logger.getLogger(MayTinhChiTiet.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (MayTinhChiTiet o : list) {
                re = MayTinhChiTiet.insert(o);
                if (re != 1) {
                    break;
                }
            }
        }
        return re;
    }

    public static int exportDoc(File file, ArrayList<MayTinhChiTiet> mayTinhChiTiets, int export,
            ArrayList<TK> tks, String thuocTinh) {
        try {
            switch (export) {
                // @export :
                //      1 : tất cả
                //      2 : thống kê
                //      3 : tìm kiếm
                case 1:
                    WordHelper.exportMayTinhChiTiet(file, mayTinhChiTiets, "THÔNG TIN MÁY TÍNH CHI TIẾT");
                    break;
                case 2:
                    WordHelper.writeTK(file, tks, "THỐNG KÊ MÁY TÍNH CHI TIẾT", thuocTinh);
                    break;
                case 3:
                    WordHelper.exportMayTinhChiTiet(file, mayTinhChiTiets, "TÌM KIẾM MÁY TÍNH CHI TIẾT");
                    break;
                case 0:
            }
            return 1;
        } catch (IOException ex) {
            Logger.getLogger(MayTinhChiTietUI.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

//    public static void main(String[] args) {
//        System.out.println(getAll().size());
//    }
}
