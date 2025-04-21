package ProductosTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp5.FacturaServicio;

public class FacturaServicioTest {

    @Test
    public void testMontoCalculadoCorrectamente() {
        FacturaServicio fs = new FacturaServicio("Luz", 15.5, 10);
        assertEquals(155.0, fs.calcularMonto());
    }
}
