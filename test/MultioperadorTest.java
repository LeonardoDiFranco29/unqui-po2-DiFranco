import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp3.Multioperador;

public class MultioperadorTest {

    private Multioperador multi;
    private ArrayList<Integer> lista;

    @BeforeEach
    public void setUp() {
        multi = new Multioperador();
        lista = new ArrayList<>();
    }

    @Test
    public void testSumar() {
        lista.add(1);
        lista.add(2);
        lista.add(3);
        assertEquals(6, multi.sumar(lista));
    }

    @Test
    public void testRestar() {
        lista.add(10);
        lista.add(3);
        lista.add(2);
        assertEquals(5, multi.restar(lista)); // 10 - 3 - 2
    }

    @Test
    public void testMultiplicar() {
        lista.add(2);
        lista.add(3);
        lista.add(4);
        assertEquals(24, multi.multiplicar(lista)); // 2 * 3 * 4
    }

    @Test
    public void testConListaVacia() {
        assertEquals(0, multi.sumar(lista));
        assertEquals(0, multi.restar(lista));
        assertEquals(0, multi.multiplicar(lista));
    }

    @Test
    public void testMultiplicarConCero() {
        lista.add(4);
        lista.add(0);
        lista.add(5);
        assertEquals(0, multi.multiplicar(lista));
    }
}
