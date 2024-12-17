package com.hacs.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "donations")
public class Donation {
    @Id
    private String id;
    private String type;
    private double amount;
    private String description;
    private Date date;

    public Donation() {
        this.date = new Date();
    }

    public Donation(String id, String type, double amount, String description) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.date = new Date();
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Date getDate() { return date; }
}