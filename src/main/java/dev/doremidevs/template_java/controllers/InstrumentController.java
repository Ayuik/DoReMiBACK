package dev.doremidevs.template_java.controllers;

import dev.doremidevs.template_java.models.InstrumentModel;
import dev.doremidevs.template_java.models.InterfaceNote;

public class InstrumentController <T extends InterfaceNote> {
    private final InstrumentModel <T> instrumentModel;
        
    public InstrumentController(InstrumentModel <T> instrumentModel) {
        this.instrumentModel = instrumentModel;
    }

    public T selectNote(String frontNote, T[] values) {
        for (T note : values) {
            if (note.getNoteName().equals(frontNote)) {
                return note;
            }
        }
        return null;
    }
    public String playNote(String frontNote, T[] values) {
        T note = selectNote(frontNote, values);
        return instrumentModel.makeSound(note);
    }
}
