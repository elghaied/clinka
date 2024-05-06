package com.clsys.clinika.resource;

import com.clsys.clinika.model.Prescription;
import com.clsys.clinika.service.PrescriptionService;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/prescriptions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PrescriptionResource {

    @Inject
    private Instance<PrescriptionService> prescriptionService;

    @GET
    @Path("/{id}")
    public Response getPrescriptionById(@PathParam("id") Long id) {
        Prescription prescription = prescriptionService.get().getPrescriptionById(id);
        if (prescription != null) {
            return Response.ok(prescription).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    public Response getAllPrescriptions() {
        List<Prescription> prescriptions = prescriptionService.get().getAllPrescriptions();
        return Response.ok(prescriptions).build();
    }

    @POST
    public Response addPrescription(Prescription prescription) {
        prescriptionService.get().addPrescription(prescription);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response updatePrescription(@PathParam("id") Long id, Prescription prescription) {
        prescription.setId(id);
        prescriptionService.get().updatePrescription(prescription);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletePrescription(@PathParam("id") Long id) {
        prescriptionService.get().deletePrescription(id);
        return Response.noContent().build();
    }
}
