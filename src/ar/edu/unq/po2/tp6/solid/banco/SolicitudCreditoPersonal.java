package ar.edu.unq.po2.tp6.solid.banco;

public class SolicitudCreditoPersonal extends SolicitudCredito {
    public SolicitudCreditoPersonal(Cliente cliente, double montoSolicitado, int plazoMeses) {
        super(cliente, montoSolicitado, plazoMeses);
    }

    @Override
    public boolean puedeSerAceptada() {
        return getCliente().getSueldoNetoAnual() >= 15000 &&
               getMontoCuotaMensual() <= 0.70 * getCliente().getSueldoNetoMensual();
    }
}