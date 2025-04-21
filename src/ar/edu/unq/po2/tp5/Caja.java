package ar.edu.unq.po2.tp5;

import java.util.ArrayList;
import java.util.List;

public class Caja {
    private List<Producto> productos = new ArrayList<>();
    private List<Facturable> facturas = new ArrayList<>();

    public void registrarProducto(Producto producto) {
        producto.registrar();
        productos.add(producto);
    }

    public void registrarFactura(Facturable factura) {
        facturas.add(factura);
    }

    public double calcularTotal() {
        double total = 0;
        for (Producto p : productos) {
            total += p.getPrecio();
        }
        for (Facturable f : facturas) {
            total += f.calcularMonto();
        }
        return total;
    }

    public void cerrarCaja(Agencia agencia) {
        for (Facturable f : facturas) {
            f.registrarPago(agencia);
        }
    }
}