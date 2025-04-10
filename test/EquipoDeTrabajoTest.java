import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp3.EquipoDeTrabajo;
import ar.edu.unq.po2.tp3.Persona;

public class EquipoDeTrabajoTest {

    @Test
    void testPromedioEdad() {
        EquipoDeTrabajo equipo = new EquipoDeTrabajo("Equipo Java");

        // Agregamos 5 personas con edades conocidas
        equipo.agregarIntegrante(new Persona("Ana", "López", 30));
        equipo.agregarIntegrante(new Persona("Luis", "Martínez", 40));
        equipo.agregarIntegrante(new Persona("Sofía", "Pérez", 20));
        equipo.agregarIntegrante(new Persona("Carlos", "Gómez", 25));
        equipo.agregarIntegrante(new Persona("Lucía", "Ramírez", 50));

        double promedioEsperado = 33.0;
        double promedioObtenido = equipo.promedioEdad();

        assertEquals(promedioEsperado, promedioObtenido, 0.0001);
    }
}
