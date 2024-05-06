package com.clsys.clinika.dao;


import com.clsys.clinika.model.Patient;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PatientDAO implements PanacheRepository<Patient> {


}
