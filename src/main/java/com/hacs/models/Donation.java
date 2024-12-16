package com.hacs.models;

import java.util.Date;

public class Donation {
    private String id;
    private String type;
    private double amount;
    private String description;
    private Date date;

    public Donation(String id, String type, double amount, String description) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.date = new Date();
    }

    // Getters and Setters
    public String getId() { return id; }
    public String getType() { return type; }
    public double getAmount() { return amount; }
    public String getDescription() { return description; }
    public Date getDate() { return date; }
}
