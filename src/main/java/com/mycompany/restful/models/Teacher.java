/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restful.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import lombok.Getter;
/**
 *
 * @author agozie
 */
@Getter
public class Teacher {
    private long id;
    @NotNull(message="Name is required")
    private String name;
    @Email(message="Invalid email address")
    private String email;
    private long department;
    
    public Teacher() {
        
    }
    
    public  Teacher(long id, String name, String email, long department) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
    }   
}
