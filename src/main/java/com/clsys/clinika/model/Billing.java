package com.clsys.clinika.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "billing") // Specify the table name
public class Billing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false) // Specify the column name for the patient reference and make it not nullable
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "appointment_id", nullable = false) // Specify the column name for the appointment reference and make it not nullable
    private Appointment appointment;

    @Column(nullable = false) // Make the amount column not nullable
    private BigDecimal amount;

    @Column(name = "paymentStatus", nullable = false) // Specify the column name for the payment status and make it not nullable
    private boolean paymentStatus;

    // Constructors
    public Billing() {
    }

    public Billing(Patient patient, Appointment appointment, BigDecimal amount, boolean paymentStatus) {
        this.patient = patient;
        this.appointment = appointment;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
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

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
