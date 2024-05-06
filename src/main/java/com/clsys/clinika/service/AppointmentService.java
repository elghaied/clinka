package com.clsys.clinika.service;

import com.clsys.clinika.dao.AppointmentDAO;
import com.clsys.clinika.model.Appointment;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class AppointmentService {

    private final AppointmentDAO appointmentDAO;

    @Inject
    public AppointmentService(AppointmentDAO appointmentDAO) {
        this.appointmentDAO = appointmentDAO;
    }

    @Transactional
    public void addAppointment(Appointment appointment) {
        appointmentDAO.persist(appointment);
    }

    public Appointment getAppointmentById(Long id) {
        return appointmentDAO.findById(id);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentDAO.listAll();
    }

    @Transactional
    public void updateAppointment(Appointment appointment) {
        appointmentDAO.persistAndFlush(appointment);
    }

    @Transactional
    public void deleteAppointment(Long id) {
        appointmentDAO.deleteById(id);
    }
}
