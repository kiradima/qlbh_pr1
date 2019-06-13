/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command_pattern;

import ui.HoaDonNhapUI;
import entity.HoaDonNhapChiTiet;
import entity.KhachHang;
import entity.NhaCungCap;
import entity.NhanVien;
import entity.TK;
import entity.TKR;
import entity.ThangNam;
import java.sql.ResultSet;
import helper.ConnectDatabase;
import helper.ExcelHelper;
import helper.WordHelper;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Kira
 */
public class HoaDonNhap {

//    maNhap, maNhanVien, maNhaCungCap, thoiGian, tongTien
    public final static String HOA_DON_NHAP = "hoadonnhap";

    public final static String COL_MA_NHAP = "maNhap";
    public final static String COL_MA_NHAN_VIEN = "maNhanVien";
    public final static String COL_MA_NHA_CUNG_CAP = "maNhaCungCap";
    public final static String COL_THOI_GIAN = "thoiGian";
    public final static String COL_TONG_TIEN = "tongTien";

    public final static String TT_MA_NHAP = "Mã nh?p";
    public final static String TT_MA_NHAN_VIEN = "Mã nhân viên";
    public final static String TT_MA_NHA_CUNG_CAP = "Mã nhà cung c?p";
    public final static String TT_THOI_GIAN = "Th?i gian";
    public final static String TT_TONG_TIEN = "T?ng ti?n";

    public final static String TT_TEN_NHAN_VIEN = "Tên nhân viên";
    public final static String TT_TEN_NHA_CUNG_CAP = "Tên nhà cung c?p";

//    public final static String TT_THANH_PHO = "Thành ph?";
    private int maNhap;
    private int maNhanVien;
    private int maNhaCungCap;
    private Date thoiGian;
    private double tongTien;
    private ArrayList<HoaDonNhapChiTiet> hoaDonNhapChiTiets;

    public ArrayList<HoaDonNhapChiTiet> getHoaDonNhapChiTiets() {
        return hoaDonNhapChiTiets;
    }

    public void setHoaDonNhapChiTiets(ArrayList<HoaDonNhapChiTiet> hoaDonNhapChiTiets) {
        this.hoaDonNhapChiTiets = hoaDonNhapChiTiets;
    }

    public HoaDonNhap() {
    }

    public HoaDonNhap(int maNhap, int maNhanVien, int maNhaCungCap, Date thoiGian, double tongTien) {
        this.maNhap = maNhap;
        this.maNhanVien = maNhanVien;
        this.maNhaCungCap = maNhaCungCap;
        this.thoiGian = thoiGian;
        this.tongTien = tongTien;
    }

    public int getMaNhaCungCap() {
        return maNhaCungCap;
    }

