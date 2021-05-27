/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import objetos.Empleado;

/**
 *
 * @author BCJL1
 */
public class EmpleadoTable extends AbstractTableModel {
      private static final int ID_EMPLEADO = 0;
    private static final int NOMBRE = 1;
    private static final int TELEFONO = 2;
    private static final int FECHA_INICIO = 3;
   

    private final String[] columnNames = {"ID Empleado", "Nombre",
        "Telefono", "Fecha Inicio"};
    private final List<Empleado> empleados;

    public EmpleadoTable(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return empleados.size();
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {

        Empleado empleado = empleados.get(row);

        switch (col) {
            case ID_EMPLEADO:
                return empleado.getId();
            case NOMBRE:
                return empleado.getNombre();
            case TELEFONO:
                return empleado.getTelefono();
            case FECHA_INICIO:
                return empleado.getFechaInicio();
            default:
                return empleado.getId();
        }
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}
  

