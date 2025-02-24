package models;

public class InstrumentModel<T extends Note>{
    public String makeSound(T note) {
        if (note.getNoteUrl() != null) {
            return note.getNoteUrl();
        }
        return note.getNoteName();
    } 
}

