package DatabaseConnection;

import dev.doremidevs.template_java.models.RecordingModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecordingRepository {

    public void initializeDatabase() {
        try (Connection conn = DatabaseConnection.getConnection();
             var stmt = conn.createStatement()) {

            stmt.execute("CREATE TABLE IF NOT EXISTS Recordings (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "name VARCHAR(255), " +
                    "notes TEXT)");
            System.out.println("Base de datos inicializada");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveRecording(int id, String recordingName, List<String> recording) {
        if (recordingName == null || recordingName.isEmpty()) {
            throw new IllegalArgumentException("El nombre de la grabación no puede ser nulo o vacío.");
        }
        if (recording == null || recording.isEmpty()) {
            throw new IllegalArgumentException("La lista de notas no puede ser nula o vacía.");
        }

        String query = "INSERT INTO Recordings (name, notes) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, recordingName);
            pstmt.setString(2, String.join(",", recording));
            pstmt.executeUpdate();

            System.out.println("Grabación guardada: " + recordingName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<RecordingModel<?>> getRecordings() {
        List<RecordingModel<?>> recordingModelList = new ArrayList<>();
        String query = "SELECT id, name, notes FROM Recordings";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String recordingName = rs.getString("name");
                String notes = rs.getString("notes");

                List<String> recording = notes != null && !notes.isEmpty()
                        ? List.of(notes.split(","))
                        : new ArrayList<>();

                recordingModelList.add(new RecordingModel<>(id, recordingName, new ArrayList<>(recording)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recordingModelList;
    }

    public void deleteRecording(String recordingName) {
        if (recordingName == null || recordingName.isEmpty()) {
            throw new IllegalArgumentException("El nombre de la grabación no puede ser nulo o vacío.");
        }

        String query = "DELETE FROM Recordings WHERE name = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, recordingName);
            pstmt.executeUpdate();

            System.out.println("Grabación eliminada: " + recordingName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
