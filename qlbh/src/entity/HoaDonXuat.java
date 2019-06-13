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
public class HoaDonXuat {

    final static String HOA_DON_XUAT = "hoadonxuat";

    public final static String COL_MA_XUAT = "maXuat";
    public final static String COL_MA_KHACH_HANG = "maKhachHang";
    public final static String COL_MA_NHAN_VIEN = "maNhanVien";
    public final static String COL_THOI_GIAN = "thoiGian";
    public final static String COL_TONG_TIEN = "tongTien";

    public final static String TT_MA_XUAT = "Mã xuất";
    public final static String TT_MA_KHACH_HANG = "Mã nhân viên";
    public final static String TT_MA_NHAN_VIEN = "Mã nhà cung cấp";
    public final static String TT_THOI_GIAN = "Thời gian";
    public final static String TT_TONG_TIEN = "Tổng tiền";

    public final static String TT_TEN_NHAN_VIEN = "Tên nhân viên";
    public final static String TT_TEN_KHACH_HANG = "Tên khách hàng";

    private int maXuat;
    private int maKhachHang;
    private int maNhanVien;
    private Date thoiGian;
    private double tongTien;

    public HoaDonXuat() {
    }

    public HoaDonXuat(int maXuat, int maKhachHang, int maNhanVien, Date thoiGian, double tongTien) {
        this.maXuat = maXuat;
        this.maKhachHang = maKhachHang;
        this.maNhanVien = maNhanVien;
        this.thoiGian = thoiGian;
        this.tongTien = tongTien;
    }

    public int getMaXuat() {
        return maXuat;
    }

