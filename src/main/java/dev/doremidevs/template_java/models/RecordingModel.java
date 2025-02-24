package dev.doremidevs.template_java.models;

import java.util.ArrayList;

public class RecordingModel <T extends InterfaceNote> {

    private int id;
    private String recordingName;
    private ArrayList <String> recording = new ArrayList<>();

    public RecordingModel(int id, String recordingName, ArrayList<String> recording) {
        this.id = id;
        this.recordingName = recordingName;
        this.recording = recording;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getRecordingName() {
        return recordingName;
    }

    public void setRecordingName(String recordingName) {
        this.recordingName = recordingName;
    }

    public ArrayList<String> getRecording() {
        return recording;
    }

    public void createRecording(T note) {
        String url = note.getNoteUrl();
        recording.add(url);
    }

}
