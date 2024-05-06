package com.clsys.clinika.service;

import com.clsys.clinika.dao.MedicalRecordDAO;
import com.clsys.clinika.model.MedicalRecord;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class MedicalRecordService {

    private final MedicalRecordDAO medicalRecordDAO;

    @Inject
    public MedicalRecordService(MedicalRecordDAO medicalRecordDAO) {
        this.medicalRecordDAO = medicalRecordDAO;
    }

    @Transactional
    public void addMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecordDAO.persist(medicalRecord);
    }

    public MedicalRecord getMedicalRecordById(Long id) {
        return medicalRecordDAO.findById(id);
    }

    public List<MedicalRecord> getAllMedicalRecords() {
        return medicalRecordDAO.listAll();
    }

    @Transactional
    public void updateMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecordDAO.persistAndFlush(medicalRecord);
    }

    @Transactional
    public void deleteMedicalRecord(Long id) {
        medicalRecordDAO.deleteById(id);
    }
}
