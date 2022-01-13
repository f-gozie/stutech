/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restful.services;

// Required Java imports
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author agozie
 */
public class PostgresConnector {
    private String databaseConnectionString = "jdbc:postgresql://localhost:5432/postgres";
    private String databaseUserName = "postgres";
    private String databasePassword = "juggernut";
    
    
    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(databaseConnectionString, databaseUserName, databasePassword);
        }
        catch (SQLException e){
            System.out.println(e);
        }
        return conn;
    }

}
