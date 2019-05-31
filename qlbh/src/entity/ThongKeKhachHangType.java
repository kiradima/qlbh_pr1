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
import java.util.ArrayList;

/**
 *
 * @author hantr
 */
public class ThongKeKhachHangType {

    private String thuocTinh;
    private int soLuong;

    public ThongKeKhachHangType() {
    }

    public ThongKeKhachHangType(String thuocTinh, int soLuong) {
        this.thuocTinh = thuocTinh;
        this.soLuong = soLuong;
    }

    public String getThuocTinh() {
        return thuocTinh;
    }

    public void setThuocTinh(String thuocTinh) {
        this.thuocTinh = thuocTinh;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public static ArrayList<ThongKeKhachHangType> getlist(String tieuChi) throws ClassNotFoundException, SQLException {
        ArrayList<ThongKeKhachHangType> list = new ArrayList<>();
        String sql = "SELECT  "+tieuChi+" , count(maKhachHang)   FROM khachhang group by  "+tieuChi+"  order by count(maKhachHang) DESC ;";

        ConnectDatabase ketNoiQLBH = new ConnectDatabase();
        Connection connection = ketNoiQLBH.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            list.add(new ThongKeKhachHangType(
                    resultSet.getString("" + tieuChi),
                    resultSet.getInt("count(maKhachHang)")
            ));
        }

        return list;
    }

}
