/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restful.resources;

// Required Java Imports
import java.util.List;

// Required Javax Imports 
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

// Required Javax Core Imports
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

// Required Local Imports
import com.mycompany.restful.models.Teacher;
import com.mycompany.restful.services.TeacherService;
import javax.validation.Valid;


/**
 *
 * @author agozie
 */

@Path("/teachers")
public class TeacherResource {
    
    private TeacherService teacherService = new TeacherService();
    
    // Get list of all teachers
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Teacher> fetchAll() {
        return teacherService.fetchAll();
    }
    
    // Get a specific teacher with provided ID
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        Teacher teach = teacherService.fetchBy(id);
        return Response.ok().entity(teach).build();
//        return Response.ok().entity(new Teacher(03, "Java Test", "java@gmail.com")).build();
    }
    
    // Create a new teacher  
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@Valid Teacher teacher) {
        String t = teacherService.create(teacher);
        return Response.status(Status.CREATED).entity(t).build();
    }
    
    // Update a particular teacher resource
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") long id, Teacher teacher) {
        teacherService.update(id, teacher);
        return Response.noContent().build();
    }
    
    // Delete a particular teacher resource
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id) {
        teacherService.delete(id);
        return Response.status(202).entity("User deleted successfully!!").build();
    }
}
