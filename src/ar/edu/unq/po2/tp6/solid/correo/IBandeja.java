package ar.edu.unq.po2.tp6.solid.correo;

import java.util.List;

public interface IBandeja {
    void agregarCorreo(Correo correo);
    void eliminarCorreo(Correo correo);
    int obtenerCantidad();
    List<Correo> obtenerCorreos();
}