package ar.edu.unq.po2.tp6.solid.correo;

import java.util.ArrayList;
import java.util.List;

public class Papelera implements IBandeja {
    private List<Correo> correosBorrados = new ArrayList<>();

    @Override
    public void agregarCorreo(Correo correo) {
        this.correosBorrados.add(correo);
        System.out.println("Correo borrado: " + correo.getAsunto());
    }

    @Override
    public void eliminarCorreo(Correo correo) {
        this.correosBorrados.remove(correo);
        System.out.println("Correo eliminado permanentemente: " + correo.getAsunto());
    }

    @Override
    public int obtenerCantidad() {
        return this.correosBorrados.size();
    }

    @Override
    public List<Correo> obtenerCorreos() {
        return new ArrayList<>(this.correosBorrados); // Retornar una copia
    }
}