package ar.edu.unq.po2.tp6.solid.correo;

public class ConexionPop implements IConexion {
    private boolean conectado = false;

    @Override
    public void conectar(String nombreUsuario, String passusuario) {
        // Simulación de conexión a servidor POP
        System.out.println("Conectando a servidor POP para: " + nombreUsuario + "...");
        conectado = true;
        System.out.println("Conexión POP establecida.");
    }

    @Override
    public void desconectar() {
        if (conectado) {
            System.out.println("Desconectando de servidor POP.");
            conectado = false;
        } else {
            System.out.println("Ya estaba desconectado del servidor POP.");
        }
    }
}