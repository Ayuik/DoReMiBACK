package models;

public class Instrument {
    public String makeSound(enums.EnumInstrumentNotes note){
        String  sound = note.getNoteName();
        return sound;
    }

}