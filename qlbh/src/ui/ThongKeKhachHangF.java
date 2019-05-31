/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import entity.ThongKeKhachHangType;
import helper.ConnectDatabase;
import helper.WordHelper;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author hantr
 */
public class ThongKeKhachHangF extends javax.swing.JFrame {

    /**
     * Creates new form ThongKeKhachHangF
     */
    ConnectDatabase ketNoiQLlBH = null;
    Connection connection = null;
    ArrayList<ThongKeKhachHangType> listThongKe = new ArrayList<>();
    
    public ThongKeKhachHangF() {
        ketNoiQLlBH = new ConnectDatabase();
        connection = ketNoiQLlBH.getConnection();
        initComponents();
        this.setLocationRelativeTo(null);
        JTableHeader header = bangthongke.getTableHeader();
        header.setFont(new Font("Tahoma", Font.BOLD, 14));
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        tenchon = new javax.swing.JRadioButton();
        gioitinhchon = new javax.swing.JRadioButton();
        diachichon = new javax.swing.JRadioButton();
        namsinhchon = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        bangthongke = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("THỐNG KÊ KHÁCH HÀNG");

        buttonGroup1.add(tenchon);
        tenchon.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tenchon.setText("Tên khách hàng ");
        tenchon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tenchonActionPerformed(evt);
            }
        });

        buttonGroup1.add(gioitinhchon);
        gioitinhchon.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        gioitinhchon.setText("Giới tính");
        gioitinhchon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gioitinhchonActionPerformed(evt);
            }
        });

        buttonGroup1.add(diachichon);
        diachichon.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        diachichon.setText("Địa chỉ");
        diachichon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diachichonActionPerformed(evt);
            }
        });

        buttonGroup1.add(namsinhchon);
        namsinhchon.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        namsinhchon.setText("Năm sinh ");
        namsinhchon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namsinhchonActionPerformed(evt);
            }
        });

        bangthongke.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bangthongke.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(bangthongke);

        jButton1.setBackground(new java.awt.Color(102, 102, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("Xuất file");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(102, 102, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Quay lại");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(102, 102, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("Đăng xuất");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));

        jLabel12.setBackground(new java.awt.Color(204, 204, 204));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel12.setText("CỬA HÀNG MÁY VI TÍNH  K-P-T XIN CHÀO QUÝ KHÁCH !");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 0));
        jLabel15.setText("Nhóm1");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 0));
        jLabel16.setText("Đoàn Văn Tiến");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 0));
        jLabel17.setText("Hàn Trung Kiên");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 0));
        jLabel18.setText("Phan Hà Phương");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel12))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addGap(17, 17, 17)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton2)
                .addGap(237, 237, 237)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(tenchon)
                .addGap(89, 89, 89)
                .addComponent(gioitinhchon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(diachichon)
                .addGap(116, 116, 116)
                .addComponent(namsinhchon)
                .addGap(20, 20, 20))
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(240, 240, 240))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tenchon)
                            .addComponent(diachichon)
                            .addComponent(namsinhchon))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(gioitinhchon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void diachichonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diachichonActionPerformed
        // TODO add your handling code here:
        bangthongke.removeAll();
        String[] columns = {"Địa chỉ ", "Số lượng khách hàng"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        String sql = "SELECT diachi, count(maKhachHang)   FROM khachhang group by diachi order by count(maKhachHang) DESC ;";
        Statement statement = null;
        ResultSet resultSet = null;
        
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Vector vector = new Vector();
                vector.add(resultSet.getString("diachi"));
                vector.add(resultSet.getInt("count(maKhachHang)"));
                
                model.addRow(vector);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        bangthongke.setModel(model);
    }//GEN-LAST:event_diachichonActionPerformed

    private void gioitinhchonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gioitinhchonActionPerformed
        // TODO add your handling code here:
        bangthongke.removeAll();
        String[] columns = {"Giới tính ", "Số lượng khách hàng"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        String sql = "SELECT gioiTinh, count(maKhachHang)   FROM khachhang group by gioiTinh order by count(maKhachHang) DESC ;";
        Statement statement = null;
        ResultSet resultSet = null;
        
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Vector vector = new Vector();
                vector.add(resultSet.getString("gioiTinh"));
                vector.add(resultSet.getInt("count(maKhachHang)"));
                
                model.addRow(vector);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        bangthongke.setModel(model);
    }//GEN-LAST:event_gioitinhchonActionPerformed

    private void tenchonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tenchonActionPerformed
        // TODO add your handling code here:
        bangthongke.removeAll();
        String[] columns = {"Tên khách hàng ", "Số lượng khách hàng"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        String sql = "SELECT tenKhachHang, count(maKhachHang)   FROM khachhang group by tenKhachHang order by count(maKhachHang) DESC ;";
        Statement statement = null;
        ResultSet resultSet = null;
        
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Vector vector = new Vector();
                vector.add(resultSet.getString("tenKhachHang"));
                vector.add(resultSet.getInt("count(maKhachHang)"));
                
                model.addRow(vector);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        bangthongke.setModel(model);
    }//GEN-LAST:event_tenchonActionPerformed

    private void namsinhchonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namsinhchonActionPerformed
        // TODO add your handling code here:
        bangthongke.removeAll();
        String[] columns = {"Năm sinh ", "Số lượng khách hàng"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        String sql = "SELECT year(ngaySinh), count(maKhachHang)   FROM khachhang group by year(ngaySinh) order by count(maKhachHang) DESC ;";
        Statement statement = null;
        ResultSet resultSet = null;
        
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Vector vector = new Vector();
                vector.add(resultSet.getString("year(ngaySinh)"));
                vector.add(resultSet.getInt("count(maKhachHang)"));
                
                model.addRow(vector);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        bangthongke.setModel(model);
    }//GEN-LAST:event_namsinhchonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (tenchon.isSelected()) {
            try {
                listThongKe = ThongKeKhachHangType.getlist("tenKhachHang");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ThongKeKhachHangF.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ThongKeKhachHangF.class.getName()).log(Level.SEVERE, null, ex);
            }
            JFileChooser jFileChooser = new JFileChooser();
            if (jFileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                File file = jFileChooser.getSelectedFile();
                
                try {
                    WordHelper.writeKhachHangTheoTen(file, listThongKe, "Thống kê khách hàng theo tên");
                    JOptionPane.showMessageDialog(null, "Xuất file thành công");
                    
                } catch (IOException ex) {
                    Logger.getLogger(ThongKeKhachHangF.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, "Xuất file thất bại!");
                }
                
            }
        } else if (gioitinhchon.isSelected()) {
            try {
                listThongKe = ThongKeKhachHangType.getlist("gioiTinh");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ThongKeKhachHangF.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ThongKeKhachHangF.class.getName()).log(Level.SEVERE, null, ex);
            }
            JFileChooser jFileChooser = new JFileChooser();
            if (jFileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                File file = jFileChooser.getSelectedFile();
                
                try {
                    WordHelper.writeKhachHangTheoGioiTinh(file, listThongKe, "Thống kê khách hàng theo giới tính");
                    JOptionPane.showMessageDialog(null, "Xuất file thành công");
                    
                } catch (IOException ex) {
                    Logger.getLogger(ThongKeKhachHangF.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, "Xuất file thất bại!");
                }
                
            }
        } else if (diachichon.isSelected()) {
            try {
                listThongKe = ThongKeKhachHangType.getlist("diachi");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ThongKeKhachHangF.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ThongKeKhachHangF.class.getName()).log(Level.SEVERE, null, ex);
            }
            JFileChooser jFileChooser = new JFileChooser();
            if (jFileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                File file = jFileChooser.getSelectedFile();
                
                try {
                    WordHelper.writeKhachHangTheoDiaChi(file, listThongKe, "Thống kê khách hàng theo địa chỉ");
                    JOptionPane.showMessageDialog(null, "Xuất file thành công");
                    
                } catch (IOException ex) {
                    Logger.getLogger(ThongKeKhachHangF.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, "Xuất file thất bại!");
                }
                
            }
        } else if (namsinhchon.isSelected()) {
            try {
                listThongKe = ThongKeKhachHangType.getlist("year(ngaySinh)");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ThongKeKhachHangF.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ThongKeKhachHangF.class.getName()).log(Level.SEVERE, null, ex);
            }
            JFileChooser jFileChooser = new JFileChooser();
            if (jFileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                File file = jFileChooser.getSelectedFile();
                
                try {
                    WordHelper.writeKhachHangTheoNamSinh(file, listThongKe, "Thống kê khách hàng theo năm sinh");
                    JOptionPane.showMessageDialog(null, "Xuất file thành công");
                    
                } catch (IOException ex) {
                    Logger.getLogger(ThongKeKhachHangF.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, "Xuất file thất bại!");
                }
                
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new KhachHangF().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new DangNhap().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ThongKeKhachHangF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongKeKhachHangF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongKeKhachHangF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongKeKhachHangF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThongKeKhachHangF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bangthongke;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton diachichon;
    private javax.swing.JRadioButton gioitinhchon;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton namsinhchon;
    private javax.swing.JRadioButton tenchon;
    // End of variables declaration//GEN-END:variables
}
