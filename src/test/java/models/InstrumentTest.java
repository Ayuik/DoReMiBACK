package models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InstrumentTest {

    @Test
    @DisplayName("Should return the name of a given note")  
    void testMakeSound() {
        enums.EnumInstrumentNotes note = enums.EnumInstrumentNotes.DO;
        Instrument instrument = new Instrument(); 
        String sound = instrument.makeSound(note);
        assertEquals(sound, "do");
    }
    
}
