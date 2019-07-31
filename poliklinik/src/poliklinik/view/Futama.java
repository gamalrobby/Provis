/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poliklinik.view;

import java.awt.Color;
import java.util.Date;  
import java.text.DateFormat;  
import java.text.SimpleDateFormat;
import java.util.Random;
import javax.swing.JOptionPane;
/**
 *
 * @author Gamal Robby
 */
public class Futama extends javax.swing.JFrame {

    /**
     * Creates new form Futama
     */
    public void validasilogin(){
        Session ses = new Session();
        lblNama.setText(ses.getNama_pegawai());
        if(ses.getPekerjaan().equalsIgnoreCase("dokter")){
            btnCMedik.setVisible(true);
            btnPenanganan.setVisible(true);
            btnPasien.setVisible(false);
            btnPegawai.setVisible(false);
            btnPembayaran.setVisible(false);
            btnObat.setVisible(false);
            btnCMedik.setBackground(new Color(39, 174, 96));
            bgDinamic.removeAll();
            bgDinamic.repaint();
            bgDinamic.revalidate();
            
            bgDinamic.add(pnlCMedik);
            bgDinamic.repaint();
            bgDinamic.revalidate();
        } else if (ses.getPekerjaan().equalsIgnoreCase("apoteker")){
            btnCMedik.setVisible(false);
            btnPenanganan.setVisible(false);
            btnPasien.setVisible(false);
            btnPegawai.setVisible(false);
            btnPembayaran.setVisible(true);
            btnObat.setVisible(true);
            btnPembayaran.setBackground(new Color(39, 174, 96));
            bgDinamic.removeAll();
            bgDinamic.repaint();
            bgDinamic.revalidate();
            
            bgDinamic.add(pnlPembayaran);
            bgDinamic.repaint();
            bgDinamic.revalidate();
        } else if (ses.getPekerjaan().equalsIgnoreCase("resepsionis")){
            btnCMedik.setVisible(false);
            btnPenanganan.setVisible(false);
            btnPasien.setVisible(true);
            btnPegawai.setVisible(false);
            btnPembayaran.setVisible(false);
            btnObat.setVisible(false);
            btnPasien.setBackground(new Color(39, 174, 96));
            bgDinamic.removeAll();
            bgDinamic.repaint();
            bgDinamic.revalidate();
            
            bgDinamic.add(pnlPasien);
            bgDinamic.repaint();
            bgDinamic.revalidate();
        } else if (ses.getPekerjaan().equalsIgnoreCase("admin")){
            btnCMedik.setVisible(false);
            btnPenanganan.setVisible(false);
            btnPasien.setVisible(true);
            btnPegawai.setVisible(true);
            btnPembayaran.setVisible(false);
            btnObat.setVisible(false);
            btnPasien.setBackground(new Color(39, 174, 96));
            bgDinamic.removeAll();
            bgDinamic.repaint();
            bgDinamic.revalidate();
            
            bgDinamic.add(pnlPasien);
            bgDinamic.repaint();
            bgDinamic.revalidate();
        }
    }
    private String getTanggal() {  
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        Date date = new Date();  
        return dateFormat.format(date);  
    }  
    public void tampildata_catatanmedik()
    {
        Database db = new Database();
        TableCatatanMedik cMedik = new TableCatatanMedik();
        cMedik.setData(db.tampil_semua_catatanmedik());
        tblCatatanMedik.setModel(cMedik);
    }
    
    public void tampildata_pilihobat()
    {
        Database db = new Database();
        TablePilihObat tObat = new TablePilihObat();
        tObat.setData(db.tampil_semua_pilihobat());
        tblPilihObat.setModel(tObat);
    }
    
    public void tampildata_pilihtindakan()
    {
        Database db = new Database();
        TablePilihTindakan tTindakan = new TablePilihTindakan();
        tTindakan.setData(db.tampil_semua_pilihtindakan());
        tblPilihTindakan.setModel(tTindakan);
    }
    
    public void tampildata_detail_obat()
    {
        Database db = new Database();
        TableDetailObat tDetailObat = new TableDetailObat();
        tDetailObat.setData(db.tampil_semua_detail_obat());
        tblDetailObat.setModel(tDetailObat);
    }
    
    public void tampildata_detail_tindakan()
    {
        Database db = new Database();
        TableDetailTindakan tDetailTindakan = new TableDetailTindakan();
        tDetailTindakan.setData(db.tampil_semua_detail_tindakan());
        tblDetailTindakan.setModel(tDetailTindakan);
    }
    
    public void tampildata_detail_resep_obat()
    {
        Database db = new Database();
        tableDetailResepTindakan tDetailTindakan = new tableDetailResepTindakan();
        tDetailTindakan.setData(db.tampil_semua_detail_tindakan());
        tblDetailResepTindakan.setModel(tDetailTindakan);
    }
    
    public void tampildata_detail_resep_tindakan()
    {
        Database db = new Database();
        tableDetailResepObat tDetailObat = new tableDetailResepObat();
        tDetailObat.setData(db.tampil_semua_detail_obat());
        tblDetailResepObat.setModel(tDetailObat);
    }
    
    public void random_no_resep(){
        Random angkaRandom = new Random(); 
        int hasil;
        char hasil2 = 0;
        String tampil = "";
        hasil = 1 + angkaRandom.nextInt(999999);
        for (int x = 1; x <= 4; x++) {
             hasil2 = (char) ('A' + Math.random() * ('Z' - 'A' + 1));
             tampil +=hasil2; 
        }
        txtNoresep.setText(tampil+String.valueOf(hasil));
    }
    
