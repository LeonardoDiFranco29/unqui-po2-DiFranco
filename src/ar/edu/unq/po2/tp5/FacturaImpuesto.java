package ar.edu.unq.po2.tp5;

public class FacturaImpuesto extends Factura implements Facturable {
    private double montoFijo;

    public FacturaImpuesto(String descripcion, double montoFijo) {
        super(descripcion);
        this.montoFijo = montoFijo;
    }

    @Override
    public double calcularMonto() {
        return montoFijo;
    }

    @Override
    public void registrarPago(Agencia agencia) {
        agencia.registrarPago(this);
    }
}