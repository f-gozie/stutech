/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restful.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.NotFoundException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

import com.mycompany.restful.models.Department;
import com.mycompany.restful.services.PostgresConnector;
import java.util.Arrays;

/**
 *
 * @author agozie
 */
public class DepartmentService {
    private List<Department> departments = new ArrayList<Department>();
    PostgresConnector conn = new PostgresConnector();
    Connection connection = conn.connect();

//    public List<Department> fetchAll() {
//        try {
//            if (!connection.isClosed()) {
//                try {
//                    Statement stmt = connection.createStatement();
//                    String sql = String.format("SELECT id, name, teachers, students, courses FROM Department");
//                    ResultSet resp = stmt.executeQuery(sql);
//                    while (resp.next()) {
//                        departments.add(new Department(resp.getLong("id"), resp.getString("name"), resp.getArray("students"), resp.getArray("teachers"), resp.getArray("courses")));
//                    }
//                    return departments;
//                }
//                catch (SQLException e) {
//                    System.out.println(e.getMessage());
//                }
//            }
//        }
//        catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return departments;
//    }

//    public Department fetchBy(long id) throws NotFoundException {
//        Department department = null;
//        try {
//            if (!connection.isClosed()) {
//                try {
//                    Statement stmt = connection.createStatement();
//                    String sql = String.format("SELECT id, name, students, teachers, courses FROM Department WHERE id='%1s'", id);
//                    ResultSet resp = stmt.executeQuery(sql);
//                    while (resp.next()) {
//                        long userId = resp.getLong("id");
//                        String name = resp.getString("name");
//                        List<String> students = resp.getArray("students");
//                        List<String> teachers = new ArrayList<>(Arrays.asList(resp.getArray("teachers")));
//                        List<String> courses = new ArrayList<>(Arrays.asList(resp.getArray("courses")));
//                        department = new Department(userId, name, students, teachers, courses);
//                        return department;
//                    }
//                }
//                catch (SQLException e) {
//                    System.out.println(e.getMessage());
//                }
//            }
//        }
//        catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return department;
//    }
}
