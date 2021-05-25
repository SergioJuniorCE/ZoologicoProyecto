package dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import exceptions.DAOException;
import objetos.Itinerario;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Updates.set;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;

public class ItinerarioDAO extends BaseDAO<Itinerario> {

    @Override
    public void create(Itinerario ob) {
        MongoCollection<Itinerario> collection = this.getCollection();
        collection.insertOne(ob);
    }

    @Override
    public void delete(Itinerario ob) throws DAOException {
        Itinerario itinerario = this.get(ob.getId());
        if (itinerario != null) {
            MongoCollection<Itinerario> coleccion = this.getCollection();
            coleccion.deleteOne(eq("_id", ob.getId()));
        } else {
            throw new DAOException(String.format("Itinerario %s no encontrado", ob.getId()));
        }
    }

    @Override
    public void update(Itinerario ob) throws DAOException {
        MongoCollection<Itinerario> coleccion = this.getCollection();
        coleccion.updateOne(
                eq("_id", ob.getId()),
                combine(
                        set("duracion", ob.getDuracionMin()),
                        set("longitud", ob.getLongitud()),
                        set("numeroVisitantes", ob.getNumeroVisitantes()),
                        set("numeroEspecies", ob.getNumeroEspecies())
                )
        );
    }

    @Override
    public Itinerario get(ObjectId id) {
        MongoCollection<Itinerario> coleccion = this.getCollection();
        return coleccion.find(eq("_id", id)).first();
    }

    public Itinerario get(String id) {
        return this.get(new ObjectId(id));
    }

    public Itinerario getByName(String nombre) {
        MongoCollection<Itinerario> coleccion = this.getCollection();
        return coleccion.find(eq("nombre", nombre)).first();
    }

    @Override
    public List<Itinerario> list() {
        MongoCollection<Itinerario> coleccion = this.getCollection();
        FindIterable<Itinerario> itinerarios = coleccion.find();
        List<Itinerario> listaItinerarios = new ArrayList<>();
        for (Itinerario temp : itinerarios) {
            listaItinerarios.add(temp);
        }
        return listaItinerarios;
    }

    @Override
    public MongoCollection<Itinerario> getCollection() {
        MongoDatabase db = this.getMongoDatabase();
        return db.getCollection("itinerarios", Itinerario.class);
    }
}
