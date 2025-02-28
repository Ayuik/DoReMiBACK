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

            stmt.execute("CREATE TABLE IF NOT EXISTS Recordings (" + "id INT PRIMARY KEY AUTO_INCREMENT, "
                    + "name VARCHAR(255), " + "notes TEXT");

            System.out.println("Base de datos inicializada");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveRecording(int id, String recordingName, ArrayList<String> recording) {
        String query = "INSERT INTO Recordings (name, notes) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            pstmt.setString(2, recordingName);
            pstmt.setString(3, String.join(",", recording));
            pstmt.executeUpdate();
            System.out.println("Grabación guardada: " + recordingName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<RecordingModel> getRecordings() {
        ArrayList<RecordingModel> recordingModelList = new ArrayList<>();
        String query = "SELECT id, name, notes FROM Recordings";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
                ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String recordingName = rs.getString("name");
                String notes = rs.getString("notes");
                ArrayList<String> recording = new ArrayList<>(List.of(notes.split(",")));
                recordingModelList.add(new RecordingModel(id, recordingName, new ArrayList<>(recording)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recordingModelList;
    }

    public void deleteRecording(String recordingName) {
        String query = "DELETE FROM recordings WHERE recordingName = ?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, recordingName);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public RecordingModel getRecordingByName(String recordingName) {
        String query = "SELECT * FROM recordings WHERE recordingName = ?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, recordingName);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                RecordingModel recordingModel = new RecordingModel();
                recordingModel.setRecordingName(rs.getString("recordingName"));
                recordingModel.createRecording(rs.getArray("notes"));
                return recordingModel;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
