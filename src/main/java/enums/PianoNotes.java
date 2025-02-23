package enums;

import models.Note;

public enum PianoNotes implements Note {
    DO ("do", null),
    RE("re", null),
    MI("mi", null),
    FA("fa", null),
    SOL("sol", null),
    LA("la", null),
    SI("si", null);

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
