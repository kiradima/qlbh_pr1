/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command_pattern;

import entity.HoaDonNhapChiTiet;
import entity.MayTinh;
import entity.MayTinhChiTiet;
import entity.NhaCungCap;
import entity.NhanVien;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kira
 */
public class HoaDonNhapChiTietView extends javax.swing.JFrame {
    
    ArrayList<NhanVien> nhanViens;
    ArrayList<NhaCungCap> nhaCungCaps;
    private HoaDonNhapChiTietController controller;
    private HoaDonNhap hoaDonNhap;

    /**
     * Creates new form View
     */
    public HoaDonNhapChiTietView() {
        initComponents();
        this.setLocationRelativeTo(null);
        loadCbbMHDN();
        nhanViens = NhanVien.getAll();
        loadCbbNV(nhanViens);
        nhaCungCaps = NhaCungCap.getAll();
        loadCbbNCC(nhaCungCaps);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnChiTiet = new javax.swing.JButton();
        btnThongTin = new javax.swing.JButton();
        cbbListMHDN = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMHDN = new javax.swing.JTextField();
        txtTT = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        dateTG = new com.toedter.calendar.JDateChooser();
        cbbMNV = new javax.swing.JComboBox<>();
        txtTNV = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbbMNCC = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        txtTNCC = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table);

