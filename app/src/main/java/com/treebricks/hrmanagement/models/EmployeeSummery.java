package com.treebricks.hrmanagement.models;

public class EmployeeSummery {
    private String imageUrl;
    private String name;
    private String designation;
    private String email;

    public EmployeeSummery(String imageUrl, String name, String designation, String email) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.designation = designation;
        this.email = email;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
