/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ui.KhachHangUI;

/**
 *
 * @author Kira
 */
public class KhachHang {

    final static String KHACH_HANG = "khachhang";
    final static String HOA_DON_XUAT = "hoadonxuat";

    final static String COL_MA_KHACH_HANG = "maKhachHang";
    final static String COL_TEN_KHACH_HANG = "tenKhachHang";
    final static String COL_DIEN_THOAI_KHACH_HANG = "sdtKhachHang";
    final static String COL_DIA_CHI_KHACH_HANG = "diaChi";
    final static String COL_CMT_KHACH_HANG = "soCMT";
    final static String COL_NGAY_SINH_KHACH_HANG = "ngaySinh";
    final static String COL_GIOI_TINH_KHACH_HANG = "gioiTinh";
    final static String COL_EMAIL_KHACH_HANG = "emailKhachHang";

    public final static String TT_MA = "Mã";
    public final static String TT_TEN = "Tên";
    public final static String TT_SDT = "Số điện thoại";
    public final static String TT_DIA_CHI = "Địa chỉ";
    public final static String TT_CMT = "Chứng minh thư";
    public final static String TT_NGAY_SINH = "Ngày sinh";
    public final static String TT_GIOI_TINH = "Giới tính";
    public final static String TT_EMAIL = "Email";

