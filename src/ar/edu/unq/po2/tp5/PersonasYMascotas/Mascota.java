package ar.edu.unq.po2.tp5.PersonasYMascotas;

public class Mascota implements Nombrable {
    private String nombre;
    private String raza;

    public Mascota(String nombre, String raza) {
        this.nombre = nombre;
        this.raza = raza;
    }

    @Override
    public String getName() {
        return nombre;
    }

    public String getRaza() {
        return raza;
    }
}
