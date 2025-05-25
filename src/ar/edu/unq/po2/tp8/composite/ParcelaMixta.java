package ar.edu.unq.po2.tp8.composite;

import java.util.ArrayList;
import java.util.List;

// --- 3. Compuesto (Composite): ParcelaMixta ---
//Representa una porción de tierra dividida en cuatro sub-regiones iguales.
public class ParcelaMixta implements Parcela {
 private List<Parcela> subParcelas; // Contiene otras Parcelas (hojas o compuestos)

 // Constructor: Inicializa una parcela mixta con 4 subdivisiones nulas.
 // Luego se deben asignar las sub-parcelas.
 public ParcelaMixta() {
     this.subParcelas = new ArrayList<>(4);
     // Inicializamos con nulls o con ParcelasCultivoSimple "vacías" si se prefiere un estado inicial definido
     // Para este problema, asumimos que se asignarán las 4 sub-parcelas después.
     for (int i = 0; i < 4; i++) {
         this.subParcelas.add(null); // Las subdivisiones se llenarán después
     }
 }

 // Método para establecer una sub-parcela en una de las 4 regiones
 // Index debe ser 0, 1, 2 o 3.
 public void setSubParcela(int index, Parcela parcela) {
     if (index < 0 || index >= 4) {
         throw new IndexOutOfBoundsException("La subdivisión debe estar entre 0 y 3.");
     }
     if (parcela == null) {
         throw new IllegalArgumentException("La sub-parcela no puede ser nula.");
     }
     this.subParcelas.set(index, parcela);
 }

 @Override
 public double calcularGananciaAnualSoja() {
     double totalGanancia = 0.0;
     for (Parcela subParcela : subParcelas) {
         if (subParcela != null) { // Asegurarse de que la sub-parcela no sea nula
             totalGanancia += subParcela.calcularGananciaAnualSoja() / 4.0; // Cada sub-parcela es 1/4 de la región
         }
     }
     return totalGanancia;
 }

 @Override
 public double calcularGananciaAnualTrigo() {
     double totalGanancia = 0.0;
     for (Parcela subParcela : subParcelas) {
         if (subParcela != null) {
             totalGanancia += subParcela.calcularGananciaAnualTrigo() / 4.0; // Cada sub-parcela es 1/4 de la región
         }
     }
     return totalGanancia;
 }

 // Opcional: Para representación en consola
 @Override
 public String toString() {
     StringBuilder sb = new StringBuilder("ParcelaMixta[\n");
     for (int i = 0; i < subParcelas.size(); i++) {
         sb.append("  Region ").append(i).append(": ");
         if (subParcelas.get(i) != null) {
             sb.append(subParcelas.get(i).toString().replace("\n", "\n  ")); // Indentación para hijos
         } else {
             sb.append("VACIO");
         }
         sb.append("\n");
     }
     sb.append("]");
     return sb.toString();
 }
}
