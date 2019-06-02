/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Kira
 */
public class TinhThanhPho {

    public static ArrayList<String> getListTinh() {
        ArrayList<String> tinhs = new ArrayList<>();
//        C:\Users\Kira\Documents\Git - QLBH - PR1\qlbh_pr1\qlbh\src\files\tinh_thanhpho.txt
        File file = new File("");
        File in = new File(file.getAbsolutePath()
                + "\\src\\files" + "\\tinh_thanhpho.txt");
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(in), "UTF8"));
            String line = "";
            // đọc từng dòng
            while ((line = br.readLine()) != null) {
                if (!line.equals("")) {
                    tinhs.add(line.trim());
                }
            }
        } catch (IOException ex) {

        }
        return tinhs;
    }

    public static String[][] classifyDiaChis(ArrayList<String> diaChis) {

        String[][] matrixClassify = new String[63][diaChis.size()];
        ArrayList<String> tinhs = getListTinh();
        for (int i = 0; i < tinhs.size(); i++) {
            int j = 0;
            for (String diaChi : diaChis) {
                if (diaChi.toLowerCase().contains(tinhs.get(i).toLowerCase())) {
                    matrixClassify[i][j++] = diaChi;
                }
            }
        }
        return matrixClassify;
    }

    public static String getTenTinh(int position) {
        return getListTinh().get(position);
    }

}
