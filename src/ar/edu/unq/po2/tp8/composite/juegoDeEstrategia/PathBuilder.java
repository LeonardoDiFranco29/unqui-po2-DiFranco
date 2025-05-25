package ar.edu.unq.po2.tp8.composite.juegoDeEstrategia;

import java.util.HashSet;
import java.util.Set;

//--- 2. Clase Auxiliar PathBuilder (para Ingeniero) ---
//NOTA: Se asume que PathBuilder es una instancia compartida entre todos los Ingenieros
//para que el estado de los caminos construidos sea global.
public class PathBuilder {
 private final Set<Position> builtPaths;

 public PathBuilder() {
     this.builtPaths = new HashSet<>();
 }

 // Intenta colocar una laja en una posición. Retorna true si se colocó, false si ya había una.
 public boolean tryPlaceLaja(Position pos) {
     if (builtPaths.contains(pos)) {
         System.out.println("    Laja: Ya hay una laja en " + pos + ".");
         return false; // Ya hay una laja aquí
     }
     builtPaths.add(pos);
     System.out.println("    Laja: Colocada laja en " + pos + ".");
     return true; // Laja colocada con éxito
 }

 public void clearPaths() {
     builtPaths.clear();
     System.out.println("    PathBuilder: Caminos construidos limpiados.");
 }
}