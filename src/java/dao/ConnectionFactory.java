/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Vinicius
 */
public class ConnectionFactory {
    private static ConnectionFactory instance;
    private String driver;
    private String database;
    private String user;
    private String password;
    private String url;

    public ConnectionFactory(){
        this.driver = "org.postgresql.Driver";
        this.database = "bbdb";
        this.user = "postgres";
        this.password = "admin";
        this.url = "jdbc:postgresql://localhost:5432/" + database;
    }

    public static ConnectionFactory getInstance() {
        if (ConnectionFactory.instance == null) {
            ConnectionFactory.instance = new ConnectionFactory();
        }
        return ConnectionFactory.instance;
    }

    public Connection getConnection() {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(
                    url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}

