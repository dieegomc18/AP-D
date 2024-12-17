package com.hacs.models;

import javax.persistence.*;

@Entity
@Table(name = "needs")
public class Need {
    @Id
    private String id;
    private String type;
    private String description;
    private String status;

    @ManyToOne
    @JoinColumn(name = "affected_individual_id")
    private AffectedIndividual affectedIndividual;

    public Need() {
        this.status = "Pending";
    }

    public Need(String id, String type, String description) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.status = "Pending";
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public AffectedIndividual getAffectedIndividual() { return affectedIndividual; }
    public void setAffectedIndividual(AffectedIndividual affectedIndividual) { this.affectedIndividual = affectedIndividual; }
}