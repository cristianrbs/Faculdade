package com.mycompany.sem02.classes.basicas;
import Classes.Casa;

public class Ex10 {
    public static void main(String[] args) {

        Casa c1 = new Casa("Rua das Flores, 123", 200.0, 3,  950_000.0);
        Casa c2 = new Casa("Av. Paulista, 456",   120.0, 2,  780_000.0);
        Casa c3 = new Casa("Rua do Lago, 78",     350.0, 4, 1_400_000.0);

        System.out.println("=== Comparativo de Imóveis ===");
        c1.exibirResumo();
        c2.exibirResumo();
        c3.exibirResumo();

        Casa[] casas = { c1, c2, c3 };
        Casa melhor = casas[0];

        for (Casa c : casas) {
            if (c.calcularPrecoPorM2() < melhor.calcularPrecoPorM2()) {
                melhor = c;
            }
        }

        System.out.println("---------------------------------------------------------");
        System.out.printf("Melhor custo por m²: %s — R$ %,.2f/m²%n", melhor.getEndereco(), melhor.calcularPrecoPorM2());
    }
}
