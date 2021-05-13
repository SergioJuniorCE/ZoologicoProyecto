package dao;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import objetos.Habitat;
import org.bson.Document;
import org.bson.types.ObjectId;

public class HabitatDAO {

    private final MongoDatabase database;
    MongoCollection<Document> collection;
    
    public HabitatDAO() {
        MongoClientURI uri = new MongoClientURI(
                "mongodb+srv://admin:admin@cluster0.omhei.mongodb.net/myFirstDa"
                + "tabase?retryWrites=true&w=majority");
        MongoClient mongoClient = new MongoClient(uri);
        database = mongoClient.getDatabase("zoologico");
        collection = database.getCollection("habitats");
    }

    /**
     *
     * @param nombre
     * @param clima
     * @param tipoVegetacion
     * @param continentes
     * @return
     */
    public boolean create(String nombre, String clima, String tipoVegetacion,
            ArrayList<String> continentes) {
        try {
            Habitat habitat = new Habitat(nombre, clima, tipoVegetacion, continentes);
            Document document = new Document("nombre", nombre).
                    append("clima", clima).
                    append("tipoVegetacion", tipoVegetacion);

            Document continenteDoc = new Document();
            for (int i = 0; i < continentes.size(); i++) {
                String cont = continentes.get(i);
                continenteDoc.append(String.valueOf(i), cont);
            }
            document.append("continentes", continenteDoc);
            
            collection.insertOne(document);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    public boolean update(ObjectId id, String nombre, String clima, String tipoVegetacion,
            ArrayList<String> continentes){
        
        return true;
    }
    
    public Habitat get(ObjectId id){
        try {
            
            Document habitatDoc = collection.find(new Document("_id", id)).first();
            System.out.println(habitatDoc.toJson());
        } catch (Exception e) {
        }
        return null;
    }
}
