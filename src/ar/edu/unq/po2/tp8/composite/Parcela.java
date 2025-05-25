package ar.edu.unq.po2.tp8.composite;

//--- 1. Componente (Interfaz Parcelas) ---
//Define la interfaz común para hojas (cultivos simples) y compuestos (parcelas mixtas).
public interface Parcela {
    double calcularGananciaAnualSoja();
    double calcularGananciaAnualTrigo();
}