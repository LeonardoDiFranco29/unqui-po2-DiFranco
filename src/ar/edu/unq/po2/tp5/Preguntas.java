package ar.edu.unq.po2.tp5;

public class Preguntas {
		/*
		 * 1. ¿Qué ventajas, en cuanto a polimorfismo, brindan las interfaces en Java?
Las interfaces permiten definir un contrato que múltiples clases pueden implementar, lo que favorece el polimorfismo. Esto significa que se puede trabajar con objetos de distintas clases a través de una misma referencia de tipo interfaz, facilitando la extensión y reutilización del código.

2. ¿Por qué no siempre puedo utilizar clases abstractas para agrupar clases polimórficas?
Porque Java no permite herencia múltiple de clases, pero sí permite que una clase implemente múltiples interfaces. Si se usaran solo clases abstractas, esto limitaría la flexibilidad. Además, las interfaces permiten una mayor separación entre definición y comportamiento.

3. ¿Qué ventajas tienen las clases abstractas sobre las interfaces?
Pueden tener atributos y constructores.

Permiten definir métodos con implementación parcial.

Son útiles cuando varias clases comparten comportamientos comunes, no solo una firma.

4. ¿Se puede instanciar una interfaz?
No. Las interfaces no se pueden instanciar directamente, ya que solo definen métodos sin implementación. Para usarlas, se debe crear una clase que las implemente.

5. ¿Por qué no es recomendable incrementar o modificar las firmas definidas en un interface?
Porque rompería el contrato que establece la interfaz. Esto podría generar errores en todas las clases que ya la implementan, afectando la compatibilidad hacia atrás y violando el principio de sustitución de Liskov.

6. ¿Por qué, en lenguajes como Smalltalk, no es necesaria la implementación de interfaces?
Porque Smalltalk utiliza tipado dinámico y polimorfismo por duck typing: si un objeto tiene un método llamado mover(), no importa de qué clase sea. En cambio, Java usa tipado estático, por eso necesita interfaces que aseguren que una clase implementa ciertos métodos.
		 * */
}
