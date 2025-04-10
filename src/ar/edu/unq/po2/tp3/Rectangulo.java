package ar.edu.unq.po2.tp3;

public class Rectangulo {
    private Point origen;
    private int ancho;
    private int alto;

    // 1. Constructor asegurando consistencia
    public Rectangulo(Point origen, int ancho, int alto) {
        if (ancho < 0 || alto < 0) {
            throw new IllegalArgumentException("Ancho y alto deben ser positivos");
        }
        this.origen = origen;
        this.ancho = ancho;
        this.alto = alto;
    }

    // 2. Obtener área
    public int getArea() {
        return ancho * alto;
    }

    // 3. Obtener perímetro
    public int getPerimetro() {
        return 2 * (ancho + alto);
    }

    // 4. Determinar si es horizontal
    public boolean esHorizontal() {
        return ancho > alto;
    }

    // 4. Determinar si es vertical
    public boolean esVertical() {
        return alto > ancho;
    }

    // Getters opcionales
    public Point getOrigen() {
        return origen;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }
}

