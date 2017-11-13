package DAO.impl;

import DAO.MongoDB;
import DAO.goodsDAO;
import Model.Goods;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import utils.Common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.mongodb.client.model.Filters.eq;


public class GoodsDAOImpl implements goodsDAO {
    @Override
    public void insert(Goods goods) {
        String collectionName = "goods";
        MongoCollection<Document> collection = MongoDB.getCollection(collectionName);

        Document document;
        document = new Document("name", goods.getName());
        document.append("desc", goods.getDesc());
        document.append("picture", goods.getPicture());
        document.append("price", goods.getPrice());
        document.append("assort", goods.getAssort());
        document.append("quantity", goods.getQuantity());

        collection.insertOne(document);
    }

    @Override
    public Goods findOne(Map<String, Object> params) {
        String collectionName = "goods";
        MongoCollection<Document> collection = MongoDB.getCollection(collectionName);
        String key = Common.getKey(params);

        Document document = collection.find(eq(key, params.get(key))).first();
        if (document == null) {
            return null;
        }
        Goods goods = new Goods();
        goods.setName(document.getString("name"));
        goods.setQuantity(document.getInteger("quantity"));
        goods.setPrice(document.getInteger("price"));
        goods.setPicture(document.getString("picture"));
        goods.setAssort(document.getString("assort"));
        goods.setDesc(document.getString("desc"));

        return goods;
    }

    @Override
    public ArrayList<Goods> findAll(Map<String, Object> params) {
        /*page ,type*/
        String collectionName = "goods";
        MongoCollection<Document> collection = MongoDB.getCollection(collectionName);
        String type;
        int page;
        try {
            type = params.get("type").toString();
            page = Integer.parseInt(params.get("page").toString());
            if (page < 0) return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        MongoCursor<Document> docs;
        ArrayList<Goods> list = new ArrayList<Goods>();
//        if (key == null) {
//            docs = collection.find().iterator();
//        } else {
//            docs = collection.find(eq(key, params.get(key))).iterator();
//        }
        docs = collection.find().iterator();
        if (type.equals("all") || type.equals("All") || type.equals("ALL")) {
            docs = collection.find().skip(page * 10).sort(new BasicDBObject()).limit(10).iterator();
        } else {
            docs = collection.find(eq("type", type)).skip(page * 10).sort(new BasicDBObject()).limit(10).iterator();
        }
        Document document;
        while (docs.hasNext()) {
            Goods goods = new Goods();
            document = docs.next();
            goods.setName(document.getString("name"));
            goods.setQuantity(document.getInteger("quantity"));
            goods.setPrice(document.getInteger("price"));
            goods.setPicture(document.getString("picture"));
            goods.setAssort(document.getString("assort"));
            goods.setDesc(document.getString("desc"));
            goods.setId(document.getInteger("id"));
            goods.setOwner(document.getString("owner"));
            list.add(goods);
        }
        return list;
    }

    @Override
    public void update(Goods goods) {
        String collectionName = "goods";
        MongoCollection<Document> collection = MongoDB.getCollection(collectionName);

        Document document;
        document = new Document("name", goods.getName());
        document.append("desc", goods.getDesc());
        document.append("picture", goods.getPicture());
        document.append("price", goods.getPrice());
        document.append("assort", goods.getAssort());
        document.append("quantity", goods.getQuantity());
        collection.updateOne(eq("name", goods.getName()), new Document("$set", document));

    }

    @Override
    public void remove(Map<String, Object> params) {
        String collectionName = "goods";
        MongoCollection<Document> collection = MongoDB.getCollection(collectionName);

        String key = Common.getKey(params);

        if (key == null) {
            collection.drop();
        } else {
            collection.findOneAndDelete(eq(key, params.get(key)));
        }
    }

    @Override
    public int getCount() {
        String collectionName = "goods";
        MongoCollection<Document> collection = MongoDB.getCollection(collectionName);

        return (int) collection.count();
    }
}
