/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restful.services;

// Required Java Imports
import java.util.ArrayList;
import java.util.List;

// Required Javax Imports
import javax.ws.rs.NotFoundException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

// Required Local Imports
import com.mycompany.restful.models.Student;
import com.mycompany.restful.services.PostgresConnector;

/**
 *
 * @author agozie
 */
public class StudentService {
    private List<Student> students = new ArrayList<Student>();
    PostgresConnector conn = new PostgresConnector();
    Connection connection = conn.connect();
    
    public List<Student> fetchAll() {
        try {
            if (!connection.isClosed()) {
                try {
                    Statement stmt = connection.createStatement();
                    String sql = String.format("SELECT id, name, email FROM Student");
                    ResultSet resp = stmt.executeQuery(sql);
                    while (resp.next()) {
                        students.add(new Student(resp.getLong("id"), resp.getString("name"), resp.getString("email")));
                    }
                    return students;
                }
                catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return students;
    }

    public Student fetchBy(long id) throws NotFoundException {
        Student student = null;
        try {
            if(!connection.isClosed()) {
                try {
                    Statement stmt = connection.createStatement();
                    String sql = String.format("SELECT id, name, email FROM Student WHERE id='%1s'", id);
                    ResultSet resp = stmt.executeQuery(sql);
                    while (resp.next()) {
                        long userId = resp.getLong("id");
                        String name = resp.getString("name");
                        String email = resp.getString("email");
                        student = new Student(userId, name, email);
                        return student;
                    }
                }
                catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return student;
    }
    
    public String create(Student student) {
        try{
            if(!connection.isClosed())
            {
               try {
                    Statement stmt = connection.createStatement();
                    long id = student.getId();
                    String name = student.getName();
                    String email = student.getEmail();

                    String sql = String.format("INSERT INTO Student(id, name, email) Values('%1s', '%2s', '%3s')", id, name, email);
                    stmt.executeUpdate(sql);
                    return student.getName();
                }
                catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        return "Check your error logs";
    }
    
    public void update(long id, Student student) {
        try {
            Statement stmt = connection.createStatement();
            String name = student.getName();
            String email = student.getEmail();

            String sql = String.format("UPDATE Student SET name='%1s', email='%2s' WHERE id='%3s'", name, email, id);
            stmt.executeUpdate(sql);
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void delete(long id) throws NotFoundException {
        try {
            if (!connection.isClosed()) {
                try {
                Statement stmt = connection.createStatement();
                String sql = String.format("DELETE FROM Student WHERE id='%1s'", id);
                stmt.executeUpdate(sql);
                }
                catch (SQLException e){
                    System.out.println(e.getMessage());
                }
            }
        }
        catch (SQLException e) {
            System.out.append(e.getMessage());
        }

    }
    
}
