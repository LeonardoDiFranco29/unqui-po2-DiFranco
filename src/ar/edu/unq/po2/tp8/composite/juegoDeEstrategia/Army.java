package ar.edu.unq.po2.tp8.composite.juegoDeEstrategia;

import java.util.ArrayList;
import java.util.List;

//--- 5. Compuesto (Composite del Composite) ---
public class Army implements Character {
 private final String id;
 private final List<Character> units; // Puede contener Engineers, Knights o otros Armies
 private Position currentPosition; // La posición del ejército

 public Army(String id, Position initialPosition) {
     this.id = id;
     this.units = new ArrayList<>();
     this.currentPosition = initialPosition;
 }

 @Override
 public String getId() {
     return id;
 }

 @Override
 public Position getCurrentPosition() {
     // Para simplificar, la posición del ejército es la de su inicialización o último destino.
     // En un juego real, podría ser el centroide de sus unidades o la posición del líder.
     return currentPosition;
 }

 public void addUnit(Character unit) {
     units.add(unit);
     System.out.println("Ejército " + id + ": Añadida unidad " + unit.getId());
 }

 public void removeUnit(Character unit) {
     units.remove(unit);
     System.out.println("Ejército " + id + ": Eliminada unidad " + unit.getId());
 }

 public List<Character> getUnits() {
     return new ArrayList<>(units); // Devuelve una copia
 }

 @Override
 public void move(Position destination) {
     System.out.println("\n--- Ejército " + id + " comienza movimiento a " + destination + " ---");
     for (Character unit : units) {
         // Cada unidad se mueve a la posición de destino según su propia lógica
         unit.move(destination);
     }
     this.currentPosition = destination; // Actualiza la posición del ejército
     System.out.println("--- Ejército " + id + " ha completado el movimiento ---");
 }
}