        btnChiTiet.setText("Chi tiết hóa đơn");
        btnChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietActionPerformed(evt);
            }
        });

        btnThongTin.setText("Thông tin");
        btnThongTin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongTinActionPerformed(evt);
            }
        });

        cbbListMHDN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbListMHDNActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Mã nhân viên : ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Mã hóa đơn nhập : ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Mã nhà cung cấp : ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Thời gian : ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Tổng tiền : ");

        txtMHDN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtTT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("HÓA ĐƠN NHẬP");

        dateTG.setDateFormatString("dd-MM-yyyy");
        dateTG.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        cbbMNV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbbMNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMNVActionPerformed(evt);
            }
        });

        txtTNV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTNVActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Tên nhân viên : ");

        cbbMNCC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbbMNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMNCCActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Tên nhà cung cấp : ");

        txtTNCC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTNCCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cbbListMHDN, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(241, 241, 241)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 72, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnChiTiet)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(btnThongTin)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbbMNV, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbMNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateTG, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                            .addComponent(txtTT, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMHDN))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTNV, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(126, 126, 126))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cbbMNCC, cbbMNV, dateTG, txtMHDN, txtTT});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbbListMHDN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 16, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel8)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel7)
                            .addComponent(txtTNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel14)
                            .addComponent(txtTNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtMHDN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jLabel2)
                                    .addComponent(cbbMNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jLabel4)
                                    .addComponent(cbbMNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(btnThongTin)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel5)
                            .addComponent(dateTG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel6)
                            .addComponent(txtTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addComponent(btnChiTiet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietActionPerformed
        // TODO add your handling code here:
        loadListChiTiet();
    }//GEN-LAST:event_btnChiTietActionPerformed

    private void btnThongTinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongTinActionPerformed
        // TODO add your handling code here:
        loadInfo();
    }//GEN-LAST:event_btnThongTinActionPerformed

    private void cbbListMHDNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbListMHDNActionPerformed
        // TODO add your handling code here:
        loadController();
    }//GEN-LAST:event_cbbListMHDNActionPerformed

    private void cbbMNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMNVActionPerformed
        // TODO insert your handling code here:
        // chọn mã -> show tên
        txtTNV.setText(nhanViens.get(cbbMNV.getSelectedIndex()).getTenNhanVien());
    }//GEN-LAST:event_cbbMNVActionPerformed

    private void txtTNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTNVActionPerformed
        // TODO insert your handling code here:
    }//GEN-LAST:event_txtTNVActionPerformed

    private void cbbMNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMNCCActionPerformed
        // TODO insert your handling code here:
        txtTNCC.setText(nhaCungCaps.get(cbbMNCC.getSelectedIndex()).getTenNhaCungCap());
    }//GEN-LAST:event_cbbMNCCActionPerformed

    private void txtTNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTNCCActionPerformed
        // TODO insert your handling code here:
    }//GEN-LAST:event_txtTNCCActionPerformed

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
            java.util.logging.Logger.getLogger(HoaDonNhapChiTietView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HoaDonNhapChiTietView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HoaDonNhapChiTietView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HoaDonNhapChiTietView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HoaDonNhapChiTietView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChiTiet;
    private javax.swing.JButton btnThongTin;
    private javax.swing.JComboBox<String> cbbListMHDN;
    private javax.swing.JComboBox<String> cbbMNCC;
    private javax.swing.JComboBox<String> cbbMNV;
    private com.toedter.calendar.JDateChooser dateTG;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtMHDN;
    private javax.swing.JTextField txtTNCC;
    private javax.swing.JTextField txtTNV;
    private javax.swing.JTextField txtTT;
    // End of variables declaration//GEN-END:variables

    private void loadListChiTiet() {
        controller.setCommand(new LoadTableCommand(hoaDonNhap));
        controller.load();
        showTable(hoaDonNhap.getHoaDonNhapChiTiets());
    }
    
    private void loadCbbMHDN() {
        ArrayList<HoaDonNhap> hoaDonNhaps = HoaDonNhap.getAll();
        for (HoaDonNhap hoaDonNhap : hoaDonNhaps) {
            cbbListMHDN.addItem(hoaDonNhap.getMaNhap() + "");
        }
    }
    
    private void showTable(ArrayList<HoaDonNhapChiTiet> hoaDonNhapChiTiets) {
        table.setEnabled(true);
        table.removeAll();
        String[] columns = new String[]{"TT", "Mã HĐN",
            "Mã MTCT", "Tên MT", "Đơn giá", "Số lượng", "Thành tiền"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        for (int i = 0; i < hoaDonNhapChiTiets.size(); i++) {
            HoaDonNhapChiTiet o = hoaDonNhapChiTiets.get(i);
            Vector vector = new Vector();
            vector.add(i + 1);
            vector.add(o.getMaNhap() + "");
            vector.add(o.getMaMayTinhChiTiet() + "");
            vector.add(MayTinh.get(MayTinhChiTiet.get(o.getMaMayTinhChiTiet())
                    .getMaMayTinh()).getTenMayTinh());
            vector.add(new DecimalFormat("###,###")
                    .format(MayTinhChiTiet.get(o.getMaMayTinhChiTiet())
                            .getGiaNhap()));
            vector.add(o.getSoLuong());
            vector.add(new DecimalFormat("###,###").format(o.getTongTien()) + "");
            model.addRow(vector);
        }
        table.setModel(model);
    }
    
    private void loadInfo() {
        controller.setCommand(new LoadInfoCommand(hoaDonNhap));
        controller.load();
        txtMHDN.setText(hoaDonNhap.getMaNhap() + "");
        for (int i = 0; i < nhanViens.size(); i++) {
            if (nhanViens.get(i).getMaNhanVien() == hoaDonNhap.getMaNhanVien()) {
                cbbMNV.setSelectedIndex(i);
                txtTNV.setText(nhanViens.get(i).getTenNhanVien());
                break;
            }
        }
        for (int i = 0; i < nhaCungCaps.size(); i++) {
            if (nhaCungCaps.get(i).getMaNhaCungCap() == hoaDonNhap.getMaNhaCungCap()) {
                cbbMNCC.setSelectedIndex(i);
                txtTNCC.setText(nhaCungCaps.get(i).getTenNhaCungCap());
                break;
            }
        }
        dateTG.setDate(hoaDonNhap.getThoiGian());
        txtTT.setText(new DecimalFormat("###,###").format(hoaDonNhap.getTongTien()));
    }
    
    private void loadCbbNV(ArrayList<NhanVien> list) {
        cbbMNV.removeAllItems();
        for (int i = 0; i < list.size(); i++) {
            cbbMNV.addItem(list.get(i).getMaNhanVien() + "");
        }
    }
    
    private void loadCbbNCC(ArrayList<NhaCungCap> list) {
        cbbMNCC.removeAllItems();
        for (int i = 0; i < list.size(); i++) {
            cbbMNCC.addItem(list.get(i).getMaNhaCungCap() + "");
        }
    }
    
    private void loadController() {
        hoaDonNhap = new HoaDonNhap();
        hoaDonNhap.setMaNhap(Integer.parseInt((String) cbbListMHDN.getSelectedItem()));
        controller = new HoaDonNhapChiTietController();
    }
}
