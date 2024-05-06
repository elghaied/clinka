package com.clsys.clinika.resource;

import com.clsys.clinika.model.Doctor;
import com.clsys.clinika.service.DoctorService;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/doctors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DoctorResource {

    @Inject
    private Instance<DoctorService> doctorService;

    @POST
    public Response addDoctor(Doctor doctor) {
        doctorService.get().addDoctor(doctor);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/{id}")
    public Response getDoctorById(@PathParam("id") Long id) {
        Doctor doctor = doctorService.get().getDoctorById(id);
        if (doctor == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(doctor).build();
    }

    @GET
    public Response getAllDoctors() {
        return Response.ok(doctorService.get().getAllDoctors()).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateDoctor(@PathParam("id") Long id, Doctor doctor) {
        doctor.setId(id);
        doctorService.get().updateDoctor(doctor);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteDoctor(@PathParam("id") Long id) {
        doctorService.get().deleteDoctor(id);
        return Response.ok().build();
    }
}
