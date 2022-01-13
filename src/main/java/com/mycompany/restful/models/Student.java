/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restful.models;
import lombok.Getter;
/**
 *
 * @author agozie
 */
@Getter
public class Student {
    private long id;
    private String name;
    private String email;
    private long department;
    
    public Student() {
        
    }
    
    public Student(long id, String name, String email, long department) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
    }
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public long getDepartment() {
        return department;
    }

    public void setDepartment(long department) {
        this.department = department;
    }
}
