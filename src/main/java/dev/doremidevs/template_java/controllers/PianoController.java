package dev.doremidevs.template_java.controllers;

import dev.doremidevs.template_java.enums.PianoNotes;
import dev.doremidevs.template_java.models.InstrumentModel;

public class PianoController extends InstrumentController<PianoNotes> {

    public PianoController(InstrumentModel<PianoNotes> instrumentModel) {
        super(instrumentModel);
    }

}
