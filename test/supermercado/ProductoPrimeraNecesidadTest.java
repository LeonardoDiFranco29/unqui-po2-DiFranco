package supermercado;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp4.ProductoPrimeraNecesidad;

import static org.junit.jupiter.api.Assertions.*;

public class ProductoPrimeraNecesidadTest {

	private ProductoPrimeraNecesidad leche;
	private ProductoPrimeraNecesidad arroz;
	
	@BeforeEach
	public void setUp() {
		leche = new ProductoPrimeraNecesidad("Leche", 8d, false);
		arroz = new ProductoPrimeraNecesidad("Arroz", 20d, true, 0.08); // 8% de descuento
	}
	
	@Test
	public void testCalcularPrecio() {
		assertEquals(new Double(7.2), leche.getPrecio());
		assertEquals(18.4, arroz.getPrecio(), 0.001); // 20 * 0.92 = 18.4
		//assertEquals(7.2, leche.getPrecio(), 0.001);
	}
}
