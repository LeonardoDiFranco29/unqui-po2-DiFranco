package ar.edu.unq.po2.tp3;

import java.util.ArrayList;
import java.util.List;

public class EquipoDeTrabajo {
    private String nombre;
    private List<Persona> integrantes;

    public EquipoDeTrabajo(String nombre) {
        this.nombre = nombre;
        this.integrantes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarIntegrante(Persona persona) {
        integrantes.add(persona);
    }

    public double promedioEdad() {
        if (integrantes.isEmpty()) {
            return 0.0;
        }

        int suma = 0;
        for (Persona p : integrantes) {
            suma += p.getEdad();
        }

        return (double) suma / integrantes.size();
    }
}