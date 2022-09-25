/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListEntity;

import ConnectSQLSever.ConnectSQLSever;
import Entity.GradeOB;
import Entity.SinhVienOB;
import DAO.DAOGrade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author NguyenMinhHau_PS24488
 */
public class Grade implements DAOGrade {

    ArrayList<GradeOB> s = new ArrayList<>();
    SinhVien sv = new SinhVien();

    public Grade() {
        //dữ liệu mẫu thêm vào
        try {
            s.clear();
            ConnectSQLSever con = new ConnectSQLSever();
            ResultSet rs = con.getTable("Grade");
            while (rs.next()) {
                s.add(new GradeOB(rs.getString(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5)));
            }
            for (GradeOB gradeOB : s) {
                for (SinhVienOB sv : sv.getAll()) {
                    if (gradeOB.getMasv().equalsIgnoreCase(sv.getMasv())) {
                        gradeOB.setHovaten(sv.getHovaten());
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
//        laydanhsach();
//        s.get(0).setDiem(8.6, 8.9, 10);
//        s.get(1).setDiem(8, 8, 8);
//        s.get(2).setDiem(7, 9, 8);
//        s.get(3).setDiem(5, 8, 9);
//        s.get(4).setDiem(9, 9, 8);
        sapxep();
    }

    @Override
    public boolean checkdiem() {
        return true;
    }

    @Override
    public ArrayList<GradeOB> laydanhsach() {
        try {
            s.clear();
            ConnectSQLSever con = new ConnectSQLSever();
            ResultSet rs = con.getTable("Grade");
            while (rs.next()) {
                s.add(new GradeOB(rs.getString(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5)));
            }
            for (GradeOB gradeOB : s) {
                for (SinhVienOB sv : sv.getAll()) {
                    if (gradeOB.getMasv().equalsIgnoreCase(sv.getMasv())) {
                        gradeOB.setHovaten(sv.getHovaten());
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
//        sapxep(s);
        return s;
    }

    @Override
    public void sapxep() {
        Comparator<GradeOB> com = new Comparator<GradeOB>() {
            @Override
            public int compare(GradeOB o1, GradeOB o2) {
                Double x1 = o1.getTb();
                Double x2 = o2.getTb();
                return x2.compareTo(x1);
            }
        };
        Collections.sort(s, com);

    }

    public void sapxep(ArrayList<GradeOB> sv) {
        laydanhsach();
        Comparator<GradeOB> com = new Comparator<GradeOB>() {
            @Override
            public int compare(GradeOB o1, GradeOB o2) {
                Double x1 = o1.getTb();
                Double x2 = o2.getTb();
                return x2.compareTo(x1);
            }
        };
        Collections.sort(sv, com);

    }

    @Override
    public void suadiem(String ms, double toan, double li, double hoa) {
        try {
            ConnectSQLSever con = new ConnectSQLSever();
//            ResultSet rs = con.getTable("Grade");
            Connection connect = con.getConnection();
            Statement statement = connect.createStatement();
            String update1 = "UPDATE Grade set toan = " + toan + " WHERE  MASV like '" + ms + "'";
            String update2 = "UPDATE Grade set li = " + li + " WHERE  MASV like '" + ms + "'";
            String update3 = "UPDATE Grade set hoa = " + hoa + " WHERE  MASV like '" + ms + "'";
            statement.executeUpdate(update1);
            statement.executeUpdate(update2);
            statement.executeUpdate(update3);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @Override
    public void themdiem(String ms, double toan, double li, double hoa) {
        try {
            double tb = Math.round(((toan + li + hoa) / 3) * 100) / 100;
            ConnectSQLSever con = new ConnectSQLSever();
//            ResultSet rs = con.getTable("Grade");
            Connection connect = con.getConnection();
            Statement statement = connect.createStatement();
            String insert = "IF NOT EXISTS(select * from Grade where MASV like N'"+ms+"') and EXISTS(select * from SinhVien where MASV like N'"+ms+"') "+" INSERT INTO Grade "
                    + "VALUES(N'" + ms + "'," + toan + "," + li + "," + hoa + "," + tb + ")";
            int row = statement.executeUpdate(insert);
            if(row == 0 ){
                  JOptionPane.showMessageDialog(null, "Mã sinh viên không tồn tại hoặc sinh viên này đã có điểm vui lòng kiểm tra lại");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @Override
    public void xoadiem(String ms) {
        try {
            ConnectSQLSever con = new ConnectSQLSever();
//            ResultSet rs = con.getTable("Grade");
            Connection connect = con.getConnection();
            Statement statement = connect.createStatement();
            String update1 = "DELETE from Grade WHERE  MASV like N'" + ms + "'";
            statement.executeUpdate(update1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @Override
    public ArrayList<GradeOB> getAll() {
        return laydanhsach();
    }

}
