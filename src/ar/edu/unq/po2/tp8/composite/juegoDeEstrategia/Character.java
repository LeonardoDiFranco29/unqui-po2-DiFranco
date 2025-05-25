package ar.edu.unq.po2.tp8.composite.juegoDeEstrategia;

//--- 3. Interfaz Character (Componente del Composite) ---
public interface Character {
 String getId(); // Identificador único del personaje/ejército
 void move(Position destination);
 Position getCurrentPosition();
 
}