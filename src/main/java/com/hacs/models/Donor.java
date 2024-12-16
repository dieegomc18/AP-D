package com.hacs.models;

import java.util.ArrayList;
import java.util.List;

public class Donor {
    private String id;
    private String name;
    private List<Donation> donations;

    public Donor(String id, String name) {
        this.id = id;
        this.name = name;
        this.donations = new ArrayList<>();
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Donation> getDonations() { return donations; }
    public void addDonation(Donation donation) { this.donations.add(donation); }
}
