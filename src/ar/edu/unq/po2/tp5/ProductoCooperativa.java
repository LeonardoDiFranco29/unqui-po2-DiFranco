package ar.edu.unq.po2.tp5;

public class ProductoCooperativa extends ProductoComun {

    public ProductoCooperativa(String nombre, double precioBase) {
        super(nombre, precioBase);
    }

    @Override
    public double getPrecio() {
        return super.getPrecio() * 0.9; // 10% de descuento
    }
}
