/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import helper.ConnectDatabase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kira
 */
public class LoiNhuan {

    private double tienVao;
    private double tienRa;
    private double loiNhuan;
    private String thoigian;

    public LoiNhuan() {
    }

    public LoiNhuan(double tienVao, double tienRa, double loiNhuan, String thoigian) {
        this.tienVao = tienVao;
        this.tienRa = tienRa;
        this.loiNhuan = loiNhuan;
        this.thoigian = thoigian;
    }

    public double getTienVao() {
        return tienVao;
    }

    public void setTienVao(double tienVao) {
        this.tienVao = tienVao;
    }

    public double getTienRa() {
        return tienRa;
    }

    public void setTienRa(double tienRa) {
        this.tienRa = tienRa;
    }

    public double getLoiNhuan() {
        return loiNhuan;
    }

    public void setLoiNhuan(double loiNhuan) {
        this.loiNhuan = loiNhuan;
    }

    public String getThoigian() {
        return thoigian;
    }

    public void setThoigian(String thoigian) {
        this.thoigian = thoigian;
    }

    public static LoiNhuan getLoiNhuan(String ngay, String thang, String nam) {
        LoiNhuan loiNhuan = new LoiNhuan();
        try {
            String thoiGian = "";
            if (!ngay.equals("0") && !thang.equals("0") && !nam.equals("0")) { // theo ngày
                thoiGian = nam + "-" + thang + "-" + ngay;
                loiNhuan.setThoigian(ngay + "-" + thang + "-" + nam);
            } else if (ngay.equals("0") && !thang.equals("0") && !nam.equals("0")) { // theo tháng
                thoiGian = nam + "-" + thang + "-%";
                loiNhuan.setThoigian(thang + "-" + nam);
            } else if (ngay.equals("0") && thang.equals("0") && !nam.equals("0")) { // theo năm
                thoiGian = nam + "-%";
                loiNhuan.setThoigian(nam + "");
            } else {
//                JOptionPane.showMessageDialog(LoiNhuanUI.class, "Lỗi");
            }

            ConnectDatabase connectDatabase = new ConnectDatabase();
            String sql = "SELECT sum(tongTien) FROM qlbh.hoadonnhap where"
                    + " thoiGian like '" + thoiGian + "';";
            ResultSet resultSet = connectDatabase.getConnection().createStatement().executeQuery(sql);
            while (resultSet.next()) {
                loiNhuan.setTienRa(resultSet.getDouble("sum(tongTien)"));
            }
            sql = "SELECT sum(tongTien) FROM qlbh.hoadonxuat where"
                    + " thoiGian like '" + thoiGian + "';";
            resultSet = connectDatabase.getConnection().createStatement().executeQuery(sql);
            while (resultSet.next()) {
                loiNhuan.setTienVao(resultSet.getDouble("sum(tongTien)"));
            }
            loiNhuan.setLoiNhuan(loiNhuan.getTienVao() - loiNhuan.getTienRa());
            System.out.println(loiNhuan.getThoigian());
            System.out.println("Tiền vào : " + loiNhuan.getTienVao());
            System.out.println("Tiền ra : " + loiNhuan.getTienRa());
            System.out.println("Lợi nhuận : " + loiNhuan.getLoiNhuan());
        } catch (SQLException ex) {
            Logger.getLogger(LoiNhuan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return loiNhuan;
    }

    public static ArrayList<LoiNhuan> get(String type) {
        ArrayList<LoiNhuan> list = new ArrayList();
        String sql;
        ResultSet re;
        ConnectDatabase connectDatabase = new ConnectDatabase();
        if (type.equals("Ngày")) {
            try {
                sql = "select YEAR(thoiGian) as c1, MONTH(thoiGian) as c2, DAY(thoiGian) as c3 from qlbh.hoadonnhap "
                        + "UNION "
                        + "select YEAR(thoiGian) as c1, MONTH(thoiGian) as c2, DAY(thoiGian) as c3 from qlbh.hoadonxuat "
                        + "order by c1, c2, c3";
                re = connectDatabase.getConnection().
                        createStatement().executeQuery(sql);
                while (re.next()) {
                    String ngay = re.getString("c3");
                    if (ngay.length() == 1) {
                        ngay = "0" + ngay;
                    }
                    String thang = re.getString("c2");
                    if (thang.length() == 1) {
                        thang = "0" + thang;
                    }
                    list.add(getLoiNhuan(ngay, thang,
                            re.getString("c1")));
                }
                connectDatabase.getConnection().close();
            } catch (SQLException ex) {
                Logger.getLogger(LoiNhuan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (type.equals("Tháng")) {
            try {
                sql = "select YEAR(thoiGian) as c1, MONTH(thoiGian) as c2 from qlbh.hoadonnhap "
                        + "UNION "
                        + "select YEAR(thoiGian) as c1, MONTH(thoiGian) as c2 from qlbh.hoadonxuat "
                        + "order by c1, c2";
                re = connectDatabase.getConnection().
                        createStatement().executeQuery(sql);
                while (re.next()) {
                    String thang = re.getString("c2");
                    if (thang.length() == 1) {
                        thang = "0" + thang;
                    }
                    list.add(getLoiNhuan(0 + "", thang,
                            re.getString("c1")));
                }
                connectDatabase.getConnection().close();
            } catch (SQLException ex) {
                Logger.getLogger(LoiNhuan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (type.equals("Năm")) {
            try {
                sql = "select YEAR(thoiGian) as c1 from qlbh.hoadonnhap "
                        + "UNION "
                        + "select YEAR(thoiGian) as c1 from qlbh.hoadonxuat "
                        + "order by c1";
                re = connectDatabase.getConnection().
                        createStatement().executeQuery(sql);
                while (re.next()) {
                    list.add(getLoiNhuan(0 + "", 0 + "",
                            re.getString("c1")));
                }
                connectDatabase.getConnection().close();
            } catch (SQLException ex) {
                Logger.getLogger(LoiNhuan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

}
