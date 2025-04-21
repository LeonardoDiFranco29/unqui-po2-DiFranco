package ar.edu.unq.po2.tp5;

import java.time.LocalDate;
import java.time.Period;

public class Persona extends SerConNombre {
    private String nombre;
    private LocalDate fechaNacimiento;

    public Persona(String nombre, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public int getEdad() {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    public boolean esMenorQue(Persona otra) {
        return this.getEdad() < otra.getEdad();
    }

    @Override
    public String getName() {
        return this.nombre;
    }
}
