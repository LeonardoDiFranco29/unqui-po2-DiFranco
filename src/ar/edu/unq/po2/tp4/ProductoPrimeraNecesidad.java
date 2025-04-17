package ar.edu.unq.po2.tp4;

public class ProductoPrimeraNecesidad extends Producto {

	private double descuento;

    public ProductoPrimeraNecesidad(String nombre, double precio, boolean esPrecioCuidado, double descuento) {
        super(nombre, precio, esPrecioCuidado);
        this.descuento = descuento;
    }
    
    public ProductoPrimeraNecesidad(String nombre, double precio, boolean esPrecioCuidado) {
        this(nombre, precio, esPrecioCuidado, 0.1); // descuento por defecto del 10%
    }

    @Override
    public Double getPrecio() {
        return super.getPrecio() * (1 - descuento);
    }

}
