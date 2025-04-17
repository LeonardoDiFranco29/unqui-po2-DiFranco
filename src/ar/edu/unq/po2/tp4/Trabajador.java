package ar.edu.unq.po2.tp4;

import java.util.List;

public class Trabajador {
    private List<Ingreso> ingresos;

    public Trabajador(List<Ingreso> ingresos) {
        this.ingresos = ingresos;
    }
    
    
    public double getTotalPercibido() {
        double total = 0;
        for (Ingreso ingreso : ingresos) {
            total += ingreso.getMontoPercibido();
        }
        return total;
    }

    public double getMontoImponible() {
        double total = 0;
        for (Ingreso ingreso : ingresos) {
            total += ingreso.getMontoImponible();
        }
        return total;
    }

    /*public double getTotalPercibido() {
        return ingresos.stream()
                       .mapToDouble(Ingreso::getMontoPercibido)
                       .sum();
    }

    public double getMontoImponible() {
        return ingresos.stream()
                       .mapToDouble(Ingreso::getMontoImponible)
                       .sum();
    }
*/
    public double getImpuestoAPagar() {
        return getMontoImponible() * 0.02;
    }
}