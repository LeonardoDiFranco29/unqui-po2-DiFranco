package BancoTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp6.solid.banco.Banco;
import ar.edu.unq.po2.tp6.solid.banco.Cliente;
import ar.edu.unq.po2.tp6.solid.banco.GestorSolicitudesCredito;
import ar.edu.unq.po2.tp6.solid.banco.IClienteRepository;
import ar.edu.unq.po2.tp6.solid.banco.ISolicitudCreditoRepository;
import ar.edu.unq.po2.tp6.solid.banco.Propiedad;
import ar.edu.unq.po2.tp6.solid.banco.SolicitudCredito;
import ar.edu.unq.po2.tp6.solid.banco.SolicitudCreditoHipotecario;
import ar.edu.unq.po2.tp6.solid.banco.SolicitudCreditoPersonal;

import java.util.ArrayList;
import java.util.List;

class ClienteRepositoryStub implements IClienteRepository {
    private List<Cliente> clientes = new ArrayList<>();

    @Override
    public void agregar(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public Cliente obtener(String nombre, String apellido) {
        for (Cliente c : clientes) {
            if (c.getNombre().equals(nombre) && c.getApellido().equals(apellido)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public List<Cliente> obtenerTodos() {
        return new ArrayList<>(clientes);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
}

class SolicitudCreditoRepositoryStub implements ISolicitudCreditoRepository {
    private List<SolicitudCredito> solicitudes = new ArrayList<>();

    @Override
    public void agregar(SolicitudCredito solicitud) {
        solicitudes.add(solicitud);
    }

    @Override
    public List<SolicitudCredito> obtenerTodos() {
        return new ArrayList<>(solicitudes);
    }

    @Override
    public List<SolicitudCredito> obtenerAceptadas() {
        List<SolicitudCredito> aceptadas = new ArrayList<>();
        for (SolicitudCredito s : solicitudes) {
            if (s.esAceptada()) {
                aceptadas.add(s);
            }
        }
        return aceptadas;
    }

    public List<SolicitudCredito> getSolicitudes() {
        return solicitudes;
    }
}

public class BancoTest {

    @Test
    void agregarClienteAlBanco() {
        ClienteRepositoryStub clienteRepo = new ClienteRepositoryStub();
        SolicitudCreditoRepositoryStub solicitudRepo = new SolicitudCreditoRepositoryStub();
        GestorSolicitudesCredito gestorSolicitudes = new GestorSolicitudesCredito(solicitudRepo);
        Banco banco = new Banco(clienteRepo, gestorSolicitudes);
        Cliente cliente = new Cliente("Test", "User", "Test Address", 25, 2000);
        banco.agregarCliente(cliente);
        assertEquals(1, clienteRepo.getClientes().size());
        assertEquals(cliente, clienteRepo.getClientes().get(0));
    }

    @Test
    void registrarSolicitudCreditoPersonal_aceptada() {
        ClienteRepositoryStub clienteRepo = new ClienteRepositoryStub();
        SolicitudCreditoRepositoryStub solicitudRepo = new SolicitudCreditoRepositoryStub();
        GestorSolicitudesCredito gestorSolicitudes = new GestorSolicitudesCredito(solicitudRepo);
        Banco banco = new Banco(clienteRepo, gestorSolicitudes);
        Cliente cliente = new Cliente("Test", "User", "Test Address", 25, 3000);
        banco.registrarSolicitudCreditoPersonal(cliente, 10000, 12);
        assertEquals(1, solicitudRepo.getSolicitudes().size());
        assertTrue(solicitudRepo.getSolicitudes().get(0).esAceptada());
        assertEquals(cliente, solicitudRepo.getSolicitudes().get(0).getCliente());
    }

    @Test
    void registrarSolicitudCreditoPersonal_rechazada() {
        ClienteRepositoryStub clienteRepo = new ClienteRepositoryStub();
        SolicitudCreditoRepositoryStub solicitudRepo = new SolicitudCreditoRepositoryStub();
        GestorSolicitudesCredito gestorSolicitudes = new GestorSolicitudesCredito(solicitudRepo);
        Banco banco = new Banco(clienteRepo, gestorSolicitudes);
        Cliente cliente = new Cliente("Test", "User", "Test Address", 25, 1000);
        banco.registrarSolicitudCreditoPersonal(cliente, 5000, 12);
        assertEquals(1, solicitudRepo.getSolicitudes().size());
        assertFalse(solicitudRepo.getSolicitudes().get(0).esAceptada());
        assertEquals(cliente, solicitudRepo.getSolicitudes().get(0).getCliente());
    }

    @Test
    void registrarSolicitudCreditoHipotecario_aceptada() {
        ClienteRepositoryStub clienteRepo = new ClienteRepositoryStub();
        SolicitudCreditoRepositoryStub solicitudRepo = new SolicitudCreditoRepositoryStub();
        GestorSolicitudesCredito gestorSolicitudes = new GestorSolicitudesCredito(solicitudRepo);
        Banco banco = new Banco(clienteRepo, gestorSolicitudes);
        Cliente cliente = new Cliente("Test", "User", "Test Address", 50, 4000);
        Propiedad garantia = new Propiedad("Casa", "Address", 200000);
        banco.registrarSolicitudCreditoHipotecario(cliente, 100000, 120, garantia);
        assertEquals(1, solicitudRepo.getSolicitudes().size());
        assertTrue(solicitudRepo.getSolicitudes().get(0).esAceptada());
        SolicitudCreditoHipotecario solicitud = (SolicitudCreditoHipotecario) solicitudRepo.getSolicitudes().get(0);
        assertEquals(cliente, solicitud.getCliente());
        assertEquals(garantia, solicitud.getPropiedadGarantia());
    }

    @Test
    void registrarSolicitudCreditoHipotecario_rechazada_ingresos() {
        ClienteRepositoryStub clienteRepo = new ClienteRepositoryStub();
        SolicitudCreditoRepositoryStub solicitudRepo = new SolicitudCreditoRepositoryStub();
        GestorSolicitudesCredito gestorSolicitudes = new GestorSolicitudesCredito(solicitudRepo);
        Banco banco = new Banco(clienteRepo, gestorSolicitudes);
        Cliente cliente = new Cliente("Test", "User", "Test Address", 50, 1000);
        Propiedad garantia = new Propiedad("Casa", "Address", 200000);
        banco.registrarSolicitudCreditoHipotecario(cliente, 100000, 120, garantia);
        assertEquals(1, solicitudRepo.getSolicitudes().size());
        assertFalse(solicitudRepo.getSolicitudes().get(0).esAceptada());
    }

    @Test
    void calcularTotalDesembolso() {
        ClienteRepositoryStub clienteRepo = new ClienteRepositoryStub();
        SolicitudCreditoRepositoryStub solicitudRepo = new SolicitudCreditoRepositoryStub();
        GestorSolicitudesCredito gestorSolicitudes = new GestorSolicitudesCredito(solicitudRepo);
        Banco banco = new Banco(clienteRepo, gestorSolicitudes);
        Cliente cliente1 = new Cliente("Cliente1", "Apellido1", "Dir", 30, 3000);
        Cliente cliente2 = new Cliente("Cliente2", "Apellido2", "Dir", 40, 4000);
        solicitudRepo.agregar(new SolicitudCreditoPersonal(cliente1, 10000, 12));
        solicitudRepo.getSolicitudes().get(0).setAceptada(true);
        solicitudRepo.agregar(new SolicitudCreditoHipotecario(cliente2, 50000, 60, new Propiedad("Prop", "Addr", 100000)));
        solicitudRepo.getSolicitudes().get(1).setAceptada(true);
        assertEquals(60000, banco.calcularTotalDesembolso(), 0.001);
    }

    @Test
    void buscarClienteExistente() {
        ClienteRepositoryStub clienteRepo = new ClienteRepositoryStub();
        SolicitudCreditoRepositoryStub solicitudRepo = new SolicitudCreditoRepositoryStub();
        GestorSolicitudesCredito gestorSolicitudes = new GestorSolicitudesCredito(solicitudRepo);
        Banco banco = new Banco(clienteRepo, gestorSolicitudes);
        Cliente cliente = new Cliente("Buscar", "Cliente", "Address", 30, 2500);
        clienteRepo.agregar(cliente);
        assertEquals(cliente, banco.buscarCliente("Buscar", "Cliente"));
    }

    @Test
    void buscarClienteNoExistente() {
        ClienteRepositoryStub clienteRepo = new ClienteRepositoryStub();
        SolicitudCreditoRepositoryStub solicitudRepo = new SolicitudCreditoRepositoryStub();
        GestorSolicitudesCredito gestorSolicitudes = new GestorSolicitudesCredito(solicitudRepo);
        Banco banco = new Banco(clienteRepo, gestorSolicitudes);
        assertNull(banco.buscarCliente("No", "Existe"));
    }
}