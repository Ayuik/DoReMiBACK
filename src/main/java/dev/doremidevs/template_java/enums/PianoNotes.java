package dev.doremidevs.template_java.enums;

import dev.doremidevs.template_java.models.InterfaceNote;

public enum PianoNotes implements InterfaceNote  {
    DO ("pianoDo", null),
    RE("pianoRe", null),
    MI("pianoMi", null),
    FA("pianoFa", null),
    SOL("pianoSol", null),
    LA("pianoLa", null),
    SI("pianoSi", null);

    private final String noteName;
    private final String noteUrl;


    PianoNotes(String noteName, String noteUrl) {
        this.noteName = noteName;
        this.noteUrl = noteUrl;
    }

    @Override
    public String getNoteName() {
        return noteName;
    }

    @Override       
    public String getNoteUrl() {
        return noteUrl;
    }

}