    public void setMaNhaCungCap(int maNhaCungCap) {
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
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(HoaDonNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return o;
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

    public static int insert(HoaDonNhap o) {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            // n?u tr? v? 1 là thành công
            return connectDatabase.getConnection().createStatement().executeUpdate("insert into "
                    + HOA_DON_NHAP + " values('"
                    + o.getMaNhap() + "','"
                    + o.getMaNhanVien() + "','"
                    + o.getMaNhaCungCap() + "','"
                    + new SimpleDateFormat("yyyy-MM-dd").format(o.getThoiGian()) + "','"
                    + o.getTongTien() + "')"
            );
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "L?i insert CSDL");
            Logger.getLogger(HoaDonNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static int update(HoaDonNhap o) {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            // n?u tr? v? 1 là thành công
            return connectDatabase.getConnection().createStatement().executeUpdate("update "
                    + HOA_DON_NHAP + " set " + COL_MA_NHAN_VIEN + " = '"
                    + o.getMaNhanVien() + "'," + COL_MA_NHA_CUNG_CAP + " = '"
                    + o.getMaNhaCungCap() + "'," + COL_THOI_GIAN + " = '"
                    + new SimpleDateFormat("yyyy-MM-dd").format(o.getThoiGian()) + "'," + COL_TONG_TIEN + " = '"
                    + o.getTongTien() + "'where " + COL_MA_NHAP + " = '"
                    + o.getMaNhap() + "'"
            );
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "L?i update CSDL");
            Logger.getLogger(HoaDonNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static int delete(int ma) {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            // n?u tr? v? 1 là thành công
            return connectDatabase.getConnection().createStatement().executeUpdate("delete from "
                    + HOA_DON_NHAP + " where "
                    + COL_MA_NHAP + " = " + ma);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "L?i delete CSDL");
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
            case TT_TEN_NHAN_VIEN:
                String sql1 = "select * from qlbh." + NhanVien.NHAN_VIEN
                        + " where lower(" + NhanVien.COL_TEN_NHAN_VIEN
                        + ") like '%" + search.toLowerCase() + "%'";
                try {
                    ResultSet resultSet1 = connectDatabase.getConnection().
                            createStatement().executeQuery(sql1);
                    while (resultSet1.next()) {
                        list.addAll(search(resultSet1.getInt(NhanVien.COL_MA_NHAN_VIEN) + "", TT_MA_NHAN_VIEN));
                    }
                } catch (SQLException e) {
                }
                break;
            case TT_TEN_NHA_CUNG_CAP:
                sql1 = "select * from qlbh." + NhaCungCap.NHA_CUNG_CAP
                        + " where lower(" + NhaCungCap.COL_TEN_NHA_CUNG_CAP
                        + ") like '%" + search.toLowerCase() + "%'";
                try {
                    ResultSet resultSet1 = connectDatabase.getConnection().
                            createStatement().executeQuery(sql1);
                    while (resultSet1.next()) {
                        list.addAll(search(resultSet1
                                .getInt(NhaCungCap.COL_MA_NHA_CUNG_CAP) + "", TT_MA_NHA_CUNG_CAP));
                    }
                } catch (SQLException e) {
                }
                break;

        }

        if (!type.equals(TT_TEN_NHAN_VIEN) && !type.equals(TT_TEN_NHA_CUNG_CAP)) {
            System.out.println("vào");
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
                JOptionPane.showMessageDialog(null, "L?i truy v?n CSDL");
                Logger.getLogger(HoaDonNhap.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(HoaDonNhap.class.getName()).log(Level.SEVERE, null, ex);
            }
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

    public static ArrayList<TKR> thongKeRieng(String thuocTinh) {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        ArrayList<TKR> list = new ArrayList<>();
        try {
            String sql;
            ResultSet re;
            switch (thuocTinh) {
                case TT_MA_NHA_CUNG_CAP:
                    sql = "select " + COL_MA_NHA_CUNG_CAP + ",count(*) from qlbh."
                            + HOA_DON_NHAP + " group by " + COL_MA_NHA_CUNG_CAP;
                    re = connectDatabase.getConnection().
                            createStatement().executeQuery(sql);
                    while (re.next()) {
                        TK tk = new TK(re.getString(COL_MA_NHA_CUNG_CAP) + "", re.getInt("count(*)"));
                        long tongTien = NhaCungCap.getTongTienGiaoDich(re.getInt(COL_MA_NHA_CUNG_CAP));
                        list.add(new TKR(tk, tongTien));
                    }
                    connectDatabase.getConnection().close();
                    break;
                case TT_MA_NHAN_VIEN:
                    sql = "select " + COL_MA_NHAN_VIEN + ",count(*) from qlbh."
                            + HOA_DON_NHAP + " group by " + COL_MA_NHAN_VIEN;
                    re = connectDatabase.getConnection().
                            createStatement().executeQuery(sql);
                    while (re.next()) {
                        TK tk = new TK(re.getString(COL_MA_NHAN_VIEN) + "", re.getInt("count(*)"));
                        long tongTien = NhanVien.getTongTienNhap(re.getInt(COL_MA_NHAN_VIEN));
                        list.add(new TKR(tk, tongTien));
                    }
                    connectDatabase.getConnection().close();
                    break;

                case "Ngày":
                    sql = "select " + COL_THOI_GIAN + ", count(*), sum(" + COL_TONG_TIEN
                            + ") from qlbh." + HOA_DON_NHAP + " group by " + COL_THOI_GIAN;
                    re = connectDatabase.getConnection().
                            createStatement().executeQuery(sql);
                    while (re.next()) {
                        Date date = re.getDate(COL_THOI_GIAN);
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(date);
                        TK tk = new TK(new SimpleDateFormat("dd-MM-yyyy").
                                format(date), re.getInt("count(*)"));
                        long tongTien = re.getLong("sum(" + COL_TONG_TIEN + ")");
                        list.add(new TKR(tk, tongTien));
                    }
                    connectDatabase.getConnection().close();
                    break;
                case "Tháng":
                    // ph??ng án là : l?y ra các tháng(c? n?m) có trong csdl,
                    //sau ?ó tr? v? các ngày trong m?i tháng cùng v?i th?ng kê c?a nó
                    ArrayList<ThangNam> thangNams = new ArrayList<>();
                    sql = "select distinct month(" + COL_THOI_GIAN
                            + "),year(" + COL_THOI_GIAN + ") from qlbh." + HOA_DON_NHAP;
                    re = connectDatabase.getConnection().
                            createStatement().executeQuery(sql);
                    while (re.next()) {
                        thangNams.add(new ThangNam(re.getInt("month(" + COL_THOI_GIAN + ")"),
                                re.getInt("year(" + COL_THOI_GIAN + ")")));
                    }
                    for (ThangNam thangNam : thangNams) {
                        //li?t kê t?t c? thu?c tính c?n thi?t tháng xx, n?m xxxx
                        sql = "select count(*), sum(" + COL_TONG_TIEN + ") from qlbh." + HOA_DON_NHAP + " \n"
                                + "where month(" + COL_THOI_GIAN + ") = '" + thangNam.getThang() + "' \n"
                                + "and year(" + COL_THOI_GIAN + ") = '" + thangNam.getNam() + "'";
                        re = connectDatabase.getConnection().
                                createStatement().executeQuery(sql);
                        while (re.next()) {
                            TK tk = new TK(thangNam.getThang() + "-"
                                    + thangNam.getNam(), re.getInt("count(*)"));
                            long tongTien = re.getLong("sum(" + COL_TONG_TIEN + ")");
                            list.add(new TKR(tk, tongTien));
                        }
                    }

                    connectDatabase.getConnection().close();
                    break;
                case "N?m":

                    ArrayList<Integer> nams = new ArrayList<>();
                    // ph??ng án là : l?y ra các n?m có trong csdl,
                    //sau ?ó tr? v? các ngày trong m?i n?m cùng v?i th?ng kê c?a nó
                    sql = "select distinct year(" + COL_THOI_GIAN + ") from qlbh." + HOA_DON_NHAP;
                    re = connectDatabase.getConnection().
                            createStatement().executeQuery(sql);
                    while (re.next()) {
                        nams.add(re.getInt("year(" + COL_THOI_GIAN + ")"));
                    }
                    for (Integer nam : nams) {
                        //li?t kê t?t c? thu?c tính c?n thi?t tháng xx, n?m xxxx
                        sql = "select count(*), sum(" + COL_TONG_TIEN + ") from qlbh." + HOA_DON_NHAP
                                + " where year(" + COL_THOI_GIAN + ") = '" + nam + "'";
                        re = connectDatabase.getConnection().
                                createStatement().executeQuery(sql);
                        while (re.next()) {
                            TK tk = new TK(nam + "", re.getInt("count(*)"));
                            long tongTien = re.getLong("sum(" + COL_TONG_TIEN + ")");
                            list.add(new TKR(tk, tongTien));
                        }
                    }
                    connectDatabase.getConnection().close();
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

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
            ArrayList<TKR> tkrs, String thuocTinh) {
        try {
            switch (export) {
                // @export :
                //      1 : t?t c?
                //      2 : th?ng kê
                //      3 : tìm ki?m
                case 1:
                    WordHelper.exportHoaDonNhap(file, hoaDonNhaps, "THÔNG TIN HÓA ?ON NH?P");
                    break;
                case 2:
                    WordHelper.writeTKR(file, tkrs, "TH?NG KÊ HÓA ??N NH?P", thuocTinh);
                    break;
                case 3:
                    WordHelper.exportHoaDonNhap(file, hoaDonNhaps, "TÌM KI?M HÓA ??N NH?P");
                    break;
                case 0:
            }
            return 1;
        } catch (IOException ex) {
            Logger.getLogger(HoaDonNhapUI.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public void getListHoaDonNhapChiTiet(int maHoaDonNhap) {
        setHoaDonNhapChiTiets(HoaDonNhapChiTiet.getAll(maHoaDonNhap));
    }

    public void getInfoFromDatabase(int maHoaDonNhap) {
        HoaDonNhap hoaDonNhap = get(maHoaDonNhap);
        setMaNhap(hoaDonNhap.getMaNhap());
        setMaNhanVien(hoaDonNhap.getMaNhanVien());
        setMaNhaCungCap(hoaDonNhap.getMaNhaCungCap());
        setThoiGian(hoaDonNhap.getThoiGian());
        setTongTien(hoaDonNhap.getTongTien());
    }
}
