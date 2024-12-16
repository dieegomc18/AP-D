package com.hacs.database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {
    private static final String CONNECTION_URI = "mongodb+srv://hacs:BAyjXN6QIXLZJN96@hacs.eeo77.mongodb.net/";

    public static MongoDatabase getDatabase(String dbName) {
        MongoClient mongoClient = MongoClients.create(CONNECTION_URI);
        return mongoClient.getDatabase(dbName);
    }
}
