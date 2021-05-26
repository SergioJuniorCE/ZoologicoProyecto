package tables;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import objetos.Habitat;

public class HabitatTable extends AbstractTableModel {

    private static final int ID_HABITAT = 0;
    private static final int NOMBRE = 1;
    private static final int CLIMA = 2;
    private static final int TIPO_VEGETACION = 3;
    private static final int CONTINENTES = 4;

    private final String[] columnNames = {"ID Habitat", "Nombre", "Clima",
        "Tipo Vegetacion", "Continentes"};
    private final List<Habitat> habitats;

    public HabitatTable(List<Habitat> habitats) {
        this.habitats = habitats;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return habitats.size();
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {

        Habitat habitat = habitats.get(row);

        switch (col) {
            case ID_HABITAT:
                return habitat.getId();
            case NOMBRE:
                return habitat.getNombre();
            case CLIMA:
                return habitat.getClima();
            case TIPO_VEGETACION:
                return habitat.getTipoVegetacion();
            case CONTINENTES:
                return habitat.getContinentes().toString();
            default:
                return habitat.getId();
        }
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}
