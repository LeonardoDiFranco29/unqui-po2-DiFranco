package ar.edu.unq.po2.tp3;

public class Point {
    private int x;
    private int y;

    // 1. Constructor que recibe x e y
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // 2. Constructor sin parámetros, crea (0, 0)
    public Point() {
        this.x = 0;
        this.y = 0;
    }

    // 3. Método para mover el punto a otra posición
    public void moveTo(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }

    // 4. Método para sumarse con otro punto y devolver un nuevo punto
    public Point sum(Point other) {
        int newX = this.x + other.x;
        int newY = this.y + other.y;
        return new Point(newX, newY);
    }

    // Getters (opcional pero útiles para pruebas)
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
