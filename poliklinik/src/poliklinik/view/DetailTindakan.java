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
class DetailTindakan {
    private String kode_tindakan;
    private String nama_tindakan;

    public DetailTindakan(String kode_tindakan, String nama_tindakan) {
        this.kode_tindakan = kode_tindakan;
        this.nama_tindakan = nama_tindakan;
    }

    public String getKode_tindakan() {
        return kode_tindakan;
    }

    public void setKode_tindakan(String kode_tindakan) {
        this.kode_tindakan = kode_tindakan;
    }

    public String getNama_tindakan() {
        return nama_tindakan;
    }

    public void setNama_tindakan(String nama_tindakan) {
        this.nama_tindakan = nama_tindakan;
    }
    
    
}