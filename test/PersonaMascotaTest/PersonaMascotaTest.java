package PersonaMascotaTest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp5.PersonasYMascotas.Mascota;
import ar.edu.unq.po2.tp5.PersonasYMascotas.Persona;

public class PersonaMascotaTest {

    @Test
    public void testNombrePersona() {
        Persona p = new Persona("Carlos", LocalDate.of(2000, 1, 1));
        assertEquals("Carlos", p.getName());
    }

    @Test
    public void testEdadPersona() {
        Persona p = new Persona("Laura", LocalDate.now().minusYears(25));
        assertEquals(25, p.getEdad());
    }

    @Test
    public void testComparacionPersona() {
        Persona p1 = new Persona("A", LocalDate.of(1995, 1, 1));
        Persona p2 = new Persona("B", LocalDate.of(2000, 1, 1));
        assertTrue(p1.compareTo(p2) < 0);
    }

    @Test
    public void testNombreMascota() {
        Mascota m = new Mascota("Rocky", "Bulldog");
        assertEquals("Rocky", m.getName());
    }

    @Test
    public void testRazaMascota() {
        Mascota m = new Mascota("Nina", "Caniche");
        assertEquals("Caniche", m.getRaza());
    }
}
