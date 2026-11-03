package br.edu.infnet.ruan_silva_dr1_tp1.exercicio4;

public class ExemploOperadores {
    public static void main(String[] args) {
        int quantidadeCaixas = 24;
        double pesoPorCaixa = 12.5;
        double pesoTotal = quantidadeCaixas * pesoPorCaixa;
        boolean cargaPesada = pesoTotal > 250.0;

        System.out.println("Peso total: " + pesoTotal + " kg");
        System.out.println("Carga pesada: " + cargaPesada);
    }
}
