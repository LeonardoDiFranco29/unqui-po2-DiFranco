package ar.edu.unq.po2.tp8.composite.juegoDeEstrategia;

public class Knight implements Character {
    private final String id;
    private Position currentPosition;

    public Knight(String id, Position initialPosition) {
        this.id = id;
        this.currentPosition = initialPosition;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Position getCurrentPosition() {
        return currentPosition;
    }

    // El método move() contiene la lógica del zigzag directamente
    @Override
    public void move(Position destination) {
        Position start = this.currentPosition;
        System.out.println("Caballero " + id + " inicia movimiento.");
        System.out.println("  " + id + " se mueve de " + start + " a " + destination + " en zigzag (vigilando la zona).");
        this.currentPosition = destination; // Actualiza la posición final
        System.out.println("Caballero " + id + " llegó a " + currentPosition + ".");
    }
}