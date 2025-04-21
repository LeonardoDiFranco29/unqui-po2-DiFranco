package ar.edu.unq.po2.tp5;

public abstract class Factura {
    protected String descripcion;

    public Factura(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
