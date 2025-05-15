package ar.edu.unq.po2.tp6.solid.correo;

import java.util.ArrayList;
import java.util.List;

public class BandejaEntrada implements IBandeja {
    private List<Correo> correos = new ArrayList<>();

    @Override
    public void agregarCorreo(Correo correo) {
        this.correos.add(correo);
        System.out.println("Correo recibido: " + correo.getAsunto());
    }

    @Override
    public void eliminarCorreo(Correo correo) {
        this.correos.remove(correo);
        System.out.println("Correo movido a la papelera: " + correo.getAsunto());
    }

    @Override
    public int obtenerCantidad() {
        return this.correos.size();
    }

    @Override
    public List<Correo> obtenerCorreos() {
        return new ArrayList<>(this.correos); // Retornar una copia
    }
}