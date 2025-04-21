package ProductosTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp5.ProductoComun;

public class ProductoComunTest {

    @Test
    public void testPrecioBase() {
        ProductoComun prod = new ProductoComun("Arroz", 100);
        assertEquals(100, prod.getPrecio());
    }

    @Test
    public void testNombreProducto() {
        ProductoComun prod = new ProductoComun("Fideos", 80);
        assertEquals("Fideos", prod.getNombre());
    }
}
