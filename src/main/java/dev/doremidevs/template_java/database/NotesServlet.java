package dev.doremidevs.template_java.database;

import dev.doremidevs.template_java.enums.PianoNotes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/notes")
public class NotesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder json = new StringBuilder("[");
        for (PianoNotes note : PianoNotes.values()) {
            json.append("{\"name\":\"").append(note.getNoteName())
                .append("\",\"url\":\"").append(note.getNoteUrl()).append("\"},");
        }
        if (json.length() > 1) {
            json.deleteCharAt(json.length() - 1);
        }
        json.append("]");

        response.setContentType("application/json");
        response.getWriter().write(json.toString());
    }
}