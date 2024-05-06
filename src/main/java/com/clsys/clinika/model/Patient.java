package com.clsys.clinika.model;


import jakarta.persistence.Entity;

@Entity
public class Patient extends Person {
    private String medicalHistory;

    private String currentHealthStatus;


    // Constructors
    public Patient() {
    }

    public Patient(String name, String contactInformation, String address, String medicalHistory, String currentHealthStatus) {
        super(name, contactInformation, address);
        this.medicalHistory = medicalHistory;
        this.currentHealthStatus = currentHealthStatus;
    }

    // Getters and setters
    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getCurrentHealthStatus() {
        return currentHealthStatus;
    }

    public void setCurrentHealthStatus(String currentHealthStatus) {
        this.currentHealthStatus = currentHealthStatus;
    }
}
