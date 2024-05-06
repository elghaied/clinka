package com.clsys.clinika.model;

import jakarta.persistence.*;

@Entity
@Table(name = "person") // Specify the table name in lowercase
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // Specify the column name in lowercase
    private Long id;

    @Column(name = "name", nullable = false) // Specify the column name in lowercase and make it not nullable
    private String name;

    @Column(name = "contactInformation") // Specify the column name in lowercase
    private String contactInformation;

    @Column(name = "address") // Specify the column name in lowercase
    private String address;

    // Constructors
    public Person() {
    }

    public Person(String name, String contactInformation, String address) {
        this.name = name;
        this.contactInformation = contactInformation;
        this.address = address;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
