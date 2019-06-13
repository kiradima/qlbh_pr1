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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ui.NhanVienUI;

/**
 *
 * @author Kira
 */
public class NhanVien {

    public final static String NHAN_VIEN = "nhanvien";
    public final static String HOA_DON_XUAT = "hoadonxuat";
    public final static String HOA_DON_NHAP = "hoadonnhap";

    public final static String COL_MA_NHAN_VIEN = "maNhanVien";
    public final static String COL_TEN_NHAN_VIEN = "tenNhanVien";
    public final static String COL_DIEN_THOAI_NHAN_VIEN = "sdtNhanVien";
    public final static String COL_DIA_CHI_NHAN_VIEN = "diaChiNhanVien";
    public final static String COL_CMT_NHAN_VIEN = "soCMT";
    public final static String COL_NGAY_SINH_NHAN_VIEN = "ngaySinh";
    public final static String COL_GIOI_TINH_NHAN_VIEN = "gioiTinh";
    public final static String COL_EMAIL_NHAN_VIEN = "emailNhanVien";
    public final static String COL_CHUC_VU_NHAN_VIEN = "chucVu";

    public final static String TT_MA = "Mã";
    public final static String TT_TEN = "Tên";
    public final static String TT_SDT = "Số điện thoại";
    public final static String TT_DIA_CHI = "Địa chỉ";
    public final static String TT_CMT = "Chứng minh thư";
    public final static String TT_NGAY_SINH = "Ngày sinh";
    public final static String TT_GIOI_TINH = "Giới tính";
    public final static String TT_EMAIL = "Email";
    public final static String TT_CHUC_VU = "Chức vụ";

    public final static String TT_THANH_PHO = "Thành phố";

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

