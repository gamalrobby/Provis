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
class catatanMedik {
    private String no_pasien;
    private String nama_pasien;
    private String nama_pegawai;
    private String no_resep;
    private String tgl_catatan;
    private String catatan_medik;

    public catatanMedik(String no_pasien, String nama_pasien, String nama_pegawai, String no_resep, String tgl_catatan, String catatan_medik) {
        this.no_pasien = no_pasien;
        this.nama_pasien = nama_pasien;
        this.nama_pegawai = nama_pegawai;
        this.no_resep = no_resep;
        this.tgl_catatan = tgl_catatan;
        this.catatan_medik = catatan_medik;
    }

    
    public String getNo_pasien() {
        return no_pasien;
    }

    public void setNo_pasien(String no_pasien) {
        this.no_pasien = no_pasien;
    }

    public String getNama_pasien() {
        return nama_pasien;
    }

    public void setNama_pasien(String nama_pasien) {
        this.nama_pasien = nama_pasien;
    }

    public String getNama_pegawai() {
        return nama_pegawai;
    }

    public void setNama_pegawai(String nama_pegawai) {
        this.nama_pegawai = nama_pegawai;
    }

    public String getNo_resep() {
        return no_resep;
    }

    public void setNo_resep(String no_resep) {
        this.no_resep = no_resep;
    }

    public String getTgl_catatan() {
        return tgl_catatan;
    }

    public void setTgl_catatan(String tgl_catatan) {
        this.tgl_catatan = tgl_catatan;
    }

    public String getCatatan_medik() {
        return catatan_medik;
    }

    public void setCatatan_medik(String catatan_medik) {
        this.catatan_medik = catatan_medik;
    }
    
    
}
