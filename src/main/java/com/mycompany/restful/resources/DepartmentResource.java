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
import com.mycompany.restful.models.Department;
import com.mycompany.restful.services.DepartmentService;
import javax.validation.Valid;
/**
 *
 * @author agozie
 */
@Path("/departments")
public class DepartmentResource {
    
    private DepartmentService departmentService = new DepartmentService();

    // Get list of all departments
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Department> fetchAll() {
        return departmentService.fetchAll();
    }

    // Get specific department with a provided ID
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        Department dep = departmentService.fetchBy(id);
        return Response.ok().entity(dep).build();
    }

    // Create a new department
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@Valid Department department) {
        String dep = departmentService.create(department);
        return Response.status(Status.CREATED).entity(dep).build();
    }

    // Update a particular department resource
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") long id, Department department) {
        departmentService.update(id, department);
        return Response.noContent().build();
    }

    // Delete a particular department resource
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id) {
        departmentService.delete(id);
        return Response.status(202).entity("User deleted successfully").build();
    }
}
