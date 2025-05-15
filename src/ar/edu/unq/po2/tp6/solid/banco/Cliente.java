package ar.edu.unq.po2.tp6.solid.banco;

import java.util.Objects;

public class Cliente {
    private String nombre;
    private String apellido;
    private String direccion;
    private int edad;
    private double sueldoNetoMensual;

    public Cliente(String nombre, String apellido, String direccion, int edad, double sueldoNetoMensual) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.edad = edad;
        this.sueldoNetoMensual = sueldoNetoMensual;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public double getSueldoNetoAnual() {
        return sueldoNetoMensual * 12;
    }

    public double getSueldoNetoMensual() {
        return sueldoNetoMensual;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return edad == cliente.edad &&
               Double.compare(cliente.sueldoNetoMensual, sueldoNetoMensual) == 0 &&
               Objects.equals(nombre, cliente.nombre) &&
               Objects.equals(apellido, cliente.apellido) &&
               Objects.equals(direccion, cliente.direccion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido, direccion, edad, sueldoNetoMensual);
    }
}