package DAO.impl;

import DAO.MongoDB;
import DAO.userDAO;
import Model.User;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import utils.Common;

import java.util.List;
import java.util.Map;

import static com.mongodb.client.model.Filters.eq;

public class UserDAOImpl implements userDAO {
    @Override
    public void insert(User object) {
        String collectionName = "users";
        MongoCollection<Document> collection = MongoDB.getCollection(collectionName);

        Document document;
        document = new Document("username", object.getUsername());
        document.append("password", object.getUsername());

        collection.insertOne(document);
    }

    @Override
    public void update(User object) {
        String collectionName = "users";
        MongoCollection<Document> collection = MongoDB.getCollection(collectionName);

        Document document;
        document = new Document("username", object.getUsername());
        document.append("password", object.getUsername());

        collection.updateOne(eq("username",object.getUsername()),new Document("$set",document));

    }

    @Override
    public List<User> findAll(Map<String, Object> params) {
//        String collectionName = "uses";
//        MongoCollection<Document> collection = MongoDB.getCollection(collectionName);
        return null;
    }

    @Override
    public void remove(Map<String, Object> params) {
        String collectionName = "users";
        MongoCollection<Document> collection = MongoDB.getCollection(collectionName);
    }

    @Override
    public User findOne(Map<String, Object> params) {
        String collectionName = "users";
        MongoCollection<Document> collection = MongoDB.getCollection(collectionName);

        String key= Common.getKey(params);

        Document document=collection.find(eq(key,params.get(key))).first();

        if(document==null){
            return null;
        }
        User object=new User();
        object.setUsername(document.getString("username"));
        object.setPassword(document.getString("password"));
        object.setType(document.getString("type"));

        return object;
    }
}
