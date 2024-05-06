package com.clsys.clinika.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointment") // Specify the table name
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dateTime", nullable = false) // Specify the column name and make it not nullable
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false) // Specify the column name for the patient reference and make it not nullable
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false) // Specify the column name for the doctor reference and make it not nullable
    private Doctor doctor;

    // Constructors
    public Appointment() {
    }

    public Appointment(LocalDateTime dateTime, Patient patient, Doctor doctor) {
        this.dateTime = dateTime;
        this.patient = patient;
        this.doctor = doctor;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
