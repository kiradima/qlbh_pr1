/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import command_pattern.HoaDonNhap;
import helper.ConnectDatabase;
import helper.ExcelHelper;
import helper.TinhThanhPho;
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
import ui.NhaCungCapUI;

/**
 *
 * @author hantr
 */
public class NhaCungCap {

    public final static String NHA_CUNG_CAP = "nhacungcap";
    public final static String HOA_DON_NHAP = "hoadonnhap";

    public final static String COL_MA_NHA_CUNG_CAP = "maNhaCungCap";
    public final static String COL_TEN_NHA_CUNG_CAP = "tenNhaCungCap";
    public final static String COL_DIEN_THOAI_NHA_CUNG_CAP = "dienThoai";
    public final static String COL_DIA_CHI_NHA_CUNG_CAP = "diaChi";
    public final static String COL_EMAIL_NHA_CUNG_CAP = "email";

    public final static String TT_MA = "Mã";
    public final static String TT_TEN = "Tên";
    public final static String TT_SDT = "Số điện thoại";
    public final static String TT_DIA_CHI = "Địa chỉ";
    public final static String TT_EMAIL = "Email";

    public final static String TT_THANH_PHO = "Thành phố";

    private int maNhaCungCap;
    private String tenNhaCungCap;
    private String dienThoai;
    private String diaChi;
    private String email;

    public NhaCungCap() {
    }

    public NhaCungCap(int maNhaCungCap, String tenNhaCungCap, String dienThoai, String diaChi, String email) {
        this.maNhaCungCap = maNhaCungCap;
        this.tenNhaCungCap = tenNhaCungCap;
        this.dienThoai = dienThoai;
        this.diaChi = diaChi;
        this.email = email;
    }

    public int getMaNhaCungCap() {
        return maNhaCungCap;
    }

    public void setMaNhaCungCap(int maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }

    public String getTenNhaCungCap() {
        return tenNhaCungCap;
    }

