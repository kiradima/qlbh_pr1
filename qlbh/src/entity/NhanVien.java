/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import helper.ConnectDatabase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Kira
 */
public class NhanVien {

    private int maNhanVien;
    private String tenNhanVien;
    private String sdtNhanVien;
    private String diaChiNhanVien;
    private String soCMT;
    private Date ngaySinh;
    private String gioiTinh;
    private String emailNhanVien;
    private String chucVu;

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getSdtNhanVien() {
        return sdtNhanVien;
    }

    public void setSdtNhanVien(String sdtNhanVien) {
        this.sdtNhanVien = sdtNhanVien;
    }

    public String getDiaChiNhanVien() {
        return diaChiNhanVien;
    }

    public void setDiaChiNhanVien(String diaChiNhanVien) {
        this.diaChiNhanVien = diaChiNhanVien;
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

    public String getEmailNhanVien() {
        return emailNhanVien;
    }

    public void setEmailNhanVien(String emailNhanVien) {
        this.emailNhanVien = emailNhanVien;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public NhanVien(int maNhanVien, String tenNhanVien, String sdtNhanVien, String diaChiNhanVien, String soCMT, Date ngaySinh, String gioiTinh, String emailNhanVien, String chucVu) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.sdtNhanVien = sdtNhanVien;
        this.diaChiNhanVien = diaChiNhanVien;
        this.soCMT = soCMT;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.emailNhanVien = emailNhanVien;
        this.chucVu = chucVu;
    }

    public NhanVien() {
    }

    public static ArrayList<NhanVien> getAll() {
        ArrayList<NhanVien> list = new ArrayList<>();
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            ResultSet re = connectDatabase.getConnection().
                    createStatement().executeQuery("select * from nhanvien");
            while (re.next()) {
                list.add(new NhanVien(re.getInt("maNhanVien"),
                        re.getString("tenNhanVien"),
                        re.getString("sdtNhanVien"),
                        re.getString("diaChiNhanVien"),
                        re.getString("soCMT"),
                        re.getDate("ngaySinh"),
                        re.getString("gioiTinh"),
                        re.getString("emailNhanVien"),
                        re.getString("chucVu")));
            }
            connectDatabase.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static NhanVien get(int ma) {
        NhanVien o = null;
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            ResultSet re = connectDatabase.getConnection().
                    createStatement().executeQuery("select * from nhanvien where maNhanVien = " + ma);
            while (re.next()) {
                o = new NhanVien(re.getInt("maNhanVien"),
                        re.getString("tenNhanVien"),
                        re.getString("sdtNhanVien"),
                        re.getString("diaChiNhanVien"),
                        re.getString("soCMT"),
                        re.getDate("ngaySinh"),
                        re.getString("gioiTinh"),
                        re.getString("emailNhanVien"),
                        re.getString("chucVu"));
            }
            connectDatabase.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return o;
    }

    public static long getTongTienNhap(int ma) {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            ResultSet re = connectDatabase.getConnection().
                    createStatement().executeQuery("select sum(tongTien) "
                            + "from qlbh.hoadonnhap where maNhanVien = '" + ma + "'");
            while (re.next()) {
                return re.getLong("sum(tongTien)");
            }
            connectDatabase.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static long getTongTienXuat(int ma) {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            ResultSet re = connectDatabase.getConnection().
                    createStatement().executeQuery("select sum(tongTien) "
                            + "from qlbh.hoadonxuat where maNhanVien = '" + ma + "'");
            while (re.next()) {
                return re.getLong("sum(tongTien)");
            }
            connectDatabase.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static ArrayList<TK> thongKe(String thuocTinh) {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        ArrayList<TK> list = new ArrayList<>();
        String sql;
        ResultSet re;
        try {
            switch (thuocTinh) {
                case "Mã nhân viên":
                    sql = "select maNhanVien,count(*) from qlbh.nhanvien group by maNhanVien";
                    re = connectDatabase.getConnection().
                            createStatement().executeQuery(sql);
                    while (re.next()) {
                        list.add(new TK(re.getInt("maNhanVien") + "",
                                re.getInt("count(*)")));
                    }
                    connectDatabase.close();
                    break;
                case "Tên nhân viên":
                    sql = "select tenNhanVien,count(*) from qlbh.nhanvien group by tenNhanVien";
                    re = connectDatabase.getConnection().
                            createStatement().executeQuery(sql);
                    while (re.next()) {
                        list.add(new TK(re.getString("tenNhanVien") + "",
                                re.getInt("count(*)")));
                    }
                    connectDatabase.close();
                    break;
                case "Số điện thoại":
                    sql = "select sdtNhanVien,count(*) from qlbh.nhanvien group by sdtNhanVien";
                    re = connectDatabase.getConnection().
                            createStatement().executeQuery(sql);
                    while (re.next()) {
                        list.add(new TK(re.getString("sdtNhanVien") + "",
                                re.getInt("count(*)")));
                    }
                    connectDatabase.close();
                    break;
                case "Địa chỉ":
                    sql = "select diaChiNhanVien,count(*) from qlbh.nhanvien group by diaChiNhanVien";
                    re = connectDatabase.getConnection().
                            createStatement().executeQuery(sql);
                    while (re.next()) {
                        list.add(new TK(re.getString("diaChiNhanVien") + "",
                                re.getInt("count(*)")));
                    }
                    connectDatabase.close();
                    break;
                case "Chứng minh thư":
                    sql = "select soCMT,count(*) from qlbh.nhanvien group by soCMT";
                    re = connectDatabase.getConnection().
                            createStatement().executeQuery(sql);
                    while (re.next()) {
                        list.add(new TK(re.getString("soCMT") + "",
                                re.getInt("count(*)")));
                    }
                    connectDatabase.close();
                    break;
                case "Ngày sinh":
                    sql = "select ngaySinh,count(*) from qlbh.nhanvien group by ngaySinh";
                    re = connectDatabase.getConnection().
                            createStatement().executeQuery(sql);
                    while (re.next()) {
                        list.add(new TK(new SimpleDateFormat("dd-MM-yyyy").format(re.getDate("ngaySinh")),
                                re.getInt("count(*)")));
                    }
                    connectDatabase.close();
                    break;
                case "Giới tính":
                    sql = "select gioiTinh,count(*) from qlbh.nhanvien group by gioiTinh";
                    re = connectDatabase.getConnection().
                            createStatement().executeQuery(sql);
                    while (re.next()) {
                        list.add(new TK(re.getString("gioiTinh") + "",
                                re.getInt("count(*)")));
                    }
                    connectDatabase.close();
                    break;
                case "Email":
                    sql = "select emailNhanVien,count(*) from qlbh.nhanvien group by emailNhanVien";
                    re = connectDatabase.getConnection().
                            createStatement().executeQuery(sql);
                    while (re.next()) {
                        list.add(new TK(re.getString("emailNhanVien") + "",
                                re.getInt("count(*)")));
                    }
                    connectDatabase.close();
                    break;
                case "Chức vụ":
                    sql = "select chucVu,count(*) from qlbh.nhanvien group by chucVu";
                    re = connectDatabase.getConnection().
                            createStatement().executeQuery(sql);
                    while (re.next()) {
                        list.add(new TK(re.getString("chucVu") + "",
                                re.getInt("count(*)")));
                    }
                    connectDatabase.close();
                    break;

            }
        } catch (SQLException e) {
        }
        return list;
    }

    public static int insert(NhanVien o) {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            // nếu trả về 1 là thành công
            return connectDatabase.getConnection().createStatement().executeUpdate(
                    "insert into nhanvien values('"
                    + o.getMaNhanVien() + "','"
                    + o.getTenNhanVien() + "','"
                    + o.getSdtNhanVien() + "','"
                    + o.getDiaChiNhanVien() + "','"
                    + o.getSoCMT() + "','"
                    + new SimpleDateFormat("yyyy-MM-dd").format(o.getNgaySinh()) + "','"
                    + o.getGioiTinh() + "','"
                    + o.getEmailNhanVien() + "','"
                    + o.getChucVu() + "')"
            );
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi insert CSDL");
            Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static int update(NhanVien o) {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            // nếu trả về 1 là thành công
            return connectDatabase.getConnection().createStatement().executeUpdate(
                    "update nhanvien set tenNhanVien = '"
                    + o.getTenNhanVien() + "',sdtNhanVien = '"
                    + o.getSdtNhanVien() + "',diaChiNhanVien = '"
                    + o.getDiaChiNhanVien() + "',soCMT = '"
                    + o.getSoCMT() + "',ngaySinh = '"
                    + new SimpleDateFormat("yyyy-MM-dd").format(o.getNgaySinh()) + "',gioiTinh = '"
                    + o.getGioiTinh() + "', emailNhanVien = '"
                    + o.getEmailNhanVien() + "', chucVu = '"
                    + o.getChucVu() + "'where maNhanVien = '"
                    + o.getMaNhanVien() + "'"
            );
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi update CSDL");
            Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static int delete(int ma) {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            // nếu trả về 1 là thành công
            return connectDatabase.getConnection().createStatement().executeUpdate(
                    "delete from nhanvien where maNhanVien = " + ma);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi delete CSDL");
            Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static ArrayList<NhanVien> search(String search, String type) {
        ArrayList<NhanVien> list = new ArrayList<>();
        ConnectDatabase connectDatabase = new ConnectDatabase();
        String sql = "select * from qlbh.nhanvien where ";
        switch (type) {
            case "maNhanVien":
                sql += "maNhanVien like '%" + search + "%'";
                break;
            case "tenNhanVien":
                sql += " lower(tenNhanVien) like '%" + search.toLowerCase() + "%'";
                break;
            case "sdtNhanVien":
                sql += "sdtNhanVien like '%" + search + "%'";
                break;
            case "diaChiNhanVien":
                sql += "lower(diaChiNhanVien) like '%" + search.toLowerCase() + "%'";
                break;
            case "soCMT":
                sql += "soCMT like '%" + search + "%'";
                break;
            case "ngaySinh": {
                try {
                    sql += "ngaySinh = '" + new SimpleDateFormat("yyyy-MM-dd")
                            .format(new SimpleDateFormat("dd-MM-yyyy").parse(search)) + "'";
                } catch (ParseException ex) {
                    Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case "gioiTinh":
                sql += "lower(gioiTinh) like '" + search.toLowerCase() + "'";
                break;
            case "emailNhanVien":
                sql += "lower(emailNhanVien) like '%" + search.toLowerCase() + "%'";
                break;
            case "chucVu":
                sql += "lower(chucVu) like '%" + search.toLowerCase() + "%'";
                break;
        }
        System.out.println(sql);

        try {
            ResultSet re = connectDatabase.getConnection().
                    createStatement().executeQuery(sql);
            while (re.next()) {
                list.add(new NhanVien(re.getInt("maNhanVien"),
                        re.getString("tenNhanVien"),
                        re.getString("sdtNhanVien"),
                        re.getString("diaChiNhanVien"),
                        re.getString("soCMT"),
                        re.getDate("ngaySinh"),
                        re.getString("gioiTinh"),
                        re.getString("emailNhanVien"),
                        re.getString("chucVu")));
            }
            connectDatabase.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn CSDL");
            Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
