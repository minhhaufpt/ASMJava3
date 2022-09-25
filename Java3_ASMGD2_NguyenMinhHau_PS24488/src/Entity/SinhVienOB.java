/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import javax.swing.ImageIcon;

/**
 *
 * @author NguyenMinhHau_PS24488
 */
public class SinhVienOB {

    private String masv;
    private String hovaten;
    private String email;
    private String sdt;
    private boolean gioitinh;
    private String diachi;
    public String hinhanh;

    public SinhVienOB() {
    }

    public SinhVienOB(String masv, String hovaten, String email, String sdt, boolean gioitinh, String diachi, String hinhanh) {
        this.masv = masv;
        this.hovaten = hovaten;
        this.email = email;
        this.sdt = sdt;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.hinhanh = hinhanh;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getHovaten() {
        return hovaten;
    }

    public void setHovaten(String hovaten) {
        this.hovaten = hovaten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

}
