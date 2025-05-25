package ar.edu.unq.po2.tp8.composite.juegoDeEstrategia;

public class Engineer implements Character {
    private final String id;
    private Position currentPosition;
    private int lajas;
    private final PathBuilder pathBuilder; // Inyectamos el constructor de caminos

    public Engineer(String id, Position initialPosition, int initialLajas, PathBuilder pathBuilder) {
        this.id = id;
        this.currentPosition = initialPosition;
        this.lajas = initialLajas;
        this.pathBuilder = pathBuilder;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Position getCurrentPosition() {
        return currentPosition;
    }
    
    public int getLajas() {
        return lajas;
    }


    // El método move() contiene la lógica del camino más corto directamente
    @Override
    public void move(Position destination) {
        Position start = this.currentPosition;
        System.out.println("Ingeniero " + id + " inicia movimiento.");
        System.out.println("  " + id + " se mueve de " + start + " a " + destination + " por la ruta más corta.");

        // Lógica para construir camino con lajas
        if (lajas > 0) {
            boolean lajaPlaced = pathBuilder.tryPlaceLaja(destination);
            if (lajaPlaced) {
                lajas--;
                System.out.println("    Ingeniero " + id + " ha colocado una laja. Lajas restantes: " + lajas);
            } else {
                System.out.println("    Ingeniero " + id + " no colocó laja (ya había una). Lajas restantes: " + lajas);
            }
        } else {
            System.out.println("    Ingeniero " + id + ": No quedan lajas para construir camino, caminando normalmente.");
        }

        this.currentPosition = destination; // Actualiza la posición final
        System.out.println("Ingeniero " + id + " llegó a " + currentPosition + ".");
    }
}