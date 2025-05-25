package ar.edu.unq.po2.tp7.state.videoMachine;

public interface GameState {
    void handleInsertToken(VideoGameMachine machine); // Maneja la inserción de una ficha
    void handlePressStartButton(VideoGameMachine machine); // Maneja el presionar el botón de inicio
    void handleEndGame(VideoGameMachine machine); // Maneja el fin del juego (para volver al estado inicial)
}