package com.clsys.clinika.service;

import com.clsys.clinika.dao.DoctorDAO;
import com.clsys.clinika.model.Doctor;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Model;
import jakarta.inject.Inject;


import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import java.util.List;

@SuppressWarnings("cdi.unsatisfieddependency")
@RequestScoped
public class DoctorService {

    private final DoctorDAO doctorDAO;

    @Inject
    public DoctorService(DoctorDAO doctorDAO) {
        this.doctorDAO = doctorDAO;
    }

    @Transactional
    public void addDoctor(Doctor doctor) {
        doctorDAO.persist(doctor);
    }

    public Doctor getDoctorById(Long id) {
        return doctorDAO.findById(id);
    }

    public List<Doctor> getAllDoctors() {
        return doctorDAO.listAll();
    }

    @Transactional
    public void updateDoctor(Doctor doctor) {
        doctorDAO.persistAndFlush(doctor);
    }

    @Transactional
    public void deleteDoctor(Long id) {
        doctorDAO.deleteById(id);
    }
}
