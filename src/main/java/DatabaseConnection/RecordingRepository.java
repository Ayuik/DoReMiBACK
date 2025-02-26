package DatabaseConnection;

import java.io.InputStream;
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

                stmt.execute("CREATE TABLE IF NOT EXISTS Recordings (" + "id INT PRIMARY KEY AUTO_INCREMENT, " + "name VARCHAR(255), " + "notes TEXT" );
            
                System.out.println("Base de datos inicializada");
            }
             catch (SQLException e) 
             {e.printStackTrace();}
    }







    public void saveRecording(String name, List<String> notes) {
        String query = "INSERT INTO Recordings (name, notes) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, name);
            pstmt.setString(2,String.join(",", notes));
            pstmt.executeUpdate();
            System.out.println("Grabación guardada: " + name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<RecordingModel> getRecordings() {
        List <RecordingModel> recordings = new ArrayList<>();
        String query = "SELECT id, name, notes FROM Recordings";
        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery()) {

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String notes = rs.getString("notes");
                    List<String> notesList = new ArrayList<>(List.of(notes.split(",")));
                    recordings.add(new RecordingModel(id, name, new ArrayList<>(nooteList)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recordings;
    }
}