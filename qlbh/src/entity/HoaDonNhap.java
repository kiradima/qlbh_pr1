/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.ResultSet;
import helper.ConnectDatabase;
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
public class HoaDonNhap {

    final static String COL_MA_NHA_CUNG_CAP = "maNhaCungCap";
    final static String COL_MA_NHAN_VIEN = "maNhanVien";
    
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
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            ResultSet re = connectDatabase.getConnection().
                    createStatement().executeQuery("select * from hoadonnhap");
            while (re.next()) {
                list.add(new HoaDonNhap(re.getInt("maNhap"),
                        re.getInt("maNhanVien"),
                        re.getInt("maNhaCungCap"),
                        re.getDate("thoiGian"),
                        re.getDouble("tongTien")));
            }
            connectDatabase.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn CSDL");
            Logger.getLogger(HoaDonNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static int insert(HoaDonNhap o) {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            // nếu trả về 1 là thành công
            return connectDatabase.getConnection().createStatement().executeUpdate(
                    "insert into hoadonnhap values("
                    + o.getMaNhap() + ", "
                    + o.getMaNhanVien() + ", '"
                    + o.getMaNhaCungCap()+ "', '"
                    + new SimpleDateFormat("yyyy-MM-dd").format(o.getThoiGian()) + "', NULL"
                    + ")");
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
            return connectDatabase.getConnection().createStatement().executeUpdate(
                    "update hoadonnhap set maNhanVien = " + o.getMaNhanVien()
                    + ", maNhaCungCap = '" + o.getMaNhaCungCap()
                    + "', thoiGian = '" + new SimpleDateFormat("yyyy-MM-dd").format(o.getThoiGian())
                    + "', tongTien = " + o.getTongTien()
                    + "where maNhap = " + o.getMaNhap());
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
            return connectDatabase.getConnection().createStatement().executeUpdate(
                    "delete from hoadonnhap where maNhap = " + ma);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi delete CSDL");
            Logger.getLogger(HoaDonNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static ArrayList<HoaDonNhap> search(String search, String type) throws ParseException {
        ArrayList<HoaDonNhap> list = new ArrayList<>();
        ConnectDatabase connectDatabase = new ConnectDatabase();
        String sql = "select * from hoadonnhap where ";
        switch (type) {
            case "maNhanVien":
                sql += "maNhanVien = " + Integer.parseInt(search);
                break;
            case "maNhaCungCap":
                sql += "maNhaCungCap = '" + search + "'";
                break;
            case "thoiGian":
                sql += "thoiGian = '" + new SimpleDateFormat("yyyy-MM-dd")
                        .format(new SimpleDateFormat("dd-MM-yyyy").parse(search)) + "'";
                break;
            case "tongTien":
                sql += "tongTien = " + Double.parseDouble(search);
                break;
        }
        try {
            ResultSet re = connectDatabase.getConnection().
                    createStatement().executeQuery(sql);
            while (re.next()) {
                list.add(new HoaDonNhap(re.getInt("maNhap"),
                        re.getInt("maNhanVien"),
                        re.getInt("maNhaCungCap"),
                        re.getDate("thoiGian"),
                        re.getDouble("tongTien")));
            }
            connectDatabase.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn CSDL");
            Logger.getLogger(HoaDonNhap.class.getName()).log(Level.SEVERE, null, ex);
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
                case "Mã nhân viên":
                    sql = "select maNhanVien,count(*) from hoadonnhap group by maNhanVien";
                    re = connectDatabase.getConnection().
                            createStatement().executeQuery(sql);
                    while (re.next()) {
                        list.add(new TK(re.getInt("maNhanVien") + "",
                                re.getInt("count(*)")));
                    }
                    connectDatabase.close();
                    break;
                case "Nhà cung cấp":
                    sql = "select nhaCungCap,count(*) from hoadonnhap group by nhaCungCap";
                    re = connectDatabase.getConnection().
                            createStatement().executeQuery(sql);
                    while (re.next()) {
                        list.add(new TK(re.getString("nhaCungCap") + "",
                                re.getInt("count(*)")));
                    }
                    connectDatabase.close();
                    break;
                case "Thời gian":
                    sql = "select thoiGian,count(*) from hoadonnhap group by thoiGian";
                    re = connectDatabase.getConnection().
                            createStatement().executeQuery(sql);
                    while (re.next()) {
                        list.add(new TK(re.getDate("thoiGian") + "",
                                re.getInt("count(*)")));
                    }
                    connectDatabase.close();
                    break;
                case "Tổng tiền":
                    sql = "select tongTien,count(*) from hoadonnhap group by tongTien";
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
            case "Mã nhà cung cấp":
                sql = "select maNhaCungCap,count(*) from qlbh.hoadonnhap group by maNhaCungCap";
                re = connectDatabase.getConnection().
                        createStatement().executeQuery(sql);
                while (re.next()) {
                    TK tk = new TK(re.getInt("maNhaCungCap") + "", re.getInt("count(*)"));
                    long tongTien = HoaDonNhap.getTongNCC(re.getInt("maNhaCungCap") + "");
                    list.add(new TKR(tk, tongTien));
                }
                connectDatabase.getConnection().close();
                break;
            case "Mã nhân viên":
                sql = "select maNhanVien,count(*) from qlbh.hoadonnhap group by maNhanVien";
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
                sql = "select thoiGian, count(*), sum(tongTien) from qlbh.hoadonnhap group by thoiGian";
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
                sql = "select distinct month(thoiGian),year(thoiGian) from qlbh.hoadonnhap;";
                re = connectDatabase.getConnection().
                        createStatement().executeQuery(sql);
                while (re.next()) {
                    thangNams.add(new ThangNam(re.getInt("month(thoiGian)"),
                            re.getInt("year(thoiGian)")));
                }
                for (ThangNam thangNam : thangNams) {
                    //liệt kê tất cả thuộc tính cần thiết tháng xx, năm xxxx
                    sql = "select count(*), sum(tongTien) from qlbh.hoadonnhap \n"
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
                sql = "select distinct year(thoiGian) from qlbh.hoadonnhap";
                re = connectDatabase.getConnection().
                        createStatement().executeQuery(sql);
                while (re.next()) {
                    nams.add(re.getInt("year(thoiGian)"));
                }
                for (Integer nam : nams) {
                    //liệt kê tất cả thuộc tính cần thiết tháng xx, năm xxxx
                    sql = "select count(*), sum(tongTien) from qlbh.hoadonnhap"
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

    public static long getTongNCC(String mncc) {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            ResultSet re = connectDatabase.getConnection().
                    createStatement().executeQuery("select sum(tongTien) "
                            + "from qlbh.hoadonnhap where maNhaCungCap = '" + mncc + "'");
            while (re.next()) {
                return re.getLong("sum(tongTien)");
            }
            connectDatabase.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static HoaDonNhap get(int ma) {
        HoaDonNhap o = null;
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            ResultSet re = connectDatabase.getConnection().
                    createStatement().executeQuery("select * from qlbh.hoadonnhap where maNhap = " + ma);
            while (re.next()) {
                o = new HoaDonNhap(re.getInt("maNhap"),
                        re.getInt("maNhanVien"),
                        re.getInt("maNhaCungCap"),
                        re.getDate("thoiGian"),
                        re.getDouble("tongTien"));
            }
            connectDatabase.close();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return o;
    }
}
