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
class DetailObat {
    private String no_resep;
    private String kode_obat;
    private String nama_obat;
    private String jumlah;
    private String harga_obat;
    private String aturan_pakai;
    private String sub_harga_obat;

    public DetailObat(String no_resep, String kode_obat, String nama_obat, String jumlah, String harga_obat, String aturan_pakai, String sub_harga_obat) {
        this.no_resep = no_resep;
        this.kode_obat = kode_obat;
        this.nama_obat = nama_obat;
        this.jumlah = jumlah;
        this.harga_obat = harga_obat;
        this.aturan_pakai = aturan_pakai;
        this.sub_harga_obat = sub_harga_obat;
    }

    public String getHarga_obat() {
        return harga_obat;
    }

    public void setHarga_obat(String harga_obat) {
        this.harga_obat = harga_obat;
    }

    
    public String getKode_obat() {
        return kode_obat;
    }

    public void setKode_obat(String kode_obat) {
        this.kode_obat = kode_obat;
    }

    public String getNo_resep() {
        return no_resep;
    }

    public void setNo_resep(String no_resep) {
        this.no_resep = no_resep;
    }

    public String getNama_obat() {
        return nama_obat;
    }

    public void setNama_obat(String nama_obat) {
        this.nama_obat = nama_obat;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getAturan_pakai() {
        return aturan_pakai;
    }

    public void setAturan_pakai(String aturan_pakai) {
        this.aturan_pakai = aturan_pakai;
    }

    public String getSub_harga_obat() {
        return sub_harga_obat;
    }

    public void setSub_harga_obat(String sub_harga_obat) {
        this.sub_harga_obat = sub_harga_obat;
    }
    
    
}
