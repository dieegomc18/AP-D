package com.hacs.services;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.hacs.database.MongoDBConnection;
import com.hacs.models.Donation;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

public class DonationService {
    private final MongoCollection<Document> collection;

    public DonationService() {
        this.collection = MongoDBConnection.getDatabase("hacs").getCollection("donations");
    }

    // Create a new donation
    public void createDonation(Donation donation) {
        Document doc = new Document("id", donation.getId())
                .append("type", donation.getType())
                .append("amount", donation.getAmount())
                .append("description", donation.getDescription())
                .append("date", donation.getDate());
        collection.insertOne(doc);
    }

    // Update an existing donation
    public void updateDonation(String donationId, Donation updatedDonation) {
        Bson filter = Filters.eq("id", donationId);
        Bson updates = Updates.combine(
                Updates.set("type", updatedDonation.getType()),
                Updates.set("amount", updatedDonation.getAmount()),
                Updates.set("description", updatedDonation.getDescription())
        );
        collection.updateOne(filter, updates);
    }

    // Delete a donation
    public void deleteDonation(String donationId) {
        Bson filter = Filters.eq("id", donationId);
        collection.deleteOne(filter);
    }

    // View donation history for a donor
    public List<Donation> viewDonationHistory(String donorId) {
        List<Donation> donations = new ArrayList<>();
        for (Document doc : collection.find(Filters.eq("donorId", donorId))) {
            donations.add(new Donation(
                    doc.getString("id"),
                    doc.getString("type"),
                    doc.getDouble("amount"),
                    doc.getString("description")
            ));
        }
        return donations;
    }

    // Generate donation confirmation
    public String generateDonationConfirmation(String donationId) {
        Document doc = collection.find(Filters.eq("id", donationId)).first();
        if (doc == null) {
            return "Donation not found.";
        }
        return String.format(
                "Donation Confirmation:\nID: %s\nType: %s\nAmount: %.2f\nDescription: %s\nDate: %s",
                doc.getString("id"),
                doc.getString("type"),
                doc.getDouble("amount"),
                doc.getString("description"),
                doc.getDate("date")
        );
    }
}
