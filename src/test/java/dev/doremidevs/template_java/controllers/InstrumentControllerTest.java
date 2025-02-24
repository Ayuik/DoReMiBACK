package dev.doremidevs.template_java.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dev.doremidevs.template_java.models.InstrumentModel;
import dev.doremidevs.template_java.models.InterfaceNote;

public class InstrumentControllerTest {
    enum InstrumentNotes implements InterfaceNote {
        DO("instrumentDo", "https://example.com/c.wav"),
        RE("instrumentRe", null);

        private final String noteName;
        private final String noteUrl;

        InstrumentNotes(String noteName, String noteUrl) {
            this.noteName = noteName;
            this.noteUrl = noteUrl;
        }

        @Override
        public String getNoteName() {
            return noteName;

        }

        @Override
        public String getNoteUrl() {
            return noteUrl;
        }
    }
    
    InstrumentModel<InstrumentNotes> instrumentModel;
    InstrumentController<InstrumentNotes> instrumentController;

    @BeforeEach
    void setUp() {
        instrumentModel = new InstrumentModel<InstrumentNotes>();
        instrumentController = new InstrumentController<InstrumentNotes>(instrumentModel);
    }
    
    @Test
    @DisplayName("Should call the model to implement makeSound()")
    void testPlayNote() {
        String result = instrumentController.playNote("instrumentDo", InstrumentNotes.values());
        String result2 = instrumentController.playNote("instrumentRe", InstrumentNotes.values());
        assertEquals(result, "https://example.com/c.wav");
        assertEquals(result2, "instrumentRe");
    }

    @Test
    @DisplayName("Should link a note received from the front to the notes in the enum")
    void testSelectNote() {
        InstrumentNotes result = instrumentController.selectNote("instrumentDo", InstrumentNotes.values());
        InstrumentNotes result2 = instrumentController.selectNote("instrumentLa", InstrumentNotes.values());
        assertEquals(result, InstrumentNotes.DO);
        assertEquals(result2, null);
    }
}
