package dev.doremidevs.template_java.database;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

import dev.doremidevs.template_java.database.DatabaseConnection;


public class DatabaseConnectionTest {

    @Test
    public void testGetConnection() {
        try{
            Connection connection = DatabaseConnection.getConnection();
            assertNotNull(connection, "La conexion no debe ser nula");
        
        } catch (Exception e){
            throw new RuntimeException("Error al conectar con la base de datos", e);
        }
    }

}
