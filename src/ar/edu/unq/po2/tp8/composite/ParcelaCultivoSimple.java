package ar.edu.unq.po2.tp8.composite;

//--- 2. Hoja (Leaf): ParcelaCultivoSimple ---
//Representa una porción de tierra con un único tipo de cultivo.
public class ParcelaCultivoSimple implements Parcela {
    private TipoCultivo tipo;
    private static final double GANANCIA_SOJA = 500.0;
    private static final double GANANCIA_TRIGO = 300.0;

    public ParcelaCultivoSimple(TipoCultivo tipo) {
        if (tipo == null) {
            throw new IllegalArgumentException("El tipo de cultivo no puede ser nulo.");
        }
        this.tipo = tipo;
    }

    @Override // ¡Asegúrate de tener esta anotación!
    public double calcularGananciaAnualSoja() {
        return (this.tipo == TipoCultivo.SOJA) ? GANANCIA_SOJA : 0.0;
    }

    @Override // ¡Asegúrate de tener esta anotación!
    public double calcularGananciaAnualTrigo() {
        return (this.tipo == TipoCultivo.TRIGO) ? GANANCIA_TRIGO : 0.0;
    }

    @Override
    public String toString() {
        return "CultivoSimple[" + tipo + "]";
    }
}