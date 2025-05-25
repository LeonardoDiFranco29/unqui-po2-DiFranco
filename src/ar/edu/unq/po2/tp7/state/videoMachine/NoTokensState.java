package ar.edu.unq.po2.tp7.state.videoMachine;

public class NoTokensState implements GameState {
    @Override
    public void handleInsertToken(VideoGameMachine machine) {
        System.out.println("Token inserted."); // Informa que se insertó una ficha
        machine.setTokens(machine.getTokens() + 1); // Incrementa el contador de fichas
        machine.setState(new OneTokenState()); // Cambia el estado a OneTokenState
    }

    @Override
    public void handlePressStartButton(VideoGameMachine machine) {
        System.out.println("Please insert tokens"); // Muestra el mensaje para insertar fichas
    }

    @Override
    public void handleEndGame(VideoGameMachine machine) {
        // En este estado, el juego no ha comenzado, así que no hay un "fin de juego" aplicable.
        // Podríamos no hacer nada o mostrar un mensaje si se llama inesperadamente.
    }
}