package com.hacs.service;

import com.hacs.db.MongoDBConnector;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class DonorService {
    private final MongoCollection<Document> donationsCollection;

    public DonorService() {
        MongoDatabase database = MongoDBConnector.getDatabase();
        donationsCollection = database.getCollection("donations");
    }

    public void createDonation(String type, double amount, String description) {
        Document newDonation = new Document("type", type)
                .append("amount", amount)
                .append("description", description)
                .append("status", "confirmed");
        donationsCollection.insertOne(newDonation);
        System.out.println("Donation created successfully.");
    }

    public void updateDonation(String donationId, String updatedDescription, double updatedAmount) {
        Document query = new Document("_id", new org.bson.types.ObjectId(donationId));
        Document update = new Document("$set", new Document("description", updatedDescription)
                .append("amount", updatedAmount));
        donationsCollection.updateOne(query, update);
        System.out.println("Donation updated successfully.");
    }

    public void deleteDonation(String donationId) {
        Document query = new Document("_id", new org.bson.types.ObjectId(donationId));
        donationsCollection.deleteOne(query);
        System.out.println("Donation deleted successfully.");
    }

    public void viewDonationHistory(String donorId) {
        Document query = new Document("donorId", donorId);
        List<Document> donations = donationsCollection.find(query).into(new ArrayList<>());
        for (Document donation : donations) {
            System.out.println(donation.toJson());
        }
    }

    public void generateDonationConfirmation(String donationId) {
        Document query = new Document("_id", new org.bson.types.ObjectId(donationId));
        Document donation = donationsCollection.find(query).first();
        if (donation != null) {
            System.out.println("Donation Confirmation:");
            System.out.println("Type: " + donation.getString("type"));
            System.out.println("Amount: " + donation.getDouble("amount"));
            System.out.println("Date: " + donation.getDate("date"));
            System.out.println("Confirmation ID: " + donation.getObjectId("_id").toHexString());
        } else {
            System.out.println("Donation not found.");
        }
    }
}
