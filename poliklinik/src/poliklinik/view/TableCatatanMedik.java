/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poliklinik.view;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Gamal Robby
 */
public class TableCatatanMedik extends AbstractTableModel{
    private ArrayList<Catatanmedik> data;
    private String[] namaField = {"No Pasien","Nama Pasien","Nama Dokter","No Resep","Tgl Catatan","Catatan Medik"};
    
    public void setData(ArrayList<Catatanmedik> dt)
    {
        this.data = dt;
    }
    
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return namaField.length;
    }

    @Override
    public Object getValueAt(int baris, int kolom) {
        Catatanmedik m = data.get(baris);
        switch(kolom)
        {
            case 0 : return m.getNo_pasien();
            case 1 : return m.getNama_pasien();
            case 2 : return m.getNama_pegawai();
            case 3 : return m.getNo_resep();
            case 4 : return m.getTgl_catatan();
            case 5 : return m.getCatatan_medik();
            default: return null;
        }
    }
    
    public String getColumnName(int column) { 
        return namaField[column]; 
    }
}
