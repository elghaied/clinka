package com.clsys.clinika.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Doctor extends Person {
    @Column(name = "specialization")
    private String specialization;

    // Constructors
    public Doctor() {
    }

    public Doctor(String name, String contactInformation, String address, String specialization) {
        super(name, contactInformation, address);
        this.specialization = specialization;
    }

    // Getters and setters
    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
