package dev.doremidevs.template_java.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RecordingModelTest {

    private RecordingModel<InterfaceNote> recordingModel;
    private InterfaceNote testNote;

    @BeforeEach
    void setUp() {
        recordingModel = new RecordingModel<>(1, "Test Recording", new ArrayList<>());
        testNote = new InterfaceNote() {
            @Override
            public String getNoteUrl() {
                return "../resources/DO4.mp3";
            }

            @Override
            public String getNoteName() {
                return "do4";
            }
        };
    }

    @Test
    void testGetId() {
        assertEquals(1, recordingModel.getId());
    }

    @Test
    void testSetId() {
        recordingModel.setId(2);
        assertEquals(2, recordingModel.getId());
    }

    @Test
    void testGetRecordingName() {
        assertEquals("Test Recording", recordingModel.getRecordingName());
    }

    @Test
    void testSetRecordingName() {
        recordingModel.setRecordingName("New Recording");
        assertEquals("New Recording", recordingModel.getRecordingName());
    }

    @Test
    void testCreateRecording() {
        recordingModel.createRecording(testNote);
        assertEquals(1, recordingModel.getRecording().size());
        assertEquals("../resources/DO4.mp3", recordingModel.getRecording().get(0));
    }

}
