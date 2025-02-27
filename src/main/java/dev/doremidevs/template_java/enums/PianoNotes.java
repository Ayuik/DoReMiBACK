package dev.doremidevs.template_java.enums;

import dev.doremidevs.template_java.models.InterfaceNote;

public enum PianoNotes implements InterfaceNote  {
    DO4 ("do4", "../resources/DO4.mp3"),
    DO5 ("do5", "../resources/DO5.mp3"),
    FA4 ("fa4","../resources/FA4.mp3"),
    LA4 ("la4","../resources/LA4.mp3"),
    LAB4("lab4","../resources/LAB4.mp3"),
    MI4 ("mi4","../resources/MI4.mp3"),
    MI5 ("mi5","../resources/MI5.mp3"),
    MIB4("mib4","../resources/MIB4.mp3"),
    MIB5("mib5","../resources/MIB5.mp3"),
    RE4 ("re4","../resources/RE4.mp3"),
    RE5 ("re5","../resources/RE5.mp3"),
    REB4("reb4","../resources/REB4.mp3"),
    REB5("reb5","../resources/REB5.mp3"),
    SI4 ("si4","../resources/SI4.mp3"),
    SIB4("sib4","../resources/SIB4.mp3"),
    SOL4("sol4","../resources/SOL4.mp3"),
    SOLB4("solb4","../resources/SOLB4.mp3");

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
