package com.clsys.clinika.resource;

import com.clsys.clinika.model.MedicalRecord;
import com.clsys.clinika.service.MedicalRecordService;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
@SuppressWarnings("cdi.unsatisfieddependency")
@Path("/medical-records")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MedicalRecordResource {

    @Inject
    private Instance<MedicalRecordService> medicalRecordService;

    @GET
    public Response getAllMedicalRecords() {
        List<MedicalRecord> medicalRecords = medicalRecordService.get().getAllMedicalRecords();
        return Response.ok(medicalRecords).build();
    }

    @GET
    @Path("/{id}")
    public Response getMedicalRecordById(@PathParam("id") Long id) {
        MedicalRecord medicalRecord = medicalRecordService.get().getMedicalRecordById(id);
        if (medicalRecord != null) {
            return Response.ok(medicalRecord).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response addMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecordService.get().addMedicalRecord(medicalRecord);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateMedicalRecord(@PathParam("id") Long id, MedicalRecord medicalRecord) {
        medicalRecord.setId(id);
        medicalRecordService.get().updateMedicalRecord(medicalRecord);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteMedicalRecord(@PathParam("id") Long id) {
        medicalRecordService.get().deleteMedicalRecord(id);
        return Response.ok().build();
    }
}
