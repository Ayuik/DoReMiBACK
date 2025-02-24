package dev.doremidevs.template_java.models;

public class InstrumentModel<T extends InterfaceNote>{
    public String makeSound(T note) {
        if (note.getNoteUrl() != null) {
            return note.getNoteUrl();
        }
        return note.getNoteName();
    } 
}

