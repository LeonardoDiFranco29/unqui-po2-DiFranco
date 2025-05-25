package ar.edu.unq.po2.tp7.state.videoMachine;

//Estado cuando hay una ficha insertada.
public class OneTokenState implements GameState {
 @Override
 public void handleInsertToken(VideoGameMachine machine) {
     System.out.println("Token inserted."); // Informa que se insertó otra ficha
     machine.setTokens(machine.getTokens() + 1); // Incrementa el contador de fichas
     machine.setState(new TwoTokensState()); // Cambia el estado a TwoTokensState
 }

 @Override
 public void handlePressStartButton(VideoGameMachine machine) {
     System.out.println("Starting single player game..."); // Inicia el juego para un jugador
     machine.endGame(); // Llama a endGame en el contexto, que manejará el regreso al estado inicial
 }

 @Override
 public void handleEndGame(VideoGameMachine machine) {
     System.out.println("Game Over. Returning to initial state."); // Mensaje de fin de juego
     machine.setState(new NoTokensState()); // Vuelve al estado NoTokensState
     machine.setTokens(0); // Reinicia el contador de fichas
 }
}