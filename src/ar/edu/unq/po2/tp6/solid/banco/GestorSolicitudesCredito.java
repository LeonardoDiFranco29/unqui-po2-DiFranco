package ar.edu.unq.po2.tp6.solid.banco;

import java.util.List;

public class GestorSolicitudesCredito {
	
    private ISolicitudCreditoRepository repositorioSolicitudes;

    public GestorSolicitudesCredito(ISolicitudCreditoRepository repositorioSolicitudes) {
        this.repositorioSolicitudes = repositorioSolicitudes;
    }

    public void agregarSolicitud(SolicitudCredito solicitud) {
        repositorioSolicitudes.agregar(solicitud);
    }

    public void evaluarSolicitud(SolicitudCredito solicitud) {
        if (solicitud.puedeSerAceptada()) {
            solicitud.setAceptada(true);
        } else {
            solicitud.setAceptada(false);
        }
    }

    public double calcularTotalDesembolso() {
        double total = 0;
        for (SolicitudCredito solicitud : repositorioSolicitudes.obtenerAceptadas()) {
            total += solicitud.getMontoSolicitado();
        }
        return total;
    }

    public List<SolicitudCredito> obtenerTodasLasSolicitudes() {
        return repositorioSolicitudes.obtenerTodos();
    }

    protected ISolicitudCreditoRepository getRepositorioSolicitudes() { // Para pruebas
        return repositorioSolicitudes;
    }
}