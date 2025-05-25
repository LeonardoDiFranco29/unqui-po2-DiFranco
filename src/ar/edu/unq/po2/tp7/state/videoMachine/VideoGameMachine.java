package ar.edu.unq.po2.tp7.state.videoMachine;

//La clase principal que representa la máquina de videojuegos.
//Delega el comportamiento a su objeto de estado actual.
public class VideoGameMachine {
 private GameState state; // Atributo que mantiene el estado actual de la máquina
 private int tokens;      // Atributo para llevar la cuenta de las fichas

 // Constructor de la máquina de videojuegos.
 public VideoGameMachine() {
     this.tokens = 0; // Inicializa las fichas en cero
     this.state = new NoTokensState(); // Establece el estado inicial al arrancar la máquina
 }

 // Método para insertar una ficha. Delega la acción al estado actual.
 public void insertToken() {
     state.handleInsertToken(this); // 'this' se pasa para que el estado pueda interactuar con la máquina
 }

 // Método para presionar el botón de inicio. Delega la acción al estado actual.
 public void pressStartButton() {
     state.handlePressStartButton(this);
 }

 // Método para finalizar el juego. Delega la acción al estado actual.
 public void endGame() {
     state.handleEndGame(this);
 }

 // --- Getters y Setters ---

 // Obtiene el estado actual. Usado principalmente en los tests para verificar el cambio de estado.
 public GameState getState() {
     return state;
 }

 // Establece un nuevo estado para la máquina. Los estados concretos lo usan para cambiar el contexto.
 public void setState(GameState state) {
     this.state = state;
 }

 // Obtiene el número actual de fichas.
 public int getTokens() {
     return tokens;
 }

 // Establece el número de fichas. Usado por los estados para actualizar el contador.
 public void setTokens(int tokens) {
     this.tokens = tokens;
 }
}