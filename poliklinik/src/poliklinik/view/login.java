/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poliklinik.view;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author Gamal Robby
 */
public class login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    Connection con;
    Statement stat;
    ResultSet rs;
    String sql;
    public login() {
        try {
            initComponents();
            Image i = ImageIO.read(getClass().getResource("/poliklinik/image/icon.png"));
            setIconImage(i);
            pnlBg.setBackground(new Color(250,250,250,100));
            pnlBgLogin.setBackground(new Color(250,250,250,210));
            database DB = new database();
            DB.config();
            con = DB.con;
            stat = DB.stm;
        } catch (IOException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
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

        pnlBg = new javax.swing.JPanel();
        pnlBgLogin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        bgLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setPreferredSize(new java.awt.Dimension(800, 500));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlBg.setBackground(new java.awt.Color(204, 204, 204));
        pnlBg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlBgLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Clarendon BT", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(13, 206, 112));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PASSWORD");
        pnlBgLogin.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 120, 150, -1));
        pnlBgLogin.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 200, 32));

        jLabel2.setFont(new java.awt.Font("Clarendon BT", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(13, 206, 112));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("USERNAME");
        pnlBgLogin.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 20, 150, -1));

        btnLogin.setBackground(new java.awt.Color(13, 206, 112));
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLoginMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnLoginMousePressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Clarendon BT", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("LOGIN");

        javax.swing.GroupLayout btnLoginLayout = new javax.swing.GroupLayout(btnLogin);
        btnLogin.setLayout(btnLoginLayout);
        btnLoginLayout.setHorizontalGroup(
            btnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        btnLoginLayout.setVerticalGroup(
            btnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        pnlBgLogin.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 150, 40));
        pnlBgLogin.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 200, 32));

        pnlBg.add(pnlBgLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 500, 300));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poliklinik/image/poliklinik.png"))); // NOI18N
        pnlBg.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, 160, 80));

        getContentPane().add(pnlBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        bgLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poliklinik/image/bglogin.jpg"))); // NOI18N
        getContentPane().add(bgLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseEntered
        // TODO add your handling code here:
        btnLogin.setBackground(new Color(41,185,55));
    }//GEN-LAST:event_btnLoginMouseEntered

    private void btnLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseExited
        // TODO add your handling code here:
        btnLogin.setBackground(new Color(13,206,112));
    }//GEN-LAST:event_btnLoginMouseExited

    private void btnLoginMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMousePressed
        // TODO add your handling code here:
        
        session ses = new session();
        try {
            sql = "SELECT * FROM pegawai WHERE username='"+txtUsername.getText()+"' AND password='"+txtPassword.getText()+"'";
            rs = stat.executeQuery(sql);
            if(rs.next()){
                if(txtUsername.getText().equals(rs.getString("username")) && txtPassword.getText().equals(rs.getString("password"))){
                    ses.setNip(rs.getString("nip"));
                    ses.setNama_pegawai(rs.getString("nama_pegawai"));
                    ses.setPekerjaan(rs.getString("pekerjaan"));
                    System.out.println(ses.getPekerjaan());
                    fUtama futama = new fUtama();
                    futama.setVisible(true);
                    this.setVisible(false);
                }
            }else{
                    JOptionPane.showMessageDialog(null, "username atau password salah");
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnLoginMousePressed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bgLogin;
    private javax.swing.JPanel btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel pnlBg;
    private javax.swing.JPanel pnlBgLogin;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