    public final static String TT_THANH_PHO = "Thành phố";

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
        try {

            String sql = "select * from " + KHACH_HANG;
            ConnectDatabase connectDatabase = new ConnectDatabase();
            Connection connection = connectDatabase.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                list.add(new KhachHang(
                        resultSet.getInt(COL_MA_KHACH_HANG),
                        resultSet.getString(COL_TEN_KHACH_HANG),
                        resultSet.getString(COL_DIEN_THOAI_KHACH_HANG),
                        resultSet.getString(COL_DIA_CHI_KHACH_HANG),
                        resultSet.getString(COL_CMT_KHACH_HANG),
                        new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString(COL_NGAY_SINH_KHACH_HANG)),
                        resultSet.getString(COL_GIOI_TINH_KHACH_HANG),
                        resultSet.getString(COL_EMAIL_KHACH_HANG)
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    /**
     *
     * @param ma
     * @return
     */
    public static KhachHang get(int ma) {
        KhachHang o = null;
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            ResultSet resultSet = connectDatabase.getConnection().
                    createStatement().executeQuery("select * from " + KHACH_HANG + " where "
                            + COL_MA_KHACH_HANG + " = " + ma);
            while (resultSet.next()) {
                o = new KhachHang(
                        resultSet.getInt(COL_MA_KHACH_HANG),
                        resultSet.getString(COL_TEN_KHACH_HANG),
                        resultSet.getString(COL_DIEN_THOAI_KHACH_HANG),
                        resultSet.getString(COL_DIA_CHI_KHACH_HANG),
                        resultSet.getString(COL_CMT_KHACH_HANG),
                        new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString(COL_NGAY_SINH_KHACH_HANG)),
                        resultSet.getString(COL_GIOI_TINH_KHACH_HANG),
                        resultSet.getString(COL_EMAIL_KHACH_HANG)
                );
            }
            connectDatabase.close();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return o;
    }

    public static int insert(KhachHang o) {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            // nếu trả về 1 là thành công
            return connectDatabase.getConnection().createStatement().executeUpdate(
                    "insert into " + KHACH_HANG + " values('"
                    + o.getMaKhachHang() + "','"
                    + o.getTenKhachHang() + "','"
                    + o.getSdtKhachHang() + "','"
                    + o.getDiaChi() + "','"
                    + o.getSoCMT() + "','"
                    + new SimpleDateFormat("yyyy-MM-dd").format(o.getNgaySinh()) + "','"
                    + o.getGioiTinh() + "','"
                    + o.getEmailKhachHang() + "')"
            );
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi insert CSDL");
            Logger.getLogger(KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static int update(KhachHang o) {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            // nếu trả về 1 là thành công
            return connectDatabase.getConnection().createStatement().executeUpdate("update " + KHACH_HANG
                    + " set " + COL_TEN_KHACH_HANG + " = '"
                    + o.getTenKhachHang() + "'," + COL_DIEN_THOAI_KHACH_HANG + " = '"
                    + o.getSdtKhachHang() + "'," + COL_DIA_CHI_KHACH_HANG + " = '"
                    + o.getDiaChi() + "'," + COL_CMT_KHACH_HANG + " = '"
                    + o.getSoCMT() + "'," + COL_NGAY_SINH_KHACH_HANG + " = '"
                    + new SimpleDateFormat("yyyy-MM-dd").format(o.getNgaySinh()) + "'," + COL_GIOI_TINH_KHACH_HANG + " = '"
                    + o.getGioiTinh() + "'," + COL_EMAIL_KHACH_HANG + " = '"
                    + o.getEmailKhachHang() + "'where " + COL_MA_KHACH_HANG + " = '"
                    + o.getMaKhachHang() + "'"
            );
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi update CSDL");
            Logger.getLogger(KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static int delete(int ma) {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            // nếu trả về 1 là thành công
            return connectDatabase.getConnection().createStatement().executeUpdate("delete from "
                    + KHACH_HANG + " where "
                    + COL_MA_KHACH_HANG + " = " + ma);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi delete CSDL");
            Logger.getLogger(KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static ArrayList<KhachHang> search(String search, String type) {
        ArrayList<KhachHang> list = new ArrayList<>();
        ConnectDatabase connectDatabase = new ConnectDatabase();
        String sql = "select * from qlbh." + KHACH_HANG + " where ";
        switch (type) {
            case TT_MA:
                sql += COL_MA_KHACH_HANG + " like '%" + search + "%'";
                break;
            case TT_TEN:
                sql += " lower(" + COL_TEN_KHACH_HANG + ") like '%" + search.toLowerCase() + "%'";
                break;
            case TT_SDT:
                sql += COL_DIEN_THOAI_KHACH_HANG + " like '%" + search + "%'";
                break;
            case TT_DIA_CHI:
                sql += "lower(" + COL_DIA_CHI_KHACH_HANG + ") like '%" + search.toLowerCase() + "%'";
                break;
            case TT_CMT:
                sql += COL_CMT_KHACH_HANG + " like '%" + search + "%'";
                break;
            case TT_NGAY_SINH:
                sql += COL_NGAY_SINH_KHACH_HANG + " like '%" + search + "%'";
                break;
            case TT_GIOI_TINH:
                sql += "lower(" + COL_GIOI_TINH_KHACH_HANG + ") like '%" + search.toLowerCase() + "%'";
                break;
            case TT_EMAIL:
                sql += "lower(" + COL_EMAIL_KHACH_HANG + ") like '%" + search.toLowerCase() + "%'";
                break;
        }
        System.out.println(sql);

        try {
            ResultSet resultSet = connectDatabase.getConnection().
                    createStatement().executeQuery(sql);
            while (resultSet.next()) {
                list.add(new KhachHang(
                        resultSet.getInt(COL_MA_KHACH_HANG),
                        resultSet.getString(COL_TEN_KHACH_HANG),
                        resultSet.getString(COL_DIEN_THOAI_KHACH_HANG),
                        resultSet.getString(COL_DIA_CHI_KHACH_HANG),
                        resultSet.getString(COL_CMT_KHACH_HANG),
                        new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString(COL_NGAY_SINH_KHACH_HANG)),
                        resultSet.getString(COL_GIOI_TINH_KHACH_HANG),
                        resultSet.getString(COL_EMAIL_KHACH_HANG)
                ));
            }
            connectDatabase.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn CSDL");
            Logger.getLogger(KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static ArrayList<TK> thongKe(String thuocTinh) {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        ArrayList<TK> list = new ArrayList<>();
        switch (thuocTinh) {
            case TT_MA:
                list = supportThongKe(COL_MA_KHACH_HANG);
                break;
            case TT_TEN:
                list = supportThongKe(COL_TEN_KHACH_HANG);
                break;
            case TT_SDT:
                list = supportThongKe(COL_DIEN_THOAI_KHACH_HANG);
                break;
            case TT_THANH_PHO:
                String sql1 = "SELECT diaChi FROM qlbh." + KHACH_HANG;
                ArrayList<String> diaChis = new ArrayList();
                ResultSet resultSet;
                try {
                    resultSet = connectDatabase.getConnection().createStatement().executeQuery(sql1);
                    while (resultSet.next()) {
                        diaChis.add(resultSet.getString(COL_DIA_CHI_KHACH_HANG));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHang.class.getName()).log(Level.SEVERE, null, ex);
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
            case TT_CMT:
                list = supportThongKe(COL_CMT_KHACH_HANG);
                break;
            case TT_NGAY_SINH:
                list = supportThongKe(COL_NGAY_SINH_KHACH_HANG);
                break;
            case TT_GIOI_TINH:
                list = supportThongKe(COL_GIOI_TINH_KHACH_HANG);
                break;
            case TT_EMAIL:
                list = supportThongKe(COL_EMAIL_KHACH_HANG);
                break;

        }
        return list;

    }

    private static ArrayList<TK> supportThongKe(String column) {
        ArrayList<TK> list = new ArrayList<>();
        try {
            String sql = "select " + column + ",count(*) from qlbh."
                    + KHACH_HANG + " group by " + column;
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

    public static long getTongTienGiaoDich(int ma) {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            ResultSet re = connectDatabase.getConnection().
                    createStatement().executeQuery("select sum(tongTien) "
                            + "from qlbh." + HOA_DON_XUAT
                            + " where " + HoaDonXuat.COL_MA_KHACH_HANG + " = '" + ma + "'");
            while (re.next()) {
                return re.getLong("sum(tongTien)");
            }
            connectDatabase.close();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
//

    public static int importExcel(File file) {
        int re = -1;
        String type = file.getName().substring(file.getName().lastIndexOf(".") + 1);
        if (type.equals("xls") || type.equals("xlsx")) {
            ArrayList<KhachHang> list = new ArrayList<>();
            try {
                list = ExcelHelper.importKhachHang(file);
            } catch (Exception ex) {
                Logger.getLogger(KhachHang.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (KhachHang o : list) {
                re = KhachHang.insert(o);
                if (re != 1) {
                    break;
                }
            }
        }
        return re;
    }

    public static int exportDoc(File file, ArrayList<KhachHang> khachHangs, int export,
            ArrayList<TK> tks, String thuocTinh) {
        try {
            switch (export) {
                // @export :
                //      1 : tất cả
                //      2 : thống kê
                //      3 : tìm kiếm
                case 1:
                    WordHelper.exportKhachHang(file, khachHangs, "THÔNG TIN KHÁCH HÀNG");
                    break;
                case 2:
                    WordHelper.writeTK(file, tks, "THỐNG KÊ KHÁCH HÀNG", thuocTinh);
                    break;
                case 3:
                    WordHelper.exportKhachHang(file, khachHangs, "TÌM KIẾM KHÁCH HÀNG");
                    break;
                case 0:
            }
            return 1;
        } catch (IOException ex) {
            Logger.getLogger(KhachHangUI.class.getName()).log(Level.SEVERE, null, ex);
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
