package ar.edu.unq.po2.tp3;

import java.util.ArrayList;

public class Counter {
    private ArrayList<Integer> numeros = new ArrayList<>();

    public void agregarNumero(int numero) {
        numeros.add(numero);
    }

    public int contarPares() {
        int cantidad = 0;
        for (int numero : numeros) {
            if (numero % 2 == 0) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public int contarImpares() {
        int cantidad = 0;
        for (int numero : numeros) {
            if (numero % 2 != 0) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public int contarMultiplosDe(int valor) {
        int cantidad = 0;
        for (int numero : numeros) {
            if (numero % valor == 0) {
                cantidad++;
            }
        }
        return cantidad;
    }
}