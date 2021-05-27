package dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import exceptions.DAOException;
import objetos.Especie;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import java.util.List;
import static com.mongodb.client.model.Updates.set;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;

public class EspecieDAO extends BaseDAO<Especie> {

    @Override
    public void create(Especie ob) {
        MongoCollection<Especie> collection = this.getCollection();
        collection.insertOne(ob);
    }

    @Override
    public void delete(Especie ob) throws DAOException {
        Especie especie = this.get(ob.getId());
        if (especie != null) {
            MongoCollection<Especie> coleccion = this.getCollection();
            coleccion.deleteOne(eq("_id", ob.getId()));
        } else {
            throw new DAOException(String.format("Especie %s no encontrado", ob.getId()));
        }
    }

    @Override
    public void update(Especie ob) throws DAOException {
        MongoCollection<Especie> coleccion = this.getCollection();
        coleccion.updateOne(
                eq("_id", ob.getId()),
                combine(
                        set("nombre", ob.getNombre()),
                        set("nombreCientifico", ob.getNombreCientifico()),
                        set("descripcion", ob.getDescripcion()),
                        set("habitats", ob.getHabitat())
                )
        );
    }

    @Override
    public Especie get(ObjectId id) {
        MongoCollection<Especie> coleccion = this.getCollection();
        return coleccion.find(eq("_id", id)).first();
    }

    public Especie get(String id) {
        return this.get(new ObjectId(id));
    }

    public Especie getByName(String nombre) {
        MongoCollection<Especie> coleccion = this.getCollection();
        return coleccion.find(eq("nombre", nombre)).first();
    }

    @Override
    public List<Especie> list() {
        MongoCollection<Especie> coleccion = this.getCollection();
        FindIterable<Especie> especies = coleccion.find();
        List<Especie> listaEspecies = new ArrayList<>();
        for (Especie temp : especies) {
            listaEspecies.add(temp);
        }
        return listaEspecies;
    }

    @Override
    public MongoCollection<Especie> getCollection() {
        MongoDatabase db = this.getMongoDatabase();
        return db.getCollection("especies", Especie.class);
    }
}
