package DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RecordingRepository {
    public void saveRecording(String name, double duration) {
        String query = "INSERT INTO Recordings (name, duration) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, name);
            pstmt.setDouble(2, duration);
            pstmt.executeUpdate();
            System.out.println("Grabación guardada: " + name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}