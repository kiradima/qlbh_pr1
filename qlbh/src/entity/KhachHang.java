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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kira
 */
public class KhachHang {

    private int maKhachHang;
    private String tenKhachHang;
    private String sdtKhachHang;
    private String diaChi;
    private String soCMT;
    private Date ngaySinh;
    private String gioiTinh;
    private String emailKhachHang;

    public KhachHang() {
    }

    public KhachHang(int maKhachHang, String tenKhachHang, String sdtKhachHang, String diaChi, String soCMT, Date ngaySinh, String gioiTinh, String emailKhachHang) {
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.sdtKhachHang = sdtKhachHang;
        this.diaChi = diaChi;
        this.soCMT = soCMT;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.emailKhachHang = emailKhachHang;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getSdtKhachHang() {
        return sdtKhachHang;
    }

    public void setSdtKhachHang(String sdtKhachHang) {
        this.sdtKhachHang = sdtKhachHang;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoCMT() {
        return soCMT;
    }

    public void setSoCMT(String soCMT) {
        this.soCMT = soCMT;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getEmailKhachHang() {
        return emailKhachHang;
    }

    public void setEmailKhachHang(String emailKhachHang) {
        this.emailKhachHang = emailKhachHang;
    }

    public static ArrayList<KhachHang> getAll() {
        ArrayList<KhachHang> list = new ArrayList<>();
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            ResultSet re = connectDatabase.getConnection().
                    createStatement().executeQuery("select * from khachhang");
            while (re.next()) {
                list.add(new KhachHang(re.getInt("maKhachHang"),
                        re.getString("tenKhachHang"),
                        re.getString("sdtKhachHang"),
                        re.getString("diaChi"),
                        re.getString("soCMT"),
                        re.getDate("ngaySinh"),
                        re.getString("gioiTinh"),
                        re.getString("emailKhachHang")));
            }
            connectDatabase.close();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static KhachHang get(int ma) {
        KhachHang o = null;
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            ResultSet re = connectDatabase.getConnection().
                    createStatement().executeQuery("select * from khachhang where maKhachHang = " + ma);
            while (re.next()) {
                o = new KhachHang(re.getInt("maKhachHang"),
                        re.getString("tenKhachHang"),
                        re.getString("sdtKhachHang"),
                        re.getString("diaChi"),
                        re.getString("soCMT"),
                        re.getDate("ngaySinh"),
                        re.getString("gioiTinh"),
                        re.getString("emailKhachHang"));
            }
            connectDatabase.close();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return o;
    }

    public static long getTongTienXuat(int maKH) {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            ResultSet re = connectDatabase.getConnection().
                    createStatement().executeQuery("select sum(tongTien) from qlbh.hoadonxuat where maKhachHang = " + maKH);
            while (re.next()) {
                return re.getLong("sum(tongTien)");
            }
            connectDatabase.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static int add(KhachHang o) throws ClassNotFoundException {
        String sql = "insert into  khachhang values("
                + o.getMaKhachHang() + ", '"
                + o.getTenKhachHang() + "','"
                + o.getSdtKhachHang() + "', '"
                + o.getDiaChi() + "', '"
                + o.getSoCMT() + "', '"
                + new SimpleDateFormat("yyyy-MM-dd").format(o.getNgaySinh()) + "', '"
                + o.getGioiTinh() + "', '"
                + o.getEmailKhachHang() + "'"
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

}
