package ar.edu.unq.po2.tp4;

public class IngresoPorHorasExtras extends Ingreso {
    private int horasExtras;

    public IngresoPorHorasExtras(double monto, String concepto, int horasExtras) {
        super(monto, concepto);
        this.horasExtras = horasExtras;
    }

    @Override
    public double getMontoImponible() {
        return 0; // Exento del impuesto
    }

    // El método getMontoPercibido() hereda directamente y devuelve el monto real
}