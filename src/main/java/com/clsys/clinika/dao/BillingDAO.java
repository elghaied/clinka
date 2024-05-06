package com.clsys.clinika.dao;

import com.clsys.clinika.model.Billing;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BillingDAO implements PanacheRepository<Billing> {


}
