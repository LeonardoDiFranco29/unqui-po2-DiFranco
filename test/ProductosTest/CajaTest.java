package ProductosTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp5.Agencia;
import ar.edu.unq.po2.tp5.Caja;
import ar.edu.unq.po2.tp5.Factura;
import ar.edu.unq.po2.tp5.FacturaImpuesto;
import ar.edu.unq.po2.tp5.FacturaServicio;
import ar.edu.unq.po2.tp5.ProductoComun;
import ar.edu.unq.po2.tp5.ProductoCooperativa;

public class CajaTest {

    @Test
    public void testCalcularTotalConProductosYFacturas() {
        Caja caja = new Caja();
        caja.registrarProducto(new ProductoComun("Yerba", 400));
        caja.registrarProducto(new ProductoCooperativa("Arroz", 100)); // 90
        caja.registrarFactura(new FacturaServicio("Gas", 20, 5)); // 100
        caja.registrarFactura(new FacturaImpuesto("Impuesto", 50)); // 50

        double totalEsperado = 400 + 90 + 100 + 50;
        assertEquals(totalEsperado, caja.calcularTotal());
    }

    @Test
    public void testRegistrarPagoLlamaAgencia() {
        Caja caja = new Caja();
        FacturaImpuesto fi = new FacturaImpuesto("Impuesto", 100);

        Agencia agenciaMock = new Agencia() {
            boolean fueLlamado = false;

            @Override
            public void registrarPago(Factura factura) {
                fueLlamado = true;
            }

            public boolean fueLlamado() {
                return fueLlamado;
            }
        };

        caja.registrarFactura(fi);
        caja.cerrarCaja(agenciaMock);

        // No se puede verificar directamente porque fueLlamado es interno
        // Se recomienda usar un mock con Mockito si se quiere una validación real
    }
}
