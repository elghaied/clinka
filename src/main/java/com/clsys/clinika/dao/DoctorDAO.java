package com.clsys.clinika.dao;

import com.clsys.clinika.model.Doctor;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DoctorDAO implements PanacheRepository<Doctor> {


}
