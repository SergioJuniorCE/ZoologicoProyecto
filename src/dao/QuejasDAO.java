package dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import exceptions.DAOException;
import objetos.Quejas;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Updates.set;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;

public class QuejasDAO extends BaseDAO<Quejas> {

    @Override
    public void create(Quejas ob) {
        MongoCollection<Quejas> collection = this.getCollection();
        collection.insertOne(ob);
    }

    @Override
    public void delete(Quejas ob) throws DAOException {
        Quejas quejas = this.get(ob.getId());
        if (quejas != null) {
            MongoCollection<Quejas> coleccion = this.getCollection();
            coleccion.deleteOne(eq("_id", ob.getId()));
        } else {
            throw new DAOException(String.format("Quejas %s no encontrado", ob.getId()));
        }
    }

    @Override
    public void update(Quejas ob) throws DAOException {
        MongoCollection<Quejas> coleccion = this.getCollection();
        coleccion.updateOne(
                eq("_id", ob.getId()),
                combine(
                        set("descripcion", ob.getDescripcion()),
                        set("fecha", ob.getFecha().toString()),
                        set("email", ob.getEmail()),
                        set("telefono", ob.getTelefono())
                )
        );
    }

    @Override
    public Quejas get(ObjectId id) {
        MongoCollection<Quejas> coleccion = this.getCollection();
        return coleccion.find(eq("_id", id)).first();
    }

    public Quejas get(String id) {
        return this.get(new ObjectId(id));
    }

    public Quejas getByName(String nombre) {
        MongoCollection<Quejas> coleccion = this.getCollection();
        return coleccion.find(eq("nombre", nombre)).first();
    }

    @Override
    public List<Quejas> list() {
        MongoCollection<Quejas> coleccion = this.getCollection();
        FindIterable<Quejas> quejass = coleccion.find();
        List<Quejas> listaQuejass = new ArrayList<>();
        for (Quejas temp : quejass) {
            listaQuejass.add(temp);
        }
        return listaQuejass;
    }

    @Override
    public MongoCollection<Quejas> getCollection() {
        MongoDatabase db = this.getMongoDatabase();
        return db.getCollection("quejass", Quejas.class);
    }
}
