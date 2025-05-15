package ar.edu.unq.po2.tp6.solid.banco;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository implements IClienteRepository {
    private List<Cliente> clientes = new ArrayList<>();

    @Override
    public void agregar(Cliente cliente) {
        this.clientes.add(cliente);
    }

    @Override
    public Cliente obtener(String nombre, String apellido) {
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equals(nombre) && cliente.getApellido().equals(apellido)) {
                return cliente;
            }
        }
        return null;
    }

    @Override
    public List<Cliente> obtenerTodos() {
        return new ArrayList<>(this.clientes);
    }

    protected List<Cliente> getClientes() { // Para pruebas
        return clientes;
    }
}