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
public class TKR {

    private TK tk;
    private double tongTien;

    public TKR() {
    }

    public TKR(TK tk, double tongTien) {
        this.tk = tk;
        this.tongTien = tongTien;
    }

    public TK getTk() {
        return tk;
    }

    public void setTk(TK tk) {
        this.tk = tk;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    

}
