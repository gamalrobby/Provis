/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poliklinik.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Gamal Robby
 */
public class Database {
    Connection con;
    Statement stm;
    
    public void config(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/dbpoliklinik", "root","");
            stm = con.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "koneksi gagal "+e.getMessage());
        }
    }
    
    
    
    public final String driver ="com.mysql.jdbc.Driver";
    public final String url ="jdbc:mysql://localhost/dbpoliklinik";
    public final String user="root";
    public final String pass="";
    
    public ArrayList <Pegawai> tampil_semua_pegawai()
    {
        ArrayList<Pegawai> list = new ArrayList<Pegawai>();
        Connection conn=null;
        Statement stmt = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pass);
            stmt = conn.createStatement();
            String sql;
            sql="select nip,nama_spesialis,username,password,nama_pegawai,pekerjaan,tgl_lahir_pegawai,alamat_pegawai,no_telp_pegawai from pegawai,spesialis where pegawai.kode_spesialis=spesialis.kode_spesialis";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                list.add(new Pegawai(rs.getString("nip"),rs.getString("nama_spesialis")
                        ,rs.getString("username"),rs.getString("password"),rs.getString("nama_pegawai")
                        ,rs.getString("pekerjaan"),rs.getString("tgl_lahir_pegawai"),rs.getString("alamat_pegawai")
                        ,rs.getString("no_telp_pegawai")));                
            }
            rs.close();
                    
        } catch (Exception e) {
            System.out.println("Error : "+ e.getMessage());
        }
        finally
        {
            try {
                stmt.close();
            } catch (Exception e) {
            }
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
        return list;
    }
    
    public ArrayList <Catatanmedik> tampil_semua_catatanmedik()
    {
        ArrayList<Catatanmedik> list = new ArrayList<Catatanmedik>();
        Connection conn=null;
        Statement stmt = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pass);
            stmt = conn.createStatement();
            String sql;
            sql="select pasien.no_pasien,pasien.nama_pasien,pegawai.nama_pegawai,resep.no_resep, catatan_medik.tgl_catatan,catatan_medik.catatan_medik FROM resep\n" +
                "JOIN pegawai ON resep.nip=pegawai.nip\n" +
                "JOIN pasien ON resep.no_pasien=pasien.no_pasien\n" +
                "JOIN catatan_medik ON resep.no_resep=catatan_medik.no_resep ";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                list.add(new Catatanmedik(rs.getString("no_pasien"),rs.getString("nama_pasien")
                        ,rs.getString("nama_pegawai"),rs.getString("no_resep"),
                        rs.getString("tgl_catatan"),rs.getString("catatan_medik")));                
            }
            rs.close();
                    
        } catch (Exception e) {
            System.out.println("Error : "+ e.getMessage());
        }
        finally
        {
            try {
                stmt.close();
            } catch (Exception e) {
            }
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
        return list;
    }
    
    public ArrayList<Catatanmedik> cari_catatanmedik(String katakunci){
        ArrayList<Catatanmedik> listmahasiswa = new ArrayList<Catatanmedik>();
        Connection conn= null;
        Statement stmt= null;
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,pass);
            stmt=conn.createStatement();
            String sql="select pasien.no_pasien,pasien.nama_pasien,pegawai.nama_pegawai,resep.no_resep, catatan_medik.tgl_catatan,catatan_medik.catatan_medik FROM resep\n" +
                "JOIN pegawai ON resep.nip=pegawai.nip\n" +
                "JOIN pasien ON resep.no_pasien=pasien.no_pasien\n" +
                "JOIN catatan_medik ON resep.no_resep=catatan_medik.no_resep  where  resep.no_pasien like '%"+katakunci+"%'";
            ResultSet rs  = stmt.executeQuery(sql);
            while(rs.next()){
                listmahasiswa.add(new Catatanmedik(rs.getString("no_pasien"),rs.getString("nama_pasien")
                        ,rs.getString("nama_pegawai"),rs.getString("no_resep"),
                        rs.getString("tgl_catatan"),rs.getString("catatan_medik")));
            }
            rs.close();
        } catch (Exception e) {
        System.out.println("Error : "+e.getMessage());
        }
        finally
        {
            try {
                stmt.close();
            } catch (Exception e) {
            }
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
        return listmahasiswa;
    }
}
