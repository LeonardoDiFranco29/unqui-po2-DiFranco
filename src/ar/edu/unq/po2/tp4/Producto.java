package ar.edu.unq.po2.tp4;

public class Producto {
    private String nombre;
    private double precio;
    private boolean esPrecioCuidado;

    public Producto(String nombre, double precio) {
        this(nombre, precio, false);
    }

    public Producto(String nombre, double precio, boolean esPrecioCuidado) {
        this.nombre = nombre;
        this.precio = precio;
        this.esPrecioCuidado = esPrecioCuidado;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public boolean esPrecioCuidado() {
        return esPrecioCuidado;
    }

    public void aumentarPrecio(double aumento) {
        this.precio += aumento;
    }
}