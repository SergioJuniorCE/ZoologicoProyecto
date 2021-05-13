package pruebas;

import dao.HabitatDAO;
import java.util.ArrayList;
import org.bson.types.ObjectId;

public class Pruebas {

    public static void main(String args[]) {
        HabitatDAO dao = new HabitatDAO();
        ArrayList<String> continentes = new ArrayList<>();
        continentes.add("America");
        continentes.add("Oceania");
        dao.create("Selva", "Humedo", "Forndoza", continentes);
        dao.get(new ObjectId("609cbdfd453ecf4ebb4eefd0"));
    }
}
