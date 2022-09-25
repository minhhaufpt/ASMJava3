/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListEntity;

import ConnectSQLSever.ConnectSQLSever;
import Entity.SinhVienOB;
import Entity.UserOB;
import DAO.DAOSinhVien;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.*;


/**
 *
 * @author NguyenMinhHau_PS24488
 */
public class SinhVien implements DAOSinhVien {

    ArrayList<SinhVienOB> sv = new ArrayList<>();

    public SinhVien() {
//        sv.add(new SinhVienOB("PS24488", "Nguyễn Minh Hậu", "haunmps24488@fpt.edu.vn", "0123456789", true, "Bình Định", "No Image"));
//        sv.add(new SinhVienOB("PS23344", "Nguyễn Ngọc Ánh Hoa", "hoannaps23344@fpt.edu.vn", "0222222222", false, "Bình Định", "No Image"));
//        sv.add(new SinhVienOB("PS12344", "Nguyễn Minh Hằng", "hoannaps23344@fpt.edu.vn", "0222222222", false, "Bình Định", "No Image"));
//        sv.add(new SinhVienOB("PS24121", "Nguyễn Ánh Dương", "hoannaps23344@fpt.edu.vn", "0222222222", false, "Bình Định", "No Image"));
//        sv.add(new SinhVienOB("PS37377", "Nguyễn Phú Khoa", "hoannaps23344@fpt.edu.vn", "0222222222", true, "Bình Định", "No Image"));
        try {
            sv.clear();
            ConnectSQLSever con = new ConnectSQLSever();
            ResultSet rs = con.getTable("SinhVien");
            while (rs.next()) {
                sv.add(new SinhVienOB(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5) == true ? true : false, rs.getString(6), rs.getString(7)));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    @Override
    public boolean validate(SinhVienOB s) {
        String chke = "\\w+@\\w{3,8}+\\.+\\w{2,3}+\\.+\\w{2,3}";
        String chkt = "[^0-9]{3,30}";
        String chkdt = "[0-9]{9,11}";
        if (s.getMasv().equals("") || s.getMasv() == null) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập mã sinh viên", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (!s.getHovaten().matches(chkt)) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập họ tên từ 3 - 30 kí tự không có số", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (!s.getEmail().matches(chke)) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng email", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (!s.getSdt().matches(chkdt)) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng số điện thoại", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (s.getDiachi() == null || "".equals(s.getDiachi())) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập địa chỉ", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    @Override
    public void addSV(SinhVienOB s) {
        if (validate(s)) {

            try {
                ConnectSQLSever con = new ConnectSQLSever();
//            ResultSet rs = con.getTable("Grade");
                Connection connect = con.getConnection();
                Statement statement = connect.createStatement();
                String insert = "INSERT INTO SinhVien "
                        + "VALUES(N'" + s.getMasv() + "',N'" + s.getHovaten() + "',N'" + s.getEmail() + "',N'" + s.getSdt() +"','"+s.isGioitinh()+ "',N'" + s.getDiachi() + "',N'" + s.getHinhanh() + "')";
                statement.executeUpdate(insert);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    @Override
    public void updateSV(String msv, String hoten, String email, String sdt, boolean gt, String diachi, String hinhanh) {
        try {
            ConnectSQLSever con = new ConnectSQLSever();
//            ResultSet rs = con.getTable("Grade");
            Connection connect = con.getConnection();
            Statement statement = connect.createStatement();
            String update2 = "UPDATE SinhVien set Hoten = N'" + hoten + "' WHERE  MASV like N'" + msv + "'";
            String update3 = "UPDATE SinhVien set Email = N'" + email + "' WHERE  MASV like N'" + msv + "'";
            String update4 = "UPDATE SinhVien set SDT = N'" + sdt + "' WHERE  MASV like N'" + msv + "'";
            String update5 = "UPDATE SinhVien set gioitinh = '" + gt + "' WHERE  MASV like N'" + msv + "'";
            String update6 = "UPDATE SinhVien set Diachi = N'" + diachi + "' WHERE  MASV like N'" + msv + "'";
            String update7 = "UPDATE SinhVien set Hinhanh = N'" + hinhanh + "' WHERE  MASV like N'" + msv + "'";

            statement.executeUpdate(update4);
            statement.executeUpdate(update2);
            statement.executeUpdate(update3);
            statement.executeUpdate(update5);
            statement.executeUpdate(update6);
            statement.executeUpdate(update7);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @Override
    public void updateSV(SinhVienOB s, int index) {
        if (validate(s)) {
            sv.set(index, s);
        }
    }

    @Override
    public void deleteSV(String msv) {

        try {
            ConnectSQLSever con = new ConnectSQLSever();
//            ResultSet rs = con.getTable("Grade");
            Connection connect = con.getConnection();
            Statement statement = connect.createStatement();
//            PreparedStatement PS = connect.prepareStatement("");
            String del = "DELETE from SinhVien WHERE  MASV like N'" + msv + "'";
            statement.executeUpdate(del);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    @Override
    public void deleteSV(int index) {

        sv.remove(index);

    }

    public ArrayList<SinhVienOB> getAll() {
        try {
            sv.clear();
            ConnectSQLSever con = new ConnectSQLSever();
            ResultSet rs = con.getTable("SinhVien");
            while (rs.next()) {
                sv.add(new SinhVienOB(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5) == true ? true : false, rs.getString(6), rs.getString(7)));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return sv;
    }
}
