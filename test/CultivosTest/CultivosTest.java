package CultivosTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp8.composite.ParcelaCultivoSimple;
import ar.edu.unq.po2.tp8.composite.ParcelaMixta;
import ar.edu.unq.po2.tp8.composite.TipoCultivo;
import ar.edu.unq.po2.tp8.composite.Parcela;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// No necesitas ByteArrayOutputStream ni PrintStream para este tipo de pruebas
// import java.io.ByteArrayOutputStream;
// import java.io.PrintStream;

public class CultivosTest {

    // No necesitas capturar la salida de la consola si tu lógica de negocio
    // devuelve directamente los valores.
    // private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        // Si tus métodos de cálculo no imprimen, no necesitas redirigir System.out.
        // System.setOut(new PrintStream(outContent));
        // outContent.reset();
    }

    // Test para una parcela pura de Soja
    @Test
    void testParcelaPuraSojaGanancia() {
        Parcela sojaPura = new ParcelaCultivoSimple(TipoCultivo.SOJA);
        // Verificamos directamente el valor numérico retornado
        assertEquals(500.0, sojaPura.calcularGananciaAnualSoja(), 0.001); // El 0.001 es para tolerancia en doubles
        assertEquals(0.0, sojaPura.calcularGananciaAnualTrigo(), 0.001);
    }

    // Test para una parcela pura de Trigo
    @Test
    void testParcelaPuraTrigoGanancia() {
        Parcela trigoPuro = new ParcelaCultivoSimple(TipoCultivo.TRIGO);
        assertEquals(0.0, trigoPuro.calcularGananciaAnualSoja(), 0.001);
        assertEquals(300.0, trigoPuro.calcularGananciaAnualTrigo(), 0.001);
    }

    // Test para la parcela mixta del ejemplo de la figura
    @Test
    void testParcelaMixtaFiguraGanancia() {
        ParcelaMixta parcelaMixtaEjemplo = new ParcelaMixta();
        parcelaMixtaEjemplo.setSubParcela(0, new ParcelaCultivoSimple(TipoCultivo.SOJA));
        parcelaMixtaEjemplo.setSubParcela(1, new ParcelaCultivoSimple(TipoCultivo.SOJA));
        parcelaMixtaEjemplo.setSubParcela(2, new ParcelaCultivoSimple(TipoCultivo.TRIGO));
        parcelaMixtaEjemplo.setSubParcela(3, new ParcelaCultivoSimple(TipoCultivo.TRIGO));

        // Ganancia de Soja: (500/4) + (500/4) = 125 + 125 = 250
        assertEquals(250.0, parcelaMixtaEjemplo.calcularGananciaAnualSoja(), 0.001);
        // Ganancia de Trigo: (300/4) + (300/4) = 75 + 75 = 150
        assertEquals(150.0, parcelaMixtaEjemplo.calcularGananciaAnualTrigo(), 0.001);
    }

    // Test para una subdivisión recursiva
    @Test
    void testParcelaMixtaRecursivaGanancia() {
        ParcelaCultivoSimple sojaBase = new ParcelaCultivoSimple(TipoCultivo.SOJA);
        ParcelaCultivoSimple trigoBase = new ParcelaCultivoSimple(TipoCultivo.TRIGO);

        ParcelaMixta subMixtaA = new ParcelaMixta();
        subMixtaA.setSubParcela(0, sojaBase);
        subMixtaA.setSubParcela(1, trigoBase);
        subMixtaA.setSubParcela(2, sojaBase);
        subMixtaA.setSubParcela(3, trigoBase);

        // Ganancia Soja de subMixtaA: (500/4) + (0/4) + (500/4) + (0/4) = 125 + 125 = 250
        assertEquals(250.0, subMixtaA.calcularGananciaAnualSoja(), 0.001);
        // Ganancia Trigo de subMixtaA: (0/4) + (300/4) + (0/4) + (300/4) = 75 + 75 = 150
        assertEquals(150.0, subMixtaA.calcularGananciaAnualTrigo(), 0.001);

        // Parcela Mixta principal
        ParcelaMixta parcelaPrincipal = new ParcelaMixta();
        parcelaPrincipal.setSubParcela(0, subMixtaA);
        parcelaPrincipal.setSubParcela(1, sojaBase);
        parcelaPrincipal.setSubParcela(2, trigoBase);
        parcelaPrincipal.setSubParcela(3, sojaBase);

        // Cálculo Soja: (250/4) + (500/4) + (0/4) + (500/4) = 62.5 + 125 + 0 + 125 = 312.5
        assertEquals(312.5, parcelaPrincipal.calcularGananciaAnualSoja(), 0.001);
        // Cálculo Trigo: (150/4) + (0/4) + (300/4) + (0/4) = 37.5 + 0 + 75 + 0 = 112.5
        assertEquals(112.5, parcelaPrincipal.calcularGananciaAnualTrigo(), 0.001);
    }

    @Test
    void testParcelaMixtaConAlgunasRegionesVacias() {
        ParcelaMixta parcela = new ParcelaMixta();
        parcela.setSubParcela(0, new ParcelaCultivoSimple(TipoCultivo.SOJA));
        parcela.setSubParcela(1, new ParcelaCultivoSimple(TipoCultivo.TRIGO));
        // Las regiones 2 y 3 se quedan como null

        // Ganancia Soja: 500/4 + 0/4 + 0/4 + 0/4 = 125
        assertEquals(125.0, parcela.calcularGananciaAnualSoja(), 0.001);
        // Ganancia Trigo: 0/4 + 300/4 + 0/4 + 0/4 = 75
        assertEquals(75.0, parcela.calcularGananciaAnualTrigo(), 0.001);
    }
}