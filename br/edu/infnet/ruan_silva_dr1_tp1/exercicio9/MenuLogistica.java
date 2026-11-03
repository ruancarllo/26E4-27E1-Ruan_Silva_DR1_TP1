package br.edu.infnet.ruan_silva_dr1_tp1.exercicio9;

import java.util.Scanner;

/*
Neste programa, usei IA generativa para entender como funciona o lançamento da exceção NumberFormatException pelo Integer.parseInt
e pelo Double.parseDouble durante o tratamento de entradas inválidas com Scanner, e para conferir os fatores numéricos das fórmulas
de conversão de temperatura (9/5 e 32) e de distância (0.621371). Também usei IA para revisão gramatical do relatório.
*/

public class MenuLogistica {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean executando = true;

        do {
            exibirMenu();
            String entradaOpcao = scanner.nextLine();

            int opcao;
            try {
                opcao = Integer.parseInt(entradaOpcao);
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Digite um número inteiro entre 1 e 5.");
                continue;
            }

            switch (opcao) {
                case 1:
                    executarConversaoTemperatura(scanner);
                    break;
                case 2:
                    executarConversaoDistancia(scanner);
                    break;
                case 3:
                    executarClassificacaoPedido(scanner);
                    break;
                case 4:
                    executarSobre();
                    break;
                case 5:
                    executando = false;
                    System.out.println("Encerrando o menu.");
                    break;
                default:
                    System.out.println("Opção inválida. Escolha entre 1 e 5.");
                    break;
            }
        } while (executando);
    }

    public static void exibirMenu() {
        System.out.println();
        System.out.println("Menu de logística:");
        System.out.println("1 - Converter temperatura");
        System.out.println("2 - Converter distância");
        System.out.println("3 - Classificar pedido");
        System.out.println("4 - Sobre");
        System.out.println("5 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static void executarConversaoTemperatura(Scanner scanner) {
        Double celsius = lerDoubleNaoNegativo(scanner, "Informe a temperatura em Celsius: ");
        if (celsius == null) {
            return;
        }
        System.out.println("Temperatura em Fahrenheit: " + celsiusParaFahrenheit(celsius));
    }

    public static void executarConversaoDistancia(Scanner scanner) {
        Double quilometros = lerDoubleNaoNegativo(scanner, "Informe a distância em quilômetros: ");
        if (quilometros == null) {
            return;
        }
        System.out.println("Distância em milhas: " + quilometrosParaMilhas(quilometros));
    }

    public static void executarClassificacaoPedido(Scanner scanner) {
        Double peso = lerDoubleNaoNegativo(scanner, "Informe o peso do pedido em kg: ");
        if (peso == null) {
            return;
        }
        System.out.println("Pedido de " + peso + " kg classificado como: " + classificarPedido(peso));
    }

    public static void executarSobre() {
        System.out.println("Versão do Java em uso: " + System.getProperty("java.version"));
        System.out.println("Este programa funciona sem alterações em Windows, Linux ou macOS porque o javac gera bytecode, que é portátil, e a JVM de cada sistema operacional, com seu compilador JIT, traduz esse bytecode para o código de máquina nativo em tempo de execução.");
    }

    public static Double lerDoubleNaoNegativo(Scanner scanner, String mensagem) {
        System.out.print(mensagem);
        String entrada = scanner.nextLine();

        double valor;
        try {
            valor = Double.parseDouble(entrada);
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Informe um número decimal.");
            return null;
        }

        if (valor < 0) {
            System.out.println("Entrada inválida. Informe um número não negativo.");
            return null;
        }

        return valor;
    }

    public static double celsiusParaFahrenheit(double celsius) {
        return celsius * 9.0 / 5.0 + 32.0;
    }

    public static double quilometrosParaMilhas(double quilometros) {
        return quilometros * 0.621371;
    }

    public static String classificarPedido(double peso) {
        /*
        Limites escolhidos:
            - até 10 kg = leve (documentos, encomendas pequenas, itens de e-commerce)
            - de 10.01 a 50 kg = padrão (eletrônicos, móveis pequenos, caixas médias)
            - acima de 50 kg = urgente (cargas volumosas ou pesadas, com despacho prioritário)
        */
        final double limiteLeve = 10.0;
        final double limitePadrao = 50.0;

        if (peso <= limiteLeve) {
            return "leve";
        }

        if (peso <= limitePadrao) {
            return "padrão";
        }

        return "urgente";
    }
}
