package DatabaseConnection;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseConnectionTest {

    @Test
    void testGetConnection_Success() throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        assertNotNull(connection);
        connection.close();
    }


    @Test
    void testGetUrlUsingReflection() throws Exception {
        Field urlField = DatabaseConnection.class.getDeclaredField("URL");
        urlField.setAccessible(true);
        String url = (String) urlField.get(null);
    
        assertEquals("jdbc:h2:./testdb", url);
    }
}