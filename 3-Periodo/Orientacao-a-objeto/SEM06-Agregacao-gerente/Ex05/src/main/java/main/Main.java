package main;

import Classes.Carro;
import Classes.Proprietario;
import Classes.Roda;

public class Main {

    public static void main(String[] args) {

        Roda roda1 = new Roda(17.0, "Liga leve", "Prata");
        Roda roda2 = new Roda(15.0, "Aço", "Preto");


        Carro c1 = new Carro("Toyota", "Corolla", "Branco");
        c1.adicionarRoda(roda1);

        Carro c2 = new Carro("Honda", "Civic", "Prata");
        c2.adicionarRoda(roda2);


        Proprietario p1 = new Proprietario("Carlos", "111.111.111-11", "carlos@email.com");
        p1.adicionarCarro(c1);
        p1.adicionarCarro(c2);


        Carro c3 = new Carro("Toyota", "Hilux", "Preto");
        c3.adicionarRoda(roda1);

        Carro c4 = new Carro("Volkswagen", "Golf", "Azul");
        c4.adicionarRoda(roda2);


        Proprietario p2 = new Proprietario("Ana", "222.222.222-22", "ana@email.com");
        p2.adicionarCarro(c3);
        p2.adicionarCarro(c4);


        System.out.println(p1);
        System.out.println(p2);

        System.out.println("------------------------------");
        System.out.println("Fabricantes em comum");
        
        for (Carro c : p1.getCarros()) {
            if (p2.possuiCarroDeFabricante(c.getFabricante())) {
                System.out.println(p1.getNome() + " e " + p2.getNome() +
                        " possuem carros do mesmo fabricante: " + c.getFabricante()); 
            }
        }
    }
}