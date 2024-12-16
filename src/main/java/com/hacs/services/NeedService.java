package com.hacs.services;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.hacs.database.MongoDBConnection;
import com.hacs.models.Need;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

public class NeedService {
    private final MongoCollection<Document> collection;

    public NeedService() {
        this.collection = MongoDBConnection.getDatabase("hacs").getCollection("needs");
    }

    // 1. Create Need
    public void createNeed(Need need) {
        Document doc = new Document("id", need.getId())
                .append("type", need.getType())
                .append("description", need.getDescription())
                .append("status", need.getStatus());
        collection.insertOne(doc);
        System.out.println("Need created successfully!");
    }

    // 2. Update Need
    public void updateNeed(String requestId, String field, Object newValue) {
        Bson filter = Filters.eq("id", requestId);
        Bson update = Updates.set(field, newValue);
        collection.updateOne(filter, update);
        System.out.println("Need updated successfully!");
    }

    // 3. Delete Need
    public void deleteNeed(String requestId) {
        Bson filter = Filters.eq("id", requestId);
        collection.deleteOne(filter);
        System.out.println("Need deleted successfully!");
    }

    // 4. View Need Status
    public String viewNeedStatus(String requestId) {
        Document doc = collection.find(Filters.eq("id", requestId)).first();
        if (doc == null) {
            return "Need not found!";
        }

        return String.format("""
                Need Status:
                - ID: %s
                - Type: %s
                - Description: %s
                - Status: %s
                """,
                doc.getString("id"),
                doc.getString("type"),
                doc.getString("description"),
                doc.getString("status"));
    }

    // 5. List all needs for a specific user
    public List<Need> listAllNeeds(String userId) {
        List<Need> needs = new ArrayList<>();
        for (Document doc : collection.find(Filters.eq("userId", userId))) {
            needs.add(new Need(
                    doc.getString("id"),
                    doc.getString("type"),
                    doc.getString("description")
            ));
        }
        return needs;
    }
}
