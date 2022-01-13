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

/**
 *
 * @author agozie
 */

public class DepartmentService {
    private List<Department> departments = new ArrayList<Department>();
    PostgresConnector conn = new PostgresConnector();
    Connection connection = conn.connect();
    
    public List<Department> fetchAll() {
        try{
            if (!connection.isClosed()) {
                try {
                    Statement stmt = connection.createStatement();
                    String sql = String.format("SELECT id, name FROM Department");
                    ResultSet resp = stmt.executeQuery(sql);
                    while (resp.next()) {
                        departments.add(new Department(resp.getLong("id"), resp.getString("name")));
                    }
                    return departments;
                }
                catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return departments;
    }

    public Department fetchBy(long id) throws NotFoundException {
        Department department = null;
        try{
            if (!connection.isClosed()) {
                try {
                    Statement stmt = connection.createStatement();
                    String sql = String.format("SELECT id, name FROM Department WHERE id='%1s'", id);
                    ResultSet resp = stmt.executeQuery(sql);

                    while (resp.next()) {
                        long dep_id = resp.getLong("id");
                        String name = resp.getString("name");
                        department = new Department(dep_id, name);
                        return department;
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
        return department;
    }

    public String create(Department department) {
        try {
            if (!connection.isClosed()) {
                try {
                    Statement stmt = connection.createStatement();
                    long id = department.getId();
                    String name = department.getName();

                    String sql = String.format("INSERT INTO Department(id, name) Values('%1s', '%2s')", id, name);
                    stmt.executeUpdate(sql);
                    return department.getName();
                }
                catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "Check your error logs";
    }

    public void update(long id, Department department) {
        try {
            Statement stmt = connection.createStatement();
            String name = department.getName();

            String sql = String.format("UPDATE Department SET name='%1s' WHERE id='%2s'", name, id);
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
                String sql = String.format("DELETE FROM Department WHERE id='%1s'", id);
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
