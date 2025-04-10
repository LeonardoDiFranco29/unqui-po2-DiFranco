import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp3.Cuadrado;
import ar.edu.unq.po2.tp3.Point;

public class CuadradoTest {

    @Test
    public void testConstructorYGetters() {
        Cuadrado c = new Cuadrado(new Point(1, 1), 5);

        assertEquals(5, c.getAncho());
        assertEquals(5, c.getAncho());
        assertEquals(5, c.getAlto());
    }

    @Test
    public void testAreaYPerimetro() {
        Cuadrado c = new Cuadrado(new Point(0, 0), 4);

        assertEquals(16, c.getArea());
        assertEquals(16, c.getPerimetro());
    }

    @Test
    public void testEsHorizontalYVertical() {
        Cuadrado c = new Cuadrado(new Point(0, 0), 6);

        // Al ser cuadrado, es tanto horizontal como vertical
        assertTrue(c.esHorizontal());
        assertTrue(c.esVertical());
    }

    @Test
    public void testConstructorConLadoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cuadrado(new Point(0, 0), -1);
        });
    }
}