package ar.edu.unq.po2.tp6.solid.banco;

import java.util.List;

public interface ISolicitudCreditoRepository {
    void agregar(SolicitudCredito solicitud);
    List<SolicitudCredito> obtenerTodos();
    List<SolicitudCredito> obtenerAceptadas();
}