package enums;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PianoNotesTest {
    @Test
    void testGetNoteName() {
        assertEquals("pianoDo", PianoNotes.DO.getNoteName());
        assertEquals("pianoRe", PianoNotes.RE.getNoteName());
        assertEquals("pianoMi", PianoNotes.MI.getNoteName());
        assertEquals("pianoFa", PianoNotes.FA.getNoteName());
        assertEquals("pianoSol", PianoNotes.SOL.getNoteName());
        assertEquals("pianoLa", PianoNotes.LA.getNoteName());
        assertEquals("pianoSi", PianoNotes.SI.getNoteName());
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
   
