package com.hacs.db;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnector {
    private static final String CONNECTION_STRING = "mongodb+srv://hacs:BAyjXN6QIXLZJN96@hacs.eeo77.mongodb.net/";
    private static final String DATABASE_NAME = "HACS";

    private static MongoClient mongoClient = null;

    public static MongoDatabase getDatabase() {
        if (mongoClient == null) {
            mongoClient = MongoClients.create(CONNECTION_STRING);
        }
        return mongoClient.getDatabase(DATABASE_NAME);
    }
}
