package ar.edu.unq.po2.tp6.solid.correo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ServidorPop implements IReceptorCorreo, IEmisorCorreo {
    private Random random = new Random();

    @Override
    public List<Correo> recibirNuevos(String user, String pass) {
        // Simulación de recepción de correos
        System.out.println("Verificando nuevos correos para: " + user + "...");
        List<Correo> nuevosCorreos = new ArrayList<>();
        int cantidadNuevos = random.nextInt(3); // Simula la llegada de 0 a 2 correos
        for (int i = 0; i < cantidadNuevos; i++) {
            nuevosCorreos.add(new Correo("Nuevo Correo " + (i + 1), user, "Cuerpo del nuevo correo " + (i + 1)));
        }
        System.out.println("Recibidos " + cantidadNuevos + " nuevos correos.");
        return nuevosCorreos;
    }

    @Override
    public void enviar(Correo correo) {
        // Simulacion de envío de correo
        System.out.println("Enviando correo a: " + correo.getDestinatario() + " con asunto: " + correo.getAsunto());
        // Aquí iría la lógica real de envío
        System.out.println("Correo enviado.");
    }
}