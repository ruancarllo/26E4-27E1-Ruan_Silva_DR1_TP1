package br.edu.infnet.ruan_silva_dr1_tp1.exercicio1;

public class InfoAmbiente {
    public static void main(String[] args) {
        System.out.println("Nome do sistema atual: " + System.getProperty("os.name"));
        System.out.println("Versão do Java: " + System.getProperty("java.version"));
        System.out.println("Diretório de trabalho atual: " + System.getProperty("user.dir"));
    }
}
