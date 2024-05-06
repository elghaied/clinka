package com.clsys.clinika.service;

import com.clsys.clinika.dao.PatientDAO;
import com.clsys.clinika.model.Patient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import java.util.List;
@SuppressWarnings("cdi.unsatisfieddependency")
@ApplicationScoped
public class PatientService {

    private final PatientDAO patientDAO;

    @Inject
    public PatientService(PatientDAO patientDAO) {
        this.patientDAO = patientDAO;
    }

    @Transactional
    public void addPatient(Patient patient) {
        patientDAO.persist(patient);
    }

    public Patient getPatientById(Long id) {
        return patientDAO.findById(id);
    }

    public List<Patient> getAllPatients() {
        return patientDAO.listAll();
    }

    @Transactional
    public void updatePatient(Patient patient) {
        patientDAO.persistAndFlush(patient);
    }

    @Transactional
    public void deletePatient(Long id) {
        patientDAO.deleteById(id);
    }
}
