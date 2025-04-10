package ar.edu.unq.po2.tp3;

public class TiposPrimitivos {

    // 1. ¿Qué son los tipos de datos primitivos?
    // Los tipos de datos primitivos en Java son los tipos más básicos de datos,
    // predefinidos por el lenguaje. No son objetos y se usan para almacenar valores simples.
    // Son: byte, short, int, long, float, double, char, y boolean.

    // 2. ¿Cuál es la diferencia entre un int y un Integer?
    // int es un tipo primitivo, mientras que Integer es una clase envoltorio (wrapper class).
    // Integer permite trabajar con valores int como objetos.
    // Esto es útil cuando necesitamos almacenar un valor en estructuras de datos que requieren objetos
    // (como ArrayList) o usar métodos que solo funcionan con objetos.

    // 3. Si se define una variable de instancia de tipo int, ¿cuál sería su valor predeterminado?
    // ¿Y si se define una de tipo Integer?
    // Las variables de instancia (es decir, atributos de clase) tienen valores por defecto:
    // - int -> 0
    // - Integer -> null
    // Esto se puede verificar ejecutando el siguiente código:

    int valorInt;          // valor predeterminado: 0
    Integer valorInteger;  // valor predeterminado: null

    // Método para imprimir los valores por defecto
    public void mostrarValoresDeInstancia() {
        System.out.println("Valor int (instancia): " + valorInt);
        System.out.println("Valor Integer (instancia): " + valorInteger);
    }

    public void mostrarValoresLocales() {
        // 4. ¿Qué pasa si las variables son locales (definidas en un método)?
        // En este caso, Java NO asigna valores por defecto.
        // Debemos inicializarlas antes de usarlas, o se producirá un error de compilación.
        
        // int localInt;           // Error si se usa sin inicializar
        // Integer localInteger;   // Error si se usa sin inicializar

        // Para evitar el error:
        int localInt = 0;
        Integer localInteger = null;

        System.out.println("Valor int (local): " + localInt);
        System.out.println("Valor Integer (local): " + localInteger);
    }

    public static void main(String[] args) {
        TiposPrimitivos tp = new TiposPrimitivos();
        tp.mostrarValoresDeInstancia();
        tp.mostrarValoresLocales();
    }
}

