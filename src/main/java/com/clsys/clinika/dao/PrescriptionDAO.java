package com.clsys.clinika.dao;

import com.clsys.clinika.model.Prescription;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PrescriptionDAO implements PanacheRepository<Prescription> {


}
