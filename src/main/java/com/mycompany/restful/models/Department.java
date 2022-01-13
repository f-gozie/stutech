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
public class Department {
    private long id;
    private String name;
    
    public Department() {
    
    }
    
    public Department(long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}
