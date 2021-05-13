package pruebas;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Pruebas {

    public static void main(String args[]) {
        MongoClientURI uri = new MongoClientURI(
                "mongodb+srv://admin:admin@cluster0.omhei.mongodb.net/myFirstDa"
                        + "tabase?retryWrites=true&w=majority");
        MongoClient mongoClient = new MongoClient(uri);
        
        MongoDatabase database = mongoClient.getDatabase("zoologico");
        MongoCollection collection = database.getCollection("animales");
//        collection.insertOne();
    }
}
