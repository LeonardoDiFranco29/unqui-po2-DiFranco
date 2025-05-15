package ar.edu.unq.po2.tp6.solid.banco;

import java.util.ArrayList;
import java.util.List;

public class SolicitudCreditoRepository implements ISolicitudCreditoRepository {
    private List<SolicitudCredito> solicitudes = new ArrayList<>();

    @Override
    public void agregar(SolicitudCredito solicitud) {
        this.solicitudes.add(solicitud);
    }

    @Override
    public List<SolicitudCredito> obtenerTodos() {
        return new ArrayList<>(this.solicitudes);
    }

    @Override
    public List<SolicitudCredito> obtenerAceptadas() {
        List<SolicitudCredito> aceptadas = new ArrayList<>();
        for (SolicitudCredito solicitud : this.solicitudes) {
            if (solicitud.esAceptada()) {
                aceptadas.add(solicitud);
            }
        }
        return aceptadas;
    }

    protected List<SolicitudCredito> getSolicitudes() { // Para pruebas
        return solicitudes;
    }
}