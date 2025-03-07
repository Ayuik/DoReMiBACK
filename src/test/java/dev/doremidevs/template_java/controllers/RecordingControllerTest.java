package dev.doremidevs.template_java.controllers;

import dev.doremidevs.template_java.models.RecordingModel;
import DatabaseConnection.RecordingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecordingControllerTest {

    private RecordingController controller;
    private RecordingRepository mockRepository;

    @BeforeEach
    void setUp() {
        mockRepository = new RecordingRepository() {
            private final List<RecordingModel<?>> recordings = new ArrayList<>();

            @Override
            public List<RecordingModel<?>> getRecordings() {
                return recordings;
            }

            @Override
            public void saveRecording(int id, String recordingName, List<String> recording) {
                recordings.add(new RecordingModel<>(id, recordingName, new ArrayList<>(recording)));
            }

            @Override
            public void deleteRecording(String recordingName) {
                recordings.removeIf(recording -> recording.getRecordingName().equals(recordingName));
            }
        };

        controller = new RecordingController(mockRepository);
    }

    // @Test
    // void testIndex() {
    //     // Crear una grabación y guardarla en el repositorio
    //     RecordingModel<?> recording = new RecordingModel<>(1, "Test Recording", List.of("C", "D", "E"));
    //     mockRepository.saveRecording(recording.getId(), recording.getRecordingName(), recording.getRecording());

    //     // Llamar al método index del controlador
    //     var recordings = controller.index();

    //     // Verificar que se haya devuelto la grabación correcta
    //     assertEquals(1, recordings.size());
    //     assertEquals("Test Recording", recordings.get(0).getRecordingName());
    // }

    // @Test
    // void testCreate() {
    //     // Crear una nueva grabación
    //     RecordingModel<?> newRecording = new RecordingModel<>(0, "New Recording", List.of("A", "B", "C"));

    //     // Llamar al método create del controlador
    //     controller.create(newRecording);

    //     // Obtener todas las grabaciones
    //     var recordings = controller.index();

    //     // Verificar que se haya guardado correctamente
    //     assertEquals(1, recordings.size());
    //     assertEquals("New Recording", recordings.get(0).getRecordingName());
    // }

    /* @Test
    void testDestroy() {
        // Crear una grabación y guardarla en el repositorio
        RecordingModel<?> recording = new RecordingModel<>(1, "Test Recording", List.of("C", "D", "E"));
        mockRepository.saveRecording(recording.getId(), recording.getRecordingName(), recording.getRecording());

        // Llamar al método destroy del controlador
        controller.destroy("Test Recording");

        // Obtener todas las grabaciones
        var recordings = controller.index();

        // Verificar que la grabación haya sido eliminada
        assertEquals(0, recordings.size());
    } */
}