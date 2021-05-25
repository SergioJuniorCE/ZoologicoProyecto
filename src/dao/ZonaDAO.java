package dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import exceptions.DAOException;
import objetos.Zona;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Updates.set;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;

public class ZonaDAO extends BaseDAO<Zona> {

    @Override
    public void create(Zona ob) {
        MongoCollection<Zona> collection = this.getCollection();
        collection.insertOne(ob);
    }

    @Override
    public void delete(Zona ob) throws DAOException {
        Zona zona = this.get(ob.getId());
        if (zona != null) {
            MongoCollection<Zona> coleccion = this.getCollection();
            coleccion.deleteOne(eq("_id", ob.getId()));
        } else {
            throw new DAOException(String.format("Zona %s no encontrado", ob.getId()));
        }
    }

    @Override
    public void update(Zona ob) throws DAOException {
        MongoCollection<Zona> coleccion = this.getCollection();
        coleccion.updateOne(
                eq("_id", ob.getId()),
                combine(
                        set("nombre", ob.getNombre()),
                        set("extencion", ob.getExtencion()),
                        set("especies", ob.getExtencion())
                )
        );
    }

    @Override
    public Zona get(ObjectId id) {
        MongoCollection<Zona> coleccion = this.getCollection();
        return coleccion.find(eq("_id", id)).first();
    }

    public Zona get(String id) {
        return this.get(new ObjectId(id));
    }

    public Zona getByName(String nombre) {
        MongoCollection<Zona> coleccion = this.getCollection();
        return coleccion.find(eq("nombre", nombre)).first();
    }

    @Override
    public List<Zona> list() {
        MongoCollection<Zona> coleccion = this.getCollection();
        FindIterable<Zona> zonas = coleccion.find();
        List<Zona> listaZonas = new ArrayList<>();
        for (Zona temp : zonas) {
            listaZonas.add(temp);
        }
        return listaZonas;
    }

    @Override
    public MongoCollection<Zona> getCollection() {
        MongoDatabase db = this.getMongoDatabase();
        return db.getCollection("zonas", Zona.class);
    }
}
