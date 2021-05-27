/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import objetos.Zona;

public class ZonaTable extends AbstractTableModel {

    private static final int ID_ZONA = 0;
    private static final int NOMBRE = 1;
    private static final int EXTENCION = 2;
    private static final int ESPECIES = 3;
    


    private final String[] columnNames = {"ID Zona", "Nombre",
        "Extencion", "Especies"};
    private final List<Zona> zonas;

    public ZonaTable(List<Zona> zonas) {
        this.zonas = zonas;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return zonas.size();
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {

        Zona especie = zonas.get(row);

        switch (col) {
            case ID_ZONA:
                return especie.getId();
            case NOMBRE:
                return especie.getNombre();
            case EXTENCION:
                return especie.getExtencion();
            case ESPECIES:
                return especie.getEspecies();
            default:
                return especie.getId();
        }
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}