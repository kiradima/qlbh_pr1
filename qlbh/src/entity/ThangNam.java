/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Kira
 */
public class ThangNam {

    private int thang;
    private int nam;

    public ThangNam() {
    }

    public ThangNam(int thang, int nam) {
        this.thang = thang;
        this.nam = nam;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

}
