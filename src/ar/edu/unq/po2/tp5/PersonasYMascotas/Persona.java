package ar.edu.unq.po2.tp5.PersonasYMascotas;

import java.time.LocalDate;
import java.time.Period;

public class Persona implements Nombrable, Comparable<Persona> {
    private String nombre;
    private LocalDate fechaNacimiento;

    public Persona(String nombre, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String getName() {
        return nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public int getEdad() {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    @Override
    public int compareTo(Persona otra) {
        return this.fechaNacimiento.compareTo(otra.fechaNacimiento);
    }
}