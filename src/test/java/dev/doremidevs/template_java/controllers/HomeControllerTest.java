package dev.doremidevs.template_java.controllers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class HomeControllerTest {

    @Test
    void testHomeControllerInstantiation() {
        HomeController controller = new HomeController();
        assertNotNull(controller);
    }
}