package ar.edu.unq.po2.tp6.solid.banco;

public class SolicitudCreditoHipotecario extends SolicitudCredito {
    private Propiedad propiedadGarantia;

    public SolicitudCreditoHipotecario(Cliente cliente, double montoSolicitado, int plazoMeses, Propiedad propiedadGarantia) {
        super(cliente, montoSolicitado, plazoMeses);
        this.propiedadGarantia = propiedadGarantia;
    }

    public Propiedad getPropiedadGarantia() {
        return propiedadGarantia;
    }

    @Override
    public boolean puedeSerAceptada() {
        return getMontoCuotaMensual() <= 0.50 * getCliente().getSueldoNetoMensual() &&
               getMontoSolicitado() <= 0.70 * propiedadGarantia.getValorFiscal() &&
               (getCliente().getEdad() + (double)getPlazoMeses() / 12) <= 65;
    }
}