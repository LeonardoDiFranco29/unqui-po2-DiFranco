import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ar.edu.unq.po2.tp3.Counter;  // importante importar la clase

public class CounterTestCase {

    private Counter counter;

    /**
     * Crea un escenario de test básico: 10 números
     * 9 impares y 1 par (el 4)
     */
    @BeforeEach
    public void setUp() throws Exception {
        counter = new Counter();
        counter.addNumber(1);
        counter.addNumber(3);
        counter.addNumber(5);
        counter.addNumber(7);
        counter.addNumber(9);
        counter.addNumber(1);
        counter.addNumber(1);
        counter.addNumber(1);
        counter.addNumber(1);
        counter.addNumber(4);
    }

    /**
     * Verifica que haya 1 número par
     */
    @Test
    public void testEvenNumbers() {
        int cantidad = counter.getEvenOcurrences();
        assertEquals(1, cantidad);
    }

    /**
     * Verifica que haya 9 impares
     */
    @Test
    public void testOddNumbers() {
        int cantidad = counter.getOddOcurrences();
        assertEquals(9, cantidad);
    }

    /**
     * Verifica cuántos son múltiplos de 3
     */
    @Test
    public void testMultiplesOf3() {
        int cantidad = counter.getMultiplesOf(3);
        // 3 y 9 son múltiplos de 3
        assertEquals(2, cantidad);
    }
}