package models;

public class Instrument {
    public String makeSoundDo(){
        return enums.EnumInstrumentNotes.DO.getNoteName();
    }

    public String makeSoundRe(){
        return enums.EnumInstrumentNotes.RE.getNoteName();
    }

    public String makeSoundMi(){
        return enums.EnumInstrumentNotes.MI.getNoteName();
    }

    public String makeSoundFa(){
        return enums.EnumInstrumentNotes.FA.getNoteName();
    }

    public String makeSoundSol(){
        return enums.EnumInstrumentNotes.SOL.getNoteName();
    }

    public String makeSoundLa(){    
        return enums.EnumInstrumentNotes.LA.getNoteName();
    }

    public String makeSoundSi(){
        return enums.EnumInstrumentNotes.SI.getNoteName();
    }   
}
