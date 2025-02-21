package enums;

public enum EnumInstrumentNotes {
    DO ("do"),
    RE("re"),
    MI("mi"),
    FA("fa"),
    SOL("sol"),
    LA("la"),
    SI("si");

    private final String noteName;

    private EnumInstrumentNotes(String noteName) {
        this.noteName = noteName;
    }

    public String getNoteName() {
        return noteName;
    }

}
