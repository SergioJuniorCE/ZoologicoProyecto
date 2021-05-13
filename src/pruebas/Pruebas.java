package pruebas;

import dao.HabitatDAO;
import java.util.Arrays;
import java.util.List;

import objetos.Habitat;
import org.bson.types.ObjectId;

public class Pruebas {

    public static void main(String args[]) {
        HabitatDAO dao = new HabitatDAO();
        List<String> continentes = Arrays.asList("Oceania", "America");
        dao.create(new Habitat("Selva", "Humedo", "Forndoza", continentes));
        System.out.println(dao.get(new ObjectId("609dac45edf35fa6bb5dcfc2")));
    }
}
