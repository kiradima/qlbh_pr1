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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Kira
 */
public class User {

    final static String USER = "user";

    final static String COL_USERNAME = "userName";
    final static String COL_PASSWORD = "password";

    private String userName;
    private String passWord;

    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public static ArrayList<User> getAll() {
        ArrayList<User> list = new ArrayList<>();
        try {
            String sql = "select * from " + USER;
            ConnectDatabase connectDatabase = new ConnectDatabase();
            Connection connection = connectDatabase.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                list.add(new User(
                        resultSet.getString(COL_USERNAME),
                        resultSet.getString(COL_PASSWORD)
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static int insert(User o) {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        try {
            // nếu trả về 1 là thành công
            return connectDatabase.getConnection().createStatement().executeUpdate(
                    "insert into " + USER + " values('"
                    + o.getUserName() + "','"
                    + o.getPassWord() + "')"
            );
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi insert CSDL");
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static boolean login(User user) {
        ArrayList<User> users = getAll();
        for (User u : users) {
            if (u.getUserName().equals(user.getUserName())
                    && u.getPassWord().equals(user.getPassWord())) {
                return true;
            }
        }
        return false;
    }

    public static boolean register(User user) {
        boolean re = true;
        ArrayList<User> users = getAll();
        for (User u : users) {
            if (u.getUserName().equals(user.getUserName())) {
                re = false;
                break;
            }
        }
        if (re == true) {
            insert(user);
            return true;
        } else {
            return false;
        }
    }
}
