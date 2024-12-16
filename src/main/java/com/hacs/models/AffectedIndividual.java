package com.hacs.models;


import java.util.ArrayList;
import java.util.List;

public class AffectedIndividual {
    private String id;
    private String name;
    private List<Need> needs;

    public AffectedIndividual(String id, String name) {
        this.id = id;
        this.name = name;
        this.needs = new ArrayList<>();
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Need> getNeeds() { return needs; }
    public void addNeed(Need need) { this.needs.add(need); }
}
