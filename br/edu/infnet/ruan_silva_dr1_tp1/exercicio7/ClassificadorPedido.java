package br.edu.infnet.ruan_silva_dr1_tp1.exercicio7;

import java.util.Scanner;

public class ClassificadorPedido {
    public static void main(String[] args) {
        /*
        Limites escolhidos:
            - até 10 kg = leve (documentos, encomendas pequenas, itens de e-commerce)
            - de 10.01 a 50 kg = padrão (eletrônicos, móveis pequenos, caixas médias)
            - acima de 50 kg = urgente (cargas volumosas ou pesadas, com despacho prioritário)
        */
        final double valorSentinela = -1.0;
        int contadorLeve = 0;
        int contadorPadrao = 0;
        int contadorUrgente = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Informe o peso do pedido (-1 para encerrar): ");
            String entradaPeso = scanner.nextLine();

            double peso;
            try {
                peso = Double.parseDouble(entradaPeso);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Informe um número decimal para o peso.");
                continue;
            }

            if (peso == valorSentinela) {
                break;
            }

            if (peso < 0) {
                System.out.println("Erro: o peso do pedido não pode ser negativo (use -1 para encerrar).");
                continue;
            }

            if (peso <= 10.0) {
                System.out.println("Pedido de " + peso + " kg classificado como: leve");
                contadorLeve++;
            } else if (peso <= 50.0) {
                System.out.println("Pedido de " + peso + " kg classificado como: padrão");
                contadorPadrao++;
            } else {
                System.out.println("Pedido de " + peso + " kg classificado como: urgente");
                contadorUrgente++;
            }
        }

        int totalPedidos = contadorLeve + contadorPadrao + contadorUrgente;

        System.out.println();
        System.out.println("Leve: " + contadorLeve);
        System.out.println("Padrão: " + contadorPadrao);
        System.out.println("Urgente: " + contadorUrgente);
        System.out.println("Total de pedidos: " + totalPedidos);
    }
}
