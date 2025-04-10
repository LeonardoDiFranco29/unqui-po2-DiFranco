import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp3.Multiplos;

class MultiplosTest {

	 @Test
	    public void testMayorMultiploDe3y9() {
	        int resultado = Multiplos.mayorMultiploComun(3, 9);
	        assertEquals(999, resultado);
	    }

	    @Test
	    public void testMayorMultiploDe5y7() {
	        int resultado = Multiplos.mayorMultiploComun(5, 7);
	        assertEquals(980, resultado);
	    }

	    @Test
	    public void testSinMultiploComun() {
	        int resultado = Multiplos.mayorMultiploComun(997, 998);
	        assertEquals(-1, resultado);
	    }

	    @Test
	    public void testMultiploDe10y20() {
	        int resultado = Multiplos.mayorMultiploComun(10, 20);
	        assertEquals(1000, resultado);
	    }
	}
