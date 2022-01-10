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
import com.mycompany.restful.models.Student;
import com.mycompany.restful.services.StudentService;

/**
 *
 * @author agozie
 */

@Path("/students")
public class StudentResource {
    
    private StudentService studentService = new StudentService();
    
//    Get list of all students
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> fetchAll() {
        return studentService.fetchAll();
    }
    
//    Get a specific student with provided ID
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") long id) {
        Student student = studentService.fetchBy(id);
        return Response.ok().entity(student).build();
    }
    
//    Create a new student
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Student student) {
        String s = studentService.create(student);
        return Response.status(Status.CREATED).entity(s).build();
    }
    
//    Update a particular student resource
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") long id, Student student) {
        studentService.update(id, student);
        return Response.noContent().build();
    }
    
//    Delete a particular student resource
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id) {
        studentService.delete(id);
        return Response.status(202).entity("User deleted successfully").build();
    }

    // Get students using department ID
    @GET
    @Path("/department/{id}")
    public List<Student> listStudentsByDepartment(@PathParam("id") long depID) {
        System.out.println(depID);
        return studentService.getStudentsByDepartment(depID);
    }
}
