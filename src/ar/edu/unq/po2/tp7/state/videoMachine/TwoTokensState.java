package ar.edu.unq.po2.tp7.state.videoMachine;

public class TwoTokensState implements GameState {
    @Override
    public void handleInsertToken(VideoGameMachine machine) {
        System.out.println("Already have enough tokens for a game."); // Ya hay suficientes fichas
        // No se incrementan las fichas ni se cambia de estado, se ignora la ficha extra.
    }

    @Override
    public void handlePressStartButton(VideoGameMachine machine) {
        System.out.println("Starting two player game..."); // Inicia el juego para dos jugadores
        machine.endGame(); // Llama a endGame en el contexto, que manejará el regreso al estado inicial
    }

    @Override
    public void handleEndGame(VideoGameMachine machine) {
        System.out.println("Game Over. Returning to initial state."); // Mensaje de fin de juego
        machine.setState(new NoTokensState()); // Vuelve al estado NoTokensState
        machine.setTokens(0); // Reinicia el contador de fichas
    }
}