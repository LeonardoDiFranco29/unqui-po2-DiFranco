package ar.edu.unq.po2.tp3;

public class Expresiones {
	 
		public static void main(String[] args) {
	        String a = "abc";
	        String s = a;
	        String t = null;

	        // 1. s.length();
	        // Resultado: 3
	        // Explicación: 's' contiene "abc", que tiene 3 caracteres.
	        System.out.println(s.length());

	        // 2. t.length();
	        // Resultado: NullPointerException
	        // Explicación: 't' no fue inicializado, es null. Llama a un método sobre null -> error.
	        // System.out.println(t.length()); // <- Esto tira error si lo descomentás

	        // 3. 1 + a;
	        // Resultado: "1abc"
	        // Explicación: Se concatena el número con el string.
	        System.out.println(1 + a);

	        // 4. a.toUpperCase();
	        // Resultado: "ABC"
	        // Explicación: Convierte "abc" en mayúsculas.
	        System.out.println(a.toUpperCase());

	        // 5. "Libertad".indexOf("r");
	        // Resultado: 4
	        // Explicación: La letra "r" está en el índice 4 (empieza en 0).
	        System.out.println("Libertad".indexOf("r"));

	        // 6. "Universidad".lastIndexOf('i');
	        // Resultado: 9
	        // Explicación: Última aparición de 'i' está en el índice 9.
	        System.out.println("Universidad".lastIndexOf('i'));

	        // 7. "Quilmes".substring(2,4);
	        // Resultado: "il"
	        // Explicación: Extrae caracteres desde índice 2 hasta antes del 4.
	        System.out.println("Quilmes".substring(2, 4));

	        // 8. (a.length() + a).startsWith("a");
	        // Resultado: false
	        // Explicación: a.length() es 3, se concatena con "abc" => "3abc", no empieza con "a".
	        System.out.println((a.length() + a).startsWith("a"));

	        // 9. s == a;
	        // Resultado: true
	        // Explicación: 's' y 'a' apuntan al mismo objeto en memoria.
	        System.out.println(s == a);

	        // 10. a.substring(1,3).equals("bc")
	        // Resultado: true
	        // Explicación: Extrae "bc" de "abc" y lo compara con "bc", son iguales.
	        System.out.println(a.substring(1, 3).equals("bc"));
	    }
	}