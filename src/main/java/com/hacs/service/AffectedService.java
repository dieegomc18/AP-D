package com.hacs.service;

import com.hacs.db.MongoDBConnector;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class AffectedService {
    private final MongoCollection<Document> needsCollection;

    public AffectedService() {
        MongoDatabase database = MongoDBConnector.getDatabase();
        needsCollection = database.getCollection("needs");
    }

    public void createNeed(String type, String description, String urgency) {
        Document newNeed = new Document("type", type)
                .append("description", description)
                .append("urgency", urgency)
                .append("status", "pending");
        needsCollection.insertOne(newNeed);
        System.out.println("Need created successfully.");
    }

    public void updateNeed(String needId, String updatedDescription, String updatedUrgency) {
        Document query = new Document("_id", new org.bson.types.ObjectId(needId));
        Document update = new Document("$set", new Document("description", updatedDescription)
                .append("urgency", updatedUrgency));
        needsCollection.updateOne(query, update);
        System.out.println("Need updated successfully.");
    }

    public void deleteNeed(String needId) {
        Document query = new Document("_id", new org.bson.types.ObjectId(needId));
        needsCollection.deleteOne(query);
        System.out.println("Need deleted successfully.");
    }

    public void viewNeedStatus(String needId) {
        Document query = new Document("_id", new org.bson.types.ObjectId(needId));
        Document need = needsCollection.find(query).first();
        if (need != null) {
            System.out.println("Status: " + need.getString("status"));
        } else {
            System.out.println("Need not found.");
        }
    }
}
