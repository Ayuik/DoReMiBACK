package models;

public class Instrument {
    enums.EnumInstrumentNotes note;
    String  sound = note.getNoteName();

    public String makeSound(enums.EnumInstrumentNotes note){
        return sound;
    }

}