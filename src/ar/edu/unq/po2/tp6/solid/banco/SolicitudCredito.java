package ar.edu.unq.po2.tp6.solid.banco;

public abstract class SolicitudCredito {
    private Cliente cliente;
    private double montoSolicitado;
    private int plazoMeses;
    private boolean aceptada;

    public SolicitudCredito(Cliente cliente, double montoSolicitado, int plazoMeses) {
        this.cliente = cliente;
        this.montoSolicitado = montoSolicitado;
        this.plazoMeses = plazoMeses;
        this.aceptada = false;
    }

    public double getMontoCuotaMensual() {
        return montoSolicitado / plazoMeses;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getMontoSolicitado() {
        return montoSolicitado;
    }

    public int getPlazoMeses() {
        return plazoMeses;
    }

    public boolean esAceptada() {
        return aceptada;
    }

    public void setAceptada(boolean aceptada) {
        this.aceptada = aceptada;
    }

    public abstract boolean puedeSerAceptada();
}