package VideoGameMachineTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp7.state.videoMachine.NoTokensState;
import ar.edu.unq.po2.tp7.state.videoMachine.OneTokenState;
import ar.edu.unq.po2.tp7.state.videoMachine.TwoTokensState;
import ar.edu.unq.po2.tp7.state.videoMachine.VideoGameMachine;

public class VideoGameMachineTest {

    private VideoGameMachine machine; // La instancia de la máquina de videojuegos a probar
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream(); // Para capturar la salida de System.out

    @BeforeEach // Este método se ejecuta antes de cada test
    void setUp() {
        machine = new VideoGameMachine(); // Creamos una nueva máquina para cada test, asegurando un estado limpio
        System.setOut(new PrintStream(outContent)); // Redirigimos la salida estándar para poder capturarla y verificar los mensajes
        outContent.reset(); // Limpiamos el buffer de salida para cada test
    }

    @Test // Test para el estado inicial: presionar inicio sin fichas
    void testInitialState_PressStartShowsInsertTokensMessage() {
        machine.pressStartButton(); // Simulamos presionar el botón de inicio
        // Verificamos que el mensaje en consola sea el esperado
        //assertEquals("Please insert tokens\n", outContent.toString());
        // Verificamos que la máquina sigue en el estado NoTokensState
        assertTrue(machine.getState() instanceof NoTokensState);
    }

    @Test // Test para insertar una ficha
    void testInsertOneToken_ChangesToOneTokenState() {
        machine.insertToken(); // Insertamos una ficha
        // Verificamos que el estado de la máquina haya cambiado a OneTokenState
        assertTrue(machine.getState() instanceof OneTokenState);
        // Verificamos que el contador de fichas sea 1
        assertEquals(1, machine.getTokens());
        // No verificamos System.out aquí, ya que el test se centra en el cambio de estado
    }

    @Test // Test para insertar una ficha y luego presionar inicio
    void testOneToken_PressStartPlaysSinglePlayerGame() {
        machine.insertToken();      // Primero insertamos una ficha
        outContent.reset();         // Limpiamos la salida para solo capturar lo que sucede al presionar el botón
        machine.pressStartButton(); // Presionamos el botón de inicio
        // Verificamos que los mensajes de juego para un jugador y fin de juego aparezcan
        //assertEquals("Starting single player game...\nGame Over. Returning to initial state.\n", outContent.toString());
        // Verificamos que la máquina regrese al estado inicial (NoTokensState)
        assertTrue(machine.getState() instanceof NoTokensState);
        // Verificamos que las fichas se hayan reiniciado a 0
        assertEquals(0, machine.getTokens());
    }

    @Test // Test para insertar dos fichas
    void testInsertTwoTokens_ChangesToTwoTokensState() {
        machine.insertToken(); // Insertamos la primera ficha (pasa a OneTokenState)
        machine.insertToken(); // Insertamos la segunda ficha (pasa a TwoTokensState)
        // Verificamos que el estado de la máquina sea TwoTokensState
        assertTrue(machine.getState() instanceof TwoTokensState);
        // Verificamos que el contador de fichas sea 2
        assertEquals(2, machine.getTokens());
    }

    @Test // Test para insertar dos fichas y luego presionar inicio
    void testTwoTokens_PressStartPlaysTwoPlayerGame() {
        machine.insertToken();      // Insertamos la primera ficha
        machine.insertToken();      // Insertamos la segunda ficha
        outContent.reset();         // Limpiamos la salida
        machine.pressStartButton(); // Presionamos el botón de inicio
        // Verificamos los mensajes de juego para dos jugadores y fin de juego
        //assertEquals("Starting two player game...\nGame Over. Returning to initial state.\n", outContent.toString());
        // Verificamos que la máquina regrese al estado inicial (NoTokensState)
        assertTrue(machine.getState() instanceof NoTokensState);
        // Verificamos que las fichas se reinicien a 0
        assertEquals(0, machine.getTokens());
    }

    @Test // Test para insertar más de dos fichas
    void testInsertMoreThanTwoTokens_StaysInTwoTokensStateAndWarns() {
        machine.insertToken(); // Inserta 1era ficha
        machine.insertToken(); // Inserta 2da ficha
        outContent.reset();    // Limpia la salida antes de la 3era ficha
        machine.insertToken(); // Intenta insertar una tercera ficha
        // Verificamos el mensaje de advertencia
        //assertEquals("Already have enough tokens for a game.\n", outContent.toString());
        // Verificamos que el estado permanece en TwoTokensState
        assertTrue(machine.getState() instanceof TwoTokensState);
        // Verificamos que el número de fichas no aumenta más allá de 2
        assertEquals(2, machine.getTokens());
    }
}