    public void setMaXuat(int maXuat) {
        this.maXuat = maXuat;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
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

    public static ArrayList<HoaDonXuat> getAll() {
        ArrayList<HoaDonXuat> list = new ArrayList<>();
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            ResultSet re = connectDatabase.getConnection().
                    createStatement().executeQuery("select * from hoadonxuat");
            while (re.next()) {
                list.add(new HoaDonXuat(re.getInt("maXuat"),
                        re.getInt("maKhachHang"),
                        re.getInt("maNhanVien"),
                        re.getDate("thoiGian"),
                        re.getDouble("tongTien")));
            }
            connectDatabase.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn CSDL");
            Logger.getLogger(HoaDonXuat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static int insert(HoaDonXuat o) {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            // nếu trả về 1 là thành công
            return connectDatabase.getConnection().createStatement().executeUpdate(
                    "insert into hoadonxuat values("
                    + o.getMaXuat() + ", "
                    + o.getMaKhachHang() + ", "
                    + o.getMaNhanVien() + ", '"
                    + new SimpleDateFormat("yyyy-MM-dd").format(o.getThoiGian()) + "', NULL"
                    + ")");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi insert CSDL");
            Logger.getLogger(HoaDonXuat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static int update(HoaDonXuat o) {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            // nếu trả về 1 là thành công
            return connectDatabase.getConnection().createStatement().executeUpdate(
                    "update hoadonxuat set maKhachHang = " + o.getMaKhachHang()
                    + ", maNhanVien = '" + o.getMaNhanVien()
                    + "', thoiGian = '" + new SimpleDateFormat("yyyy-MM-dd").format(o.getThoiGian())
                    + "', tongTien = " + o.getTongTien()
                    + "where maXuat = " + o.getMaXuat());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi update CSDL");
            Logger.getLogger(HoaDonXuat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static int delete(int ma) {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            // nếu trả về 1 là thành công
            return connectDatabase.getConnection().createStatement().executeUpdate(
                    "delete from hoadonxuat where maXuat = " + ma);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi delete CSDL");
            Logger.getLogger(HoaDonXuat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static ArrayList<HoaDonXuat> search(String search, String type) {
        ArrayList<HoaDonXuat> list = new ArrayList<>();
        ConnectDatabase connectDatabase = new ConnectDatabase();
        String sql = "select * from qlbh." + HOA_DON_XUAT + " where ";
        switch (type) {
            case TT_MA_XUAT:
                sql += COL_MA_XUAT + " like '%" + search + "%'";
                break;
            case TT_MA_KHACH_HANG:
                sql += COL_MA_KHACH_HANG + " like '%" + search + "%'";
                break;
            case TT_MA_NHAN_VIEN:
                sql += COL_MA_NHAN_VIEN + " like '%" + search + "%'";
                System.out.println(sql);
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
            case TT_TEN_KHACH_HANG:
                sql1 = "select * from qlbh." + KhachHang.KHACH_HANG
                        + " where lower(" + KhachHang.COL_TEN_KHACH_HANG
                        + ") like '%" + search.toLowerCase() + "%'";
                try {
                    ResultSet resultSet1 = connectDatabase.getConnection().
                            createStatement().executeQuery(sql1);
                    while (resultSet1.next()) {
                        list.addAll(search(resultSet1
                                .getInt(KhachHang.COL_MA_KHACH_HANG) + "", TT_MA_KHACH_HANG));
                    }
                } catch (SQLException e) {
                }
                break;

        }

        if (!type.equals(TT_TEN_NHAN_VIEN) && !type.equals(TT_TEN_KHACH_HANG)) {
            System.out.println("vào");
            try {
                ResultSet resultSet = connectDatabase.getConnection().
                        createStatement().executeQuery(sql);
                while (resultSet.next()) {
                    list.add(new HoaDonXuat(
                            resultSet.getInt(COL_MA_XUAT),
                            resultSet.getInt(COL_MA_KHACH_HANG),
                            resultSet.getInt(COL_MA_NHAN_VIEN),
                            new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString(COL_THOI_GIAN)),
                            resultSet.getDouble(COL_TONG_TIEN)
                    ));
                }
                connectDatabase.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Lỗi truy vấn CSDL");
                Logger.getLogger(HoaDonXuat.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(HoaDonXuat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    public static ArrayList<TK> thongKe(String thuocTinh) {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        ArrayList<TK> list = new ArrayList<>();
        String sql;
        ResultSet re;
        try {
            switch (thuocTinh) {
                case "Mã khách hàng":
                    sql = "select maKhachHang,count(*) from hoadonxuat group by maKhachHang";
                    re = connectDatabase.getConnection().
                            createStatement().executeQuery(sql);
                    while (re.next()) {
                        list.add(new TK(re.getInt("maKhachHang") + "",
                                re.getInt("count(*)")));
                    }
                    connectDatabase.close();
                    break;
                case "Mã nhân viên":
                    sql = "select maNhanVien,count(*) from hoadonxuat group by maNhanVien";
                    re = connectDatabase.getConnection().
                            createStatement().executeQuery(sql);
                    while (re.next()) {
                        list.add(new TK(re.getInt("maNhanVien") + "",
                                re.getInt("count(*)")));
                    }
                    connectDatabase.close();
                    break;
                case "Thời gian":
                    sql = "select thoiGian,count(*) from hoadonxuat group by thoiGian";
                    re = connectDatabase.getConnection().
                            createStatement().executeQuery(sql);
                    while (re.next()) {
                        list.add(new TK(re.getDate("thoiGian") + "",
                                re.getInt("count(*)")));
                    }
                    connectDatabase.close();
                    break;
                case "Tổng tiền":
                    sql = "select tongTien,count(*) from hoadonxuat group by tongTien";
                    re = connectDatabase.getConnection().
                            createStatement().executeQuery(sql);
                    while (re.next()) {
                        list.add(new TK(new DecimalFormat("###.#").format(re.getDouble("tongTien")) + "",
                                re.getInt("count(*)")));
                    }
                    connectDatabase.close();
                    break;
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public static ArrayList<TKR> thongKeRieng(String thuocTinh) throws SQLException {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        ArrayList<TKR> list = new ArrayList<>();

        String sql;
        ResultSet re;
        switch (thuocTinh) {
            case "Mã khách hàng":
                sql = "select maKhachHang,count(*) from qlbh.hoadonxuat group by maKhachHang";
                re = connectDatabase.getConnection().
                        createStatement().executeQuery(sql);
                while (re.next()) {
                    TK tk = new TK(re.getInt("maKhachHang") + "", re.getInt("count(*)"));
                    long tongTien = KhachHang.getTongTienGiaoDich(re.getInt("maKhachHang"));
                    list.add(new TKR(tk, tongTien));
                }
                connectDatabase.getConnection().close();
                break;
            case "Mã nhân viên":
                sql = "select maNhanVien,count(*) from qlbh.hoadonxuat group by maNhanVien";
                re = connectDatabase.getConnection().
                        createStatement().executeQuery(sql);
                while (re.next()) {
                    TK tk = new TK(re.getInt("maNhanVien") + "", re.getInt("count(*)"));
                    long tongTien = NhanVien.getTongTienXuat(re.getInt("maNhanVien"));
                    list.add(new TKR(tk, tongTien));
                }
                connectDatabase.getConnection().close();
                break;

            case "Ngày":
                sql = "select thoiGian, count(*), sum(tongTien) from qlbh.hoadonxuat group by thoiGian";
                re = connectDatabase.getConnection().
                        createStatement().executeQuery(sql);
                while (re.next()) {
                    Date date = re.getDate("thoiGian");
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(date);
                    TK tk = new TK(new SimpleDateFormat("dd-MM-yyyy").
                            format(date), re.getInt("count(*)"));
                    long tongTien = re.getLong("sum(tongTien)");
                    list.add(new TKR(tk, tongTien));
                }
                connectDatabase.getConnection().close();
                break;
            case "Tháng":
                // phương án là : lấy ra các tháng(cả năm) có trong csdl, 
                //sau đó trả về các ngày trong mỗi tháng cùng với thống kê của nó
                ArrayList<ThangNam> thangNams = new ArrayList<>();
                sql = "select distinct month(thoiGian),year(thoiGian) from qlbh.hoadonxuat;";
                re = connectDatabase.getConnection().
                        createStatement().executeQuery(sql);
                while (re.next()) {
                    thangNams.add(new ThangNam(re.getInt("month(thoiGian)"),
                            re.getInt("year(thoiGian)")));
                }
                for (ThangNam thangNam : thangNams) {
                    //liệt kê tất cả thuộc tính cần thiết tháng xx, năm xxxx
                    sql = "select count(*), sum(tongTien) from qlbh.hoadonxuat \n"
                            + "where month(thoiGian) = '" + thangNam.getThang() + "' \n"
                            + "and year(thoiGian) = '" + thangNam.getNam() + "'";
                    re = connectDatabase.getConnection().
                            createStatement().executeQuery(sql);
                    while (re.next()) {
                        TK tk = new TK(thangNam.getThang() + "-"
                                + thangNam.getNam(), re.getInt("count(*)"));
                        long tongTien = re.getLong("sum(tongTien)");
                        list.add(new TKR(tk, tongTien));
                    }
                }

                connectDatabase.getConnection().close();
                break;
            case "Năm":

                ArrayList<Integer> nams = new ArrayList<>();
                // phương án là : lấy ra các năm có trong csdl, 
                //sau đó trả về các ngày trong mỗi năm cùng với thống kê của nó
                sql = "select distinct year(thoiGian) from qlbh.hoadonxuat";
                re = connectDatabase.getConnection().
                        createStatement().executeQuery(sql);
                while (re.next()) {
                    nams.add(re.getInt("year(thoiGian)"));
                }
                for (Integer nam : nams) {
                    //liệt kê tất cả thuộc tính cần thiết tháng xx, năm xxxx
                    sql = "select count(*), sum(tongTien) from qlbh.hoadonxuat"
                            + " where year(thoiGian) = '" + nam + "'";
                    re = connectDatabase.getConnection().
                            createStatement().executeQuery(sql);
                    while (re.next()) {
                        TK tk = new TK(nam + "", re.getInt("count(*)"));
                        long tongTien = re.getLong("sum(tongTien)");
                        list.add(new TKR(tk, tongTien));
                    }
                }
                connectDatabase.getConnection().close();
                break;
        }
        return list;
    }

    public static HoaDonXuat get(int ma) {
        HoaDonXuat o = null;
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            ResultSet re = connectDatabase.getConnection().
                    createStatement().executeQuery("select * from qlbh.hoadonxuat where maXuat = " + ma);
            while (re.next()) {
                o = new HoaDonXuat(re.getInt("maXuat"),
                        re.getInt("maKhachHang"),
                        re.getInt("maNhanVien"),
                        re.getDate("thoiGian"),
                        re.getDouble("tongTien"));
            }
            connectDatabase.close();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonXuat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return o;
    }
}
