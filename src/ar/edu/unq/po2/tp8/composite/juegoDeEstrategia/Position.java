package ar.edu.unq.po2.tp8.composite.juegoDeEstrategia;

import java.util.Objects;

//--- 1. Clase Position ---
public class Position {
 private final int x;
 private final int y;

 public Position(int x, int y) {
     this.x = x;
     this.y = y;
 }

 public int getX() {
     return x;
 }

 public int getY() {
     return y;
 }

 public double distanceTo(Position other) {
     return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
 }

 @Override
 public boolean equals(Object o) {
     if (this == o) return true;
     if (o == null || getClass() != o.getClass()) return false;
     Position position = (Position) o;
     return x == position.x && y == position.y;
 }

 @Override
 public int hashCode() {
     return Objects.hash(x, y);
 }

 @Override
 public String toString() {
     return "(" + x + ", " + y + ")";
 }
}