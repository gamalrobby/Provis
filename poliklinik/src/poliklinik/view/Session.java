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
