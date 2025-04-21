package ProductosTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp5.FacturaImpuesto;

public class FacturaImpuestoTest {

    @Test
    public void testMontoFijo() {
        FacturaImpuesto fi = new FacturaImpuesto("Impuesto municipal", 300);
        assertEquals(300, fi.calcularMonto());
    }
}
