package enums;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EnumInstrumentNotesTest {
    @Test
    void testGetNoteName() {
        assertEquals("do", EnumInstrumentNotes.DO.getNoteName());
        assertEquals("re", EnumInstrumentNotes.RE.getNoteName());
        assertEquals("mi", EnumInstrumentNotes.MI.getNoteName());
        assertEquals("fa", EnumInstrumentNotes.FA.getNoteName());
        assertEquals("sol", EnumInstrumentNotes.SOL.getNoteName());
        assertEquals("la", EnumInstrumentNotes.LA.getNoteName());
        assertEquals("si", EnumInstrumentNotes.SI.getNoteName());
    }
}
   
