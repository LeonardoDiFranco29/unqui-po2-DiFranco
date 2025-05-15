package BancoTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


import ar.edu.unq.po2.tp6.solid.banco.Cliente;
import ar.edu.unq.po2.tp6.solid.banco.GestorSolicitudesCredito;

import ar.edu.unq.po2.tp6.solid.banco.ISolicitudCreditoRepository;
import ar.edu.unq.po2.tp6.solid.banco.Propiedad;
import ar.edu.unq.po2.tp6.solid.banco.SolicitudCredito;
import ar.edu.unq.po2.tp6.solid.banco.SolicitudCreditoHipotecario;
import ar.edu.unq.po2.tp6.solid.banco.SolicitudCreditoPersonal;



import java.util.ArrayList;
import java.util.List;

class SolicitudCreditoRepositoryFake implements ISolicitudCreditoRepository {
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

public class GestorSolicitudesCreditoTest {

    @Test
    void agregarSolicitudAlRepositorio() {
        SolicitudCreditoRepositoryFake solicitudRepo = new SolicitudCreditoRepositoryFake();
        GestorSolicitudesCredito gestor = new GestorSolicitudesCredito(solicitudRepo);
        Cliente cliente = new Cliente("Test", "User", "Test Address", 25, 2000);
        SolicitudCreditoPersonal solicitud = new SolicitudCreditoPersonal(cliente, 5000, 10);
        gestor.agregarSolicitud(solicitud);
        assertEquals(1, solicitudRepo.getSolicitudes().size());
        assertEquals(solicitud, solicitudRepo.getSolicitudes().get(0));
    }

    @Test
    void evaluarSolicitudPersonal_aceptada() {
        SolicitudCreditoRepositoryFake solicitudRepo = new SolicitudCreditoRepositoryFake();
        GestorSolicitudesCredito gestor = new GestorSolicitudesCredito(solicitudRepo);
        Cliente cliente = new Cliente("Test", "User", "Test Address", 25, 3000);
        SolicitudCreditoPersonal solicitud = new SolicitudCreditoPersonal(cliente, 10000, 12);
        gestor.evaluarSolicitud(solicitud);
        assertTrue(solicitud.esAceptada());
    }

    @Test
    void evaluarSolicitudPersonal_rechazada_ingresosAnuales() {
        SolicitudCreditoRepositoryFake solicitudRepo = new SolicitudCreditoRepositoryFake();
        GestorSolicitudesCredito gestor = new GestorSolicitudesCredito(solicitudRepo);
        Cliente cliente = new Cliente("Test", "User", "Test Address", 25, 1000);
        SolicitudCreditoPersonal solicitud = new SolicitudCreditoPersonal(cliente, 5000, 12);
        gestor.evaluarSolicitud(solicitud);
        assertFalse(solicitud.esAceptada());
    }

    @Test
    void evaluarSolicitudPersonal_rechazada_cuotaVsIngresos() {
        SolicitudCreditoRepositoryFake solicitudRepo = new SolicitudCreditoRepositoryFake();
        GestorSolicitudesCredito gestor = new GestorSolicitudesCredito(solicitudRepo);
        Cliente cliente = new Cliente("Test", "User", "Test Address", 25, 2000);
        SolicitudCreditoPersonal solicitud = new SolicitudCreditoPersonal(cliente, 1500, 1); // Cuota 1500, 70% de 2000 = 1400
        gestor.evaluarSolicitud(solicitud);
        assertFalse(solicitud.esAceptada());
    }

    @Test
    void evaluarSolicitudHipotecario_aceptada() {
        SolicitudCreditoRepositoryFake solicitudRepo = new SolicitudCreditoRepositoryFake();
        GestorSolicitudesCredito gestor = new GestorSolicitudesCredito(solicitudRepo);
        Cliente cliente = new Cliente("Test", "User", "Test Address", 50, 4000);
        Propiedad garantia = new Propiedad("Casa", "Address", 200000);
        SolicitudCreditoHipotecario solicitud = new SolicitudCreditoHipotecario(cliente, 100000, 120, garantia);
        gestor.evaluarSolicitud(solicitud);
        assertTrue(solicitud.esAceptada());
    }

