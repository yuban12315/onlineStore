package DAO;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import sun.security.krb5.internal.tools.Klist;

import java.util.List;

/**
 * Created by HastuneMiku on 2017/8/16.
 */
public class MongoDB {
    private static MongoDatabase mongoDatabase=new MongoClient("127.0.0.1", 27017).getDatabase("onlineStore");

    public static MongoCollection<Document> getCollection(String collection) {
        return mongoDatabase.getCollection(collection);
       // if()
    }



    public static void main(String args[]) {
        //test
        try {
            MongoCollection<Document> collection1 = getCollection("users");
            FindIterable<Document> findIterable = collection1.find();
            MongoCursor<Document> mongoCursor = findIterable.iterator();
            while (mongoCursor.hasNext()) {
                System.out.println(mongoCursor.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}