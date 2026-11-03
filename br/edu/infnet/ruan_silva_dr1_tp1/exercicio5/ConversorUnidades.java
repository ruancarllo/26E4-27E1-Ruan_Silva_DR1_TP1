package br.edu.infnet.ruan_silva_dr1_tp1.exercicio5;

public class ConversorUnidades {
    public static void main(String[] args) {
        double temperaturaCelsius = 30.0;
        int distanciaQuilometros = 120;
        double referenciaTemperatura = 100.0;

        double temperaturaFahrenheit = temperaturaCelsius * 9.0 / 5.0 + 32.0;
        double distanciaMilhas = distanciaQuilometros * 0.621371;

        System.out.println("Temperatura em Fahrenheit: " + temperaturaFahrenheit);
        System.out.println("Distância em milhas: " + distanciaMilhas);

        if (temperaturaFahrenheit > referenciaTemperatura) {
            System.out.println("A temperatura convertida é maior que a referência.");
        } else if (temperaturaFahrenheit < referenciaTemperatura) {
            System.out.println("A temperatura convertida é menor que a referência.");
        } else {
            System.out.println("A temperatura convertida é igual à referência.");
        }
    }
}
