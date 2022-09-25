/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change mainFarme license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit mainFarme template
 */
package From;

import Entity.SinhVienOB;
import ListEntity.SinhVien;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NguyenMinhHau_PS24488
 */
public class quanlisinhvien1 {

    public JLabel tieude, maso, hoten, email, sdt, gioitinh, diachi, hinhanh;
    public JButton btnnew, btnsave, btndelete, btnupdate;
    public JTable tblbang;
    public JTextField txtms, txthvt, txtemail, txtsdt;
    public JRadioButton rdonam, rdonu;
    public ButtonGroup rdo;
    public JTextArea adc;
    public JPanel pn1, pn2, pn3, pn4, pngt;
    public JFrame mainFarme;
    public JScrollPane sp;

    SinhVien lsv = new SinhVien();
    String stranh = null;

    public quanlisinhvien1() {
        Layout();

    }

    public static void main(String[] args) {
        quanlisinhvien1 quanlisinhvien1 = new quanlisinhvien1();
    }

    public void panel1() {
        pn1 = new JPanel();
        pn1.setPreferredSize(new Dimension(500, 400));
        pn1.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
        maso = new JLabel("Mã số sinh viên");
        maso.setFont(new Font("Arial", 0, 16));
        maso.setPreferredSize(new Dimension(120, 30));
        pn1.add(maso);
        txtms = new JTextField();
        txtms.setPreferredSize(new Dimension(350, 30));
        pn1.add(txtms);

        hoten = new JLabel("Họ tên");
        hoten.setFont(new Font("Arial", 0, 16));
        hoten.setPreferredSize(new Dimension(120, 30));
        pn1.add(hoten);
        txthvt = new JTextField();
        txthvt.setPreferredSize(new Dimension(350, 30));
        pn1.add(txthvt);

        email = new JLabel("Email");
        email.setFont(new Font("Arial", 0, 16));
        email.setPreferredSize(new Dimension(120, 30));
        pn1.add(email);
        txtemail = new JTextField();
        txtemail.setPreferredSize(new Dimension(350, 30));
        pn1.add(txtemail);

        sdt = new JLabel("Số điện thoại");
        sdt.setFont(new Font("Arial", 0, 16));
        sdt.setPreferredSize(new Dimension(120, 30));
        pn1.add(sdt);
        txtsdt = new JTextField();
        txtsdt.setPreferredSize(new Dimension(350, 30));
        pn1.add(txtsdt);

        gioitinh = new JLabel("Giới tính");
        gioitinh.setFont(new Font("Arial", 0, 16));
        gioitinh.setPreferredSize(new Dimension(120, 30));
        pn1.add(gioitinh);
        rdonam = new JRadioButton("Nam");
        rdonam.setFont(new Font("Arial", 0, 16));
        rdonu = new JRadioButton("Nữ");
        rdonu.setFont(new Font("Arial", 0, 16));
        rdo = new ButtonGroup();
        rdo.add(rdonam);
        rdo.add(rdonu);
        pngt = new JPanel();
        pngt.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 0));
        pngt.setPreferredSize(new Dimension(350, 30));
        pngt.add(rdonam);
        pngt.add(rdonu);
        pn1.add(pngt);

        diachi = new JLabel("Địa chỉ");
        diachi.setFont(new Font("Arial", 0, 16));
        diachi.setPreferredSize(new Dimension(120, 30));
        pn1.add(diachi);
        adc = new JTextArea();
        adc.setPreferredSize(new Dimension(350, 100));
        sp = new JScrollPane(adc, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sp.setViewportView(adc);
        adc.setBorder(new LineBorder(Color.BLACK));
        pn1.add(adc);

    }

    public void panel2() {
        pn2 = new JPanel();
        pn2.setPreferredSize(new Dimension(300, 400));
        pn2.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 25));
        hinhanh = new JLabel();
        hinhanh.setText("No Image");
        hinhanh.setHorizontalAlignment(0);
        hinhanh.setPreferredSize(new Dimension(150, 200));
        hinhanh.setBorder(new LineBorder(Color.BLACK));
        hinhanh.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String fileanh = "";
                try {
                    JFileChooser c = new JFileChooser("D:\\FPTPoly\\Java3\\Deadline\\JAVA3_PS24488_NguyenMinhHau_AssignmentGD2\\Java3_ASMGD2_NguyenMinhHau_PS24488\\build\\classes\\asm\\anhsinhvien");
                    int rVal = c.showOpenDialog(null);
                    if (rVal != JFileChooser.CANCEL_OPTION) {
                        if (rVal == JFileChooser.OPEN_DIALOG) {
                            File filename = c.getSelectedFile();
                            stranh = c.getSelectedFile().getName();
                            hinhanh.setText("");
                            Image img = ImageIO.read(filename);
                            hinhanh.setIcon(new ImageIcon(img.getScaledInstance(150, 200, 0)));
                        }

                    }
                } catch (IOException ev) {
                    JOptionPane.showMessageDialog(mainFarme, "Ảnh bị lỗi", "Lỗi ảnh", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        pn2.add(hinhanh);

        btndelete = new JButton("Delete");
        btndelete.setPreferredSize(new Dimension(120, 45));
        btndelete.setIcon(new ImageIcon(getClass().getResource("/asm/Image/delete.png")));
        btndelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = tblbang.getSelectedRow();
                if (timkiembyID() != -1 || index != -1) {
                    int result = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa sinh viên này không", "Cảnh báo", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/asm/Image/canhbao.png")));
                    if (result == JOptionPane.YES_OPTION) {
                        if (timkiembyID() == -1) {
                            String ms = lsv.getAll().get(index).getMasv();
                            lsv.deleteSV(ms);
                        } else {
                            String ms = getdetail().getMasv();
                            lsv.deleteSV(ms);
                        }
                        JOptionPane.showMessageDialog(mainFarme, "Xóa thành công", "Delete", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/asm/Image/succes.png")));
                        filltotable();
                        reset();
                    }
                } else {
                    JOptionPane.showMessageDialog(mainFarme, "Không thể xóa vui lòng kiểm tra lại", "Delete", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/asm/Image/nosuc.png")));
                }
            }

        });
        btnnew = new JButton("New");
        btnnew.setPreferredSize(new Dimension(120, 45));
        btnnew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
            }
        }
        );
        btnnew.setIcon(new ImageIcon(getClass().getResource("/asm/Image/new1.png")));
        btnsave = new JButton("Save");
        btnsave.setPreferredSize(new Dimension(120, 45));
        btnsave.setIcon(new ImageIcon(getClass().getResource("/asm/Image/save1.png")));
        btnsave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                if (checkNull()) {
                    if (validateSV()) {
                        if (getdetail() != null) {
                            if (timkiembyID() == -1) {
                                SinhVienOB s = getdetail();
                                lsv.addSV(s);
                                lsv.getAll();
                                JOptionPane.showMessageDialog(null, "Lưu thành công", "Save", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/asm/Image/succes.png")));
                                filltotable();
                                timkiembyID();
                            } else {
                                JOptionPane.showMessageDialog(null, "ID đã tồn tại không thể lưu vui lòng chọn Update nếu muốn thay đổi thông tin", "Save", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/asm/Image/nosuc.png")));
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra lại", "Save", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/asm/Image/nosuc.png")));
                        }
                    }
                }
            }
        }
        );
        btnupdate = new JButton("Update");

        btnupdate.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkNull()) {
                    if (validateSV()) {
                        if (getdetail() != null) {
                            int index = tblbang.getSelectedRow();
                            if (timkiembyID() != -1 || index != -1) {
                                SinhVienOB s = getdetail();
                                boolean flat = false;
                                for (SinhVienOB k : lsv.getAll()) {
                                    if (s.getMasv().equalsIgnoreCase(k.getMasv())) {
                                        flat = true;
                                        break;
                                    }
                                }
                                if (flat) {
                                    if (timkiembyID() == -1) {
                                        String ms = lsv.getAll().get(index).getMasv();
                                        lsv.updateSV(ms, s.getHovaten(), s.getEmail(), s.getSdt(), s.isGioitinh(), s.getDiachi(), s.getHinhanh());
                                        lsv.getAll();
                                    } else {
                                        lsv.updateSV(s.getMasv(), s.getHovaten(), s.getEmail(), s.getSdt(), s.isGioitinh(), s.getDiachi(), s.getHinhanh());
                                        lsv.getAll();
                                    }
                                    JOptionPane.showMessageDialog(null, "Update thành công", "Update", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/asm/Image/succes.png")));
                                    filltotable();
                                    timkiembyID();
                                } else {
                                    try {
                                        txtms.setText(lsv.getAll().get(index).getMasv());
                                        JOptionPane.showMessageDialog(null, "Không thể update mã sinh viên", "Update", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/asm/Image/nosuc.png")));
                                    } catch (Exception ex) {
                                        JOptionPane.showMessageDialog(null, "Xảy ra lỗi index", "Update", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/asm/Image/nosuc.png")));
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(mainFarme, "ID chưa tồn tại hoặc không có dữ liệu", "Update", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/asm/Image/nosuc.png")));
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra lại", "Update", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/asm/Image/nosuc.png")));
                        }
                    }
                }
            }
        }
        );
        btnupdate.setPreferredSize(
                new Dimension(120, 45));
        btnupdate.setIcon(
                new ImageIcon(getClass().getResource("/asm/Image/update1.png")));
        pn2.add(btnnew);

        pn2.add(btnsave);

        pn2.add(btnupdate);

        pn2.add(btndelete);

    }

    public void table() {
        String[] td = {"Mã số", "Họ tên", "Email", "Số điện thoại", "Giới tính", "Địa chỉ", "Hình ảnh"};
        String[][] t = {};
        tblbang = new JTable();
        tblbang.setPreferredSize(new Dimension(780, 180));
        tblbang.setBorder(new LineBorder(Color.BLACK));
        tblbang.setVisible(true);
        tblbang.setModel(new DefaultTableModel(new Object[][]{}, new String[]{"Mã số", "Họ tên", "Email", "Số điện thoại", "Giới tính", "Địa chỉ", "Hình ảnh"}));
        tblbang.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = tblbang.getSelectedRow();
                showdetail(index);
            }
        });
    }

    public void Layout() {

        panel1();
        panel2();
        table();
        setTable();
        mainFarme = new JFrame("Quản lí sinh viên");
        mainFarme.setFont(new Font("Arial", 0, 20));
        mainFarme.setSize(880, 800);
        mainFarme.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        mainFarme.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFarme.setLocationRelativeTo(null);

        tieude = new JLabel("Quản lí sinh viên");
        tieude.setFont(new Font("Arial", Font.CENTER_BASELINE, 32));
        tieude.setHorizontalAlignment(0);
        tieude.setPreferredSize(new Dimension(650, 40));
        mainFarme.add(tieude);
        mainFarme.add(pn1);
        mainFarme.add(pn2);

        JScrollPane sp = new JScrollPane(tblbang);
        sp.setPreferredSize(new Dimension(780, 180));
        mainFarme.add(sp);
        JButton send = new JButton("Send Email");
        JButton cancel = new JButton("Cancel");
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = tblbang.getSelectedRow();
                if (timkiembyID() != -1 || index != -1) {
                    SinhVienOB s = getdetail();
                    boolean flat = false;
                    for (SinhVienOB k : lsv.getAll()) {
                        if (s.getMasv().equalsIgnoreCase(k.getMasv())) {
                            flat = true;
                            break;
                        }
                    }
                    if (flat) {
                        Gmail g = new Gmail(s.getEmail());
                        g.setVisible(true);

                    } else {
                        Gmail g = new Gmail(lsv.getAll().get(index).getEmail());
                        g.setVisible(true);
                    }
                } else {
                    Gmail g = new Gmail();
                    g.setVisible(true);
                }
            }
        });
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thoát không ", "Cảnh báo", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/asm/Image/canhbao.png")));
                if (result == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        mainFarme.add(send);
        mainFarme.add(cancel);
        mainFarme.setIconImage(new ImageIcon(getClass().getResource("/asm/Image/qlsv.png")).getImage());
        filltotable();
        mainFarme.setVisible(true);
    }

    public void setTable() {
        tblbang.getTableHeader().setFont(new Font("Arial", Font.PLAIN, 15));
    }

    public void reset() {
        txtms.setText("");
        txthvt.setText("");
        txtemail.setText("");
        adc.setText("");
        txtsdt.setText("");
        rdonam.setSelected(true);
        hinhanh.setIcon(null);
        hinhanh.setText("No Image");
        tblbang.clearSelection();
    }

    public SinhVienOB getdetail() {
        if (checkNull()) {
            if (validateSV()) {
                SinhVienOB s = new SinhVienOB();
                s.setMasv(txtms.getText());
                s.setHovaten(txthvt.getText());
                s.setEmail(txtemail.getText());
                s.setDiachi(adc.getText());
                s.setSdt(txtsdt.getText());
                s.setGioitinh(rdonam.isSelected() ? true : false);
                if (stranh == null) {
                    s.setHinhanh("No Image");
                } else {
                    s.setHinhanh(stranh);
                }
                return s;
            }
        }
        return null;

    }

    public void showdetail(int index) {
        SinhVienOB sv = lsv.getAll().get(index);
        txtms.setText(sv.getMasv());
        txthvt.setText(sv.getHovaten());
        txtemail.setText(sv.getEmail());
        txtsdt.setText(sv.getSdt());
        adc.setText(sv.getDiachi());
        if (sv.isGioitinh()) {
            rdonam.setSelected(true);
        } else {
            rdonu.setSelected(true);
        }
        if (sv.getHinhanh().equals("No Image") || sv.getHinhanh() == null) {
            hinhanh.setText("No Image");
            hinhanh.setIcon(null);
            stranh = null;
        } else {
            hinhanh.setText("");
            ImageIcon IM = new ImageIcon(getClass().getResource("/asm/anhsinhvien/" + sv.getHinhanh()));
            Image img = IM.getImage();
            hinhanh.setIcon(new ImageIcon(img.getScaledInstance(150, 200, 0)));
            stranh = sv.getHinhanh();
        }
    }

    public int timkiembyID() {
        String id = txtms.getText();
        ArrayList<SinhVienOB> sv = lsv.getAll();
        for (SinhVienOB x : sv) {
            if (x.getMasv().equals(id)) {
                tblbang.setRowSelectionInterval(sv.indexOf(x), sv.indexOf(x));
                return sv.indexOf(x);
            }
        }
        return -1;
    }

    public void filltotable() {
        DefaultTableModel model = (DefaultTableModel) tblbang.getModel();
        model.setRowCount(0);
        for (SinhVienOB s : lsv.getAll()) {
            Object[] rowdata = {s.getMasv(), s.getHovaten(), s.getEmail(), s.getSdt(), s.isGioitinh() ? "Nam" : "Nữ", s.getDiachi(), s.getHinhanh()};
            model.addRow(rowdata);
        }
    }

    public boolean validateSV() {
        String chke = "\\w+@\\w{3,8}+\\.+\\w{2,3}+\\.+\\w{2,3}";
        String chkt = "[^0-9]{3,30}";
        String chkdt = "[0-9]{9,11}";
        if (!txthvt.getText().matches(chkt)) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập họ tên từ 3 - 30 kí tự không có số", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            txthvt.requestFocus();
            return false;
        } else if (!txtemail.getText().matches(chke)) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng email", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            txtemail.requestFocus();
            return false;
        } else if (!txtsdt.getText().matches(chkdt)) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng số điện thoại", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            txtsdt.requestFocus();
            return false;
        }
        return true;
    }

    public boolean checkNull() {
        if (txtms.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập mã số", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            txtms.requestFocus();
            return false;
        } else if (txthvt.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập họ tên ", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            txthvt.requestFocus();
            return false;
        } else if (txtemail.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập email ", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            txtemail.requestFocus();
            return false;
        } else if (txtsdt.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập số điện thoại ", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            txtsdt.requestFocus();
            return false;
        } else if (rdonam.isSelected() == false && rdonu.isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn giới tính", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (adc.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập địa chỉ ", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            adc.requestFocus();
            return false;
        }
        return true;
    }

    public void setE(boolean x) {
        mainFarme.setVisible(x);
    }
}
