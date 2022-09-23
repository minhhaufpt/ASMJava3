/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import DoiTuong.GradeOB;
import DoiTuong.SinhVienOB;
import java.util.ArrayList;

/**
 *
 * @author NguyenMinhHau_PS24488
 */
public interface DAOGrade {
//kiem tra diem co dung dinh dang
    public boolean checkdiem();
//sap xep diem theo thu hang
    public void sapxep();
//lay danh sach sinh vien sau do ra ve list chua ma so va ten sinh vien , mac dinh diem la 0
    public ArrayList<GradeOB> laydanhsach();
//function sua diem cua list
    public void suadiem(String ms, double toan, double li, double hoa);
//
    public void themdiem(String ms, double toan, double li, double hoa);
//
    public void xoadiem(String ms);
// tra ve list sinh vien da co diem    
     public ArrayList<GradeOB> getAll();
}
