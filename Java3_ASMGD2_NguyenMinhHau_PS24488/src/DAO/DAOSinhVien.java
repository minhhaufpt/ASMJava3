/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Entity.SinhVienOB;

/**
 *
 * @author NguyenMinhHau_PS24488
 */
public interface DAOSinhVien {
// phuong thuc them sinh vien vao list
    public void addSV(SinhVienOB sv);
//phuong thuc xoa sinh vien theo OB
    public void deleteSV(String msv);
//phuong thuc xoa sinh vien theo index
    public void deleteSV( int index);
//phuong thuc update sinh vien theo index
    public void updateSV(String msv,String hoten,String email , String sdt,boolean gt ,String diachi,String hinhanh);
//phuong thuc update sinh vien theo OB
    public void updateSV(SinhVienOB sv, int index);
//kiem tra du lieu
    public boolean validate(SinhVienOB sv);

}
