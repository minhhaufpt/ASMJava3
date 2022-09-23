/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change mainFarme license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit mainFarme template
 */
package From;

import DoiTuong.GradeOB;
import DoiTuong.SinhVienOB;
import ListOB.Grade;
import ListOB.SinhVien;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NguyenMinhHau_PS24488
 */
public final class quanlidiem1 {

    private JButton btndelete, btnleft, btnleftend, btnnew, btnright, btnrightend, btnsave, btntimkiem, btnupdate;
    private JLabel jLabel1, jLabel10, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9, lbldiem;
    private JScrollPane jScrollPane1;
    private JTable tbldiem;
    private JPanel jPanel1, jPanel2;
    private JTextField txthoa, txthvt, txtli, txtms, txttimkiem, txttoan;
    public JFrame mainFarme;
    Grade sv = new Grade();
    ArrayList<GradeOB> lsv = new ArrayList<>();

    //tao list dữ liệu mẫu
    public void addData() {
        lsv = sv.getAll();
    }

    public quanlidiem1() {
        Layout();
        addData();
        setTable();
        filltotable();
    }

    public static void main(String[] args) {
        quanlidiem1 quanlidiem1 = new quanlidiem1();
    }

    public void Layout() {
        mainFarme = new JFrame("Quản lí điểm sinh viên");
        mainFarme.setFont(new Font("Arial", 0, 20));
        mainFarme.setSize(780, 780);
        mainFarme.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        mainFarme.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFarme.setLocationRelativeTo(null);

        jLabel1 = new JLabel();
        jPanel1 = new JPanel();
        jLabel3 = new JLabel();
        txttimkiem = new JTextField();
        txttimkiem.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (findbyID(txttimkiem.getText()) > -1) {
                        showdetail(findbyID(txttimkiem.getText()));
                    } else if (find(txttimkiem.getText())) {
                        txttoan.setText("");
                        txthoa.setText("");
                        txtli.setText("");
                        lbldiem.setText("");
                        tbldiem.clearSelection();
                    } else {
                        JOptionPane.showMessageDialog(mainFarme, "Mã sinh viên không tồn tại");
                    }
                }
            }
        });
        btntimkiem = new JButton();
        btntimkiem.addActionListener((ActionEvent e) -> {
            if (findbyID(txttimkiem.getText()) > -1) {
                showdetail(findbyID(txttimkiem.getText()));
            } else if (find(txttimkiem.getText())) {
                txttoan.setText("");
                txthoa.setText("");
                txtli.setText("");
                lbldiem.setText("");
                tbldiem.clearSelection();
            } else {
                JOptionPane.showMessageDialog(mainFarme, "Mã sinh viên không tồn tại");
            }
        });
        jPanel2 = new JPanel();
        jLabel2 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        txtms = new JTextField();

        txthvt = new JTextField();
        txttoan = new JTextField();
        txttoan.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    txtli.requestFocus();
                }
            }
        });
        txtli = new JTextField();
        txtli.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    txthoa.requestFocus();
                }
            }
        });
        txthoa = new JTextField();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        lbldiem = new JLabel();
        btnnew = new JButton();
        btnnew.addActionListener((ActionEvent e) -> {
            txttimkiem.setText("");
            txtms.setText("");
            txthvt.setText("");
            txttoan.setText("");
            txthoa.setText("");
            txtli.setText("");
            lbldiem.setText("");
            tbldiem.clearSelection();
        });
        btnsave = new JButton();
        btnsave.addActionListener((ActionEvent e) -> {
            try {
                create();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(mainFarme, "Xảy ra lỗi", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });
        btndelete = new JButton();
        btndelete.addActionListener((ActionEvent e) -> {
            try {
                delete();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(mainFarme, "Xảy ra lỗi", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });
        btnupdate = new JButton();
        btnupdate.addActionListener((ActionEvent e) -> {
            try {
                update();
            } catch (Exception ex) {
            }
        });
        jScrollPane1 = new JScrollPane();
        tbldiem = new JTable();
        tbldiem.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = tbldiem.getSelectedRow();
                showdetail(index);
            }
        });
        jLabel10 = new JLabel();
        btnleftend = new JButton();
        btnleftend.addActionListener((ActionEvent e) -> {
            try {
                endleft();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(mainFarme, "Không có dữ liệu", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });
        btnleft = new JButton();
        btnleft.addActionListener((ActionEvent e) -> {
            try {
                left();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(mainFarme, "Không có dữ liệu", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });
        btnright = new JButton();
        btnright.addActionListener((ActionEvent e) -> {
            try {
                right();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(mainFarme, "Không có dữ liệu", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });
        btnrightend = new JButton();
        btnrightend.addActionListener((ActionEvent e) -> {
            try {
                endright();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(mainFarme, "Không có dữ liệu", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });

        mainFarme.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFarme.setIconImage(new ImageIcon(getClass().getResource("/asm/Image/qldsv.png")).getImage());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("Quản lí điểm sinh viên");

        jPanel1.setBorder(BorderFactory.createTitledBorder(null, "Tìm kiếm  ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 16))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("Mã số sinh viên");

        txttimkiem.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        btntimkiem.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btntimkiem.setIcon(new ImageIcon(getClass().getResource("/asm/Image/search.png"))); // NOI18N
        btntimkiem.setText("Search");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txttimkiem, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btntimkiem)
                                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txttimkiem, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btntimkiem))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Họ tên sinh viên");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("Mã sinh viên");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setText("Toán");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setText("Lí");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setText("Hóa");

        txtms.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        txthvt.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        txttoan.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txttoan.addActionListener((ActionEvent evt) -> {
        });

        txtli.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        txthoa.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel8.setText("Điểm trung bình");

        lbldiem.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        lbldiem.setForeground(new java.awt.Color(255, 0, 0));
        lbldiem.setHorizontalAlignment(SwingConstants.CENTER);

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79))
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                                                .addComponent(jLabel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(txthoa, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(lbldiem, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(txtli, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                                                        .addComponent(txttoan, GroupLayout.Alignment.LEADING))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(txthvt)
                                        .addComponent(txtms))
                                .addGap(47, 47, 47))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtms, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                                .addGap(20, 20, 20)
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txthvt, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                                .addGap(20, 20, 20)
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txttoan, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                                                .addGap(20, 20, 20)
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtli, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel9)))
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbldiem, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txthoa, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(30, Short.MAX_VALUE))
        );

        btnnew.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnnew.setIcon(new ImageIcon(getClass().getResource("/asm/Image/new1.png"))); // NOI18N
        btnnew.setText("New");

        btnsave.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnsave.setIcon(new ImageIcon(getClass().getResource("/asm/Image/save1.png"))); // NOI18N
        btnsave.setText("Save");
        btnsave.addActionListener((ActionEvent evt) -> {
        });

        btndelete.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btndelete.setIcon(new ImageIcon(getClass().getResource("/asm/Image/delete.png"))); // NOI18N
        btndelete.setText("Delete");

        btnupdate.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnupdate.setIcon(new ImageIcon(getClass().getResource("/asm/Image/update1.png"))); // NOI18N
        btnupdate.setText("Update");

        tbldiem.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbldiem.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Mã sinh viên", "Họ tên sinh viên", "Toán", "Lí", "Hóa", "Điểm TB"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        tbldiem.setRowHeight(18);
        jScrollPane1.setViewportView(tbldiem);
        if (tbldiem.getColumnModel().getColumnCount() > 0) {
            tbldiem.getColumnModel().getColumn(0).setMinWidth(120);
            tbldiem.getColumnModel().getColumn(0).setPreferredWidth(120);
            tbldiem.getColumnModel().getColumn(0).setMaxWidth(120);
            tbldiem.getColumnModel().getColumn(2).setMaxWidth(100);
            tbldiem.getColumnModel().getColumn(3).setMaxWidth(100);
            tbldiem.getColumnModel().getColumn(4).setMaxWidth(100);
            tbldiem.getColumnModel().getColumn(5).setMinWidth(130);
            tbldiem.getColumnModel().getColumn(5).setMaxWidth(130);
        }

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 255));
        jLabel10.setText("Top 3 sinh viên có điểm trung bình cao nhất");

        btnleftend.setIcon(new ImageIcon(getClass().getResource("/asm/Image/leftend.png"))); // NOI18N

        btnleft.setIcon(new ImageIcon(getClass().getResource("/asm/Image/lefy1.png"))); // NOI18N

        btnright.setIcon(new ImageIcon(getClass().getResource("/asm/Image/right1.png"))); // NOI18N

        btnrightend.setIcon(new ImageIcon(getClass().getResource("/asm/Image/rightend.png"))); // NOI18N
        btnrightend.addActionListener((ActionEvent evt) -> {
        });

        GroupLayout layout = new GroupLayout(mainFarme.getContentPane());
        mainFarme.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 416, GroupLayout.PREFERRED_SIZE)
                                .addGap(156, 156, 156))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(10, 10, 10)
                                                                .addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(btnsave, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(btnnew, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(btnupdate, GroupLayout.PREFERRED_SIZE, 130, Short.MAX_VALUE)
                                                                                .addComponent(btndelete, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)))))
                                                .addGap(0, 20, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(btnleftend, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(btnleft, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(btnright, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(btnrightend, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnnew)
                                                .addGap(51, 51, 51)
                                                .addComponent(btnsave)
                                                .addGap(51, 51, 51)
                                                .addComponent(btnupdate)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btndelete))
                                        .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(btnleftend)
                                        .addComponent(btnleft)
                                        .addComponent(btnright)
                                        .addComponent(btnrightend))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23))
        );
        mainFarme.setIconImage(new ImageIcon(getClass().getResource("/asm/Image/qldsv.png")).getImage());
        mainFarme.setVisible(true);

    }

    public void setTable() {
        tbldiem.getTableHeader().setFont(new Font("Arial", Font.PLAIN, 15));
        txtms.setRequestFocusEnabled(false);
        txthvt.setRequestFocusEnabled(false);
//        DefaultTableModel tablemodel = new DefaultTableModel() {
//
//            @Override
//            public boolean isCellEditable(int row, int column) {
//                return false;
//            }
//        };
//        tbldiem.setModel(tablemodel);
    }

    public int findbyID(String ID) {
        for (GradeOB OB : lsv) {
            if (OB.getMasv().equalsIgnoreCase(ID) && lsv.indexOf(OB) < 3) {
                tbldiem.setRowSelectionInterval(lsv.indexOf(OB), lsv.indexOf(OB));
                return lsv.indexOf(OB);
            } else if (OB.getMasv().equalsIgnoreCase(ID) && lsv.indexOf(OB) >= 3) {
                tbldiem.clearSelection();
                return lsv.indexOf(OB);
            }
        }

        return -1;
    }

    public int findbyID1(String ID) {
        for (GradeOB OB : lsv) {
            if (OB.getMasv().equalsIgnoreCase(ID)) {
                return lsv.indexOf(OB);
            }
        }
        return -1;
    }

    public void findbyIndex(int index) {
        if (index > -1 && index < lsv.size()) {
            tbldiem.setRowSelectionInterval(index, index);
        }

    }

    public boolean find(String ID) {
        SinhVien sv = new SinhVien();
        ArrayList<SinhVienOB> s = sv.getAll();
        for (SinhVienOB sinhVienOB : s) {
            if (sinhVienOB.getMasv().equalsIgnoreCase(ID)) {
                txtms.setText(sinhVienOB.getMasv());
                txthvt.setText(sinhVienOB.getHovaten());
                return true;
            }
        }
        return false;

    }

    public void showdetail(int index) {
        GradeOB sv = lsv.get(index);
        try {
            txtms.setText(sv.getMasv());
            txthvt.setText(sv.getHovaten());
            txttoan.setText(String.valueOf(sv.getToan()));
            txtli.setText(String.valueOf(sv.getLi()));
            txthoa.setText(String.valueOf(sv.getHoa()));
            lbldiem.setText(String.valueOf(sv.getTb()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(mainFarme, "Danh sách bị lỗi");
        }
    }

    public void left() {
        String ID = txtms.getText();
        int index = findbyID1(ID) - 1;
        if (index < 0) {
            index = lsv.size() - 1;
            showdetail(index);
            if (index < 3) {
                findbyIndex(index);
            } else if (index >= 3) {
                tbldiem.clearSelection();
            }
        } else {
            showdetail(index);
            if (index < 3) {
                findbyIndex(index);
            } else if (index >= 3) {
                tbldiem.clearSelection();
            }
        }
    }

    public void endleft() {
        String ID = txtms.getText();
        int index = findbyID1(ID);
        if (index != 0) {
            index = 0;
            showdetail(index);
            if (index < 3) {
                findbyIndex(index);
            } else if (index >= 3) {
                tbldiem.clearSelection();
            }
        } else {
            JOptionPane.showMessageDialog(mainFarme, "Đã đến đầu danh sách", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void right() {
        String ID = txtms.getText();
        int index = findbyID1(ID) + 1;
        if (index > lsv.size() - 1) {
            index = 0;
            showdetail(index);
            if (index < 3) {
                findbyIndex(index);
            } else if (index >= 3) {
                tbldiem.clearSelection();
            }
        } else {
            showdetail(index);
            if (index < 3) {
                findbyIndex(index);
            } else if (index >= 3) {
                tbldiem.clearSelection();
            }
        }
    }

    public void endright() {
        String ID = txtms.getText();
        int index = findbyID1(ID);
        if (index != lsv.size() - 1) {
            index = lsv.size() - 1;
            showdetail(index);
            if (index < 3) {
                findbyIndex(index);
            } else if (index >= 3) {
                tbldiem.clearSelection();
            }
        } else {
            JOptionPane.showMessageDialog(mainFarme, "Đã đến cuối danh sách", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void filltotable() {
        DefaultTableModel model = (DefaultTableModel) tbldiem.getModel();
        addData();
        sv.sapxep(lsv);
        model.setRowCount(0);
        for (int i = 0; i < (lsv.size() < 3 ? lsv.size() : 3); i++) {
            Object[] rowdata = {lsv.get(i).getMasv(), lsv.get(i).getHovaten(), lsv.get(i).getToan(), lsv.get(i).getLi(), lsv.get(i).getHoa(), lsv.get(i).getTb()};
            model.addRow(rowdata);
        }
    }

    public void delete() {
        if (find(txtms.getText())) {
            if (findbyID(txtms.getText()) > -1) {
                int result = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa điểm sinh viên này không", "Cảnh báo", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/asm/Image/canhbao.png")));
                if (result == JOptionPane.YES_OPTION) {
                    sv.xoadiem(txtms.getText());
                    filltotable();
                    txttimkiem.setText("");
                    txtms.setText("");
                    txthvt.setText("");
                    txttoan.setText("");
                    txthoa.setText("");
                    txtli.setText("");
                    lbldiem.setText("");
                    tbldiem.clearSelection();
                    JOptionPane.showMessageDialog(mainFarme, "Xóa thành công điểm của sinh viên", "Delete", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/asm/Image/succes.png")));
                }
            } else {
                JOptionPane.showMessageDialog(mainFarme, "Sinh viên chưa có điểm. Không thể thực hiện thao tác.", "Delete", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/asm/Image/nosuc.png")));
            }
        } else {
            JOptionPane.showMessageDialog(mainFarme, "Mã số sinh viên không có dữ liệu. Không thể thực hiện thao tác.", "Delete", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/asm/Image/nosuc.png")));
        }
    }

    public void update() {
        if (find(txtms.getText())) {
            if (findbyID(txtms.getText()) > -1) {
                if (checkValidate()) {
                    double toan = Double.parseDouble(txttoan.getText());
                    double li = Double.parseDouble(txtli.getText());
                    double hoa = Double.parseDouble(txthoa.getText());
                    int result = JOptionPane.showConfirmDialog(null, "Bạn có muốn update điểm sinh viên này không", "Cảnh báo", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/asm/Image/canhbao.png")));
                    if (result == JOptionPane.YES_OPTION) {
                        sv.suadiem(txtms.getText(), toan, li, hoa);
                        filltotable();
                        showdetail(findbyID(txtms.getText()));
                        JOptionPane.showMessageDialog(mainFarme, "Update thành công điểm của sinh viên", "Update", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/asm/Image/succes.png")));
                    }
                }
            } else {
                JOptionPane.showMessageDialog(mainFarme, "Sinh viên chưa có điểm. Không thể thực hiện thao tác.", "Update", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/asm/Image/nosuc.png")));
            }
        } else {
            JOptionPane.showMessageDialog(mainFarme, "Mã số sinh viên không có dữ liệu. Không thể thực hiện thao tác.", "Update", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/asm/Image/nosuc.png")));
        }
    }

    public void create() {
        if (find(txtms.getText())) {
            if (findbyID(txtms.getText()) == -1) {
                if (checkValidate()) {
                    double toan = Double.parseDouble(txttoan.getText());
                    double li = Double.parseDouble(txtli.getText());
                    double hoa = Double.parseDouble(txthoa.getText());
                    int result = JOptionPane.showConfirmDialog(null, "Bạn có muốn lưu điểm sinh viên này không", "Cảnh báo", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/asm/Image/canhbao.png")));
                    if (result == JOptionPane.YES_OPTION) {
                        sv.themdiem(txtms.getText(), toan, li, hoa);
                        filltotable();
                        showdetail(findbyID(txtms.getText()));
                        JOptionPane.showMessageDialog(mainFarme, "Lưu điểm của sinh viên thành công", "Save", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/asm/Image/succes.png")));
                    }
                }
            } else {
                JOptionPane.showMessageDialog(mainFarme, "Sinh viên này đã có điểm. Vui lòng chọn Update.", "Save", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/asm/Image/nosuc.png")));
            }
        } else {
            JOptionPane.showMessageDialog(mainFarme, "Mã số sinh viên không có dữ liệu. Không thể thực hiện thao tác.", "Save", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/asm/Image/nosuc.png")));
        }
    }

    public boolean checkValidate() {

        try {
            double toan = Double.parseDouble(txttoan.getText());
            double li = Double.parseDouble(txtli.getText());
            double hoa = Double.parseDouble(txthoa.getText());
            if (toan <= 0 || toan > 10) {
                JOptionPane.showMessageDialog(mainFarme, "Điểm Toán trong khoảng từ 0.5 - 10", "Điểm", JOptionPane.INFORMATION_MESSAGE);
                txttoan.requestFocus();
                return false;
            }
            if (li <= 0 || li > 10) {
                JOptionPane.showMessageDialog(mainFarme, "Điểm Lí trong khoảng từ 0.5 - 10", "Điểm", JOptionPane.INFORMATION_MESSAGE);
                txtli.requestFocus();
                return false;
            }
            if (hoa <= 0 || hoa > 10) {
                JOptionPane.showMessageDialog(mainFarme, "Điểm Hóa trong khoảng từ 0.5 - 10", "Điểm", JOptionPane.INFORMATION_MESSAGE);
                txthoa.requestFocus();
                return false;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(mainFarme, "Vui lòng nhập điểm là số và dùng dấu . để phân cách phần thập phân", "ERROL", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public void setE(boolean x) {
        mainFarme.setVisible(x);
    }
}