    public void setTenNhaCungCap(String tenNhaCungCap) {
        this.tenNhaCungCap = tenNhaCungCap;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static ArrayList<NhaCungCap> getAll() {
        ArrayList<NhaCungCap> list = new ArrayList<>();
        try {

            String sql = "select * from " + NHA_CUNG_CAP;
            ConnectDatabase connectDatabase = new ConnectDatabase();
            Connection connection = connectDatabase.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                list.add(new NhaCungCap(
                        resultSet.getInt(COL_MA_NHA_CUNG_CAP),
                        resultSet.getString(COL_TEN_NHA_CUNG_CAP),
                        resultSet.getString(COL_DIEN_THOAI_NHA_CUNG_CAP),
                        resultSet.getString(COL_DIA_CHI_NHA_CUNG_CAP),
                        resultSet.getString(COL_EMAIL_NHA_CUNG_CAP)
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    /**
     *
     * @param ma
     * @return NhaCungCap
     */
    public static NhaCungCap get(int ma) {
        NhaCungCap o = null;
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            ResultSet resultSet = connectDatabase.getConnection().
                    createStatement().executeQuery("select * from " + NHA_CUNG_CAP + " where "
                            + COL_MA_NHA_CUNG_CAP + " = " + ma);
            while (resultSet.next()) {
                o = new NhaCungCap(
                        resultSet.getInt(COL_MA_NHA_CUNG_CAP),
                        resultSet.getString(COL_TEN_NHA_CUNG_CAP),
                        resultSet.getString(COL_DIEN_THOAI_NHA_CUNG_CAP),
                        resultSet.getString(COL_DIA_CHI_NHA_CUNG_CAP),
                        resultSet.getString(COL_EMAIL_NHA_CUNG_CAP)
                );
            }
            connectDatabase.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return o;
    }

    public static int insert(NhaCungCap o) {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            // nếu trả về 1 là thành công
            return connectDatabase.getConnection().createStatement().executeUpdate(
                    "insert into " + NHA_CUNG_CAP + " values('"
                    + o.getMaNhaCungCap() + "','"
                    + o.getTenNhaCungCap() + "','"
                    + o.getDienThoai() + "','"
                    + o.getDiaChi() + "','"
                    + o.getEmail() + "')"
            );
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi insert CSDL");
            Logger.getLogger(NhaCungCap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static int update(NhaCungCap o) {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            // nếu trả về 1 là thành công
            return connectDatabase.getConnection().createStatement().executeUpdate("update " + NHA_CUNG_CAP + " set " + COL_TEN_NHA_CUNG_CAP + " = '"
                    + o.getTenNhaCungCap() + "'," + COL_DIEN_THOAI_NHA_CUNG_CAP + " = '"
                    + o.getDienThoai() + "'," + COL_DIA_CHI_NHA_CUNG_CAP + " = '"
                    + o.getDiaChi() + "'," + COL_EMAIL_NHA_CUNG_CAP + " = '"
                    + o.getEmail() + "'where " + COL_MA_NHA_CUNG_CAP + " = '"
                    + o.getMaNhaCungCap() + "'"
            );
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi update CSDL");
            Logger.getLogger(NhaCungCap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static int delete(int ma) {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            // nếu trả về 1 là thành công
            return connectDatabase.getConnection().createStatement().executeUpdate("delete from " + NHA_CUNG_CAP + " where "
                    + COL_MA_NHA_CUNG_CAP + " = " + ma);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi delete CSDL");
            Logger.getLogger(NhaCungCap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static ArrayList<NhaCungCap> search(String search, String type) {
        ArrayList<NhaCungCap> list = new ArrayList<>();
        ConnectDatabase connectDatabase = new ConnectDatabase();
        String sql = "select * from qlbh." + NHA_CUNG_CAP + " where ";
        switch (type) {
            case TT_MA:
                sql += COL_MA_NHA_CUNG_CAP + " like '%" + search + "%'";
                break;
            case TT_TEN:
                sql += " lower(" + COL_TEN_NHA_CUNG_CAP + ") like '%" + search.toLowerCase() + "%'";
                break;
            case TT_SDT:
                sql += COL_DIEN_THOAI_NHA_CUNG_CAP + " like '%" + search + "%'";
                break;
            case TT_DIA_CHI:
                sql += "lower(" + COL_DIA_CHI_NHA_CUNG_CAP + ") like '%" + search.toLowerCase() + "%'";
                break;
            case TT_EMAIL:
                sql += "lower(" + COL_EMAIL_NHA_CUNG_CAP + ") like '%" + search.toLowerCase() + "%'";
                break;
        }
        System.out.println(sql);

        try {
            ResultSet re = connectDatabase.getConnection().
                    createStatement().executeQuery(sql);
            while (re.next()) {
                list.add(new NhaCungCap(re.getInt(COL_MA_NHA_CUNG_CAP),
                        re.getString(COL_TEN_NHA_CUNG_CAP),
                        re.getString(COL_DIEN_THOAI_NHA_CUNG_CAP),
                        re.getString(COL_DIA_CHI_NHA_CUNG_CAP),
                        re.getString(COL_EMAIL_NHA_CUNG_CAP)
                ));
            }
            connectDatabase.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn CSDL");
            Logger.getLogger(NhaCungCap.class.getName()).log(Level.SEVERE, null, ex);
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
                case TT_MA:
                    sql = "select " + COL_MA_NHA_CUNG_CAP + ",count(*) from qlbh."
                            + NHA_CUNG_CAP + " group by " + COL_MA_NHA_CUNG_CAP;
                    re = connectDatabase.getConnection().
                            createStatement().executeQuery(sql);
                    while (re.next()) {
                        list.add(new TK(re.getInt(COL_MA_NHA_CUNG_CAP) + "",
                                re.getInt("count(*)")));
                    }
                    connectDatabase.close();
                    break;
                case TT_TEN:
                    sql = "select " + COL_TEN_NHA_CUNG_CAP
                            + ",count(*) from qlbh." + NHA_CUNG_CAP + " group by " + COL_TEN_NHA_CUNG_CAP;
                    re = connectDatabase.getConnection().
                            createStatement().executeQuery(sql);
                    while (re.next()) {
                        list.add(new TK(re.getString(COL_TEN_NHA_CUNG_CAP) + "",
                                re.getInt("count(*)")));
                    }
                    connectDatabase.close();
                    break;
                case TT_SDT:
                    sql = "select " + COL_DIEN_THOAI_NHA_CUNG_CAP
                            + ",count(*) from qlbh." + NHA_CUNG_CAP + " group by " + COL_DIEN_THOAI_NHA_CUNG_CAP;
                    re = connectDatabase.getConnection().
                            createStatement().executeQuery(sql);
                    while (re.next()) {
                        list.add(new TK(re.getString(COL_DIEN_THOAI_NHA_CUNG_CAP) + "",
                                re.getInt("count(*)")));
                    }
                    connectDatabase.close();
                    break;
                case TT_THANH_PHO:
                    String sql1 = "SELECT diaChi FROM qlbh." + NHA_CUNG_CAP;
                    ArrayList<String> diaChis = new ArrayList();
                    ResultSet resultSet = connectDatabase.getConnection().createStatement().executeQuery(sql1);
                    while (resultSet.next()) {
                        diaChis.add(resultSet.getString(COL_DIA_CHI_NHA_CUNG_CAP));
                    }
                    String[][] matrixClassify = TinhThanhPho.classifyDiaChis(diaChis); // phân loại địa chỉ
                    for (int i = 0; i < matrixClassify.length; i++) {
                        boolean isNull = true;
                        int count = 0;
                        for (String string : matrixClassify[i]) {
                            if (string != null) {
                                isNull = false;
                                count++;
                            }
                        }
                        if (isNull == false) {
                            list.add(new TK(TinhThanhPho.getTenTinh(i), count));
                        }
                    }
                    break;
                case TT_EMAIL:
                    sql = "select " + COL_EMAIL_NHA_CUNG_CAP
                            + ",count(*) from qlbh." + NHA_CUNG_CAP + " group by " + COL_EMAIL_NHA_CUNG_CAP;
                    re = connectDatabase.getConnection().
                            createStatement().executeQuery(sql);
                    while (re.next()) {
                        list.add(new TK(re.getString(COL_EMAIL_NHA_CUNG_CAP) + "",
                                re.getInt("count(*)")));
                    }
                    connectDatabase.close();
                    break;

            }
        } catch (SQLException e) {
        }
        return list;
    }

    public static long getTongTienGiaoDich(int ma) {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
//            SELECT sum(tongTien) FROM qlbh.hoadonnhap where maNhaCungCap = 4001;
            ResultSet re = connectDatabase.getConnection().
                    createStatement().executeQuery("select sum(tongTien) "
                            + "from qlbh." + HOA_DON_NHAP
                            + " where " + HoaDonNhap.COL_MA_NHA_CUNG_CAP + " = '" + ma + "'");
            while (re.next()) {
                return re.getLong("sum(tongTien)");
            }
            connectDatabase.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static int importExcel(File file) {
        int re = -1;
        String type = file.getName().substring(file.getName().lastIndexOf(".") + 1);
        if (type.equals("xls") || type.equals("xlsx")) {
            ArrayList<NhaCungCap> list = new ArrayList<>();
            try {
                list = ExcelHelper.importNhaCungCap(file);
            } catch (Exception ex) {
                Logger.getLogger(NhaCungCap.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (NhaCungCap o : list) {
                re = NhaCungCap.insert(o);
                if (re != 1) {
                    break;
                }
            }
        }
        return re;
    }

    public static int exportDoc(File file, ArrayList<NhaCungCap> nhaCungCaps, int export,
            ArrayList<TK> tks, String thuocTinh) {
        try {
            switch (export) {
                // @export :
                //      1 : tất cả
                //      2 : thống kê
                //      3 : tìm kiếm
                case 1:
                    WordHelper.exportNhaCungCap(file, nhaCungCaps, "THÔNG TIN NHÀ CUNG CẤP");
                    break;
                case 2:
                    WordHelper.writeTK(file, tks, "THỐNG KÊ NHÀ CUNG CẤP", thuocTinh);
                    break;
                case 3:
                    WordHelper.exportNhaCungCap(file, nhaCungCaps, "TÌM KIẾM NHÀ CUNG CẤP");
                    break;
                case 0:
            }
            return 1;
        } catch (IOException ex) {
            Logger.getLogger(NhaCungCapUI.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

//    public static void main(String[] args) {
//
//        @test thongKe
//        ArrayList<TK> tks = thongKe(TT_TONG_TIEN);
//        for (TK tk : tks) {
//            System.out.println(tk.getThuocTinh() + " - " + tk.getSoLuong());
//        }
//        @test getTongTienGiaoDich
//        System.out.println(getTongTienGiaoDich(4001));
//    }
}
