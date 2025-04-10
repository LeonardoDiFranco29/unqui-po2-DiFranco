package ar.edu.unq.po2.tp3;

public class NumeroConMasPares {

    // Función principal que recibe un arreglo y devuelve el número con más dígitos pares
    public static int numeroConMasDigitosPares(int[] numeros) {
        int maxCantidadPares = -1;
        int numeroResultado = 0;

        for (int numero : numeros) {
            int cantidadPares = contarDigitosPares(numero);
            if (cantidadPares > maxCantidadPares) {
                maxCantidadPares = cantidadPares;
                numeroResultado = numero;
            }
        }

        return numeroResultado;
    }

    // Función auxiliar que cuenta los dígitos pares de un número
    private static int contarDigitosPares(int numero) {
        int cantidad = 0;
        numero = Math.abs(numero);  // en caso de que venga negativo

        while (numero > 0) {
            int digito = numero % 10;  // último dígito
            if (digito % 2 == 0) {
                cantidad++;
            }
            numero = numero / 10;  // eliminás el último dígito
        }

        return cantidad;
    }
}
