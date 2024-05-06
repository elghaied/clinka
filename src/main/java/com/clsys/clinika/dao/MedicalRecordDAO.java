package com.clsys.clinika.dao;


import com.clsys.clinika.model.MedicalRecord;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MedicalRecordDAO implements PanacheRepository<MedicalRecord> {


}
