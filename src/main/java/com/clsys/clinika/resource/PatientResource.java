package com.clsys.clinika.resource;

import com.clsys.clinika.model.Patient;
import com.clsys.clinika.service.PatientService;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
@SuppressWarnings("cdi.unsatisfieddependency")
@Path("/patients")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PatientResource {

    @Inject
    private Instance<PatientService> patientService;

    @POST
    public void addPatient(Patient patient) {
        patientService.get().addPatient(patient);
    }

    @GET
    @Path("/{id}")
    public Patient getPatient(@PathParam("id") Long id) {
        return patientService.get().getPatientById(id);
    }

    @GET
    public List<Patient> getAllPatients() {
        return patientService.get().getAllPatients();
    }

    @PUT
    @Path("/{id}")
    public void updatePatient(@PathParam("id") Long id, Patient patient) {
        patient.setId(id);
        patientService.get().updatePatient(patient);
    }

    @DELETE
    @Path("/{id}")
    public void deletePatient(@PathParam("id") Long id) {
        patientService.get().deletePatient(id);
    }
}
