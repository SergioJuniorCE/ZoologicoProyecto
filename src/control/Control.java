package control;

import dao.EspecieDAO;
import dao.GuiaDAO;
import dao.HabitatDAO;
import dao.ItinerarioDAO;
import exceptions.DAOException;
import java.util.ArrayList;
import java.util.List;
import objetos.Especie;
import objetos.Guia;
import objetos.Habitat;
import objetos.Itinerario;

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
    
        public static void createEspecie(String nombre, String nomCientifico, String descripcion, String habitat) throws DAOException {
        try {
            EspecieDAO dao = new EspecieDAO();
            Especie especie = new Especie(nombre, nomCientifico, descripcion, null);
            dao.create(especie);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DAOException("No se pudo registrar especie");
        }
    }
    
     public static List<Itinerario> searchItinerario() {
       ItinerarioDAO dao = new ItinerarioDAO();
       List<Itinerario> itinerarios = new ArrayList<>();
       System.out.println(dao.list().toString());
       itinerarios = dao.list();
       
       return itinerarios;
     }
     
       public static List<Guia> searchGuia() {
       GuiaDAO dao = new GuiaDAO();
       List<Guia> guias = new ArrayList<>();
       System.out.println(dao.list().toString());
       guias = dao.list();
       
       return guias;
     }
     
     
    
    
}
