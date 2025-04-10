package ar.edu.unq.po2.tp3;

import java.util.ArrayList;

public class Counter {

    // Atributo: lista de números
    private ArrayList<Integer> numeros = new ArrayList<>();

    // Método para agregar un número a la lista
    public void addNumber(int numero) {
        numeros.add(numero);
    }

    // Método que cuenta cuántos números pares hay
    public int getEvenOcurrences() {
        int cantidad = 0;
        for (int numero : numeros) {
            if (numero % 2 == 0) {
                cantidad++;
            }
        }
        return cantidad;
    }

    // Método que cuenta cuántos números impares hay
    public int getOddOcurrences() {
        int cantidad = 0;
        for (int numero : numeros) {
            if (numero % 2 != 0) {
                cantidad++;
            }
        }
        return cantidad;
    }

    // Método que cuenta cuántos números son múltiplos de un valor dado
    public int getMultiplesOf(int valor) {
        int cantidad = 0;
        for (int numero : numeros) {
            if (numero % valor == 0) {
                cantidad++;
            }
        }
        return cantidad;
    }
}