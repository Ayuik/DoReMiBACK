package dev.doremidevs.template_java.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PianoNotesTest {
    @Test
    void testGetNoteName() {
        assertEquals("do4", PianoNotes.DO4.getNoteName());
        assertEquals("do5", PianoNotes.DO5.getNoteName());
        assertEquals("fa4", PianoNotes.FA4.getNoteName());
        assertEquals("la4", PianoNotes.LA4.getNoteName());
        assertEquals("lab4", PianoNotes.LAB4.getNoteName());
        assertEquals("mi4", PianoNotes.MI4.getNoteName());
        assertEquals("mi5", PianoNotes.MI5.getNoteName());
        assertEquals("mib4", PianoNotes.MIB4.getNoteName());
        assertEquals("mib5", PianoNotes.MIB5.getNoteName());
        assertEquals("re4", PianoNotes.RE4.getNoteName());
        assertEquals("re5", PianoNotes.RE5.getNoteName());
        assertEquals("reb4", PianoNotes.REB4.getNoteName());
        assertEquals("reb5", PianoNotes.REB5.getNoteName());
        assertEquals("si4", PianoNotes.SI4.getNoteName());
        assertEquals("sib4", PianoNotes.SIB4.getNoteName());
        assertEquals("sol4", PianoNotes.SOL4.getNoteName());
        assertEquals("solb4", PianoNotes.SOLB4.getNoteName());
    }

    @Test
    void testGetNoteURL() {
        assertEquals("../resources/DO4.mp3", PianoNotes.DO4.getNoteUrl());
        assertEquals("../resources/DO5.mp3",PianoNotes.DO5.getNoteUrl());
        assertEquals("../resources/FA4.mp3", PianoNotes.FA4.getNoteUrl());
        assertEquals("../resources/LA4.mp3", PianoNotes.LA4.getNoteUrl());
        assertEquals("../resources/LAB4.mp3", PianoNotes.LAB4.getNoteUrl());
        assertEquals("../resources/MI4.mp3", PianoNotes.MI4.getNoteUrl());
        assertEquals("../resources/MI5.mp3",PianoNotes.MI5.getNoteUrl());
        assertEquals("../resources/MIB4.mp3", PianoNotes.MIB4.getNoteUrl());
        assertEquals("../resources/MIB5.mp3", PianoNotes.MIB5.getNoteUrl());
        assertEquals("../resources/RE4.mp3", PianoNotes.RE4.getNoteUrl());
        assertEquals("../resources/RE5.mp3", PianoNotes.RE5.getNoteUrl());
        assertEquals("../resources/REB4.mp3", PianoNotes.REB4.getNoteUrl());
        assertEquals("../resources/REB5.mp3", PianoNotes.REB5.getNoteUrl());
        assertEquals("../resources/SI4.mp3", PianoNotes.SI4.getNoteUrl());
        assertEquals("../resources/SIB4.mp3",PianoNotes.SIB4.getNoteUrl());
        assertEquals("../resources/SOL4.mp3", PianoNotes.SOL4.getNoteUrl());
        assertEquals("../resources/SOLB4.mp3", PianoNotes.SOLB4.getNoteUrl());
    }
}
   
