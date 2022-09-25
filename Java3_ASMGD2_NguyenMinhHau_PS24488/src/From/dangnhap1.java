/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package From;

import ListEntity.User;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

/**
 *
 * @author NguyenMinhHau_PS24488
 */
public final class dangnhap1 {

    public JFrame mainFarme;
    public JLabel lb1, lb2, lb3, lb4;
    public JTextField txtU, txtP;
    public JButton btnL, btnC;
    public JRadioButton rdoG, rdoC;
    public JPanel p1, p2, p3;
    quanlidiem qld = new quanlidiem();
    quanlisinhvien qlsv = new quanlisinhvien();

    public dangnhap1() {
        Layout();
    }

    public static void main(String[] args) {
        dangnhap1 dangnhap1 = new dangnhap1();
    }

    public void Layout() {
        mainFarme = new JFrame("Login");
        mainFarme.setFont(new Font("Arial", 0, 20));
        mainFarme.setSize(460, 300);
        mainFarme.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        mainFarme.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFarme.setLocationRelativeTo(null);

        p1 = new JPanel();
        p1.setPreferredSize(new Dimension(400, 220));
        p1.setBorder(new TitledBorder("  Login  "));
        p1.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        lb1 = new JLabel("UserName");
        lb1.setPreferredSize(new Dimension(100, 40));
        lb1.setFont(new Font("Arial", 0, 16));
        p1.add(lb1);
        txtU = new JTextField(20);
        p1.add(txtU);
        lb2 = new JLabel("PassWord");
        lb2.setPreferredSize(new Dimension(100, 40));
        lb2.setFont(new Font("Arial", 0, 16));
        p1.add(lb2);
        txtP = new JPasswordField(20);
        p1.add(txtP);

        lb3 = new JLabel("Roles");
        lb3.setPreferredSize(new Dimension(100, 40));
        lb3.setFont(new Font("Arial", 0, 16));
        p1.add(lb3);
        ButtonGroup rdo = new ButtonGroup();
        rdoC = new JRadioButton("Cán bộ đào tạo");
        rdoG = new JRadioButton("Giảng viên");
        rdo.add(rdoC);
        rdo.add(rdoG);
        p2 = new JPanel();
        p2.setPreferredSize(new Dimension(100, 40));
        p1.add(rdoC);
        p1.add(rdoG);
        btnL = new JButton("Login");
        btnC = new JButton("Cancel");
        p1.add(btnL);
        btnL.addActionListener((ActionEvent e) -> {
            try {
                login();
            } catch (Exception ex) {
                Logger.getLogger(dangnhap1.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btnL.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                try {
                    login();
                } catch (Exception ex) {
                    Logger.getLogger(dangnhap1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        p1.add(btnC);
        btnC.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        btnC.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                try {
                    login();
                } catch (Exception ex) {
                    Logger.getLogger(dangnhap1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }


        });

        mainFarme.add(p1);
        mainFarme.setIconImage(new ImageIcon(getClass().getResource("/asm/Image/login.png")).getImage());
        mainFarme.setVisible(true);

    }

    private void login() throws Exception {
        User u = new User();
        if (checkNull()) {
            if (u.checkdangnhap(txtU.getText(), txtP.getText(), rdoG.isSelected() ? "giangvien" : "canbo")) {
                if (rdoG.isSelected()) {
                    qld.setVisible(true);
                    mainFarme.setVisible(false);

                } else {
                    qlsv.setVisible(true);
                    mainFarme.setVisible(false);
                }
            }
        }
    }

    public boolean checkNull() {
        if (txtU.getText().equals("")) {
            JOptionPane.showMessageDialog(mainFarme, "Username không được trống", "Lỗi đăng nhập", JOptionPane.ERROR_MESSAGE);
            txtU.requestFocus();
            return false;
        } else if (txtP.getText().equals("")) {
            JOptionPane.showMessageDialog(mainFarme, "Password không được trống", "Lỗi đăng nhập", JOptionPane.ERROR_MESSAGE);
            txtP.requestFocus();
            return false;
        } else if (rdoC.isSelected() == false && rdoG.isSelected() == false) {
            JOptionPane.showMessageDialog(mainFarme, "Vui lòng chọn vai trò", "Lỗi đăng nhập", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

}
