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
class resep {
    private String no_resep;
    private String nip;
    private String no_pasien;

    public resep(String no_resep, String nip, String no_pasien) {
        this.no_resep = no_resep;
        this.nip = nip;
        this.no_pasien = no_pasien;
    }
    
    public String getNo_resep() {
        return no_resep;
    }

    public void setNo_resep(String no_resep) {
        this.no_resep = no_resep;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNo_pasien() {
        return no_pasien;
    }

    public void setNo_pasien(String no_pasien) {
        this.no_pasien = no_pasien;
    }

    
}
