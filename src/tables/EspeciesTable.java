/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tables;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import objetos.Especie;

public class EspeciesTable extends AbstractTableModel {

    private static final int ID_ESPECIES = 0;
    private static final int NOMBRE = 1;
    private static final int NOMBRE_CIENTIFICO = 2;
    private static final int DESCRIPCION = 3;
    private static final int HABITAT = 4;
    


    private final String[] columnNames = {"ID Especie", "Nombre",
        "Nombre cientifico", "Descripcion", "Habitat"};
    private final List<Especie> especies;

    public EspeciesTable(List<Especie> especies) {
        this.especies = especies;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return especies.size();
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {

        Especie especie = especies.get(row);

        switch (col) {
            case ID_ESPECIES:
                return especie.getId();
            case NOMBRE:
                return especie.getNombre();
            case NOMBRE_CIENTIFICO:
                return especie.getNombreCientifico();
            case DESCRIPCION:
                return especie.getDescripcion();
            case HABITAT:
                return especie.getHabitat();
            default:
                return especie.getId();
        }
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}