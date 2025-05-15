package ar.edu.unq.po2.tp6.solid.correo;



public interface IConexion {
    void conectar(String nombreUsuario, String passusuario);
    void desconectar();
}