    public void random_kode_catatan(){
        Session ses = new Session();
        Random angkaRandom = new Random(); 
        int hasil;
        hasil = 1 + angkaRandom.nextInt(99999);
        int hasil2;
        hasil2 = 1 + angkaRandom.nextInt(99999);
        String tampil=(String.valueOf(hasil)+String.valueOf(hasil2));
        ses.setKode_catatan(tampil);
    }
    
    public Futama() {
        initComponents();
        validasilogin();
        lblTgl.setText("TGL : "+getTanggal());
        tampildata_catatanmedik();
        random_no_resep();
        tampildata_pilihobat();
        tampildata_pilihtindakan();
        tampildata_detail_resep_obat();
        tampildata_detail_resep_tindakan();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLeft = new javax.swing.JPanel();
        pnlLogo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnCMedik = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnPenanganan = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnPasien = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnPegawai = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnPembayaran = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnObat = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        pnlTop = new javax.swing.JPanel();
        lblNama = new javax.swing.JLabel();
        btnLogout = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        lblTgl = new javax.swing.JLabel();
        bgDinamic = new javax.swing.JPanel();
        pnlCMedik = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCatatanMedik = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tampilCatatanMedik = new javax.swing.JTextArea();
        txtSearchCmedik = new javax.swing.JTextField();
        jButton14 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        pnlPenanganan = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnTambahObatTindakan = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblDetailResepTindakan = new javax.swing.JTable();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblDetailResepObat = new javax.swing.JTable();
        lblNamaPasien = new javax.swing.JLabel();
        lblNoResep = new javax.swing.JLabel();
        btnCetak = new javax.swing.JButton();
        lblNoPasien = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtNoPasien = new javax.swing.JTextField();
        txtNoresep = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnPilihPasien = new javax.swing.JButton();
        btnBatalPasien = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        txtNamaPasien = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtAreaTambahCatatan = new javax.swing.JTextArea();
        btnSimpanCatatan = new javax.swing.JButton();
        btnUbahCatatan = new javax.swing.JButton();
        pnlPasien = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        pnlPegawai = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        pnlPembayaran = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        pnlObat = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        pnlPilihObat = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblPilihTindakan = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblPilihObat = new javax.swing.JTable();
        txtCariPilihTindakan = new javax.swing.JTextField();
        txtCariPilihObat = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        btnPilihObat = new javax.swing.JButton();
        btnPilihTindakan = new javax.swing.JButton();
        btnCariPilihTindakan = new javax.swing.JButton();
        btnCariPilihObat = new javax.swing.JButton();
        btnRefreshPiihObat = new javax.swing.JButton();
        btnRefreshPiihTindakan = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblDetailObat = new javax.swing.JTable();
        txtDetailObatJumlah = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtDetailObatAturan = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        btnSimpanDetailObat = new javax.swing.JButton();
        btnDetailObatHapus = new javax.swing.JButton();
        txtDetailObatNama = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblDetailTindakan = new javax.swing.JTable();
        btnHapusDetailTindakan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlLeft.setBackground(new java.awt.Color(13, 206, 112));
        pnlLeft.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlLogo.setBackground(new java.awt.Color(255, 255, 255));
        pnlLogo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poliklinik/image/poliklinik.png"))); // NOI18N
        pnlLogo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 70));

        pnlLeft.add(pnlLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 70));

        btnCMedik.setBackground(new java.awt.Color(13, 206, 112));
        btnCMedik.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCMedik.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCMedikMousePressed(evt);
            }
        });
        btnCMedik.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poliklinik/image/catatan.png"))); // NOI18N
        btnCMedik.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 70));

        jLabel5.setFont(new java.awt.Font("Clarendon BT", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("C. MEDIK");
        btnCMedik.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 110, 70));

        pnlLeft.add(btnCMedik, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 190, 70));

        btnPenanganan.setBackground(new java.awt.Color(13, 206, 112));
        btnPenanganan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPenanganan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnPenangananMousePressed(evt);
            }
        });
        btnPenanganan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poliklinik/image/resep.png"))); // NOI18N
        btnPenanganan.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 70));

        jLabel3.setFont(new java.awt.Font("Clarendon BT", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PENANGANAN");
        btnPenanganan.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 110, 70));

        pnlLeft.add(btnPenanganan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 190, 70));

        btnPasien.setBackground(new java.awt.Color(13, 206, 112));
        btnPasien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPasien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnPasienMousePressed(evt);
            }
        });
        btnPasien.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poliklinik/image/pasien.png"))); // NOI18N
        btnPasien.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 70));

        jLabel9.setFont(new java.awt.Font("Clarendon BT", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("PASIEN");
        btnPasien.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 110, 70));

        pnlLeft.add(btnPasien, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 190, 70));

        btnPegawai.setBackground(new java.awt.Color(13, 206, 112));
        btnPegawai.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPegawai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnPegawaiMousePressed(evt);
            }
        });
        btnPegawai.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poliklinik/image/pegawai.png"))); // NOI18N
        btnPegawai.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 70));

        jLabel7.setFont(new java.awt.Font("Clarendon BT", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("PEGAWAI");
        btnPegawai.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 110, 70));

        pnlLeft.add(btnPegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 190, 70));

        btnPembayaran.setBackground(new java.awt.Color(13, 206, 112));
        btnPembayaran.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPembayaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnPembayaranMousePressed(evt);
            }
        });
        btnPembayaran.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poliklinik/image/bill.png"))); // NOI18N
        btnPembayaran.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 70));

        jLabel11.setFont(new java.awt.Font("Clarendon BT", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("PEMBAYARAN");
        btnPembayaran.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 110, 70));

        pnlLeft.add(btnPembayaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 190, 70));

        btnObat.setBackground(new java.awt.Color(13, 206, 112));
        btnObat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnObat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnObatMousePressed(evt);
            }
        });
        btnObat.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poliklinik/image/medicine.png"))); // NOI18N
        btnObat.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 70));

        jLabel13.setFont(new java.awt.Font("Clarendon BT", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("OBAT");
        btnObat.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 110, 70));

        pnlLeft.add(btnObat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 190, 70));

        getContentPane().add(pnlLeft, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 700));

        pnlTop.setBackground(new java.awt.Color(255, 255, 255));
        pnlTop.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNama.setFont(new java.awt.Font("Clarendon BT", 0, 14)); // NOI18N
        lblNama.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNama.setText("Nama");
        pnlTop.add(lblNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 360, 30));

        btnLogout.setBackground(new java.awt.Color(13, 206, 112));
        btnLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogoutMouseExited(evt);
            }
        });
        btnLogout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setFont(new java.awt.Font("Clarendon BT", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("LOGOUT");
        btnLogout.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 70));

        pnlTop.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, 90, 70));

        lblTgl.setFont(new java.awt.Font("Clarendon BT", 0, 14)); // NOI18N
        lblTgl.setText("TGL");
        pnlTop.add(lblTgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 30));

        getContentPane().add(pnlTop, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 1010, 70));

        bgDinamic.setLayout(new java.awt.CardLayout());

        pnlCMedik.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblCatatanMedik.setModel(new javax.swing.table.DefaultTableModel(
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
        tblCatatanMedik.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblCatatanMedikMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblCatatanMedik);

        pnlCMedik.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 78, 660, 520));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Catatan Medik", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Clarendon BT", 0, 14))); // NOI18N

        tampilCatatanMedik.setEditable(false);
        tampilCatatanMedik.setColumns(20);
        tampilCatatanMedik.setLineWrap(true);
        tampilCatatanMedik.setRows(5);
        tampilCatatanMedik.setBorder(null);
        jScrollPane2.setViewportView(tampilCatatanMedik);

        pnlCMedik.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 80, 280, 520));
        pnlCMedik.add(txtSearchCmedik, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 190, 30));

        jButton14.setBackground(new java.awt.Color(13, 206, 112));
        jButton14.setForeground(new java.awt.Color(255, 255, 255));
        jButton14.setText("Cari");
        jButton14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton14.setFocusPainted(false);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        pnlCMedik.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, -1, 30));

        jButton16.setBackground(new java.awt.Color(13, 206, 112));
        jButton16.setForeground(new java.awt.Color(255, 255, 255));
        jButton16.setText("Refresh");
        jButton16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton16.setFocusPainted(false);
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        pnlCMedik.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 43, -1, 30));

        bgDinamic.add(pnlCMedik, "card2");

        pnlPenanganan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tambah Obat / Tindakan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Clarendon BT", 0, 14))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTambahObatTindakan.setBackground(new java.awt.Color(13, 206, 112));
        btnTambahObatTindakan.setForeground(new java.awt.Color(255, 255, 255));
        btnTambahObatTindakan.setText("Tambah Obat/Tindakan");
        btnTambahObatTindakan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTambahObatTindakan.setEnabled(false);
        btnTambahObatTindakan.setFocusPainted(false);
        btnTambahObatTindakan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahObatTindakanActionPerformed(evt);
            }
        });
        jPanel2.add(btnTambahObatTindakan, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, 70));

        pnlPenanganan.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 40, 270, 280));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detail Resep", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Clarendon BT", 0, 14))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDetailResepTindakan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Tindakan"
            }
        ));
        jScrollPane6.setViewportView(tblDetailResepTindakan);

        jPanel3.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 120, 220, 130));

        tblDetailResepObat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Obat", "Jumlah Obat", "Aturan Pakai"
            }
        ));
        jScrollPane10.setViewportView(tblDetailResepObat);

        jPanel3.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 550, 130));

        lblNamaPasien.setText("NAMA PASIEN :");
        jPanel3.add(lblNamaPasien, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        lblNoResep.setText("NO RESEP :");
        jPanel3.add(lblNoResep, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        btnCetak.setBackground(new java.awt.Color(13, 206, 112));
        btnCetak.setForeground(new java.awt.Color(255, 255, 255));
        btnCetak.setText("Cetak");
        btnCetak.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCetak.setEnabled(false);
        btnCetak.setFocusPainted(false);
        jPanel3.add(btnCetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 20, -1, -1));

        lblNoPasien.setText("NO PASIEN :");
        jPanel3.add(lblNoPasien, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        pnlPenanganan.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 910, 260));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Masukkan Nomor Pasien", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Clarendon BT", 0, 14))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(txtNoPasien, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 180, 30));

        txtNoresep.setEditable(false);
        jPanel4.add(txtNoresep, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 180, 30));

        jLabel14.setFont(new java.awt.Font("Clarendon BT", 0, 12)); // NOI18N
        jLabel14.setText("No Pasien");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel15.setFont(new java.awt.Font("Clarendon BT", 0, 12)); // NOI18N
        jLabel15.setText("No Resep");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        btnPilihPasien.setBackground(new java.awt.Color(13, 206, 112));
        btnPilihPasien.setForeground(new java.awt.Color(255, 255, 255));
        btnPilihPasien.setText("Pilih");
        btnPilihPasien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPilihPasien.setFocusPainted(false);
        btnPilihPasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPilihPasienActionPerformed(evt);
            }
        });
        jPanel4.add(btnPilihPasien, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 60, -1));

        btnBatalPasien.setBackground(new java.awt.Color(13, 206, 112));
        btnBatalPasien.setForeground(new java.awt.Color(255, 255, 255));
        btnBatalPasien.setText("Batal");
        btnBatalPasien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBatalPasien.setEnabled(false);
        btnBatalPasien.setFocusPainted(false);
        btnBatalPasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalPasienActionPerformed(evt);
            }
        });
        jPanel4.add(btnBatalPasien, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, -1, -1));

        jLabel28.setFont(new java.awt.Font("Clarendon BT", 0, 12)); // NOI18N
        jLabel28.setText("Nama Pasien");
        jPanel4.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        txtNamaPasien.setEditable(false);
        jPanel4.add(txtNamaPasien, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 180, 30));

        pnlPenanganan.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 310, 280));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tambah Catatan Medik", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Clarendon BT", 0, 14))); // NOI18N
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtAreaTambahCatatan.setEditable(false);
        txtAreaTambahCatatan.setColumns(20);
        txtAreaTambahCatatan.setLineWrap(true);
        txtAreaTambahCatatan.setRows(5);
        jScrollPane4.setViewportView(txtAreaTambahCatatan);

        jPanel6.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 250, 170));

        btnSimpanCatatan.setBackground(new java.awt.Color(13, 206, 112));
        btnSimpanCatatan.setForeground(new java.awt.Color(255, 255, 255));
        btnSimpanCatatan.setText("Simpan");
        btnSimpanCatatan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSimpanCatatan.setEnabled(false);
        btnSimpanCatatan.setFocusPainted(false);
        btnSimpanCatatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanCatatanActionPerformed(evt);
            }
        });
        jPanel6.add(btnSimpanCatatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, -1, -1));

        btnUbahCatatan.setBackground(new java.awt.Color(13, 206, 112));
        btnUbahCatatan.setForeground(new java.awt.Color(255, 255, 255));
        btnUbahCatatan.setText("Ubah");
        btnUbahCatatan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUbahCatatan.setEnabled(false);
        btnUbahCatatan.setFocusPainted(false);
        jPanel6.add(btnUbahCatatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 70, -1));

        pnlPenanganan.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 290, 280));

        bgDinamic.add(pnlPenanganan, "card3");

        jLabel20.setText("pasien");

        javax.swing.GroupLayout pnlPasienLayout = new javax.swing.GroupLayout(pnlPasien);
        pnlPasien.setLayout(pnlPasienLayout);
        pnlPasienLayout.setHorizontalGroup(
            pnlPasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPasienLayout.createSequentialGroup()
                .addGap(321, 321, 321)
                .addComponent(jLabel20)
                .addContainerGap(658, Short.MAX_VALUE))
        );
        pnlPasienLayout.setVerticalGroup(
            pnlPasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPasienLayout.createSequentialGroup()
                .addGap(302, 302, 302)
                .addComponent(jLabel20)
                .addContainerGap(314, Short.MAX_VALUE))
        );

        bgDinamic.add(pnlPasien, "card4");

        jLabel21.setText("pegawai");

        javax.swing.GroupLayout pnlPegawaiLayout = new javax.swing.GroupLayout(pnlPegawai);
        pnlPegawai.setLayout(pnlPegawaiLayout);
        pnlPegawaiLayout.setHorizontalGroup(
            pnlPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPegawaiLayout.createSequentialGroup()
                .addGap(249, 249, 249)
                .addComponent(jLabel21)
                .addContainerGap(721, Short.MAX_VALUE))
        );
        pnlPegawaiLayout.setVerticalGroup(
            pnlPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPegawaiLayout.createSequentialGroup()
                .addContainerGap(330, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addGap(286, 286, 286))
        );

        bgDinamic.add(pnlPegawai, "card5");

        jLabel22.setText("pembayaran");

        javax.swing.GroupLayout pnlPembayaranLayout = new javax.swing.GroupLayout(pnlPembayaran);
        pnlPembayaran.setLayout(pnlPembayaranLayout);
        pnlPembayaranLayout.setHorizontalGroup(
            pnlPembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPembayaranLayout.createSequentialGroup()
                .addGap(297, 297, 297)
                .addComponent(jLabel22)
                .addContainerGap(653, Short.MAX_VALUE))
        );
        pnlPembayaranLayout.setVerticalGroup(
            pnlPembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPembayaranLayout.createSequentialGroup()
                .addGap(287, 287, 287)
                .addComponent(jLabel22)
                .addContainerGap(329, Short.MAX_VALUE))
        );

        bgDinamic.add(pnlPembayaran, "card6");

        jLabel23.setText("onbat");

        javax.swing.GroupLayout pnlObatLayout = new javax.swing.GroupLayout(pnlObat);
        pnlObat.setLayout(pnlObatLayout);
        pnlObatLayout.setHorizontalGroup(
            pnlObatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlObatLayout.createSequentialGroup()
                .addGap(419, 419, 419)
                .addComponent(jLabel23)
                .addContainerGap(563, Short.MAX_VALUE))
        );
        pnlObatLayout.setVerticalGroup(
            pnlObatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlObatLayout.createSequentialGroup()
                .addContainerGap(322, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addGap(294, 294, 294))
        );

        bgDinamic.add(pnlObat, "card7");

        pnlPilihObat.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pilih Obat/ Tindakan Pasien", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Clarendon BT", 0, 14))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblPilihTindakan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Kode Tindakan", "Tindakan"
            }
        ));
        jScrollPane7.setViewportView(tblPilihTindakan);

        jPanel5.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 340, 130));

        tblPilihObat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Kode Obat", "Obat"
            }
        ));
        jScrollPane8.setViewportView(tblPilihObat);

        jPanel5.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 320, 130));
        jPanel5.add(txtCariPilihTindakan, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 180, 30));
        jPanel5.add(txtCariPilihObat, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 180, 30));

        jLabel16.setFont(new java.awt.Font("Clarendon BT", 0, 12)); // NOI18N
        jLabel16.setText("Cari Obat");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel17.setFont(new java.awt.Font("Clarendon BT", 0, 12)); // NOI18N
        jLabel17.setText("Cari Tindakan");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, -1, -1));

        btnPilihObat.setBackground(new java.awt.Color(13, 206, 112));
        btnPilihObat.setForeground(new java.awt.Color(255, 255, 255));
        btnPilihObat.setText("Pilih Obat");
        btnPilihObat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPilihObat.setFocusPainted(false);
        btnPilihObat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPilihObatActionPerformed(evt);
            }
        });
        jPanel5.add(btnPilihObat, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 100, -1));

        btnPilihTindakan.setBackground(new java.awt.Color(13, 206, 112));
        btnPilihTindakan.setForeground(new java.awt.Color(255, 255, 255));
        btnPilihTindakan.setText("Pilih Tindakan");
        btnPilihTindakan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPilihTindakan.setFocusPainted(false);
        btnPilihTindakan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPilihTindakanActionPerformed(evt);
            }
        });
        jPanel5.add(btnPilihTindakan, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, -1, -1));

        btnCariPilihTindakan.setBackground(new java.awt.Color(13, 206, 112));
        btnCariPilihTindakan.setForeground(new java.awt.Color(255, 255, 255));
        btnCariPilihTindakan.setText("Cari");
        btnCariPilihTindakan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCariPilihTindakan.setFocusPainted(false);
        btnCariPilihTindakan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariPilihTindakanActionPerformed(evt);
            }
        });
        jPanel5.add(btnCariPilihTindakan, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 30, -1, 30));

        btnCariPilihObat.setBackground(new java.awt.Color(13, 206, 112));
        btnCariPilihObat.setForeground(new java.awt.Color(255, 255, 255));
        btnCariPilihObat.setText("Cari");
        btnCariPilihObat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCariPilihObat.setFocusPainted(false);
        btnCariPilihObat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariPilihObatActionPerformed(evt);
            }
        });
        jPanel5.add(btnCariPilihObat, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, -1, 30));

        btnRefreshPiihObat.setBackground(new java.awt.Color(13, 206, 112));
        btnRefreshPiihObat.setForeground(new java.awt.Color(255, 255, 255));
        btnRefreshPiihObat.setText("Refresh");
        btnRefreshPiihObat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRefreshPiihObat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshPiihObatActionPerformed(evt);
            }
        });
        jPanel5.add(btnRefreshPiihObat, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 90, -1));

        btnRefreshPiihTindakan.setBackground(new java.awt.Color(13, 206, 112));
        btnRefreshPiihTindakan.setForeground(new java.awt.Color(255, 255, 255));
        btnRefreshPiihTindakan.setText("Refresh");
        btnRefreshPiihTindakan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRefreshPiihTindakan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshPiihTindakanActionPerformed(evt);
            }
        });
        jPanel5.add(btnRefreshPiihTindakan, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 220, 90, -1));

        pnlPilihObat.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 720, 260));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tambah Aturan Pakai / Hapus Obat", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Clarendon BT", 0, 14))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDetailObat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Kode Obat", "Nama Obat", "Jumlah", "Harga", "Aturan Pakai"
            }
        ));
        tblDetailObat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblDetailObatMousePressed(evt);
            }
        });
        jScrollPane9.setViewportView(tblDetailObat);

        jPanel1.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 550, 210));
        jPanel1.add(txtDetailObatJumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 80, 100, 30));

        jLabel18.setFont(new java.awt.Font("Clarendon BT", 0, 12)); // NOI18N
        jLabel18.setText("Jumlah Obat");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 90, -1, -1));
        jPanel1.add(txtDetailObatAturan, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 130, 220, 30));

        jLabel19.setFont(new java.awt.Font("Clarendon BT", 0, 12)); // NOI18N
        jLabel19.setText("Aturan Pakai");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 140, -1, -1));

        btnSimpanDetailObat.setBackground(new java.awt.Color(13, 206, 112));
        btnSimpanDetailObat.setForeground(new java.awt.Color(255, 255, 255));
        btnSimpanDetailObat.setText("Simpan");
        btnSimpanDetailObat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSimpanDetailObat.setFocusPainted(false);
        btnSimpanDetailObat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanDetailObatActionPerformed(evt);
            }
        });
        jPanel1.add(btnSimpanDetailObat, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 180, 80, 30));

        btnDetailObatHapus.setBackground(new java.awt.Color(13, 206, 112));
        btnDetailObatHapus.setForeground(new java.awt.Color(255, 255, 255));
        btnDetailObatHapus.setText("Hapus");
        btnDetailObatHapus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDetailObatHapus.setFocusPainted(false);
        btnDetailObatHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailObatHapusActionPerformed(evt);
            }
        });
        jPanel1.add(btnDetailObatHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(663, 183, 80, 30));

        txtDetailObatNama.setEditable(false);
        jPanel1.add(txtDetailObatNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 30, 220, 30));

        jLabel27.setFont(new java.awt.Font("Clarendon BT", 0, 12)); // NOI18N
        jLabel27.setText("Nama Obat");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, -1, -1));

        pnlPilihObat.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 340, 970, 270));

        jButton9.setBackground(new java.awt.Color(13, 206, 112));
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("<= Kembali");
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.setFocusPainted(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        pnlPilihObat.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 100, 30));

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tindakan Pada Pasien", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Clarendon BT", 0, 14))); // NOI18N
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDetailTindakan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Kode Tindakan", "Tindakan"
            }
        ));
        jScrollPane11.setViewportView(tblDetailTindakan);

        jPanel7.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 220, 170));

        btnHapusDetailTindakan.setBackground(new java.awt.Color(13, 206, 112));
        btnHapusDetailTindakan.setForeground(new java.awt.Color(255, 255, 255));
        btnHapusDetailTindakan.setText("Hapus");
        btnHapusDetailTindakan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHapusDetailTindakan.setFocusPainted(false);
        btnHapusDetailTindakan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusDetailTindakanActionPerformed(evt);
            }
        });
        jPanel7.add(btnHapusDetailTindakan, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 80, 30));

        pnlPilihObat.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 70, 240, 260));

        bgDinamic.add(pnlPilihObat, "card8");

        getContentPane().add(bgDinamic, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 1010, 630));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
        // TODO add your handling code here:
        login login = new login();
        login.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnLogoutMouseClicked

    private void btnLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseEntered
        // TODO add your handling code here:
        btnLogout.setBackground(new Color(46, 213, 115));
    }//GEN-LAST:event_btnLogoutMouseEntered

    private void btnLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseExited
        // TODO add your handling code here:
        btnLogout.setBackground(new Color(13,206,112));
    }//GEN-LAST:event_btnLogoutMouseExited

    private void btnCMedikMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCMedikMousePressed
        // TODO add your handling code here:
        btnCMedik.setBackground(new Color(39, 174, 96));
        btnPenanganan.setBackground(new Color(13,206,112));
        bgDinamic.removeAll();
        bgDinamic.repaint();
        bgDinamic.revalidate();
            
        bgDinamic.add(pnlCMedik);
        bgDinamic.repaint();
        bgDinamic.revalidate();
    }//GEN-LAST:event_btnCMedikMousePressed

    private void btnPenangananMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPenangananMousePressed
        // TODO add your handling code here:
        btnCMedik.setBackground(new Color(13,206,112));
        btnPenanganan.setBackground(new Color(39, 174, 96));
        bgDinamic.removeAll();
        bgDinamic.repaint();
        bgDinamic.revalidate();
 
        bgDinamic.add(pnlPenanganan);
        bgDinamic.repaint();
        bgDinamic.revalidate();
        tampildata_detail_resep_obat();
        tampildata_detail_resep_tindakan();
    }//GEN-LAST:event_btnPenangananMousePressed

    private void btnPasienMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPasienMousePressed
        // TODO add your handling code here:
        btnPasien.setBackground(new Color(39, 174, 96));
        btnPegawai.setBackground(new Color(13,206,112));
        bgDinamic.removeAll();
        bgDinamic.repaint();
        bgDinamic.revalidate();
 
        bgDinamic.add(pnlPasien);
        bgDinamic.repaint();
        bgDinamic.revalidate();
    }//GEN-LAST:event_btnPasienMousePressed

    private void btnPegawaiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPegawaiMousePressed
        // TODO add your handling code here:
        btnPasien.setBackground(new Color(13,206,112));
        btnPegawai.setBackground(new Color(39, 174, 96));
        bgDinamic.removeAll();
        bgDinamic.repaint();
        bgDinamic.revalidate();
 
        bgDinamic.add(pnlPegawai);
        bgDinamic.repaint();
        bgDinamic.revalidate();
    }//GEN-LAST:event_btnPegawaiMousePressed

    private void btnPembayaranMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPembayaranMousePressed
        // TODO add your handling code here:
        btnPembayaran.setBackground(new Color(39, 174, 96));
        btnObat.setBackground(new Color(13,206,112));
        bgDinamic.removeAll();
        bgDinamic.repaint();
        bgDinamic.revalidate();
 
        bgDinamic.add(pnlPembayaran);
        bgDinamic.repaint();
        bgDinamic.revalidate();
    }//GEN-LAST:event_btnPembayaranMousePressed

    private void btnObatMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnObatMousePressed
        // TODO add your handling code here:
        btnPembayaran.setBackground(new Color(13,206,112));
        btnObat.setBackground(new Color(39, 174, 96));
        bgDinamic.removeAll();
        bgDinamic.repaint();
        bgDinamic.revalidate();
 
        bgDinamic.add(pnlObat);
        bgDinamic.repaint();
        bgDinamic.revalidate();
    }//GEN-LAST:event_btnObatMousePressed

    private void btnTambahObatTindakanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahObatTindakanActionPerformed
        // TODO add your handling code here:
        bgDinamic.removeAll();
        bgDinamic.repaint();
        bgDinamic.revalidate();
 
        bgDinamic.add(pnlPilihObat);
        bgDinamic.repaint();
        bgDinamic.revalidate();
    }//GEN-LAST:event_btnTambahObatTindakanActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        bgDinamic.removeAll();
        bgDinamic.repaint();
        bgDinamic.revalidate();
 
        bgDinamic.add(pnlPenanganan);
        bgDinamic.repaint();
        bgDinamic.revalidate();
        tampildata_detail_resep_obat();
        tampildata_detail_resep_tindakan();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void tblCatatanMedikMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCatatanMedikMousePressed
        // TODO add your handling code here:
        int i = tblCatatanMedik.getSelectedRow();
        if (i>-1){
            tampilCatatanMedik.setText(tblCatatanMedik.getValueAt(i, 5).toString());
        }
    }//GEN-LAST:event_tblCatatanMedikMousePressed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        Database db = new Database();
        TableCatatanMedik tabelCmedik = new TableCatatanMedik();
        String katakunci=txtSearchCmedik.getText();
        if (katakunci!=null){
            tabelCmedik.setData(db.cari_catatanmedik(katakunci));
            tabelCmedik.fireTableDataChanged();
            tblCatatanMedik.setModel(tabelCmedik);
        }
        txtSearchCmedik.setText("");
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        tampildata_catatanmedik();
    }//GEN-LAST:event_jButton16ActionPerformed

    private void btnPilihPasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPilihPasienActionPerformed
        // TODO add your handling code here:
        Session ses = new Session();
        Database db = new Database();
        ses.setNo_resep(txtNoresep.getText());
        db.tambah_resep(new resep(txtNoresep.getText(),ses.getNip(),txtNoPasien.getText().toUpperCase()));
        btnPilihPasien.setEnabled(false);
        btnBatalPasien.setEnabled(true);
        txtNoPasien.setEditable(false);
        txtAreaTambahCatatan.setEditable(true);
        btnSimpanCatatan.setEnabled(true);
        btnTambahObatTindakan.setEnabled(true);
        btnCetak.setEnabled(true);
        tampildata_detail_obat();
        tampildata_detail_tindakan();
        db.tampil_nama_pasien(txtNoPasien.getText());
        txtNamaPasien.setText(ses.getNama_pasien());
        lblNoResep.setText("NO RESEP : "+txtNoresep.getText());
        lblNoPasien.setText("NO PASIEN : "+txtNoPasien.getText());
        lblNamaPasien.setText("NAMA PASIEN : "+txtNamaPasien.getText());
    }//GEN-LAST:event_btnPilihPasienActionPerformed

    private void btnBatalPasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalPasienActionPerformed
        // TODO add your handling code here:
        Session ses = new Session();
        ses.setNo_pasien(null);
        Database db = new Database();
        db.hapus_resep(txtNoresep.getText().toUpperCase());
        btnPilihPasien.setEnabled(true);
        btnBatalPasien.setEnabled(false);
        txtNoPasien.setEditable(true);
        txtAreaTambahCatatan.setEditable(false);
        btnSimpanCatatan.setEnabled(false);
        btnUbahCatatan.setEnabled(false);
        btnTambahObatTindakan.setEnabled(false);
        btnCetak.setEnabled(false);
        txtNamaPasien.setText("");
        tampildata_detail_obat();
        tampildata_detail_tindakan();
        tampildata_detail_resep_obat();
        tampildata_detail_resep_tindakan();
        lblNoResep.setText("NO RESEP : ");
        lblNoPasien.setText("NO PASIEN : ");
        lblNamaPasien.setText("NAMA PASIEN : ");
    }//GEN-LAST:event_btnBatalPasienActionPerformed

    private void btnSimpanCatatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanCatatanActionPerformed
        // TODO add your handling code here:
        btnUbahCatatan.setEnabled(true);
        btnSimpanCatatan.setEnabled(false);
        random_kode_catatan();
        Session ses = new Session();
        ses.setCatatan(txtAreaTambahCatatan.getText());
        Database db = new Database();
        db.tambah_catatan();
    }//GEN-LAST:event_btnSimpanCatatanActionPerformed

    private void btnCariPilihObatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariPilihObatActionPerformed
        // TODO add your handling code here:
        Database db = new Database();
        TablePilihObat tblcariPilihObat = new TablePilihObat();
        String katakunci=txtCariPilihObat.getText();
        if (katakunci!=null){
            tblcariPilihObat.setData(db.cari_PilihObat(katakunci));
            tblcariPilihObat.fireTableDataChanged();
            tblPilihObat.setModel(tblcariPilihObat);
        }
        txtCariPilihObat.setText("");
    }//GEN-LAST:event_btnCariPilihObatActionPerformed

    private void btnRefreshPiihObatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshPiihObatActionPerformed
        // TODO add your handling code here:
        tampildata_pilihobat();
    }//GEN-LAST:event_btnRefreshPiihObatActionPerformed

    private void btnCariPilihTindakanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariPilihTindakanActionPerformed
        // TODO add your handling code here:
        Database db = new Database();
        TablePilihTindakan tblcariPilihTindakan = new TablePilihTindakan();
        String katakunci=txtCariPilihTindakan.getText();
        if (katakunci!=null){
            tblcariPilihTindakan.setData(db.cari_PilihTindakan(katakunci));
            tblcariPilihTindakan.fireTableDataChanged();
            tblPilihTindakan.setModel(tblcariPilihTindakan);
        }
        txtCariPilihTindakan.setText("");
    }//GEN-LAST:event_btnCariPilihTindakanActionPerformed

    private void btnRefreshPiihTindakanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshPiihTindakanActionPerformed
        // TODO add your handling code here:
        tampildata_pilihtindakan();
    }//GEN-LAST:event_btnRefreshPiihTindakanActionPerformed

    private void btnPilihObatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPilihObatActionPerformed
        // TODO add your handling code here:
        try {
            Database db = new Database();
            Session ses = new Session();
            int baris = tblPilihObat.getSelectedRow();
            String kode_obat = (String)tblPilihObat.getValueAt(baris, 0);
            ses.setKode_obat(kode_obat);
            db.tambah_detail_obat();
            tampildata_detail_obat();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Pilih Obat Yang Dibutuhkan");
        }
    }//GEN-LAST:event_btnPilihObatActionPerformed

    private void tblDetailObatMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDetailObatMousePressed
        // TODO add your handling code here:
        int i = tblDetailObat.getSelectedRow();
        if (i>-1){
            txtDetailObatNama.setText(tblDetailObat.getValueAt(i, 1).toString());
        }
        
    }//GEN-LAST:event_tblDetailObatMousePressed

    private void btnSimpanDetailObatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanDetailObatActionPerformed
        // TODO add your handling code here:
        Database db = new Database();
        int i = tblDetailObat.getSelectedRow();
        int harga = 0;
        int jumlah;
        int total;
        String kode_obat = null;
        String aturan;
        if (i>-1){
            kode_obat=tblDetailObat.getValueAt(i, 0).toString();
            harga=Integer.valueOf(tblDetailObat.getValueAt(i, 3).toString());
        }
        jumlah=Integer.valueOf(txtDetailObatJumlah.getText());
        aturan=txtDetailObatAturan.getText();
        total = harga*jumlah;
        db.update_detail_obat(kode_obat,jumlah, aturan, total);
        tampildata_detail_obat();
    }//GEN-LAST:event_btnSimpanDetailObatActionPerformed

    private void btnDetailObatHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailObatHapusActionPerformed
        // TODO add your handling code here:
        Database db = new Database();
        int i = tblDetailObat.getSelectedRow();
        String kode_obat = null;
        if (i>-1){
            kode_obat=tblDetailObat.getValueAt(i, 0).toString();
        }
        db.hapus_detail_obat(kode_obat);
        tampildata_detail_obat();
    }//GEN-LAST:event_btnDetailObatHapusActionPerformed

    private void btnPilihTindakanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPilihTindakanActionPerformed
        // TODO add your handling code here:
        Database db = new Database();
         int i = tblPilihTindakan.getSelectedRow();
          String kode_tindakan = null;
         if (i>-1){
            kode_tindakan=tblPilihTindakan.getValueAt(i, 0).toString();
        }
         db.tambah_detail_tindakan(kode_tindakan);
         tampildata_detail_tindakan();
    }//GEN-LAST:event_btnPilihTindakanActionPerformed

    private void btnHapusDetailTindakanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusDetailTindakanActionPerformed
        // TODO add your handling code here:
        Database db = new Database();
        int i = tblDetailTindakan.getSelectedRow();
        String kode_tindakan = null;
        if (i>-1){
            kode_tindakan=tblDetailTindakan.getValueAt(i, 0).toString();
        }
        db.hapus_detail_tindakan(kode_tindakan);
        tampildata_detail_tindakan();
    }//GEN-LAST:event_btnHapusDetailTindakanActionPerformed

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
                if ("windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Futama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Futama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Futama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Futama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Futama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgDinamic;
    private javax.swing.JButton btnBatalPasien;
    private javax.swing.JPanel btnCMedik;
    private javax.swing.JButton btnCariPilihObat;
    private javax.swing.JButton btnCariPilihTindakan;
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnDetailObatHapus;
    private javax.swing.JButton btnHapusDetailTindakan;
    private javax.swing.JPanel btnLogout;
    private javax.swing.JPanel btnObat;
    private javax.swing.JPanel btnPasien;
    private javax.swing.JPanel btnPegawai;
    private javax.swing.JPanel btnPembayaran;
    private javax.swing.JPanel btnPenanganan;
    private javax.swing.JButton btnPilihObat;
    private javax.swing.JButton btnPilihPasien;
    private javax.swing.JButton btnPilihTindakan;
    private javax.swing.JButton btnRefreshPiihObat;
    private javax.swing.JButton btnRefreshPiihTindakan;
    private javax.swing.JButton btnSimpanCatatan;
    private javax.swing.JButton btnSimpanDetailObat;
    private javax.swing.JButton btnTambahObatTindakan;
    private javax.swing.JButton btnUbahCatatan;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblNamaPasien;
    private javax.swing.JLabel lblNoPasien;
    private javax.swing.JLabel lblNoResep;
    private javax.swing.JLabel lblTgl;
    private javax.swing.JPanel pnlCMedik;
    private javax.swing.JPanel pnlLeft;
    private javax.swing.JPanel pnlLogo;
    private javax.swing.JPanel pnlObat;
    private javax.swing.JPanel pnlPasien;
    private javax.swing.JPanel pnlPegawai;
    private javax.swing.JPanel pnlPembayaran;
    private javax.swing.JPanel pnlPenanganan;
    private javax.swing.JPanel pnlPilihObat;
    private javax.swing.JPanel pnlTop;
    private javax.swing.JTextArea tampilCatatanMedik;
    private javax.swing.JTable tblCatatanMedik;
    private javax.swing.JTable tblDetailObat;
    private javax.swing.JTable tblDetailResepObat;
    private javax.swing.JTable tblDetailResepTindakan;
    private javax.swing.JTable tblDetailTindakan;
    private javax.swing.JTable tblPilihObat;
    private javax.swing.JTable tblPilihTindakan;
    private javax.swing.JTextArea txtAreaTambahCatatan;
    private javax.swing.JTextField txtCariPilihObat;
    private javax.swing.JTextField txtCariPilihTindakan;
    private javax.swing.JTextField txtDetailObatAturan;
    private javax.swing.JTextField txtDetailObatJumlah;
    private javax.swing.JTextField txtDetailObatNama;
    private javax.swing.JTextField txtNamaPasien;
    private javax.swing.JTextField txtNoPasien;
    private javax.swing.JTextField txtNoresep;
    private javax.swing.JTextField txtSearchCmedik;
    // End of variables declaration//GEN-END:variables
}
