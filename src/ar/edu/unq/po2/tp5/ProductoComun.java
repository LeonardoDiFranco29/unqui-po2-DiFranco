package ar.edu.unq.po2.tp5;

public class ProductoComun implements Producto {
    private String nombre;
    private double precioBase;

    public ProductoComun(String nombre, double precioBase) {
        this.nombre = nombre;
        this.precioBase = precioBase;
    }

    @Override
    public double getPrecio() {
        return precioBase;
    }

    @Override
    public void registrar() {
        // Lógica de stock (si hiciera falta)
    }

    public String getNombre() {
        return nombre;
    }
}