    public NhanVien(int maNhanVien, String tenNhanVien, String sdtNhanVien,
            String diaChiNhanVien, String soCMT, Date ngaySinh,
            String gioiTinh, String emailNhanVien, String chucVu) {
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
        try {

            String sql = "select * from " + NHAN_VIEN;
            ConnectDatabase connectDatabase = new ConnectDatabase();
            Connection connection = connectDatabase.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                list.add(new NhanVien(
                        resultSet.getInt(COL_MA_NHAN_VIEN),
                        resultSet.getString(COL_TEN_NHAN_VIEN),
                        resultSet.getString(COL_DIEN_THOAI_NHAN_VIEN),
                        resultSet.getString(COL_DIA_CHI_NHAN_VIEN),
                        resultSet.getString(COL_CMT_NHAN_VIEN),
                        new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString(COL_NGAY_SINH_NHAN_VIEN)),
                        resultSet.getString(COL_GIOI_TINH_NHAN_VIEN),
                        resultSet.getString(COL_EMAIL_NHAN_VIEN),
                        resultSet.getString(COL_CHUC_VU_NHAN_VIEN)
                ));
            }
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    /**
     *
     * @param ma
     * @return
     */
    public static NhanVien get(int ma) {
        NhanVien o = null;
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            ResultSet resultSet = connectDatabase.getConnection().
                    createStatement().executeQuery("select * from " + NHAN_VIEN + " where "
                            + COL_MA_NHAN_VIEN + " = " + ma);
            while (resultSet.next()) {
                o = new NhanVien(
                        resultSet.getInt(COL_MA_NHAN_VIEN),
                        resultSet.getString(COL_TEN_NHAN_VIEN),
                        resultSet.getString(COL_DIEN_THOAI_NHAN_VIEN),
                        resultSet.getString(COL_DIA_CHI_NHAN_VIEN),
                        resultSet.getString(COL_CMT_NHAN_VIEN),
                        new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString(COL_NGAY_SINH_NHAN_VIEN)),
                        resultSet.getString(COL_GIOI_TINH_NHAN_VIEN),
                        resultSet.getString(COL_EMAIL_NHAN_VIEN),
                        resultSet.getString(COL_CHUC_VU_NHAN_VIEN)
                );
            }
            connectDatabase.close();
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return o;
    }

    public static int insert(NhanVien o) {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            // nếu trả về 1 là thành công
            return connectDatabase.getConnection().createStatement()
                    .executeUpdate("insert into " + NHAN_VIEN + " values('"
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
            return connectDatabase.getConnection().createStatement().executeUpdate("update " + NHAN_VIEN
                    + " set " + COL_TEN_NHAN_VIEN + " = '"
                    + o.getTenNhanVien() + "'," + COL_DIEN_THOAI_NHAN_VIEN + " = '"
                    + o.getSdtNhanVien() + "'," + COL_DIA_CHI_NHAN_VIEN + " = '"
                    + o.getDiaChiNhanVien() + "'," + COL_CMT_NHAN_VIEN + " = '"
                    + o.getSoCMT() + "'," + COL_NGAY_SINH_NHAN_VIEN + " = '"
                    + new SimpleDateFormat("yyyy-MM-dd").format(o.getNgaySinh()) + "'," + COL_GIOI_TINH_NHAN_VIEN + " = '"
                    + o.getGioiTinh() + "'," + COL_EMAIL_NHAN_VIEN + " = '"
                    + o.getEmailNhanVien() + "'," + COL_CHUC_VU_NHAN_VIEN + " = '"
                    + o.getChucVu() + "' where " + COL_MA_NHAN_VIEN + " = '"
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
            return connectDatabase.getConnection().createStatement().executeUpdate("delete from "
                    + NHAN_VIEN + " where "
                    + COL_MA_NHAN_VIEN + " = " + ma);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi delete CSDL");
            Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static ArrayList<NhanVien> search(String search, String type) {
        ArrayList<NhanVien> list = new ArrayList<>();
        ConnectDatabase connectDatabase = new ConnectDatabase();
        String sql = "select * from qlbh." + NHAN_VIEN + " where ";
        switch (type) {
            case TT_MA:
                sql += COL_MA_NHAN_VIEN + " like '%" + search + "%'";
                break;
            case TT_TEN:
                sql += " lower(" + COL_TEN_NHAN_VIEN + ") like '%" + search.toLowerCase() + "%'";
                break;
            case TT_SDT:
                sql += COL_DIEN_THOAI_NHAN_VIEN + " like '%" + search + "%'";
                break;
            case TT_DIA_CHI:
                sql += "lower(" + COL_DIA_CHI_NHAN_VIEN + ") like '%" + search.toLowerCase() + "%'";
                break;
            case TT_CMT:
                sql += COL_CMT_NHAN_VIEN + " like '%" + search + "%'";
                break;
            case TT_NGAY_SINH:
                sql += COL_NGAY_SINH_NHAN_VIEN + " like '%" + search + "%'";
                break;
            case TT_GIOI_TINH:
                sql += "lower(" + COL_GIOI_TINH_NHAN_VIEN + ") like '%" + search.toLowerCase() + "%'";
                break;
            case TT_EMAIL:
                sql += "lower(" + COL_EMAIL_NHAN_VIEN + ") like '%" + search.toLowerCase() + "%'";
                break;
            case TT_CHUC_VU:
                sql += "lower(" + COL_CHUC_VU_NHAN_VIEN + ") like '%" + search.toLowerCase() + "%'";
                break;
        }
        System.out.println(sql);

        try {
            ResultSet resultSet = connectDatabase.getConnection().
                    createStatement().executeQuery(sql);
            while (resultSet.next()) {
                list.add(new NhanVien(
                        resultSet.getInt(COL_MA_NHAN_VIEN),
                        resultSet.getString(COL_TEN_NHAN_VIEN),
                        resultSet.getString(COL_DIEN_THOAI_NHAN_VIEN),
                        resultSet.getString(COL_DIA_CHI_NHAN_VIEN),
                        resultSet.getString(COL_CMT_NHAN_VIEN),
                        new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString(COL_NGAY_SINH_NHAN_VIEN)),
                        resultSet.getString(COL_GIOI_TINH_NHAN_VIEN),
                        resultSet.getString(COL_EMAIL_NHAN_VIEN),
                        resultSet.getString(COL_CHUC_VU_NHAN_VIEN)
                ));
            }
            connectDatabase.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn CSDL");
            Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static ArrayList<TK> thongKe(String thuocTinh) {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        ArrayList<TK> list = new ArrayList<>();
        switch (thuocTinh) {
            case TT_MA:
                list = supportThongKe(COL_MA_NHAN_VIEN);
                break;
            case TT_TEN:
                list = supportThongKe(COL_TEN_NHAN_VIEN);
                break;
            case TT_SDT:
                list = supportThongKe(COL_DIEN_THOAI_NHAN_VIEN);
                break;
            case TT_THANH_PHO:
                String sql1 = "SELECT " + COL_DIA_CHI_NHAN_VIEN + " FROM qlbh." + NHAN_VIEN;
                ArrayList<String> diaChis = new ArrayList();
                ResultSet resultSet;
                try {
                    resultSet = connectDatabase.getConnection().createStatement().executeQuery(sql1);
                    while (resultSet.next()) {
                        diaChis.add(resultSet.getString(COL_DIA_CHI_NHAN_VIEN));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
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
                list = supportThongKe(COL_CMT_NHAN_VIEN);
                break;
            case TT_NGAY_SINH:
                list = supportThongKe(COL_NGAY_SINH_NHAN_VIEN);
                break;
            case TT_GIOI_TINH:
                list = supportThongKe(COL_GIOI_TINH_NHAN_VIEN);
                break;
            case TT_EMAIL:
                list = supportThongKe(COL_EMAIL_NHAN_VIEN);
                break;
            case TT_CHUC_VU:
                list = supportThongKe(COL_CHUC_VU_NHAN_VIEN);
                break;

        }
        return list;

    }

    private static ArrayList<TK> supportThongKe(String column) {
        ArrayList<TK> list = new ArrayList<>();
        try {
            String sql = "select " + column + ",count(*) from qlbh."
                    + NHAN_VIEN + " group by " + column;
            ConnectDatabase connectDatabase = new ConnectDatabase();
            ResultSet re = connectDatabase.getConnection().
                    createStatement().executeQuery(sql);
            while (re.next()) {
                list.add(new TK(re.getString(column) + "",
                        re.getInt("count(*)")));
            }
            connectDatabase.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static long getTongTienXuat(int ma) {
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
            Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static long getTongTienNhap(int ma) {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            ResultSet re = connectDatabase.getConnection().
                    createStatement().executeQuery("select sum(tongTien) "
                            + "from qlbh." + HOA_DON_NHAP
                            + " where " + HoaDonNhap.COL_MA_NHAN_VIEN + " = '" + ma + "'");
            while (re.next()) {
                return re.getLong("sum(tongTien)");
            }
            connectDatabase.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static int importExcel(File file) {
        int re = -1;
        String type = file.getName().substring(file.getName().lastIndexOf(".") + 1);
        if (type.equals("xls") || type.equals("xlsx")) {
            ArrayList<NhanVien> list = new ArrayList<>();
            try {
                list = ExcelHelper.importNhanVien(file);
            } catch (Exception ex) {
                Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (NhanVien o : list) {
                re = NhanVien.insert(o);
                if (re != 1) {
                    break;
                }
            }
        }
        return re;
    }

    public static int exportDoc(File file, ArrayList<NhanVien> khachHangs, int export,
            ArrayList<TK> tks, String thuocTinh) {
        try {
            switch (export) {
                // @export :
                //      1 : tất cả
                //      2 : thống kê
                //      3 : tìm kiếm
                case 1:
                    WordHelper.exportNhanVien(file, khachHangs, "THÔNG TIN NHÂN VIÊN");
                    break;
                case 2:
                    WordHelper.writeTK(file, tks, "THỐNG KÊ NHÂN VIÊN", thuocTinh);
                    break;
                case 3:
                    WordHelper.exportNhanVien(file, khachHangs, "TÌM KIẾM NHÂN VIÊN");
                    break;
                case 0:
            }
            return 1;
        } catch (IOException ex) {
            Logger.getLogger(NhanVienUI.class.getName()).log(Level.SEVERE, null, ex);
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
//        @test getTongTienXuat
//        System.out.println(getTongTienXuat(4001));
//    }
}
