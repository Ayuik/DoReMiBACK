package DatabaseConnection;

import dev.doremidevs.template_java.models.RecordingModel;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@WebServlet("/api/notes")
public class NotesServlet extends HttpServlet {
    private final RecordingRepository recordingRepository = new RecordingRepository();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String[] noteNames = request.getParameterValues("notes");
        if (noteNames != null) {
            recordingRepository.saveRecording(0, name, new ArrayList<>(List.of(noteNames)));
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write("Grabación guardada");
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("No se recibieron notas");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<RecordingModel<?>> recordings = recordingRepository.getRecordings();
        response.setContentType("application/json");
        response.getWriter().write(convertToJson(recordings));
    }
    private String convertToJson(List<RecordingModel<?>> recordings) {
        StringBuilder json = new StringBuilder("[");
        for (RecordingModel<?> recording : recordings) {
            json.append("{\"id\":").append(recording.getId())
                .append(",\"name\":\"").append(recording.getRecordingName())
                .append("\",\"notes\":[");
            for (String noteUrl : recording.getRecording()) {
                json.append("\"").append(noteUrl).append("\",");
            }
            if (!recording.getRecording().isEmpty()) {
                json.deleteCharAt(json.length() - 1);
            }
            json.append("]},");
        }
        if (!recordings.isEmpty()) {
            json.deleteCharAt(json.length() - 1);
        }
        json.append("]");
        return json.toString();
    }
}

