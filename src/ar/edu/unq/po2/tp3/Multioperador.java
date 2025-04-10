package ar.edu.unq.po2.tp3;

import java.util.ArrayList;

public class Multioperador {

    // Método para sumar todos los elementos
    public int sumar(ArrayList<Integer> numeros) {
        int suma = 0;
        for (int num : numeros) {
            suma += num;
        }
        return suma;
    }

    // Método para restar todos los elementos (de izquierda a derecha)
    public int restar(ArrayList<Integer> numeros) {
        if (numeros.isEmpty()) return 0;

        int resultado = numeros.get(0);
        for (int i = 1; i < numeros.size(); i++) {
            resultado -= numeros.get(i);
        }
        return resultado;
    }

    // Método para multiplicar todos los elementos
    public int multiplicar(ArrayList<Integer> numeros) {
        if (numeros.isEmpty()) return 0;

        int producto = 1;
        for (int num : numeros) {
            producto *= num;
        }
        return producto;
    }
}
