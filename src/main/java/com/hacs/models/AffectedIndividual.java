package com.hacs.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "affected_individuals")
public class AffectedIndividual {
    @Id
    private String id;
    private String name;

    @OneToMany(mappedBy = "affectedIndividual", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Need> needs;

    public AffectedIndividual() {
        this.needs = new ArrayList<>();
    }

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