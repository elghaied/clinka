package com.clsys.clinika.service;

import com.clsys.clinika.dao.PrescriptionDAO;
import com.clsys.clinika.model.Prescription;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
@SuppressWarnings("cdi.unsatisfieddependency")
@ApplicationScoped
public class PrescriptionService {

    private final PrescriptionDAO prescriptionDAO;

    @Inject
    public PrescriptionService(PrescriptionDAO prescriptionDAO) {
        this.prescriptionDAO = prescriptionDAO;
    }

    @Transactional
    public void addPrescription(Prescription prescription) {
        prescriptionDAO.persistAndFlush(prescription);
    }

    public Prescription getPrescriptionById(Long id) {
        return prescriptionDAO.findById(id);
    }

    public List<Prescription> getAllPrescriptions() {
        return prescriptionDAO.listAll();
    }

    @Transactional
    public void updatePrescription(Prescription prescription) {
        prescriptionDAO.persistAndFlush(prescription);
    }

    @Transactional
    public void deletePrescription(Long id) {
        prescriptionDAO.deleteById(id);
    }
}
