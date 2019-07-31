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
public class TableDetailTindakan extends AbstractTableModel{
    private ArrayList<DetailTindakan> data;
    private String[] namaField = {"Kode Tindakan","Tindakan"};
    
    public void setData(ArrayList<DetailTindakan> dt)
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
        DetailTindakan m = data.get(baris);
        switch(kolom)
        {
            case 0 : return m.getKode_tindakan();
            case 1 : return m.getNama_tindakan();
            default: return null;
        }
    }
    
    public String getColumnName(int column) { 
        return namaField[column]; 
    }
}
