package dev.doremidevs.template_java.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dev.doremidevs.template_java.models.InstrumentModel;

public class InstrumentTest {
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
    
    InstrumentModel instrumentModel = new InstrumentModel<InstrumentNotes>();

    @BeforeEach
    void setUp() {
        instrumentModel = new InstrumentModel<InstrumentNotes>();
    }
    @Test
    @DisplayName("Should return the noteUrl as it isn't null")
    void testMakeSoundReturnsUrl() {
        String url = instrumentModel.makeSound(InstrumentNotes.DO);
        assertEquals("https://example.com/c.wav", url);
    }

    @Test
    @DisplayName("Should return the noteName as noteUrl is null")
    void testMakeSoundReturnsName() {
        String result = instrumentModel.makeSound(InstrumentNotes.RE);
        assertThat (result, is("instrumentRe"));
    }
}