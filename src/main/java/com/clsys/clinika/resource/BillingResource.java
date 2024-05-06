package com.clsys.clinika.resource;

import com.clsys.clinika.model.Billing;
import com.clsys.clinika.service.BillingService;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/billings")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BillingResource {

    @Inject
    private Instance<BillingService> billingService;

    @GET
    public List<Billing> getAllBillings() {
        return billingService.get().getAllBillings();
    }

    @GET
    @Path("/{id}")
    public Response getBillingById(@PathParam("id") Long id) {
        Billing billing = billingService.get().getBillingById(id);
        if (billing != null) {
            return Response.ok(billing).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response addBilling(Billing billing) {
        billingService.get().addBilling(billing);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateBilling(@PathParam("id") Long id, Billing billing) {
        Billing existingBilling = billingService.get().getBillingById(id);
        if (existingBilling != null) {
            billing.setId(id);
            billingService.get().updateBilling(billing);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteBilling(@PathParam("id") Long id) {
        Billing existingBilling = billingService.get().getBillingById(id);
        if (existingBilling != null) {
            billingService.get().deleteBilling(id);
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
