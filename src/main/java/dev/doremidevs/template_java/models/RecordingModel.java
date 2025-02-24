package dev.doremidevs.template_java.models;

import java.util.ArrayList;

public class RecordingModel <T extends InterfaceNote> {

    private int id;
    private String recordingName;
    private ArrayList <T> recording = new ArrayList<>();

    public RecordingModel(int id, String recordingName, ArrayList<T> recording) {
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

    public ArrayList<T> getRecording() {
        return recording;
    }

    public void createRecording(T note) {
        recording.add(note);
    }

}
