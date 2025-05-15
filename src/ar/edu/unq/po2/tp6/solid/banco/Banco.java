package ar.edu.unq.po2.tp6.solid.banco;

import java.util.List; // Importar la clase List

public class Banco {
    private IClienteRepository repositorioClientes;
    private GestorSolicitudesCredito gestorSolicitudes;

    public Banco(IClienteRepository repositorioClientes, GestorSolicitudesCredito gestorSolicitudes) {
        this.repositorioClientes = repositorioClientes;
        this.gestorSolicitudes = gestorSolicitudes;
    }

    public void agregarCliente(Cliente cliente) {
        repositorioClientes.agregar(cliente);
    }

    public void registrarSolicitudCreditoPersonal(Cliente cliente, double monto, int plazoMeses) {
        SolicitudCreditoPersonal solicitud = new SolicitudCreditoPersonal(cliente, monto, plazoMeses);
        gestorSolicitudes.agregarSolicitud(solicitud);
        gestorSolicitudes.evaluarSolicitud(solicitud);
    }

    public void registrarSolicitudCreditoHipotecario(Cliente cliente, double monto, int plazoMeses, Propiedad garantia) {
        SolicitudCreditoHipotecario solicitud = new SolicitudCreditoHipotecario(cliente, monto, plazoMeses, garantia);
        gestorSolicitudes.agregarSolicitud(solicitud);
        gestorSolicitudes.evaluarSolicitud(solicitud);
    }

    public double calcularTotalDesembolso() {
        return gestorSolicitudes.calcularTotalDesembolso();
    }

    public List<SolicitudCredito> obtenerTodasLasSolicitudes() {
        return gestorSolicitudes.obtenerTodasLasSolicitudes();
    }

    public Cliente buscarCliente(String nombre, String apellido) {
        return repositorioClientes.obtener(nombre, apellido);
    }

    protected IClienteRepository getRepositorioClientes() { // Para pruebas
        return repositorioClientes;
    }

    protected GestorSolicitudesCredito getGestorSolicitudes() { // Para pruebas
        return gestorSolicitudes;
    }
}