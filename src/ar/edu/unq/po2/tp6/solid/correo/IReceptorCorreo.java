package ar.edu.unq.po2.tp6.solid.correo;

import java.util.List;

public interface IReceptorCorreo {
    List<Correo> recibirNuevos(String user, String pass);
}