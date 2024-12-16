package com.hacs.models;

public class Need {
    private String id;
    private String type;
    private String description;
    private String status;

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
}
