package main;

import Classes.Produto;
import Classes.Pedido;

public class Main {
    public static void main(String[] args) {

        
        Produto p1 = new Produto("Notebook", "Eletronicos", 3500.00);

        
        Pedido pedido1 = new Pedido("1", "09/04/2026", 2, p1);

        System.out.println("------------------------------");
        System.out.println("Pedido 1");
        System.out.println(pedido1);
        System.out.println("Total: R$ " + pedido1.calcularTotal());

        
        Pedido pedido2 = new Pedido(pedido1);
        pedido2.setNumero("2");
        pedido2.setQuantidade(5);

        System.out.println("------------------------------");
        System.out.println("Pedido 2");
        System.out.println(pedido2);
        System.out.println("Total: R$ " + pedido2.calcularTotal());

        
        Pedido pedido3 = new Pedido();
        pedido3.copiar(pedido1);
        pedido3.setNumero("3");

        System.out.println("------------------------------");
        System.out.println("Pedido 3");
        System.out.println(pedido3);
        System.out.println("Total: R$ " + pedido3.calcularTotal());
    }
}