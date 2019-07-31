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
public class Session {
    private static String nip;
    private static String nama_pegawai;
    private static String pekerjaan;
    private static String no_resep;
    private static String no_pasien;
    private static String kode_catatan;
    private static String catatan;
    private static String kode_obat;
    private static String kode_tindakan;
    private static String nama_pasien;

    public static String getNama_pasien() {
        return nama_pasien;
    }

    public static void setNama_pasien(String nama_pasien) {
        Session.nama_pasien = nama_pasien;
    }
    

    public static String getKode_obat() {
        return kode_obat;
    }

    public static void setKode_obat(String kode_obat) {
        Session.kode_obat = kode_obat;
    }

    public static String getKode_tindakan() {
        return kode_tindakan;
    }

    public static void setKode_tindakan(String kode_tindakan) {
        Session.kode_tindakan = kode_tindakan;
    }
    

    public static String getCatatan() {
        return catatan;
    }

    public static void setCatatan(String catatan) {
        Session.catatan = catatan;
    }

    public static String getKode_catatan() {
        return kode_catatan;
    }

    public static void setKode_catatan(String kode_catatan) {
        Session.kode_catatan = kode_catatan;
    }
    

    public static String getNo_pasien() {
        return no_pasien;
    }

    public static void setNo_pasien(String no_pasien) {
        Session.no_pasien = no_pasien;
    }

    public static String getNo_resep() {
        return no_resep;
    }

    public static void setNo_resep(String no_resep) {
        Session.no_resep = no_resep;
    }
    
    public static String getNip() {
        return nip;
    }

    public static void setNip(String nip) {
        Session.nip = nip;
    }

    public static String getNama_pegawai() {
        return nama_pegawai;
    }

    public static void setNama_pegawai(String nama_pegawai) {
        Session.nama_pegawai = nama_pegawai;
    }

    public static String getPekerjaan() {
        return pekerjaan;
    }

    public static void setPekerjaan(String pekerjaan) {
        Session.pekerjaan = pekerjaan;
    }
    
    
}
