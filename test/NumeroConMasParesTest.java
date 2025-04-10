import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp3.NumeroConMasPares;

public class NumeroConMasParesTest {

    @Test
    public void testNumeroConMasDigitosPares() {
        int[] numeros = {135, 2468, 1234, 8888, 4321};

        int resultado = NumeroConMasPares.numeroConMasDigitosPares(numeros);

        // 8888 tiene 4 dígitos pares: 8,8,8,8
        assertTrue(resultado == 2468 || resultado == 8888);
    }

    @Test
    public void testConNumerosConLaMismaCantidadDePares() {
        int[] numeros = {24, 42};  // ambos tienen 2 dígitos pares

        int resultado = NumeroConMasPares.numeroConMasDigitosPares(numeros);

        // Cualquiera de los dos está bien, porque tienen la misma cantidad
        assertTrue(resultado == 24 || resultado == 42);
    }

    @Test
    public void testArrayConUnSoloElemento() {
        int[] numeros = {2048};

        int resultado = NumeroConMasPares.numeroConMasDigitosPares(numeros);

        assertEquals(2048, resultado);
    }

    @Test
    public void testArraySinPares() {
        int[] numeros = {111, 333, 555};

        int resultado = NumeroConMasPares.numeroConMasDigitosPares(numeros);

        // Todos tienen 0 pares, cualquier resultado está bien
        assertTrue(resultado == 111 || resultado == 333 || resultado == 555);
    }

    @Test
    public void testNumeroNegativo() {
        int[] numeros = {-482, 123};

        int resultado = NumeroConMasPares.numeroConMasDigitosPares(numeros);

        // -482 tiene dos dígitos pares: 4 y 2
        assertEquals(-482, resultado);
    }
}
