/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import objetos.Guia;

public class GuiaTable extends AbstractTableModel {

    private static final int ID_GUIA = 0;
    private static final int NOMBRE = 1;
    private static final int ITINERARIO = 2;
    private static final int TELEFONO = 3;
    private static final int FECHA_INICIO = 4;

    private final String[] columnNames = {"ID Guia", "Nombre",
        "Itinerario", "Telefono", "Fecha Inicio"};

    private final List<Guia> guias;

    public GuiaTable(List<Guia> guias) {
        this.guias = guias;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return guias.size();
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {

        Guia guia = guias.get(row);

        switch (col) {
            case ID_GUIA:
                return guia.getId();
            case NOMBRE:
                return guia.getNombre();
            case ITINERARIO:
                return guia.getItinerario();
            case TELEFONO:
                return guia.getTelefono();
            case FECHA_INICIO:
                return guia.getFechaInicio();
            default:
                return guia.getId();
        }
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}