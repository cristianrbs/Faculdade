package com.mycompany.sem02.classes.basicas;
import Classes.Ativo;


public class Ex11 {
    public static void main(String[] args) {

        Ativo a1 = new Ativo("Apple Inc.",  121.99, 255,  1.87);
        Ativo a2 = new Ativo("Tesla Inc.",  242.50, 100, -0.54);
        Ativo a3 = new Ativo("Amazon",       98.75, 400,  3.12);

        System.out.println("=== Resumo da Carteira ===");
        a1.exibirResumo();
        a2.exibirResumo();
        a3.exibirResumo();

        // ── Somatório da carteira ─────────────────────────────────────────────────
        Ativo[] carteira = { a1, a2, a3 };
        double totalCarteira = 0;

        for (Ativo a : carteira) {
            totalCarteira += a.calcularPosicaoDoAtivo();
        }

        System.out.println("---------------------------------------------------------");
        System.out.printf("Valor total da carteira: R$ %,.2f%n", totalCarteira);
    }
}
