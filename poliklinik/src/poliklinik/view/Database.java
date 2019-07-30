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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    
    private String getTanggal() {  
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        Date date = new Date();  
        return dateFormat.format(date);  
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
    
    public ArrayList <Obat> tampil_semua_pilihobat()
    {
        ArrayList<Obat> list = new ArrayList<Obat>();
        Connection conn=null;
        Statement stmt = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pass);
            stmt = conn.createStatement();
            String sql;
            sql="select * from obat";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                list.add(new Obat(rs.getString("kode_obat"),rs.getString("nama_obat")
                        ,rs.getString("stok"),rs.getString("harga_obat")));                
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
    
    public ArrayList <Tindakan> tampil_semua_pilihtindakan()
    {
        ArrayList<Tindakan> list = new ArrayList<Tindakan>();
        Connection conn=null;
        Statement stmt = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pass);
            stmt = conn.createStatement();
            String sql;
            sql="select * from tindakan";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                list.add(new Tindakan(rs.getString("kode_tindakan"),rs.getString("nama_tindakan")
                        ,rs.getString("harga_tindakan")));                
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
    
    public ArrayList <DetailObat> tampil_semua_detail_obat()
    {
        Session ses = new Session();
        ArrayList<DetailObat> list = new ArrayList<DetailObat>();
        Connection conn=null;
        Statement stmt = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pass);
            stmt = conn.createStatement();
            String sql;
            sql="select detail_obat.no_resep,detail_obat.kode_obat,obat.nama_obat,detail_obat.jumlah,obat.harga_obat,detail_obat.aturan_pakai"
                    + ",detail_obat.sub_harga_obat from obat,detail_obat where detail_obat.kode_obat=obat.kode_obat AND"
                    + " no_resep = '"+ses.getNo_resep()+"' ";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                list.add(new DetailObat(rs.getString("detail_obat.no_resep"),rs.getString("detail_obat.kode_obat"),rs.getString("obat.nama_obat")
                        ,rs.getString("detail_obat.jumlah"),rs.getString("obat.harga_obat"),rs.getString("detail_obat.aturan_pakai"),
                        rs.getString("detail_obat.sub_harga_obat")));                
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
    
    public ArrayList<Obat> cari_PilihObat(String katakunci){
        ArrayList<Obat> listmahasiswa = new ArrayList<Obat>();
        Connection conn= null;
        Statement stmt= null;
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,pass);
            stmt=conn.createStatement();
            String sql="select * from obat where nama_obat like '%"+katakunci+"%'";
            ResultSet rs  = stmt.executeQuery(sql);
            while(rs.next()){
                listmahasiswa.add(new Obat(rs.getString("kode_obat"),rs.getString("nama_obat")
                        ,rs.getString("stok"),rs.getString("harga_obat")));
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
    
    public ArrayList<Tindakan> cari_PilihTindakan(String katakunci){
        ArrayList<Tindakan> listmahasiswa = new ArrayList<Tindakan>();
        Connection conn= null;
        Statement stmt= null;
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,pass);
            stmt=conn.createStatement();
            String sql="select * from tindakan where nama_tindakan like '%"+katakunci+"%'";
            ResultSet rs  = stmt.executeQuery(sql);
            while(rs.next()){
                listmahasiswa.add(new Tindakan(rs.getString("kode_tindakan"),rs.getString("nama_tindakan")
                        ,rs.getString("harga_tindakan")));
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
    
    public void tambah_resep(resep r)
    {
        Session ses = new Session();
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pass);
            stmt = conn.createStatement();
            String sql = "insert into resep(no_resep,nip,no_pasien) values ('"+r.getNo_resep()+"','"
                    +r.getNip()+"','"+r.getNo_pasien()+"')";
            stmt.executeUpdate(sql);
            
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
    }
    public void tambah_catatan()
    {
        
        Session ses = new Session();
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pass);
            stmt = conn.createStatement();
            String sql = "insert into catatan_medik(kode_catatan,no_resep,catatan_medik,tgl_catatan) values "
                    + "('"+ses.getKode_catatan()+"','"+ses.getNo_resep()+"','"+ses.getCatatan()+"','"+getTanggal()+"')";
            stmt.executeUpdate(sql);
            
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
    }
    public void hapus_resep(String no_resep){
        Connection conn=null;
        Statement stmt=null;
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,pass);
            stmt=conn.createStatement();
            String sql="delete from resep where no_resep='"+no_resep+"'";
            stmt.executeUpdate(sql);
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
    }
    
    public void tambah_detail_obat()
    {
        
        Session ses = new Session();
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pass);
            stmt = conn.createStatement();
            String sql = "insert into detail_obat(no_resep,kode_obat,jumlah,aturan_pakai,sub_harga_obat) values "
                    + "('"+ses.getNo_resep()+"','"+ses.getKode_obat()+"','0','-','0')";
            stmt.executeUpdate(sql);
            
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
    }

    public void update_detail_obat(String kode_obat,int jml,String aturan,int sub_harga)
    {
        Session ses = new Session();
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pass);
            stmt = conn.createStatement();
            String sql = "update detail_obat set jumlah='"+jml+"',aturan_pakai='"+aturan+"',sub_harga_obat='"+sub_harga+"' "
                    + " where no_resep='"+ses.getNo_resep()+"' AND kode_obat='"+kode_obat+"' ";
            stmt.executeUpdate(sql);
            
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
    }
}
