package com.clsys.clinika.dao;

import com.clsys.clinika.model.Appointment;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class AppointmentDAO implements PanacheRepository<Appointment> {

}
