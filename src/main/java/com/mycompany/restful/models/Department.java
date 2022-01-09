/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restful.models;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author agozie
 */
public class Department {
    private long id;
    private String name;
    private List<String> teachers = new ArrayList<String>();
    private List<String> students = new ArrayList<String>();
    private List<String> courses = new ArrayList<String>();
    
    public Department() {
    
    }
    
    public Department(long id, String name, List<String> teachers, List<String> students, List<String> courses) {
        super();
        this.id = id;
        this.name = name;
        this.teachers = teachers;
        this.students = students;
        this.courses = courses;
    }

    public long getID() {
        return id;
    }

    public void setID(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getStudents() {
        return students;
    }

    public void setStudent(String student) {
        students.add(student);
    }

    public List<String> getTeachers() {
        return teachers;
    }

    public void setTeacher(String teacher) {
        teachers.add(teacher);
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourse(String course) {
        courses.add(course);
    }
}
