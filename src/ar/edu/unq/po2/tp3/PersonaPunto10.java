package ar.edu.unq.po2.tp3;

import java.time.LocalDate;
import java.time.Period;

public class PersonaPunto10 {
    private String nombre;
    private LocalDate fechaNacimiento;

    // Constructor privado para obligar al uso del método de creación
    private PersonaPunto10(String nombre, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    // 3. Método de clase para crear una persona
    public static PersonaPunto10 crearPersona(String nombre, LocalDate fechaNacimiento) {
        return new PersonaPunto10(nombre, fechaNacimiento);
    }

    // Getter del nombre
    public String getNombre() {
        return nombre;
    }

    // Getter de la fecha de nacimiento
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    // Método para obtener la edad
    public int getEdad() {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    // 2. Método menorQue: compara edades
    public boolean menorQue(PersonaPunto10 otra) {
        return this.getEdad() < otra.getEdad();
    }

    // -------------------------------------------------------------------------
    // RESPUESTA AL PUNTO 1:
    //
    // Cuando un objeto externo llama al método getEdad(), no necesita saber 
    // cómo se calcula la edad internamente. Solo sabe que obtiene un número entero.
    //
    // Este mecanismo se llama "Encapsulamiento", que forma parte de la "Abstracción".
    // Permite ocultar los detalles internos del funcionamiento de un objeto 
    // y exponer solo lo necesario.
    // -------------------------------------------------------------------------
}