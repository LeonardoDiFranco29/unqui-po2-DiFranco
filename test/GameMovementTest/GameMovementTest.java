package GameMovementTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp8.composite.juegoDeEstrategia.Army;
import ar.edu.unq.po2.tp8.composite.juegoDeEstrategia.Engineer;
import ar.edu.unq.po2.tp8.composite.juegoDeEstrategia.Knight;
import ar.edu.unq.po2.tp8.composite.juegoDeEstrategia.PathBuilder;
import ar.edu.unq.po2.tp8.composite.juegoDeEstrategia.Position;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GameMovementTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private PathBuilder globalPathBuilder;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        globalPathBuilder = new PathBuilder(); // Asegurar PathBuilder limpio para cada test
        outContent.reset(); // Limpiar buffer de salida
    }

    // --- Tests de movimiento para Engineer ---
    @Test
    void engineerMovesAndPlacesLajaWhenAvailableAndPathNew() {
        Engineer eng = new Engineer("E1", new Position(0, 0), 1, globalPathBuilder);
        Position destination = new Position(10, 10);

        eng.move(destination);

        // Verifica que la posición final es la correcta
        assertEquals(destination, eng.getCurrentPosition());
        // Verifica que se usó una laja
        assertEquals(0, eng.getLajas());
        // Verifica el mensaje de laja colocada (ya que es parte de la consigna "va construyendo un camino")
        assertTrue(outContent.toString().contains("Laja: Colocada laja en (10, 10)."));
    }

    @Test
    void engineerMovesNormallyWhenNoLajasLeft() {
        Engineer eng = new Engineer("E2", new Position(0, 0), 0, globalPathBuilder); // Ingeniero sin lajas
        Position destination = new Position(20, 20);

        eng.move(destination);

        // Verifica que la posición final es la correcta
        assertEquals(destination, eng.getCurrentPosition());
        // Verifica que no hay lajas restantes (se inició con 0)
        assertEquals(0, eng.getLajas());
        // Verifica que el mensaje indica que camina normalmente
        assertTrue(outContent.toString().contains("Ingeniero E2: No quedan lajas para construir camino, caminando normalmente."));
        assertFalse(outContent.toString().contains("Laja: Colocada laja en")); // Asegurarse que no intenta colocar
    }

    @Test
    void engineerMovesNormallyWhenLajaAlreadyPlaced() {
        Engineer engA = new Engineer("EA", new Position(0, 0), 1, globalPathBuilder);
        Engineer engB = new Engineer("EB", new Position(0, 0), 1, globalPathBuilder);
        Position commonDestination = new Position(5, 5);

        engA.move(commonDestination); // EA coloca la laja
        outContent.reset(); // Limpia la salida para que solo veamos la de EB

        engB.move(commonDestination); // EB intenta colocar en el mismo lugar

        // Verifica que las posiciones finales son correctas
        assertEquals(commonDestination, engA.getCurrentPosition());
        assertEquals(commonDestination, engB.getCurrentPosition());
        // Verifica que EA usó su laja
        assertEquals(0, engA.getLajas());
        // Verifica que EB no usó su laja porque ya había una
        assertEquals(1, engB.getLajas());
        // Verifica el mensaje de que la laja ya existía
        assertTrue(outContent.toString().contains("Laja: Ya hay una laja en (5, 5)."));
    }

    // --- Tests de movimiento para Knight ---
    @Test
    void knightMovesInZigZagToDestination() {
        Knight kni = new Knight("K1", new Position(0, 0));
        Position destination = new Position(10, 0);

        kni.move(destination);

        // Verifica que la posición final es la correcta
        assertEquals(destination, kni.getCurrentPosition());
        // Verifica el mensaje de movimiento en zigzag (clave de su comportamiento)
        assertTrue(outContent.toString().contains("K1 se mueve de (0, 0) a (10, 0) en zigzag (vigilando la zona)."));
    }

    // --- Tests de movimiento para Army (Composite) ---
    @Test
    void armyMovesAllContainedUnits() {
        Engineer eng = new Engineer("E3", new Position(0, 0), 1, globalPathBuilder);
        Knight kni = new Knight("K3", new Position(0, 0));
        Army army = new Army("MainArmy", new Position(0, 0));

        army.addUnit(eng);
        army.addUnit(kni);

        Position destination = new Position(50, 50);
        army.move(destination);

        // Verifica que la posición final del ejército es la correcta (aunque es conceptual)
        assertEquals(destination, army.getCurrentPosition());
        // Verifica que las unidades individuales también llegaron a su destino
        assertEquals(destination, eng.getCurrentPosition());
        assertEquals(destination, kni.getCurrentPosition());

        // Verifica que el ingeniero usó su laja durante el movimiento del ejército
        assertEquals(0, eng.getLajas());
        assertTrue(outContent.toString().contains("Laja: Colocada laja en (50, 50)."));
        // Verifica que ambos tipos de movimiento (ruta corta y zigzag) ocurrieron
        assertTrue(outContent.toString().contains("E3 se mueve de (0, 0) a (50, 50) por la ruta más corta."));
        assertTrue(outContent.toString().contains("K3 se mueve de (0, 0) a (50, 50) en zigzag (vigilando la zona)."));
        assertTrue(outContent.toString().contains("--- Ejército MainArmy ha completado el movimiento ---"));
    }

    @Test
    void nestedArmiesMoveAllContainedUnitsRecursively() {
        Engineer engNested = new Engineer("ENested", new Position(0,0), 1, globalPathBuilder);
        Knight kniNested = new Knight("KNested", new Position(0,0));
        Army subArmy = new Army("SubArmy", new Position(0,0));
        subArmy.addUnit(engNested);
        subArmy.addUnit(kniNested);

        Army mainArmy = new Army("MainArmyNested", new Position(0,0));
        mainArmy.addUnit(subArmy); // Añadir el sub-ejército

        Position finalDestination = new Position(100,100);
        mainArmy.move(finalDestination);

        // Verifica que todas las unidades (incluso las anidadas en el sub-ejército) llegaron al destino
        assertEquals(finalDestination, engNested.getCurrentPosition());
        assertEquals(finalDestination, kniNested.getCurrentPosition());
        // Verifica que la laja se colocó
        assertEquals(0, engNested.getLajas());

        // Verifica que los mensajes de movimiento de todos los niveles se imprimieron
        String output = outContent.toString();
        assertTrue(output.contains("--- Ejército MainArmyNested comienza movimiento a (100, 100) ---"));
        assertTrue(output.contains("--- Ejército SubArmy comienza movimiento a (100, 100) ---"));
        assertTrue(output.contains("ENested se mueve de (0, 0) a (100, 100) por la ruta más corta."));
        assertTrue(output.toString().contains("Laja: Colocada laja en (100, 100)."));
        assertTrue(output.contains("KNested se mueve de (0, 0) a (100, 100) en zigzag (vigilando la zona)."));
        assertTrue(output.contains("--- Ejército MainArmyNested ha completado el movimiento ---"));
    }
}