    @Test
    void evaluarSolicitudHipotecario_rechazada_cuotaVsIngresos() {
        SolicitudCreditoRepositoryFake solicitudRepo = new SolicitudCreditoRepositoryFake();
        GestorSolicitudesCredito gestor = new GestorSolicitudesCredito(solicitudRepo);
        Cliente cliente = new Cliente("Test", "User", "Test Address", 50, 1000);
        Propiedad garantia = new Propiedad("Casa", "Address", 200000);
        SolicitudCreditoHipotecario solicitud = new SolicitudCreditoHipotecario(cliente, 500, 1, garantia); // Cuota 500, 50% de 1000 = 500
        gestor.evaluarSolicitud(solicitud);
        assertTrue(solicitud.esAceptada()); // Debería ser aceptada por cuota
        solicitud = new SolicitudCreditoHipotecario(cliente, 600, 1, garantia); // Cuota 600, 50% de 1000 = 500
        gestor.evaluarSolicitud(solicitud);
        assertFalse(solicitud.esAceptada());
    }

    @Test
    void evaluarSolicitudHipotecario_rechazada_montoVsValorFiscal() {
        SolicitudCreditoRepositoryFake solicitudRepo = new SolicitudCreditoRepositoryFake();
        GestorSolicitudesCredito gestor = new GestorSolicitudesCredito(solicitudRepo);
        Cliente cliente = new Cliente("Test", "User", "Test Address", 50, 4000);
        Propiedad garantia = new Propiedad("Casa", "Address", 100000);
        SolicitudCreditoHipotecario solicitud = new SolicitudCreditoHipotecario(cliente, 80000, 120, garantia); // 80000 > 70% de 100000 = 70000
        gestor.evaluarSolicitud(solicitud);
        assertFalse(solicitud.esAceptada());
    }

    @Test
    void evaluarSolicitudHipotecario_rechazada_edadMaxima() {
        SolicitudCreditoRepositoryFake solicitudRepo = new SolicitudCreditoRepositoryFake();
        GestorSolicitudesCredito gestor = new GestorSolicitudesCredito(solicitudRepo);
        Cliente cliente = new Cliente("Test", "User", "Test Address", 64, 4000);
        Propiedad garantia = new Propiedad("Casa", "Address", 200000);
        SolicitudCreditoHipotecario solicitud = new SolicitudCreditoHipotecario(cliente, 10000, 12, garantia); // Termina con 65
        gestor.evaluarSolicitud(solicitud);
        assertTrue(solicitud.esAceptada());
        solicitud = new SolicitudCreditoHipotecario(cliente, 10000, 24, garantia); // Termina con 66
        gestor.evaluarSolicitud(solicitud);
        assertFalse(solicitud.esAceptada());
    }

    @Test
    void calcularTotalDesembolso_gestor() {
        SolicitudCreditoRepositoryFake solicitudRepo = new SolicitudCreditoRepositoryFake();
        GestorSolicitudesCredito gestor = new GestorSolicitudesCredito(solicitudRepo);
        Cliente cliente1 = new Cliente("Cliente1", "Apellido1", "Dir", 30, 3000);
        Cliente cliente2 = new Cliente("Cliente2", "Apellido2", "Dir", 40, 4000);
        SolicitudCreditoPersonal solicitud1 = new SolicitudCreditoPersonal(cliente1, 10000, 12);
        solicitud1.setAceptada(true);
        SolicitudCreditoHipotecario solicitud2 = new SolicitudCreditoHipotecario(cliente2, 50000, 60, new Propiedad("Prop", "Addr", 100000));
        solicitud2.setAceptada(true);
        solicitudRepo.agregar(solicitud1);
        solicitudRepo.agregar(solicitud2);
        assertEquals(60000, gestor.calcularTotalDesembolso(), 0.001);
    }

    @Test
    void calcularTotalDesembolso_gestor_sinAceptadas() {
        SolicitudCreditoRepositoryFake solicitudRepo = new SolicitudCreditoRepositoryFake();
        GestorSolicitudesCredito gestor = new GestorSolicitudesCredito(solicitudRepo);
        assertEquals(0, gestor.calcularTotalDesembolso(), 0.001);
    }
}