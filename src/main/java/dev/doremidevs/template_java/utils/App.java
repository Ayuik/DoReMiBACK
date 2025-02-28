package dev.doremidevs.template_java.utils;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import javax.servlet.Servlet;

import DatabaseConnection.RecordingServlet;

public class App {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        handler.setContextPath("/");
        server.setHandler(handler);

        // Crear una instancia del ServletHolder
        ServletHolder servletHolder = new ServletHolder();
        servletHolder.setServlet((Servlet) new RecordingServlet());
        handler.addServlet(servletHolder, "/mi-servlet");

        try {
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
