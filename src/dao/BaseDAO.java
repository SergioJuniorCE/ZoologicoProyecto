package dao;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import exceptions.DAOException;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.types.ObjectId;

import java.util.List;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public abstract class BaseDAO<Obj> {
    private static final String DATABASE_NAME = "zoologico";

    public MongoDatabase getMongoDatabase() {
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
//        MongoClientURI uri = new MongoClientURI(
//                "mongodb+srv://admin:admin@cluster0.omhei.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
//        MongoClient mongoClient = new MongoClient(uri);
        MongoClient mongoClient = new MongoClient(
                "localhost",
                MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
        return mongoClient.getDatabase(DATABASE_NAME);
    }

    public abstract void create(Obj ob);

    public abstract void delete(Obj ob) throws DAOException;

    public abstract void update(Obj ob) throws DAOException;

    public abstract Obj get(ObjectId id);

    public abstract List<Obj> list();

    public abstract MongoCollection<Obj> getCollection();
}
