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
public class tablePembayaranTindakan extends AbstractTableModel{
    private ArrayList<detailPembayaranTindakan> data;
    private String[] namaField = {"Tindakan","Harga Tindakan"};
    
    public void setData(ArrayList<detailPembayaranTindakan> dt)
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
        detailPembayaranTindakan m = data.get(baris);
        switch(kolom)
        {
            case 0 : return m.getNama_tindakan();
            case 1 : return m.getHarga();
            default: return null;
        }
    }
    
    public String getColumnName(int column) { 
        return namaField[column]; 
    }
    
}
