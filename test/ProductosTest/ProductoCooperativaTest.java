package ProductosTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp5.ProductoCooperativa;

public class ProductoCooperativaTest {

    @Test
    public void testDescuentoDel10Porciento() {
        ProductoCooperativa prod = new ProductoCooperativa("Lentejas", 200);
        assertEquals(180, prod.getPrecio());
    }
}
