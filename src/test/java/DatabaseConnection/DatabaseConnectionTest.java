package DatabaseConnection;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

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
