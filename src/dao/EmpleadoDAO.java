package dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import exceptions.DAOException;
import objetos.Empleado;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import java.util.List;
import static com.mongodb.client.model.Updates.set;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;

public class EmpleadoDAO extends BaseDAO<Empleado> {

    @Override
    public void create(Empleado ob) {
        MongoCollection<Empleado> collection = this.getCollection();
        collection.insertOne(ob);
    }

    @Override
    public void delete(Empleado ob) throws DAOException {
        Empleado empleado = this.get(ob.getId());
        if (empleado != null) {
            MongoCollection<Empleado> coleccion = this.getCollection();
            coleccion.deleteOne(eq("_id", ob.getId()));
        } else {
            throw new DAOException(String.format("Empleado %s no encontrado", ob.getId()));
        }
    }

    @Override
    public void update(Empleado ob) throws DAOException {
        MongoCollection<Empleado> coleccion = this.getCollection();
        coleccion.updateOne(
                eq("_id", ob.getId()),
                combine(
                        set("nombre", ob.getNombre()),
                        set("telefono", ob.getTelefono()),
                        set("fechaInicio", ob.getFechaInicio())
                )
        );
    }

    @Override
    public Empleado get(ObjectId id) {
        MongoCollection<Empleado> coleccion = this.getCollection();
        return coleccion.find(eq("_id", id)).first();
    }

    public Empleado get(String id) {
        return this.get(new ObjectId(id));
    }

    public Empleado getByName(String nombre) {
        MongoCollection<Empleado> coleccion = this.getCollection();
        return coleccion.find(eq("nombre", nombre)).first();
    }

    @Override
    public List<Empleado> list() {
        MongoCollection<Empleado> coleccion = this.getCollection();
        FindIterable<Empleado> empleados = coleccion.find();
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        for (Empleado temp : empleados) {
            listaEmpleados.add(temp);
        }
        return listaEmpleados;
    }

    @Override
    public MongoCollection<Empleado> getCollection() {
        MongoDatabase db = this.getMongoDatabase();
        return db.getCollection("empleados", Empleado.class);
    }
}
