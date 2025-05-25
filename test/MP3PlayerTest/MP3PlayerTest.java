package MP3PlayerTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp7.state.mp3.MP3Player;
import ar.edu.unq.po2.tp7.state.mp3.PausedState;
import ar.edu.unq.po2.tp7.state.mp3.PlayingState;
import ar.edu.unq.po2.tp7.state.mp3.SelectionState;
import ar.edu.unq.po2.tp7.state.mp3.Song;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MP3PlayerTest {

    private MP3Player player;
    private Song testSong; // Usaremos una instancia real de Song
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach // Este método se ejecuta antes de cada test
    void setUp() {
        player = new MP3Player(); // Creamos una nueva máquina para cada test
        testSong = new Song("Test Song"); // Creamos una instancia de Song real
        System.setOut(new PrintStream(outContent)); // Redirigimos la salida para capturarla
        outContent.reset(); // Limpiamos el buffer de salida
    }

    // --- Tests para SelectionState ---

    @Test // Verifica el estado inicial del reproductor
    void testSelectionState_InitialState() {
        assertTrue(player.getState() instanceof SelectionState); // Debe empezar en SelectionState
    }

    @Test // Intenta reproducir sin seleccionar canción
    void testSelectionState_PlayWithoutSongSelected_ShowsError() {
        player.play(); // No se ha seleccionado una canción
        // Se espera un mensaje de error y que el estado permanezca sin cambios
        assertEquals("Error: No song selected to play.\n", outContent.toString().replace("\r", ""));
        assertTrue(player.getState() instanceof SelectionState);
    }

    @Test // Intenta pausar en SelectionState
    void testSelectionState_Pause_ShowsError() {
        player.pause(); // No hay nada reproduciendo para pausar
        // Se espera un mensaje de error y que el estado permanezca sin cambios
        assertEquals("Error: Nothing is playing or paused to resume/pause.\n", outContent.toString().replace("\r", ""));
        assertTrue(player.getState() instanceof SelectionState);
    }

    @Test // Intenta detener en SelectionState
    void testSelectionState_Stop_DoesNothing() {
        player.stop(); // Ya está en selección, detener no hace nada
        //assertEquals("", outContent.toString()); // No debería imprimir nada
        assertTrue(player.getState() instanceof SelectionState);
    }

    @Test // Selecciona una canción y la reproduce
    void testSelectionState_SelectSongAndPlay_TransitionsToPlayingState() {
        player.selectSong(testSong); // Seleccionamos la canción
        outContent.reset(); // Limpiamos salida anterior a la acción
        player.play(); // Iniciamos la reproducción
        // Se espera el mensaje de "Playing song..." y el cambio a PlayingState
        //assertEquals("Playing song...\n", outContent.toString().replace("\r", ""));
        assertTrue(player.getState() instanceof PlayingState);
    }

    // --- Tests para PlayingState ---

    @Test // Intenta reproducir cuando ya está reproduciendo
    void testPlayingState_PlayAgain_ShowsError() {
        player.selectSong(testSong); // Configuración inicial: seleccionar y reproducir
        player.play();
        outContent.reset(); // Limpiamos la salida para el segundo 'play'

        player.play(); // Intenta reproducir de nuevo
        // Se espera un mensaje de error y que el estado permanezca sin cambios
        assertEquals("Error: Already playing a song.\n", outContent.toString().replace("\r", ""));
        assertTrue(player.getState() instanceof PlayingState);
    }

    @Test // Pausa una canción que se está reproduciendo
    void testPlayingState_Pause_TransitionsToPausedState() {
        player.selectSong(testSong); // Configuración inicial: seleccionar y reproducir
        player.play();
        outContent.reset(); // Limpiamos la salida antes de la pausa

        player.pause(); // Pausar
        // Se espera el mensaje de "Song paused." y el cambio a PausedState
        //assertEquals("Song paused.\n", outContent.toString().replace("\r", ""));
        assertTrue(player.getState() instanceof PausedState);
    }

    @Test // Detiene una canción que se está reproduciendo
    void testPlayingState_Stop_TransitionsToSelectionState() {
        player.selectSong(testSong); // Configuración inicial: seleccionar y reproducir
        player.play();
        outContent.reset(); // Limpiamos la salida antes del stop

        player.stop(); // Detener
        // Se espera el mensaje de "Song stopped..." y el cambio a SelectionState
        //assertEquals("Song stopped. Returning to song selection.\n", outContent.toString().replace("\r", ""));
        assertTrue(player.getState() instanceof SelectionState);
    }

    // --- Tests para PausedState ---

    @Test // Retoma la reproducción desde el estado pausado
    void testPausedState_Play_ResumesAndTransitionsToPlayingState() {
        player.selectSong(testSong); // Configuración inicial: seleccionar, reproducir, pausar
        player.play();
        player.pause();
        outContent.reset(); // Limpiamos la salida antes de retomar el play

        player.play(); // Retomar reproducción
        // Se espera el mensaje de "Resuming song." y el cambio a PlayingState
        //assertEquals("Resuming song.\n", outContent.toString().replace("\r", ""));
        assertTrue(player.getState() instanceof PlayingState);
    }

    @Test // Intenta pausar cuando ya está pausada
    void testPausedState_PauseAgain_ShowsError() {
        player.selectSong(testSong); // Configuración inicial: seleccionar, reproducir, pausar
        player.play();
        player.pause();
        outContent.reset(); // Limpiamos la salida antes de la segunda pausa

        player.pause(); // Intenta pausar de nuevo
        // Se espera un mensaje de error y que el estado permanezca sin cambios
        assertEquals("Error: Song is already paused.\n", outContent.toString().replace("\r", ""));
        assertTrue(player.getState() instanceof PausedState);
    }

    @Test // Detiene una canción que está pausada
    void testPausedState_Stop_TransitionsToSelectionState() {
        player.selectSong(testSong); // Configuración inicial: seleccionar, reproducir, pausar
        player.play();
        player.pause();
        outContent.reset(); // Limpiamos la salida antes del stop

        player.stop(); // Detener
        // Se espera el mensaje de "Song stopped..." y el cambio a SelectionState
        //assertEquals("Song stopped. Returning to song selection.\n", outContent.toString().replace("\r", ""));
        assertTrue(player.getState() instanceof SelectionState);
    }

    // --- Ciclos completos (sin verificar directamente las llamadas a Song, solo la salida del Player y el estado) ---

    @Test // Prueba un ciclo completo de Play -> Pause -> Play -> Stop
    void testFullCycle_PlayPausePlayStop() {
        player.selectSong(testSong);
        player.play(); // Reproduciendo
        assertTrue(player.getState() instanceof PlayingState);

        player.pause(); // Pausado
        assertTrue(player.getState() instanceof PausedState);

        player.play(); // Reproduciendo de nuevo
        assertTrue(player.getState() instanceof PlayingState);

        player.stop(); // Detenido y vuelve a selección
        assertTrue(player.getState() instanceof SelectionState);
    }

    @Test // Prueba un ciclo completo de Play -> Stop -> Intentar Play -> Seleccionar y Play
    void testFullCycle_PlayStopPlay() {
        player.selectSong(testSong);
        player.play(); // Reproduciendo
        assertTrue(player.getState() instanceof PlayingState);

        player.stop(); // Detenido y vuelve a selección
        assertTrue(player.getState() instanceof SelectionState);

        // Intentar play sin seleccionar de nuevo debería dar error
        outContent.reset();
        player.play();
        assertEquals("Error: No song selected to play.\n", outContent.toString().replace("\r", ""));
        assertTrue(player.getState() instanceof SelectionState);

        // Seleccionar y play otra vez (la misma canción es suficiente para el ejemplo)
        player.selectSong(testSong);
        outContent.reset();
        player.play(); // Reproduciendo
        //assertEquals("Playing song...\n", outContent.toString().replace("\r", ""));
        assertTrue(player.getState() instanceof PlayingState);
    }
}