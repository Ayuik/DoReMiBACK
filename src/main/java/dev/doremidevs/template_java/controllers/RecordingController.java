package dev.doremidevs.template_java.controllers;

import dev.doremidevs.template_java.models.RecordingModel;
import java.util.ArrayList;

import DatabaseConnection.RecordingRepository;

public class RecordingController {

    private RecordingRepository recordingRepository = new RecordingRepository();

    public ArrayList<RecordingModel> index() {
        return recordingRepository.getRecordings();

    }

    public void create(RecordingModel recordingModel) {
        RecordingModel recording = new RecordingModel(recordingName, recording);
        recordingRepository.saveRecording(recording);
    }

    public RecordingModel show(String recordingName) {
        return recordingRepository.getRecordingByName(recordingName);
    }

    public void destroy(String recordingName) {
        recordingRepository.deleteRecording(recordingName);
    }

}
