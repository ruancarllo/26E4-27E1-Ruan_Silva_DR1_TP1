package br.edu.infnet.ruan_silva_dr1_tp1.exercicio6;

import java.util.Scanner;

public class ClassificadorPedido {
    public static void main(String[] args) {
        /*
        Limites escolhidos:
            - até 10 kg = leve (documentos, encomendas pequenas, itens de e-commerce)
            - de 10.01 a 50 kg = padrão (eletrônicos, móveis pequenos, caixas médias)
            - acima de 50 kg = urgente (cargas volumosas ou pesadas, com despacho prioritário)
        */
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o peso do pedido em kg: ");
        String entradaPeso = scanner.nextLine();

        double peso;
        try {
            peso = Double.parseDouble(entradaPeso);
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Informe um número decimal para o peso.");
            return;
        }

        if (peso < 0) {
            System.out.println("Erro: o peso do pedido não pode ser negativo.");
            return;
        }

        if (peso <= 10.0) {
            System.out.println("Pedido de " + peso + " kg classificado como: leve");
        } else if (peso <= 50.0) {
            System.out.println("Pedido de " + peso + " kg classificado como: padrão");
        } else {
            System.out.println("Pedido de " + peso + " kg classificado como: urgente");
        }
    }
}
