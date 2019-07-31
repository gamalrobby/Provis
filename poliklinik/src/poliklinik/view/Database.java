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
public class database {
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
    
    public ArrayList <pegawai> tampil_semua_pegawai()
    {
        ArrayList<pegawai> list = new ArrayList<pegawai>();
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
                list.add(new pegawai(rs.getString("nip"),rs.getString("nama_spesialis")
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
    
    public void tampil_nama_pasien(String no_pasien){
        Connection conn = null;
        Statement stat = null;
        ResultSet rs;
        config();
        conn = con;
        stat = stm;
        try {
            session ses = new session();
            String sql = "SELECT nama_pasien FROM pasien WHERE no_pasien='"+no_pasien+"'";
            rs = stat.executeQuery(sql);
            if(rs.next()){
                ses.setNama_pasien(rs.getString("nama_pasien"));
            }
        } catch (Exception e) {
            System.out.println("Error : "+ e.getMessage());
        }
        finally
        {
            try {
                stat.close();
            } catch (Exception e) {
            }
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
    }
    
    public ArrayList <obat> tampil_semua_pilihobat()
    {
        ArrayList<obat> list = new ArrayList<obat>();
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
                list.add(new obat(rs.getString("kode_obat"),rs.getString("nama_obat")
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
    
    public ArrayList <tindakan> tampil_semua_pilihtindakan()
    {
        ArrayList<tindakan> list = new ArrayList<tindakan>();
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
                list.add(new tindakan(rs.getString("kode_tindakan"),rs.getString("nama_tindakan")
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
    
    public ArrayList <catatanMedik> tampil_semua_catatanmedik()
    {
        ArrayList<catatanMedik> list = new ArrayList<catatanMedik>();
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
                list.add(new catatanMedik(rs.getString("no_pasien"),rs.getString("nama_pasien")
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
    
    public ArrayList <detailObat> tampil_semua_detail_obat()
    {
        session ses = new session();
        ArrayList<detailObat> list = new ArrayList<detailObat>();
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
                list.add(new detailObat(rs.getString("detail_obat.no_resep"),rs.getString("detail_obat.kode_obat"),rs.getString("obat.nama_obat")
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
    
    public ArrayList <detailPembayaranObat> tampil_semua_pembayaran_detail_obat()
    {
        session ses = new session();
        ArrayList<detailPembayaranObat> list = new ArrayList<detailPembayaranObat>();
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
                list.add(new detailPembayaranObat(rs.getString("detail_obat.no_resep"),rs.getString("detail_obat.kode_obat"),rs.getString("obat.nama_obat")
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
    
    public ArrayList <detailTindakan> tampil_semua_detail_tindakan()
    {
        session ses = new session();
        ArrayList<detailTindakan> list = new ArrayList<detailTindakan>();
        Connection conn=null;
        Statement stmt = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pass);
            stmt = conn.createStatement();
            String sql;
            sql="select detail_tindakan.kode_tindakan,tindakan.nama_tindakan,tindakan.harga_tindakan "
                    + "from tindakan,detail_tindakan where no_resep = '"+ses.getNo_resep()+"' "
                    + "AND detail_tindakan.kode_tindakan=tindakan.kode_tindakan";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                list.add(new detailTindakan(rs.getString("detail_tindakan.kode_tindakan"),rs.getString("tindakan.nama_tindakan"),rs.getString("tindakan.harga_tindakan")));                
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
    
    public ArrayList <detailPembayaranTindakan> tampil_semua_pembayaran_detail_tindakan()
    {
        session ses = new session();
        ArrayList<detailPembayaranTindakan> list = new ArrayList<detailPembayaranTindakan>();
        Connection conn=null;
        Statement stmt = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pass);
            stmt = conn.createStatement();
            String sql;
            sql="select detail_tindakan.kode_tindakan,tindakan.nama_tindakan,tindakan.harga_tindakan "
                    + "from tindakan,detail_tindakan where no_resep = '"+ses.getNo_resep()+"' "
                    + "AND detail_tindakan.kode_tindakan=tindakan.kode_tindakan";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                list.add(new detailPembayaranTindakan(rs.getString("detail_tindakan.kode_tindakan"),rs.getString("tindakan.nama_tindakan"),rs.getString("tindakan.harga_tindakan")));                
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
    
    public ArrayList<catatanMedik> cari_catatanmedik(String katakunci){
        ArrayList<catatanMedik> listmahasiswa = new ArrayList<catatanMedik>();
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
                listmahasiswa.add(new catatanMedik(rs.getString("no_pasien"),rs.getString("nama_pasien")
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
    
    public ArrayList<obat> cari_PilihObat(String katakunci){
        ArrayList<obat> listmahasiswa = new ArrayList<obat>();
        Connection conn= null;
        Statement stmt= null;
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,pass);
            stmt=conn.createStatement();
            String sql="select * from obat where nama_obat like '%"+katakunci+"%'";
            ResultSet rs  = stmt.executeQuery(sql);
            while(rs.next()){
                listmahasiswa.add(new obat(rs.getString("kode_obat"),rs.getString("nama_obat")
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
    
    public ArrayList<tindakan> cari_PilihTindakan(String katakunci){
        ArrayList<tindakan> listmahasiswa = new ArrayList<tindakan>();
        Connection conn= null;
        Statement stmt= null;
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,pass);
            stmt=conn.createStatement();
            String sql="select * from tindakan where nama_tindakan like '%"+katakunci+"%'";
            ResultSet rs  = stmt.executeQuery(sql);
            while(rs.next()){
                listmahasiswa.add(new tindakan(rs.getString("kode_tindakan"),rs.getString("nama_tindakan")
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
        session ses = new session();
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
        
        session ses = new session();
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
        
        session ses = new session();
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
        }}
        
        public void tambah_detail_tindakan(String kode)
        {
        session ses = new session();
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pass);
            stmt = conn.createStatement();
            String sql = "insert into detail_tindakan(no_resep,kode_tindakan) values "
                    + "('"+ses.getNo_resep()+"','"+kode+"')";
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
        session ses = new session();
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
    
    public void hapus_detail_obat(String kode_obat){
        session ses = new session();
        Connection conn=null;
        Statement stmt=null;
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,pass);
            stmt=conn.createStatement();
            String sql="delete from detail_obat where no_resep='"+ses.getNo_resep()+"' AND kode_obat='"+kode_obat+"'";
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
    
    public void hapus_detail_tindakan(String kode){
        session ses = new session();
        Connection conn=null;
        Statement stmt=null;
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,pass);
            stmt=conn.createStatement();
            String sql="delete from detail_tindakan where no_resep='"+ses.getNo_resep()+"' AND kode_tindakan='"+kode+"'";
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
    
    public ArrayList<detailPembayaranObat>cari_detail_obat(String katakunci){
        ArrayList<detailPembayaranObat> listmahasiswa = new ArrayList<detailPembayaranObat>();
        Connection conn= null;
        Statement stmt= null;
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,pass);
            stmt=conn.createStatement();
            String sql="select detail_obat.no_resep,detail_obat.kode_obat,obat.nama_obat,detail_obat.jumlah,obat.harga_obat,detail_obat.aturan_pakai"
                    + ",detail_obat.sub_harga_obat from obat,detail_obat where detail_obat.kode_obat=obat.kode_obat AND"
                    + " no_resep = '"+katakunci+"'";
            ResultSet rs  = stmt.executeQuery(sql);
            while(rs.next()){
                listmahasiswa.add(new detailPembayaranObat(rs.getString("detail_obat.no_resep"),rs.getString("detail_obat.kode_obat"),rs.getString("obat.nama_obat")
                        ,rs.getString("detail_obat.jumlah"),rs.getString("obat.harga_obat"),rs.getString("detail_obat.aturan_pakai"),
                        rs.getString("detail_obat.sub_harga_obat")));
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
    
    public ArrayList<detailPembayaranTindakan> cari_detail_tindakan(String katakunci){
        ArrayList<detailPembayaranTindakan> listmahasiswa = new ArrayList<detailPembayaranTindakan>();
        Connection conn= null;
        Statement stmt= null;
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,pass);
            stmt=conn.createStatement();
            String sql="select detail_tindakan.kode_tindakan,tindakan.nama_tindakan,tindakan.harga_tindakan "
                    + "from tindakan,detail_tindakan where no_resep = '"+katakunci+"' "
                    + "AND detail_tindakan.kode_tindakan=tindakan.kode_tindakan";
            ResultSet rs  = stmt.executeQuery(sql);
            while(rs.next()){
                listmahasiswa.add(new detailPembayaranTindakan(rs.getString("detail_tindakan.kode_tindakan"),rs.getString("tindakan.nama_tindakan"),rs.getString("tindakan.harga_tindakan")));
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
    
    public void tampil_nama_pasien_pembayaran(String no_resep){
        Connection conn = null;
        Statement stat = null;
        ResultSet rs;
        config();
        conn = con;
        stat = stm;
        try {
            session ses = new session();
            String sql = "SELECT pasien.no_pasien,pasien.nama_pasien FROM pasien,resep WHERE pasien.no_pasien=resep.no_pasien AND resep.no_resep='"+no_resep+"'";
            rs = stat.executeQuery(sql);
            if(rs.next()){
                ses.setPembayaran_no_pasien(rs.getString("pasien.no_pasien"));
                ses.setPembayaran_nama_pasien(rs.getString("pasien.nama_pasien"));
            }
        } catch (Exception e) {
            System.out.println("Error : "+ e.getMessage());
        }
        finally
        {
            try {
                stat.close();
            } catch (Exception e) {
            }
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
    }
    
    public void tampil_harga_obat_pembayaran(String no_resep){
        Connection conn = null;
        Statement stat = null;
        ResultSet rs;
        config();
        conn = con;
        stat = stm;
        try {
            session ses = new session();
            String sql = "SELECT SUM(detail_obat.sub_harga_obat) AS harga FROM resep,detail_obat WHERE detail_obat.no_resep=resep.no_resep AND resep.no_resep='"+no_resep+"'";
            rs = stat.executeQuery(sql);
            if(rs.next()){
                ses.setTotal_harga_obat(rs.getString("harga"));
            }
        } catch (Exception e) {
            System.out.println("Error : "+ e.getMessage());
        }
        finally
        {
            try {
                stat.close();
            } catch (Exception e) {
            }
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
    }
    public void tampil_harga_tindakan_pembayaran(String no_resep){
        Connection conn = null;
        Statement stat = null;
        ResultSet rs;
        config();
        conn = con;
        stat = stm;
        try {
            session ses = new session();
            String sql = "SELECT SUM(tindakan.harga_tindakan) AS harga FROM detail_tindakan,tindakan,resep WHERE tindakan.kode_tindakan=detail_tindakan.kode_tindakan AND detail_tindakan.no_resep=resep.no_resep AND resep.no_resep='"+no_resep+"'";
            rs = stat.executeQuery(sql);
            if(rs.next()){
                ses.setTotal_harga_tindakan(rs.getString("harga"));
            }
        } catch (Exception e) {
            System.out.println("Error : "+ e.getMessage());
        }
        finally
        {
            try {
                stat.close();
            } catch (Exception e) {
            }
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
    }
    
    public void tambah_pembayaran(String no_nota,String no_resep,int t_tindakan,int t_obat,int t_bayar,int bayar,int kembali)
        {
        session ses = new session();
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pass);
            stmt = conn.createStatement();
            String sql = "insert into transaksi(no_nota,no_resep,tgl_transaksi,total_harga_tindakan,total_harga_obat,total_pembayaran,pembayaran,kembalian)"
                    + "values ('"+no_nota+"','"+no_resep+"','"+getTanggal()+"','"+t_tindakan+"',"
                    + "'"+t_obat+"','"+t_bayar+"','"+bayar+"','"+kembali+"')";
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