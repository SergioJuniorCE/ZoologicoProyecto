package dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import exceptions.DAOException;
import objetos.Guia;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Updates.set;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;

public class GuiaDAO extends BaseDAO<Guia> {

    @Override
    public void create(Guia ob) {
        MongoCollection<Guia> collection = this.getCollection();
        collection.insertOne(ob);
    }

    @Override
    public void delete(Guia ob) throws DAOException {
        Guia guia = this.get(ob.getId());
        if (guia != null) {
            MongoCollection<Guia> coleccion = this.getCollection();
            coleccion.deleteOne(eq("_id", ob.getId()));
        } else {
            throw new DAOException(String.format("Guia %s no encontrado", ob.getId()));
        }
    }

    @Override
    public void update(Guia ob) throws DAOException {
        MongoCollection<Guia> coleccion = this.getCollection();
        coleccion.updateOne(
                eq("_id", ob.getId()),
                combine(
                        set("itinerario", ob.getItinerario()),
                        set("nombre", ob.getNombre()),
                        set("telefono", ob.getTelefono()),
                        set("fechaInicio", ob.getFechaInicio())
                )
        );
    }

    @Override
    public Guia get(ObjectId id) {
        MongoCollection<Guia> coleccion = this.getCollection();
        return coleccion.find(eq("_id", id)).first();
    }

    public Guia get(String id) {
        return this.get(new ObjectId(id));
    }

    public Guia getByName(String nombre) {
        MongoCollection<Guia> coleccion = this.getCollection();
        return coleccion.find(eq("nombre", nombre)).first();
    }

    @Override
    public List<Guia> list() {
        MongoCollection<Guia> coleccion = this.getCollection();
        FindIterable<Guia> guias = coleccion.find();
        List<Guia> listaGuias = new ArrayList<>();
        for (Guia temp : guias) {
            listaGuias.add(temp);
        }
        return listaGuias;
    }

    @Override
    public MongoCollection<Guia> getCollection() {
        MongoDatabase db = this.getMongoDatabase();
        return db.getCollection("guias", Guia.class);
    }
}
