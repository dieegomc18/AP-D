package com.hacs.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "donors")
public class Donor {
    @Id
    private String id;
    private String name;

    @OneToMany(mappedBy = "donor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Donation> donations;

    public Donor() {
        this.donations = new ArrayList<>();
    }

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