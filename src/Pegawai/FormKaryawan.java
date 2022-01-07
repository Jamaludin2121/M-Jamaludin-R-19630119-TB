/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pegawai;

import java.awt.Color;
import java.awt.print.PrinterException;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksidb;

public class FormKaryawan extends javax.swing.JFrame {

    public Statement st;
    public ResultSet rs;
    public ResultSet rs1;
    public ResultSet rs2;
    public DefaultTableModel tabModel;
    Connection cn = koneksi.koneksidb.getkoneksi();
    
    public FormKaryawan() {
        initComponents();
        autokodekaryawan();
        judul();
        tampildata();
        hapus.setEnabled(false);
        ubah.setEnabled(false);
    }
    
    public void reset(){
        autokodekaryawan();
        nama.setText("");
        umur.setText("");
        jk.setSelectedIndex(0);
        jabatan.setSelectedIndex(0);
        alamat.setText("");
        cari.setText("");
        simpan.setEnabled(true);
        hapus.setEnabled(false);
        ubah.setEnabled(false);
    }
    private void autokodekaryawan(){
        try{
            String sql;
            sql = "SELECT COUNT(kd_karyawan) as jumlah FROM tb_karyawan";
            st = cn.createStatement();
            rs1 = st.executeQuery(sql);
            if(rs1.next()){
                String jumlah = rs1.getString("jumlah");
                int jumint = Integer.parseInt(String.valueOf(jumlah));
                if(jumint > 0){
                    st = cn.createStatement();
                    sql = "SELECT MAX(kd_karyawan) AS kode FROM tb_karyawan";
                    rs2 = st.executeQuery(sql);
                    if(rs2.next()){
                        String id = rs2.getString("kode").substring(2);
                        String kode = String.valueOf(Integer.parseInt(id) + 1);
                        if(kode.length() == 1){
                            lbl_kode.setText("KR00" + kode);
                        }else if(kode.length() == 2){
                            lbl_kode.setText("KR0" + kode);
                        }else{
                            lbl_kode.setText("KR" + kode);
                        }
                    }
                }else{
                    lbl_kode.setText("KR001");
                }
            }
        }catch(Exception a){
            JOptionPane.showMessageDialog(null, a.getMessage());
        }
    }
    public void judul(){
        Object[] judul = {"KODE","Nama Karyawan","Umur","Jenis Kelamin","Jabatan","Alamat"};
        tabModel = new DefaultTableModel(null,judul);
        tabel.setModel(tabModel);
    }
    public void tampildata(){
        try{
            st = cn.createStatement();
            tabModel.getDataVector().removeAllElements();
            tabModel.fireTableDataChanged();
            rs = st.executeQuery("SELECT * FROM tb_karyawan ORDER BY kd_karyawan ASC");
            while(rs.next()){
                Object[] data = {
                    rs.getString("kd_karyawan"),
                    rs.getString("nama_karyawan"),
                    rs.getString("umur"),
                    rs.getString("jenis_kelamin"),
                    rs.getString("jabatan"),
                    rs.getString("alamat")
                };
                tabModel.addRow(data);
            }
        }catch(Exception a){
            JOptionPane.showMessageDialog(null, a.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        back = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        jPanel3 = new javax.swing.JPanel();
        label2 = new java.awt.Label();
        lbl_kode = new javax.swing.JLabel();
        label3 = new java.awt.Label();
        nama = new javax.swing.JTextField();
        label4 = new java.awt.Label();
        umur = new javax.swing.JTextField();
        label5 = new java.awt.Label();
        jk = new javax.swing.JComboBox<>();
        label6 = new java.awt.Label();
        jabatan = new javax.swing.JComboBox<>();
        label7 = new java.awt.Label();
        alamat = new javax.swing.JTextField();
        cari = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        simpan = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        ubah = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        cetak = new javax.swing.JButton();

        jButton3.setBackground(new java.awt.Color(23, 32, 41));
        jButton3.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Ubah");
        jButton3.setBorder(null);
        jButton3.setContentAreaFilled(false);
        jButton3.setOpaque(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(225, 120));
        setMinimumSize(new java.awt.Dimension(900, 500));

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(64, 64));

        back.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        back.setText("Back");
        back.setToolTipText("");
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(back, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(back, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));

        label1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText("Input Data Karyawan");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(852, 394));

        label2.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        label2.setText("Kode-Karyawan");

        lbl_kode.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_kode.setText("KR000");

        label3.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        label3.setText("Nama Karyawan");

        nama.setBackground(new java.awt.Color(240, 240, 240));
        nama.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        nama.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nama.setBorder(null);
        nama.setPreferredSize(null);

        label4.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        label4.setText("Umur");

        umur.setBackground(new java.awt.Color(240, 240, 240));
        umur.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        umur.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        umur.setBorder(null);
        umur.setPreferredSize(null);
        umur.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                umurKeyTyped(evt);
            }
        });

        label5.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        label5.setText("Jenis Kelamin");

        jk.setBackground(new java.awt.Color(240, 240, 240));
        jk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Jenis", "Laki-laki", "Perempuan" }));
        jk.setBorder(null);

        label6.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        label6.setText("Jabatan");

        jabatan.setBackground(new java.awt.Color(240, 240, 240));
        jabatan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Jabatan", "General Manager", "Manager", "Supervisor", "Kepala Cabang", "General Affair", "Staf Administrasi", "Marketing" }));
        jabatan.setBorder(null);

        label7.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        label7.setText("Alamat");

        alamat.setBackground(new java.awt.Color(240, 240, 240));
        alamat.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        alamat.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        alamat.setBorder(null);
        alamat.setPreferredSize(null);

        cari.setBackground(new java.awt.Color(240, 240, 240));
        cari.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        cari.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cari.setBorder(null);
        cari.setPreferredSize(null);
        cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cariKeyReleased(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Cari");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        tabel.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        simpan.setBackground(new java.awt.Color(23, 32, 41));
        simpan.setForeground(new java.awt.Color(255, 255, 255));
        simpan.setText("Simpan");
        simpan.setBorder(null);
        simpan.setContentAreaFilled(false);
        simpan.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Pegawai/Unavailable_32px.png"))); // NOI18N
        simpan.setOpaque(true);
        simpan.setPreferredSize(new java.awt.Dimension(50, 40));
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        hapus.setBackground(new java.awt.Color(23, 32, 41));
        hapus.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        hapus.setForeground(new java.awt.Color(255, 255, 255));
        hapus.setText("Hapus");
        hapus.setBorder(null);
        hapus.setContentAreaFilled(false);
        hapus.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Pegawai/Unavailable_32px.png"))); // NOI18N
        hapus.setOpaque(true);
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        ubah.setBackground(new java.awt.Color(23, 32, 41));
        ubah.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        ubah.setForeground(new java.awt.Color(255, 255, 255));
        ubah.setText("Ubah");
        ubah.setBorder(null);
        ubah.setContentAreaFilled(false);
        ubah.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Pegawai/Unavailable_32px.png"))); // NOI18N
        ubah.setOpaque(true);
        ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahActionPerformed(evt);
            }
        });

        reset.setBackground(new java.awt.Color(23, 32, 41));
        reset.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        reset.setForeground(new java.awt.Color(255, 255, 255));
        reset.setText("Reset");
        reset.setBorder(null);
        reset.setContentAreaFilled(false);
        reset.setOpaque(true);
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        cetak.setBackground(new java.awt.Color(23, 32, 41));
        cetak.setForeground(new java.awt.Color(255, 255, 255));
        cetak.setText("Cetak");
        cetak.setBorder(null);
        cetak.setContentAreaFilled(false);
        cetak.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Pegawai/Unavailable_32px.png"))); // NOI18N
        cetak.setOpaque(true);
        cetak.setPreferredSize(new java.awt.Dimension(50, 40));
        cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jabatan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(umur, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                .addComponent(nama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jk, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(lbl_kode)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(ubah, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(176, 176, 176)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(cetak, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(204, 204, 204))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(lbl_kode)
                        .addGap(1, 1, 1)
                        .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(umur, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jk, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ubah, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cetak, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        FormMenuUtama menu = new FormMenuUtama();
        menu.setVisible(true);
        this.hide();
    }//GEN-LAST:event_backMouseClicked

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        if(nama.getText().equals("") | umur.getText().equals("") | jk.getSelectedIndex()==0 | jabatan.getSelectedIndex()==0 | alamat.getText().equals("") )
        {
            JOptionPane.showMessageDialog(null, "Harap isi data terlebih dahulu !");
            reset();
        }else{
            try{
                st = cn.createStatement();
                st.executeUpdate("INSERT INTO tb_karyawan VALUES('"+lbl_kode.getText()+"','"+nama.getText()+"','"+umur.getText()+"'"
                    + ",'"+jk.getSelectedItem()+"','"+jabatan.getSelectedItem()+"','"+alamat.getText()+"')");
                JOptionPane.showMessageDialog(null, "Data berhasil di input !");
                tampildata();
                reset();
            }catch(SQLException a){
                JOptionPane.showMessageDialog(null, a.getMessage());
            }
            
        }
        
    }//GEN-LAST:event_simpanActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        reset();
    }//GEN-LAST:event_resetActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        if(nama.getText().equals("")|umur.getText().equals("")|jk.getSelectedIndex()==0|jabatan.getSelectedIndex()==0|alamat.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Pilih data yang anda maksud !");
        }else{
            try{
                st = cn.createStatement();
                st.executeUpdate("DELETE FROM tb_karyawan WHERE kd_karyawan = '"+lbl_kode.getText()+"'");
                JOptionPane.showMessageDialog(null, "Data berhasil di hapus !");
                tampildata();
                reset();
            }catch(Exception a)
            {
                JOptionPane.showMessageDialog(null, a.getMessage());
            }
        }
            
    }//GEN-LAST:event_hapusActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        lbl_kode.setText(tabModel.getValueAt(tabel.getSelectedRow(),0)+"");
        nama.setText(tabModel.getValueAt(tabel.getSelectedRow(),1)+"");
        umur.setText(tabModel.getValueAt(tabel.getSelectedRow(),2)+"");
        jk.setSelectedItem(tabModel.getValueAt(tabel.getSelectedRow(),3)+"");
        jabatan.setSelectedItem(tabModel.getValueAt(tabel.getSelectedRow(),4)+"");
        alamat.setText(tabModel.getValueAt(tabel.getSelectedRow(),5)+"");
        
        simpan.setEnabled(false);
        hapus.setEnabled(true);
        ubah.setEnabled(true);
    }//GEN-LAST:event_tabelMouseClicked

    private void cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariKeyReleased
        try{
            st = cn.createStatement();
            tabModel.getDataVector().removeAllElements();
            tabModel.fireTableDataChanged();
            rs = st.executeQuery("SELECT * FROM tb_karyawan WHERE kd_karyawan like '%"+cari.getText()+"%' or nama_karyawan like '%"
                +cari.getText()+"%' or umur like '%"+cari.getText()+"%' or jenis_kelamin like '%"+cari.getText()+"%' or jabatan like '%"
                +cari.getText()+"%' or alamat like '%"+cari.getText()+"%'");
            while(rs.next()){
                Object[] data = {
                    rs.getString("kd_karyawan"),
                    rs.getString("nama_karyawan"),
                    rs.getString("umur"),
                    rs.getString("jenis_kelamin"),
                    rs.getString("jabatan"),
                    rs.getString("alamat")
                };
                tabModel.addRow(data);
            }
        }catch(Exception a){
            JOptionPane.showMessageDialog(null, a.getMessage());
        }
    }//GEN-LAST:event_cariKeyReleased

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
        try{
            st = cn.createStatement();
            st.executeUpdate("UPDATE tb_karyawan SET nama_karyawan='"+nama.getText()+"',umur='"+umur.getText()
                +"',jenis_kelamin='"+jk.getSelectedItem()+"',jabatan='"+jabatan.getSelectedItem()+"',alamat='"+
                alamat.getText()+"' WHERE kd_karyawan ='"+lbl_kode.getText()+"' ");
            JOptionPane.showMessageDialog(null, "Data berhasil di ubah !");
            tampildata();
            reset();
        }catch(Exception a){
            JOptionPane.showMessageDialog(null, a.getMessage());
        }
    }//GEN-LAST:event_ubahActionPerformed

    private void umurKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_umurKeyTyped
        if(!Character.isDigit(evt.getKeyChar())){
            evt.consume();
        }    
    }//GEN-LAST:event_umurKeyTyped

    private void cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakActionPerformed
        cetak();
    }//GEN-LAST:event_cetakActionPerformed

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
            java.util.logging.Logger.getLogger(FormKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormKaryawan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alamat;
    private javax.swing.JLabel back;
    private javax.swing.JTextField cari;
    private javax.swing.JButton cetak;
    private javax.swing.JButton hapus;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jabatan;
    private javax.swing.JComboBox<String> jk;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private javax.swing.JLabel lbl_kode;
    private javax.swing.JTextField nama;
    private javax.swing.JButton reset;
    private javax.swing.JButton simpan;
    private javax.swing.JTable tabel;
    private javax.swing.JButton ubah;
    private javax.swing.JTextField umur;
    // End of variables declaration//GEN-END:variables

public void cetak() {
        try {
            tabel.print(JTable.PrintMode.FIT_WIDTH, new MessageFormat("Data Karyawan"), null);
        } catch (PrinterException ex) {
            Logger.getLogger(FormKaryawan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
