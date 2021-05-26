/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tables;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import objetos.Itinerario;

public class ItinerarioTable extends AbstractTableModel {

    private static final int ID_ITINERARIO = 0;
    private static final int NUM_PERSONAS = 1;
    private static final int NUM_ESPECIES = 2;
    private static final int DISTANCIA = 3;
    private static final int FECHA = 4;

    private final String[] columnNames = {"ID Itinerario", "Num. Personas",
        "Num. Especies", "Distancia", "Fecha"};
    private final List<Itinerario> itinerarios;

    public ItinerarioTable(List<Itinerario> itinerarios) {
        this.itinerarios = itinerarios;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return itinerarios.size();
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {

        Itinerario itinerario = itinerarios.get(row);

        switch (col) {
            case ID_ITINERARIO:
                return itinerario.getId();
            case NUM_PERSONAS:
                return itinerario.getNumeroVisitantes();
            case NUM_ESPECIES:
                return itinerario.getNumeroEspecies();
            case DISTANCIA:
                return itinerario.getDuracionMin();
            case FECHA:
                return itinerario.getFecha();
            default:
                return itinerario.getId();
        }
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}
