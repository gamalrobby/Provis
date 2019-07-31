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
public class tableObatPembayaran extends AbstractTableModel{
    private ArrayList<detailPembayaranObat> data;
    private String[] namaField = {"Nama Obat","Jumlah","Aturan Pakai","Sub Harga Obat"};
    
    public void setData(ArrayList<detailPembayaranObat> dt)
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
        detailPembayaranObat m = data.get(baris);
        switch(kolom)
        {
            case 0 : return m.getNama_obat();
            case 1 : return m.getJumlah();
            case 2 : return m.getAturan_pakai();
            case 3 : return m.getSub_harga_obat();
            default: return null;
        }
    }
    
    public String getColumnName(int column) { 
        return namaField[column]; 
    }
    
}
