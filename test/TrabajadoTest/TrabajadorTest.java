package TrabajadoTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp4.Ingreso;
import ar.edu.unq.po2.tp4.IngresoPorHorasExtras;
import ar.edu.unq.po2.tp4.Trabajador;

public class TrabajadorTest {

    @Test
    public void testGetTotalPercibido() {
        List<Ingreso> ingresos = new ArrayList<>();
        ingresos.add(new Ingreso(1000, "Salario"));
        ingresos.add(new IngresoPorHorasExtras(500, "Horas Extras", 10));

        Trabajador trabajador = new Trabajador(ingresos);
        assertEquals(1500, trabajador.getTotalPercibido());
    }

    @Test
    public void testGetMontoImponible() {
        List<Ingreso> ingresos = new ArrayList<>();
        ingresos.add(new Ingreso(1000, "Salario"));
        ingresos.add(new IngresoPorHorasExtras(500, "Horas Extras", 10));

        Trabajador trabajador = new Trabajador(ingresos);
        assertEquals(1000, trabajador.getMontoImponible());
    }

    @Test
    public void testGetImpuestoAPagar() {
        List<Ingreso> ingresos = new ArrayList<>();
        ingresos.add(new Ingreso(1000, "Salario"));
        ingresos.add(new IngresoPorHorasExtras(500, "Horas Extras", 10));

        Trabajador trabajador = new Trabajador(ingresos);
        assertEquals(20, trabajador.getImpuestoAPagar());
    }
}
