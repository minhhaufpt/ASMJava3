/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListEntity;

import ConnectSQLSever.ConnectSQLSever;
import Entity.UserOB;
import DAO.DAOUser;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

/**
 *
 * @author NguyenMinhHau_PS24488
 */
public class User implements DAOUser {

    ArrayList<UserOB> u = new ArrayList<>();

    public User() throws Exception {
        /**
         *
         * User mac dinh trong he thong
         */
        try {
            u.clear();
            ConnectSQLSever con = new ConnectSQLSever();
            ResultSet rs = con.getTable("USERS");
            while (rs.next()) {
                u.add(new UserOB(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
            u.add(new UserOB("hau", "123", "giangvien"));
            u.add(new UserOB("hau", "123", "canbo"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @Override
    public boolean checkdangnhap(String name, String pass, String role) {
        for (UserOB x : u) {
            if (name.equals(x.getName()) && pass.equals(x.getPass()) && role.equals(x.getRole())) {
                JOptionPane.showMessageDialog(null, "Đăng nhập thành công", "Login", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/asm/Image/succes.png")));
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, "Đăng nhập thất bại", "Login", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/asm/Image/nosuc.png")));
        return false;
    }

}
