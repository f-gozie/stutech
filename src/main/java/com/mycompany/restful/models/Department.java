/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restful.models;
import lombok.Getter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Setter;

/**
 *
 * @author agozie
 */
@Getter
@Setter
@Entity
@Table
public class Department {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    
    public Department(long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
    
    public Department() {
        super();
    }
    
    @Override
    public String toString() {
        return "Department [id=" + id + ", name=" + name + "]";
    }
}
