package dev.doremidevs.template_java.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dev.doremidevs.template_java.controllers.InstrumentControllerTest.InstrumentNotes;
import dev.doremidevs.template_java.enums.PianoNotes;
import dev.doremidevs.template_java.models.InstrumentModel;

public class PianoControllerTest {
    PianoController pianoController = new PianoController(new InstrumentModel<PianoNotes>());

    @BeforeEach
    void setUp() {  
        pianoController = new PianoController(new InstrumentModel<PianoNotes>());  
    }

    @Test
    @DisplayName("Should prove that PianoController inherits from InstrumentController")
    void testInheritance() {
        assertTrue(pianoController instanceof InstrumentController);
    }

    @Test
    void testPlayNote() {
        String result = pianoController.playNote("pianoDo", PianoNotes.values());
        assertEquals(result, "pianoDo");
    }

    @Test
    void testSelectNote() {
        PianoNotes result = pianoController.selectNote("pianoDo", PianoNotes.values());
        assertEquals(result, PianoNotes.DO);

    }
}
