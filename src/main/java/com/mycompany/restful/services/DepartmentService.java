/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restful.services;

import java.util.List;

import javax.ws.rs.NotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.mycompany.restful.models.Department;

/**
 *
 * @author agozie
 */

public class DepartmentService {

     public Department getById(long id, EntityManager manager) {
         Department dep = manager.find(Department.class, id);
         if (dep == null) {
             throw new NotFoundException("The given ID was not found on this server");
         }
         return dep;
     }

    public List<Department> fetchAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("stutech_JPA");
        EntityManager manager = emf.createEntityManager();

        Query query = manager.createQuery("SELECT e FROM Department e");
        return query.getResultList();
    }

    public Department fetchBy(long id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("stutech_JPA");
        EntityManager manager = factory.createEntityManager();
        Department departmentObject = getById(id, manager);

        return departmentObject;
    }

    public String create(Department department) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("stutech_JPA");

        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();

        Department departmentObject = new Department();
        departmentObject.setId(department.getId());
        departmentObject.setName(department.getName());

        manager.persist(departmentObject);
        manager.getTransaction().commit();

        manager.close();
        emf.close();
        return department.getName();
    }

    public void delete(long id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("stutech_JPA");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        Department department = getById(id, manager);
        manager.remove(department);
        manager.getTransaction().commit();
        manager.close();
        factory.close();
    }

    public void update(long id, Department department) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("stutech_JPA");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        Department departmentObject = getById(id, manager);
        departmentObject.setName(department.getName());
        manager.getTransaction().commit();

        manager.close();
        factory.close();
    }
    
    //    public class EntityMap<EntityManager, EntityManagerFactory> {
//        private EntityManager manager;
//        private EntityManagerFactory factory;
//        
//        public EntityMap(EntityManager manager, EntityManagerFactory factory) {
//            this.manager = manager;
//            this.factory = factory;
//        }
//    }
//    
//    public EntityMap<EntityManager, EntityManagerFactory> setUpEntityManager() {
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("stutech_JPA");
//        EntityManager manager = factory.createEntityManager();
//        
//        return new EntityMap(manager, factory);
//    }
}
