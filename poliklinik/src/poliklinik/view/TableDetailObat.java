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
public class TableDetailObat extends AbstractTableModel{
    private ArrayList<DetailObat> data;
    private String[] namaField = {"No Resep","Kode Obat","Nama Obat","Jumlah","Harga","Aturan Pakai"};
    
    public void setData(ArrayList<DetailObat> dt)
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
        DetailObat m = data.get(baris);
        switch(kolom)
        {
            case 0 : return m.getNo_resep();
            case 1 : return m.getKode_obat();
            case 2 : return m.getNama_obat();
            case 3 : return m.getJumlah();
            case 4 : return m.getHarga_obat();
            case 5 : return m.getAturan_pakai();
            default: return null;
        }
    }
    
    public String getColumnName(int column) { 
        return namaField[column]; 
    }
    
}
