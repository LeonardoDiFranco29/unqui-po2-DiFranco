package ar.edu.unq.po2.tp6.solid.banco;

import java.util.List;

public interface IClienteRepository {
    void agregar(Cliente cliente);
    Cliente obtener(String nombre, String apellido);
    List<Cliente> obtenerTodos();
}