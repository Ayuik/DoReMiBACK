package DatabaseConnection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RecordingServletTest {

    private RecordingServlet servlet;

    @BeforeEach
    void setUp() {
        servlet = new RecordingServlet();
    }

    @Test
    void testDoPost_Success() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getParameter("name")).thenReturn("Test Recording");
        when(request.getParameterValues("notes")).thenReturn(new String[]{"C", "D", "E"});

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(response.getWriter()).thenReturn(writer);

        servlet.doPost(request, response);

        verify(response).setStatus(HttpServletResponse.SC_OK);
        writer.flush();
        assertEquals("Grabación guardada", stringWriter.toString().trim());
    }

    @Test
    void testDoPost_NoNotesProvided() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getParameter("name")).thenReturn("Test Recording");
        when(request.getParameterValues("notes")).thenReturn(null);

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(response.getWriter()).thenReturn(writer);

        servlet.doPost(request, response);

        verify(response).setStatus(HttpServletResponse.SC_BAD_REQUEST);
        writer.flush();
        assertEquals("No se recibieron notas", stringWriter.toString().trim());
    }

    @Test
    void testDoGet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        servlet.doGet(request, response);

        verify(response).setContentType("application/json");
        writer.flush();
        assertTrue(stringWriter.toString().startsWith("["));
    }
     @Test
    void testDoPost_MissingNameParameter() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getParameter("name")).thenReturn(null);
        when(request.getParameterValues("notes")).thenReturn(new String[]{"C", "D", "E"});

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(response.getWriter()).thenReturn(writer);

        servlet.doPost(request, response);

        verify(response).setStatus(HttpServletResponse.SC_BAD_REQUEST);
        writer.flush();
        assertEquals("Nombre de grabación no proporcionado", stringWriter.toString().trim());
    }

    @Test
    void testDoPost_InvalidNotes() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getParameter("name")).thenReturn("Test Recording");
        when(request.getParameterValues("notes")).thenReturn(new String[]{});

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(response.getWriter()).thenReturn(writer);

        servlet.doPost(request, response);

        verify(response).setStatus(HttpServletResponse.SC_BAD_REQUEST);
        writer.flush();
        assertEquals("No se recibieron notas", stringWriter.toString().trim());
    }
}
