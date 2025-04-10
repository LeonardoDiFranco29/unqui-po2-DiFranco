import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp3.Point;
import ar.edu.unq.po2.tp3.Rectangulo;

public class RectanguloTest {

    @Test
    public void testConstructorYGetters() {
        Point origen = new Point(0, 0);
        Rectangulo r = new Rectangulo(origen, 10, 5);

        assertEquals(0, r.getOrigen().getX());
        assertEquals(0, r.getOrigen().getY());
        assertEquals(10, r.getAncho());
        assertEquals(5, r.getAlto());
    }

    @Test
    public void testArea() {
        Rectangulo r = new Rectangulo(new Point(1, 1), 4, 3);
        assertEquals(12, r.getArea());
    }

    @Test
    public void testPerimetro() {
        Rectangulo r = new Rectangulo(new Point(2, 2), 6, 2);
        assertEquals(16, r.getPerimetro());
    }

    @Test
    public void testEsHorizontalOVertical() {
        Rectangulo horizontal = new Rectangulo(new Point(0, 0), 10, 3);
        Rectangulo vertical = new Rectangulo(new Point(0, 0), 4, 8);

        assertTrue(horizontal.esHorizontal());
        assertFalse(horizontal.esVertical());

        assertFalse(vertical.esHorizontal());
        assertTrue(vertical.esVertical());
    }

    @Test
    public void testConstructorConValoresInvalidos() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Rectangulo(new Point(0, 0), -2, 3);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Rectangulo(new Point(0, 0), 2, -3);
        });
    }
}
