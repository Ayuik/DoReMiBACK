package dev.doremidevs.template_java.utils;

import org.eclipse.jetty.server.Server;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AppTest {

    @Test
    void testServerStarts() throws Exception {
        Server server = new Server(8080);
        try {
            server.start();
            assertTrue(server.isStarted());
        } finally {
            server.stop();
        }
    }
}