package control;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Control {
    private final MongoClientURI uri;
    private final MongoClient mongoClient;
    private MongoDatabase database;
    
    public Control(){
        uri = new MongoClientURI(
                "mongodb+srv://admin:admin@cluster0.omhei.mongodb.net/myFirstDa"
                        + "tabase?retryWrites=true&w=majority");
        mongoClient = new MongoClient(uri);
        database = mongoClient.getDatabase("zoologico");
    }
    
    
}
