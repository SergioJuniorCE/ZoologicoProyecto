package dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import exceptions.DAOException;
import objetos.Habitat;
import static com.mongodb.client.model.Updates.combine;
import org.bson.types.ObjectId;
import static com.mongodb.client.model.Updates.set;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class HabitatDAO extends BaseDAO<Habitat> {

    @Override
    public void create(Habitat ob) {
        MongoCollection<Habitat> collection = this.getCollection();
        collection.insertOne(ob);
    }

    @Override
    public void delete(Habitat ob) throws DAOException {
        Habitat habitat = this.get(ob.getId());
        if (habitat != null) {
            MongoCollection<Habitat> coleccion = this.getCollection();
            coleccion.deleteOne(eq("_id", ob.getId()));
        } else {
            throw new DAOException(String.format("Habitat %s no encontrado", ob.getId()));
        }
    }

    @Override
    public void update(Habitat ob) throws DAOException {
        MongoCollection<Habitat> coleccion = this.getCollection();
        coleccion.updateOne(
                eq("_id", ob.getId()),
                combine(
                        set("nombre", ob.getNombre()),
                        set("clima", ob.getClima()),
                        set("tipoVegetacion", ob.getTipoVegetacion()),
                        set("continentes", ob.getContinentes())
                )
        );
    }

    @Override
    public Habitat get(ObjectId id) {
        MongoCollection<Habitat> coleccion = this.getCollection();
        return coleccion.find(eq("_id", id)).first();
    }

    public Habitat get(String id) {
        return this.get(new ObjectId(id));
    }

    public Habitat getByName(String nombre) {
        MongoCollection<Habitat> coleccion = this.getCollection();
        return coleccion.find(eq("nombre", nombre)).first();
    }

    @Override
    public List<Habitat> list() {
        MongoCollection<Habitat> coleccion = this.getCollection();
        FindIterable<Habitat> habitats = coleccion.find();
        List<Habitat> listaHabitats = new ArrayList<>();
        for (Habitat temp : habitats) {
            listaHabitats.add(temp);
        }
        return listaHabitats;
    }

    @Override
    public MongoCollection<Habitat> getCollection() {
        MongoDatabase db = this.getMongoDatabase();
        return db.getCollection("habitats", Habitat.class);
    }
}
