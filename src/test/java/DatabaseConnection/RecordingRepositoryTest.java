package DatabaseConnection;

import dev.doremidevs.template_java.models.RecordingModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecordingRepositoryTest {

    private Connection connection;
    private RecordingRepository repository;

    @BeforeEach
    void setUp() throws Exception {
        String jdbcUrl = "jdbc:h2:mem:testdb";
        connection = DriverManager.getConnection(jdbcUrl, "sa", "");
        repository = new RecordingRepository();

        try (PreparedStatement stmt = connection.prepareStatement(
                "CREATE TABLE IF NOT EXISTS Recordings (" +
                        "id INT PRIMARY KEY AUTO_INCREMENT, " +
                        "name VARCHAR(255), " +
                        "notes TEXT)")) {
            stmt.execute();
        }
    }

    @AfterEach
    void tearDown() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    @Test
    void testInitializeDatabase() throws Exception {
        repository.initializeDatabase();

        try (PreparedStatement stmt = connection.prepareStatement(
                "SELECT COUNT(*) AS count FROM Recordings")) {
            var rs = stmt.executeQuery();
            assertTrue(rs.next());
            assertEquals(0, rs.getInt("count"));
        }
    }

    @Test
    void testSaveRecording_DuplicateName() throws Exception {
        repository.saveRecording(0, "Test Recording", List.of("C", "D", "E"));
        repository.saveRecording(0, "Test Recording", List.of("F", "G", "H"));
    
        try (PreparedStatement stmt = connection.prepareStatement("SELECT COUNT(*) AS count FROM Recordings WHERE name = ?")) {
            stmt.setString(1, "Test Recording");
            var rs = stmt.executeQuery();
            assertTrue(rs.next());
            assertEquals(2, rs.getInt("count"), "Deberían haber 2 grabaciones con el mismo nombre.");
        }
    }

    @Test
    void testSaveRecording_EmptyNotes() throws Exception {
        repository.saveRecording(0, "Test Recording", List.of());

        try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Recordings WHERE name = ?")) {
            stmt.setString(1, "Test Recording");
            var rs = stmt.executeQuery();
            assertTrue(rs.next());
            assertEquals("", rs.getString("notes"));
        }
    }

    @Test
    void testSaveRecording_NullName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            repository.saveRecording(0, null, List.of("C", "D", "E"));
        });
        assertEquals("El nombre de la grabación no puede ser nulo o vacío.", exception.getMessage());
    }

    @Test
    void testSaveRecording_NullNotes() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            repository.saveRecording(0, "Test Recording", null);
        });
        assertEquals("La lista de notas no puede ser nula o vacía.", exception.getMessage());
    }

    @Test
    void testGetRecordings_NoData() {
        List<RecordingModel<?>> recordings = repository.getRecordings();
        assertTrue(recordings.isEmpty());
    }

    @Test
void testGetRecordings_WithData() throws Exception {
    // Insertar datos directamente en la base de datos
    try (PreparedStatement stmt = connection.prepareStatement(
            "INSERT INTO Recordings (name, notes) VALUES (?, ?)")) {
        stmt.setString(1, "Test Recording 1");
        stmt.setString(2, "C,D,E");
        stmt.executeUpdate();

        stmt.setString(1, "Test Recording 2");
        stmt.setString(2, "F,G,H");
        stmt.executeUpdate();
    }

    // Verificar que los datos se insertaron correctamente
    try (PreparedStatement stmt = connection.prepareStatement("SELECT COUNT(*) AS count FROM Recordings")) {
        var rs = stmt.executeQuery();
        assertTrue(rs.next());
        assertEquals(2, rs.getInt("count"), "Deberían haber 2 grabaciones en la base de datos.");
    }

    // Obtener las grabaciones usando el repositorio
    List<RecordingModel<?>> recordings = repository.getRecordings();
    assertEquals(2, recordings.size(), "Deberían haber 2 grabaciones en la base de datos.");

    // Verificar los datos de la primera grabación
    RecordingModel<?> recording1 = recordings.get(0);
    assertEquals("Test Recording 1", recording1.getRecordingName());
    assertEquals(List.of("C", "D", "E"), recording1.getRecording());

    // Verificar los datos de la segunda grabación
    RecordingModel<?> recording2 = recordings.get(1);
    assertEquals("Test Recording 2", recording2.getRecordingName());
    assertEquals(List.of("F", "G", "H"), recording2.getRecording());
}

@Test
void testDeleteRecording_Existing() throws Exception {
    // Insertar datos directamente en la base de datos
    try (PreparedStatement stmt = connection.prepareStatement(
            "INSERT INTO Recordings (name, notes) VALUES (?, ?)")) {
        stmt.setString(1, "Test Recording");
        stmt.setString(2, "C,D,E");
        stmt.executeUpdate();
    }

    // Eliminar la grabación
    repository.deleteRecording("Test Recording");

    // Verificar que se eliminó correctamente
    try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Recordings WHERE name = ?")) {
        stmt.setString(1, "Test Recording");
        var rs = stmt.executeQuery();
        assertFalse(rs.next(), "La grabación no debería existir después de ser eliminada.");
    }
}

    @Test
    void testDeleteRecording_NonExisting() {
        assertDoesNotThrow(() -> repository.deleteRecording("Non Existing Recording"));
    }
}