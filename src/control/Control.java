package control;

import dao.HabitatDAO;
import exceptions.DAOException;
import java.util.ArrayList;
import java.util.List;
import objetos.Habitat;

public class Control {

    public static void createHabitat(String clima, String vegetacion, String continente, String nombre) throws DAOException {
        try {
            HabitatDAO dao = new HabitatDAO();
            Habitat habitat = new Habitat(nombre, clima, vegetacion, continente);
            dao.create(habitat);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DAOException("No se pudo registrar habitat");
        }
    }

    public static List<Habitat> searchHabitat(String nombre) {
        HabitatDAO dao = new HabitatDAO();
        List<Habitat> habitats = new ArrayList<>();
        if (nombre != null && nombre.trim().length() > 0) {
            System.out.println(dao.getByName(nombre));
            habitats.add(dao.getByName(nombre));
        } else {
            System.out.println(dao.list().toString());
            habitats = dao.list();
        }
        return habitats;
    }
}
