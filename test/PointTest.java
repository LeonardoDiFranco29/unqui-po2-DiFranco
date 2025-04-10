import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp3.Point;

public class PointTest {

    @Test
    public void testConstructorConParametros() {
        Point p = new Point(5, 10);
        assertEquals(5, p.getX());
        assertEquals(10, p.getY());
    }

    @Test
    public void testConstructorSinParametros() {
        Point p = new Point();
        assertEquals(0, p.getX());
        assertEquals(0, p.getY());
    }

    @Test
    public void testMoveTo() {
        Point p = new Point(2, 3);
        p.moveTo(8, 9);
        assertEquals(8, p.getX());
        assertEquals(9, p.getY());
    }

    @Test
    public void testSum() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(3, 4);
        Point p3 = p1.sum(p2);
        assertEquals(4, p3.getX());
        assertEquals(6, p3.getY());
    }
}
