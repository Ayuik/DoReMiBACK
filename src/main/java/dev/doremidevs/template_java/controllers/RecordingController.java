package dev.doremidevs.template_java.controllers;

import dev.doremidevs.template_java.models.RecordingModel;
import DatabaseConnection.RecordingRepository;
import java.util.List;

public class RecordingController {

    private final RecordingRepository recordingRepository;

    public RecordingController(RecordingRepository recordingRepository) {
        this.recordingRepository = recordingRepository;
    }

    public List<RecordingModel<?>> index() {
        return recordingRepository.getRecordings();
    }

    public void create(RecordingModel<?> recordingModel) {
        recordingRepository.saveRecording(
            recordingModel.getId(),
            recordingModel.getRecordingName(),
            recordingModel.getRecording()
        );
    }

    public void destroy(String recordingName) {
        recordingRepository.deleteRecording(recordingName);
    }
}
