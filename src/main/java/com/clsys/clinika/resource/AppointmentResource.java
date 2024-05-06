package com.clsys.clinika.resource;

import com.clsys.clinika.model.Appointment;
import com.clsys.clinika.service.AppointmentService;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
@SuppressWarnings("cdi.unsatisfieddependency")
@Path("/appointments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AppointmentResource {

    @Inject
    private Instance<AppointmentService> appointmentService;

    @GET
    public List<Appointment> getAllAppointments() {
        return appointmentService.get().getAllAppointments();
    }

    @GET
    @Path("/{id}")
    public Response getAppointmentById(@PathParam("id") Long id) {
        Appointment appointment = appointmentService.get().getAppointmentById(id);
        if (appointment != null) {
            return Response.ok(appointment).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response addAppointment(Appointment appointment) {
        appointmentService.get().addAppointment(appointment);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateAppointment(@PathParam("id") Long id, Appointment appointment) {
        Appointment existingAppointment = appointmentService.get().getAppointmentById(id);
        if (existingAppointment != null) {
            appointment.setId(id);
            appointmentService.get().updateAppointment(appointment);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteAppointment(@PathParam("id") Long id) {
        Appointment existingAppointment = appointmentService.get().getAppointmentById(id);
        if (existingAppointment != null) {
            appointmentService.get().deleteAppointment(id);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
