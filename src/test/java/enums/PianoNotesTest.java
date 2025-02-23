package enums;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PianoNotesTest {
    @Test
    void testGetNoteName() {
        assertEquals("do", PianoNotes.DO.getNoteName());
        assertEquals("re", PianoNotes.RE.getNoteName());
        assertEquals("mi", PianoNotes.MI.getNoteName());
        assertEquals("fa", PianoNotes.FA.getNoteName());
        assertEquals("sol", PianoNotes.SOL.getNoteName());
        assertEquals("la", PianoNotes.LA.getNoteName());
        assertEquals("si", PianoNotes.SI.getNoteName());
    }

    @Test
    void testGetNoteURL() {
        assertEquals(null, PianoNotes.DO.getNoteUrl());
        assertEquals(null, PianoNotes.RE.getNoteUrl());
        assertEquals(null, PianoNotes.MI.getNoteUrl());
        assertEquals(null, PianoNotes.FA.getNoteUrl());
        assertEquals(null, PianoNotes.SOL.getNoteUrl());
        assertEquals(null, PianoNotes.LA.getNoteUrl());
        assertEquals(null, PianoNotes.SI.getNoteUrl());
    }
}
   
