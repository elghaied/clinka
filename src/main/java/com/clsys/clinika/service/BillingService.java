package com.clsys.clinika.service;

import com.clsys.clinika.dao.BillingDAO;
import com.clsys.clinika.model.Billing;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class BillingService {

    private final BillingDAO billingDAO;

    @Inject
    public BillingService(BillingDAO billingDAO) {
        this.billingDAO = billingDAO;
    }

    @Transactional
    public void addBilling(Billing billing) {
        billingDAO.persist(billing);
    }

    public Billing getBillingById(Long id) {
        return billingDAO.findById(id);
    }

    public List<Billing> getAllBillings() {
        return billingDAO.listAll();
    }

    @Transactional
    public void updateBilling(Billing billing) {
        billingDAO.persistAndFlush(billing);
    }

    @Transactional
    public void deleteBilling(Long id) {
        billingDAO.deleteById(id);
    }
}
