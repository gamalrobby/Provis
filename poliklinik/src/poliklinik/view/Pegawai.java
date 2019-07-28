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
class Pegawai {
    private String nip;
    private String kode_spesialis;
    private String username;
    private String password;
    private String nama_pegawai;
    private String pekerjaan;
    private String tgl_lahir_pegawai;
    private String alamat_pegawai;
    private String no_telp_pegawai;

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getKode_spesialis() {
        return kode_spesialis;
    }

    public void setKode_spesialis(String kode_spesialis) {
        this.kode_spesialis = kode_spesialis;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama_pegawai() {
        return nama_pegawai;
    }

    public void setNama_pegawai(String nama_pegawai) {
        this.nama_pegawai = nama_pegawai;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public String getTgl_lahir_pegawai() {
        return tgl_lahir_pegawai;
    }

    public void setTgl_lahir_pegawai(String tgl_lahir_pegawai) {
        this.tgl_lahir_pegawai = tgl_lahir_pegawai;
    }

    public String getAlamat_pegawai() {
        return alamat_pegawai;
    }

    public void setAlamat_pegawai(String alamat_pegawai) {
        this.alamat_pegawai = alamat_pegawai;
    }

    public String getNo_telp_pegawai() {
        return no_telp_pegawai;
    }

    public void setNo_telp_pegawai(String no_telp_pegawai) {
        this.no_telp_pegawai = no_telp_pegawai;
    }
    
    public Pegawai(String nip,String kd_spesialis,String username, String password, String nama, String pekerjaan, String tgl_lahir,String alamat,String no_telp){
        setNip(nip);
        setKode_spesialis(kd_spesialis);
        setUsername(username);
        setPassword(password);
        setNama_pegawai(nama);
        setPekerjaan(pekerjaan);
        setTgl_lahir_pegawai(tgl_lahir);
        setAlamat_pegawai(alamat);
        setNo_telp_pegawai(no_telp);
    }
}
