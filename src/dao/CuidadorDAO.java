package dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import exceptions.DAOException;
import objetos.Cuidador;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import java.util.List;
import static com.mongodb.client.model.Updates.set;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;

public class CuidadorDAO extends BaseDAO<Cuidador> {

    @Override
    public void create(Cuidador ob) {
        MongoCollection<Cuidador> collection = this.getCollection();
        collection.insertOne(ob);
    }

    @Override
    public void delete(Cuidador ob) throws DAOException {
        Cuidador cuidador = this.get(ob.getId());
        if (cuidador != null) {
            MongoCollection<Cuidador> coleccion = this.getCollection();
            coleccion.deleteOne(eq("_id", ob.getId()));
        } else {
            throw new DAOException(String.format("Cuidador %s no encontrado", ob.getId()));
        }
    }

    @Override
    public void update(Cuidador ob) throws DAOException {
        MongoCollection<Cuidador> coleccion = this.getCollection();
        coleccion.updateOne(
                eq("_id", ob.getId()),
                combine(
                        set("nombre", ob.getNombre()),
                        set("expertos", ob.getExpertos()),
                        set("basicos", ob.getBasico()),
                        set("fechaInicio", ob.getFechaInicio()),
                        set("especieCuidada", ob.getEspecieCuidada())
                )
        );
    }

    @Override
    public Cuidador get(ObjectId id) {
        MongoCollection<Cuidador> coleccion = this.getCollection();
        return coleccion.find(eq("_id", id)).first();
    }

    public Cuidador get(String id) {
        return this.get(new ObjectId(id));
    }

    public Cuidador getByName(String nombre) {
        MongoCollection<Cuidador> coleccion = this.getCollection();
        return coleccion.find(eq("nombre", nombre)).first();
    }

    @Override
    public List<Cuidador> list() {
        MongoCollection<Cuidador> coleccion = this.getCollection();
        FindIterable<Cuidador> cuidadores = coleccion.find();
        List<Cuidador> listaCuidadores = new ArrayList<>();
        for (Cuidador temp : cuidadores) {
            listaCuidadores.add(temp);
        }
        return listaCuidadores;
    }

    @Override
    public MongoCollection<Cuidador> getCollection() {
        MongoDatabase db = this.getMongoDatabase();
        return db.getCollection("cuidadores", Cuidador.class);
    }
}
