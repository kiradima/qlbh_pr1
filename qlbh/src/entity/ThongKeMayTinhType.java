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
public class ThongKeMayTinhType {
    private String thuocTinh; 
    private int soLuong; 

    public ThongKeMayTinhType() {
    }

    public ThongKeMayTinhType(String thuocTinh, int soLuong) {
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
    
     public static ArrayList<ThongKeMayTinhType> getList(String tieuChi) throws ClassNotFoundException, SQLException {
        String sql = "SELECT  "+tieuChi+", sum(maytinhchitiet.soLuongTonKho) FROM maytinh INNER JOIN maytinhchitiet ON maytinh.maMayTinh=maytinhchitiet.maMayTinh group by "+tieuChi+";";

        ArrayList<ThongKeMayTinhType> list = new ArrayList<>();
        ConnectDatabase ketNoiQLBH = new ConnectDatabase();
        Connection connection = ketNoiQLBH.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            list.add(new ThongKeMayTinhType(
                    resultSet.getString(""+tieuChi),
                    resultSet.getInt("sum(maytinhchitiet.soLuongTonKho)")
            ));
        }
        connection.close();
        return list;

    }
      public static ArrayList<ThongKeMayTinhType> getList2(String tieuChi) throws ClassNotFoundException, SQLException {
        String sql = "SELECT sum(soLuongTonKho), "+ tieuChi+" FROM maytinhchitiet group by "+tieuChi +" order by sum(soLuongTonKho) DESC ;";

        ArrayList<ThongKeMayTinhType> list = new ArrayList<>();
        ConnectDatabase ketNoiQLBH = new ConnectDatabase();
        Connection connection = ketNoiQLBH.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            list.add(new ThongKeMayTinhType(
                    resultSet.getString(""+tieuChi),
                    resultSet.getInt("sum(soLuongTonKho)")
            ));
        }
        connection.close();
        return list;

    }
    
    
    
    
}
