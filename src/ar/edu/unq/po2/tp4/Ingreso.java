package ar.edu.unq.po2.tp4;

public class Ingreso {
    protected double monto;
    protected String concepto;

    public Ingreso(double monto, String concepto) {
        this.monto = monto;
        this.concepto = concepto;
    }

    public double getMontoPercibido() {
        return monto;
    }

    public double getMontoImponible() {
        return monto;
    }
}