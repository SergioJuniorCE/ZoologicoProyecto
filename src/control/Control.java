package control;

import dao.CuidadorDAO;
import dao.EmpleadoDAO;
import dao.EspecieDAO;
import dao.GuiaDAO;
import dao.HabitatDAO;
import dao.ItinerarioDAO;
import dao.ZonaDAO;
import exceptions.DAOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import objetos.Cuidador;
import objetos.Empleado;
import objetos.Especie;
import objetos.Guia;
import objetos.Habitat;
import objetos.Itinerario;
import objetos.Zona;
import org.bson.types.ObjectId;

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

    public static void updateHabitat(ObjectId id, String clima, String vegetacion, String continente, String nombre) throws DAOException {
        HabitatDAO dao = new HabitatDAO();
        Habitat habitat = new Habitat(id, nombre, clima, vegetacion, continente);
        dao.update(habitat);
    }

    public static void deleteHabitat(ObjectId id, String clima, String vegetacion, String continente, String nombre) throws DAOException {
        HabitatDAO dao = new HabitatDAO();
        Habitat habitat = new Habitat(id, nombre, clima, vegetacion, continente);
        dao.delete(habitat);
    }

    public static void createEspecie(String nombre, String nomCientifico, String descripcion, String habitat) throws DAOException {

        try {
            EspecieDAO dao = new EspecieDAO();
            Especie especie = new Especie(nombre, nomCientifico, descripcion, habitat);
            dao.create(especie);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DAOException("No se pudo registrar especie");
        }
    }

    public static List<Especie> searchEspecie() {
        EspecieDAO dao = new EspecieDAO();
        return dao.list();
    }

    public static List<Cuidador> listCuidador() {
        CuidadorDAO dao = new CuidadorDAO();
        return dao.list();
    }
    
    public static List<Itinerario> listItinerario() {
        ItinerarioDAO dao = new ItinerarioDAO();
        return dao.list();
    }

    public static List<Empleado> searchEmpleado(String nombre) {
        EmpleadoDAO dao = new EmpleadoDAO();
        List<Empleado> empleados = new ArrayList<>();
        if (nombre != null && nombre.trim().length() > 0) {
            System.out.println(dao.getByName(nombre));
            empleados.add(dao.getByName(nombre));
        } else {
            System.out.println(dao.list().toString());
            empleados = dao.list();
        }
        return empleados;
    }

    public static void createEmpleado(String nombre, String telefono, LocalDateTime fechaInicio) throws DAOException {
        try {
            EmpleadoDAO dao = new EmpleadoDAO();
            Empleado empleado = new Empleado(nombre, telefono, fechaInicio);
            dao.create(empleado);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DAOException("No se pudo registrar especie");
        }
    }

    public static List<Guia> searchGuia() {
        GuiaDAO dao = new GuiaDAO();
        return dao.list();
    }

    public static List<Zona> searchZona(String nombre) {
        ZonaDAO dao = new ZonaDAO();
        List<Zona> zonas = new ArrayList<>();
        if (nombre != null && nombre.trim().length() > 0) {
            System.out.println(dao.getByName(nombre));
            zonas.add(dao.getByName(nombre));
        } else {
            System.out.println(dao.list().toString());
            zonas = dao.list();
        }
        return zonas;
    }

    public static void createZona(String nombre, int extencion, String especies) throws DAOException {
        try {
            ZonaDAO dao = new ZonaDAO();
            Zona zona = new Zona(nombre, extencion, especies);
            dao.create(zona);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DAOException("No se pudo registrar la zona");
        }
    }

    public static void createCuidador(String especieCuidada, String nombre,
            LocalDateTime fecha, String especieExperto, String especieBasico)
            throws DAOException {
        try {
            EmpleadoDAO empleadoDAO = new EmpleadoDAO();

            Empleado empleado = empleadoDAO.getByName(nombre);

            CuidadorDAO cuidadorDAO = new CuidadorDAO();
            
            Cuidador cuidador = new Cuidador(
                    especieExperto,
                    especieBasico,
                    fecha,
                    especieCuidada,
                    nombre,
                    empleado.getTelefono(),
                    empleado.getFechaInicio()
            );
            
            cuidadorDAO.create(cuidador);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DAOException("No se pudo registrar el cuidador" + e.getMessage());
        }
    }
}
