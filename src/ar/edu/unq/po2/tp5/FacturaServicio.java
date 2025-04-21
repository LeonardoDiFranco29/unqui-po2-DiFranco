package ar.edu.unq.po2.tp5;

public class FacturaServicio extends Factura implements Facturable {
    private double costoUnitario;
    private int cantidad;

    public FacturaServicio(String descripcion, double costoUnitario, int cantidad) {
        super(descripcion);
        this.costoUnitario = costoUnitario;
        this.cantidad = cantidad;
    }

    @Override
    public double calcularMonto() {
        return costoUnitario * cantidad;
    }

    @Override
    public void registrarPago(Agencia agencia) {
        agencia.registrarPago(this);
    }
}
