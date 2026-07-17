package com.mycompany.roteiro02;
import Classes.Quadrado;
import classes.Ponto;
import classes.Triangulo;

public class Main {
    public static void main(String[] args) {
        
        Ponto pA = new Ponto(1, 2);
       
        Ponto pB = new Ponto(3, 2);
        
        Ponto pC = new Ponto(1, 1);
        
        
        Triangulo T1 = new Triangulo(pA, pB, pC);
        
        T1.imprimir();
        
        System.out.println("A distância do Ponto A e B: " + pA.distanciaDoisPontos(pB));
        System.out.println("A distância do Ponto A e C: " + pA.distanciaDoisPontos(pC));
        System.out.println("A distância do Ponto B e C: " + pB.distanciaDoisPontos(pC));
        
        System.out.println("A área do triângulo é: " + T1.area(pB, pC));
        System.out.println("O Tipo do Triângulo é: " + T1.tipo());
        System.out.println("O Perímetro do Triângulo é: " + T1.perimetro());

        Quadrado quadrado = new Quadrado();
        quadrado.fill();

        System.out.println("------------------------------");
        System.out.println("Informacoes do Quadrado");
        System.out.println("------------------------------");
        quadrado.imprimir();
        System.out.println("Area: " + quadrado.area());
        System.out.println("Perimetro: " + quadrado.perimetro());
        System.out.println("Eh um quadrado? " + quadrado.isQuadrado());
    }
}
