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
class obat {
    private String kode_obat;
    private String nama_obat;
    private String stok_obat;
    private String harga_obat;

    public obat(String kode_obat, String nama_obat, String stok_obat, String harga_obat) {
        this.kode_obat = kode_obat;
        this.nama_obat = nama_obat;
        this.stok_obat = stok_obat;
        this.harga_obat = harga_obat;
    }
    
    public String getKode_obat() {
        return kode_obat;
    }

    public void setKode_obat(String kode_obat) {
        this.kode_obat = kode_obat;
    }

    public String getNama_obat() {
        return nama_obat;
    }

    public void setNama_obat(String nama_obat) {
        this.nama_obat = nama_obat;
    }

    public String getStok_obat() {
        return stok_obat;
    }

    public void setStok_obat(String stok_obat) {
        this.stok_obat = stok_obat;
    }

    public String getHarga_obat() {
        return harga_obat;
    }

    public void setHarga_obat(String harga_obat) {
        this.harga_obat = harga_obat;
    }
    
    
}
