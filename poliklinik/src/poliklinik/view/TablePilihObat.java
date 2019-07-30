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
public class TablePilihObat extends AbstractTableModel{
    private ArrayList<Obat> data;
    private String[] namaField = {"Kode Obat","Obat"};
    
    public void setData(ArrayList<Obat> dt)
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
        Obat m = data.get(baris);
        switch(kolom)
        {
            case 0 : return m.getKode_obat();
            case 1 : return m.getNama_obat();
            default: return null;
        }
    }
    
    public String getColumnName(int column) { 
        return namaField[column]; 
    }
    
}
