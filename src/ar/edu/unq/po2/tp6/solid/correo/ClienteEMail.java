package ar.edu.unq.po2.tp6.solid.correo;

import java.util.List;

public class ClienteEMail {
    private IConexion conexion;
    private IReceptorCorreo receptor;
    private IEmisorCorreo emisor;
    private IBandeja inbox;
    private IBandeja borrados;
    private String nombreUsuario;
    private String passusuario;

    public ClienteEMail(IConexion conexion, IReceptorCorreo receptor, IEmisorCorreo emisor, String nombreUsuario, String pass) {
        this.conexion = conexion;
        this.receptor = receptor;
        this.emisor = emisor;
        this.inbox = new BandejaEntrada();
        this.borrados = new Papelera();
        this.nombreUsuario = nombreUsuario;
        this.passusuario = pass;
        this.conectar();
    }

    public void conectar() {
        this.conexion.conectar(this.nombreUsuario, this.passusuario);
    }

    public void desconectar() {
        this.conexion.desconectar();
    }

    public void borrarCorreo(Correo correo) {
        this.inbox.eliminarCorreo(correo);
        this.borrados.agregarCorreo(correo);
    }

    public int contarBorrados() {
        return this.borrados.obtenerCantidad();
    }

    public int contarInbox() {
        return this.inbox.obtenerCantidad();
    }

    public void eliminarBorrado(Correo correo) {
        this.borrados.eliminarCorreo(correo);
    }

    public void recibirNuevos() {
        List<Correo> nuevosCorreos = this.receptor.recibirNuevos(this.nombreUsuario, this.passusuario);
        for (Correo correo : nuevosCorreos) {
            this.inbox.agregarCorreo(correo);
        }
    }

    public void enviarCorreo(String asunto, String destinatario, String cuerpo) {
        Correo correo = new Correo(asunto, destinatario, cuerpo);
        this.emisor.enviar(correo);
    }

    public static void main(String[] args) {
        IConexion conexion = new ConexionPop();
        IReceptorCorreo receptor = new ServidorPop();
        IEmisorCorreo emisor = new ServidorPop();
        ClienteEMail cliente = new ClienteEMail(conexion, receptor, emisor, "usuario@example.com", "contraseña");

        cliente.recibirNuevos();
        cliente.enviarCorreo("Prueba", "destinatario@example.com", "Este es un correo de prueba.");
        if (cliente.contarInbox() > 0) {
            List<Correo> inbox = cliente.inbox.obtenerCorreos();
            cliente.borrarCorreo(inbox.get(0));
        }
        System.out.println("Correos en la bandeja de entrada: " + cliente.contarInbox());
        System.out.println("Correos en la papelera: " + cliente.contarBorrados());
        if (cliente.contarBorrados() > 0) {
            List<Correo> borrados = cliente.borrados.obtenerCorreos();
            cliente.eliminarBorrado(borrados.get(0));
        }
        System.out.println("Correos en la papelera después de eliminar: " + cliente.contarBorrados());
        cliente.desconectar();
    }
}