/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import objetos.Cuidador;

/**
 *
 * @author BCJL1
 */
public class CuidadorTable extends AbstractTableModel {

    private static final int ID_CUIDADOR = 0;
    private static final int NOMBRE = 1;
    private static final int EXPERTO = 2;
    private static final int BASICO = 3;
    private static final int CUIDADO = 4;
    private static final int FECHA = 5;

    private final String[] columnNames = {"ID Cuidador", "Nombre",
        "Experto", "Basico", "Cuidado", "Fecha"};
    private final List<Cuidador> cuidadores;

    public CuidadorTable(List<Cuidador> cuidadores) {
        this.cuidadores = cuidadores;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return cuidadores.size();
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {

        Cuidador cuidador = cuidadores.get(row);

        switch (col) {
            case ID_CUIDADOR:
                return cuidador.getId();
            case NOMBRE:
                return cuidador.getNombre();
            case EXPERTO:
                return cuidador.getExpertos();
            case BASICO:
                return cuidador.getBasico();
            case CUIDADO:
                return cuidador.getEspecieCuidada();
            case FECHA:
                return cuidador.getFechaCiudado();
            default:
                return cuidador.getId();
        }
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}
