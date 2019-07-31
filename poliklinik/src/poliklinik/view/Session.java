/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poliklinik.view;

/**
 *
 * @author Gamal Robby
 */
public class session {
    private static String nip;
    private static String nama_pegawai;
    private static String pekerjaan;
    private static String no_resep;
    private static String no_nota;
    private static String no_pasien;
    private static String kode_catatan;
    private static String catatan;
    private static String kode_obat;
    private static String kode_tindakan;
    private static String nama_pasien;
    private static String pembayaran_nama_pasien;
    private static String pembayaran_no_pasien;
    private static String total_harga_obat;
    private static String total_harga_tindakan;

    public static String getNo_nota() {
        return no_nota;
    }

    public static void setNo_nota(String no_nota) {
        session.no_nota = no_nota;
    }

    public static String getTotal_harga_obat() {
        return total_harga_obat;
    }

    public static void setTotal_harga_obat(String total_harga_obat) {
        session.total_harga_obat = total_harga_obat;
    }

    public static String getTotal_harga_tindakan() {
        return total_harga_tindakan;
    }

    public static void setTotal_harga_tindakan(String total_harga_tindakan) {
        session.total_harga_tindakan = total_harga_tindakan;
    }
    

    public static String getPembayaran_nama_pasien() {
        return pembayaran_nama_pasien;
    }

    public static void setPembayaran_nama_pasien(String pembayaran_nama_pasien) {
        session.pembayaran_nama_pasien = pembayaran_nama_pasien;
    }

    public static String getPembayaran_no_pasien() {
        return pembayaran_no_pasien;
    }

    public static void setPembayaran_no_pasien(String pembayaran_no_pasien) {
        session.pembayaran_no_pasien = pembayaran_no_pasien;
    }
    

    public static String getNama_pasien() {
        return nama_pasien;
    }

    public static void setNama_pasien(String nama_pasien) {
        session.nama_pasien = nama_pasien;
    }
    

    public static String getKode_obat() {
        return kode_obat;
    }

    public static void setKode_obat(String kode_obat) {
        session.kode_obat = kode_obat;
    }

    public static String getKode_tindakan() {
        return kode_tindakan;
    }

    public static void setKode_tindakan(String kode_tindakan) {
        session.kode_tindakan = kode_tindakan;
    }
    

    public static String getCatatan() {
        return catatan;
    }

    public static void setCatatan(String catatan) {
        session.catatan = catatan;
    }

    public static String getKode_catatan() {
        return kode_catatan;
    }

    public static void setKode_catatan(String kode_catatan) {
        session.kode_catatan = kode_catatan;
    }
    

    public static String getNo_pasien() {
        return no_pasien;
    }

    public static void setNo_pasien(String no_pasien) {
        session.no_pasien = no_pasien;
    }

    public static String getNo_resep() {
        return no_resep;
    }

    public static void setNo_resep(String no_resep) {
        session.no_resep = no_resep;
    }
    
    public static String getNip() {
        return nip;
    }

    public static void setNip(String nip) {
        session.nip = nip;
    }

    public static String getNama_pegawai() {
        return nama_pegawai;
    }

    public static void setNama_pegawai(String nama_pegawai) {
        session.nama_pegawai = nama_pegawai;
    }

    public static String getPekerjaan() {
        return pekerjaan;
    }

    public static void setPekerjaan(String pekerjaan) {
        session.pekerjaan = pekerjaan;
    }
    
    
}
