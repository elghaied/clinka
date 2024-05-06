package com.clsys.clinika.model;

import jakarta.persistence.*;

@Entity
@Table(name = "medicalrecord") // Specify the table name
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false) // Specify the column name for the patient reference and make it not nullable
    private Patient patient;

    @Column(name = "diagnoses") // Specify the column name for diagnoses
    private String diagnoses;

    @Column(name = "treatments") // Specify the column name for treatments
    private String treatments;
    // Constructors
    public MedicalRecord() {
    }

    public MedicalRecord(Patient patient, String diagnoses, String treatments) {
        this.patient = patient;
        this.diagnoses = diagnoses;
        this.treatments = treatments;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(String diagnoses) {
        this.diagnoses = diagnoses;
    }

    public String getTreatments() {
        return treatments;
    }

    public void setTreatments(String treatments) {
        this.treatments = treatments;
    }
}
