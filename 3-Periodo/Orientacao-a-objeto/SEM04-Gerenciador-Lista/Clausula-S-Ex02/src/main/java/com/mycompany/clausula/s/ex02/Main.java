package com.mycompany.clausula.s.ex02;

import Classes.Livro;


public class Main {
    public static void main(String[] args){
        Livro l1 = new Livro("Clean Code", "Robert C. Martin", 431);
        Livro l2 = new Livro("The Pragmatic Programmer", "Andrew Hunt", 352);
        Livro l3 = new Livro("Structure and Interpretation of Computer Programs", "Harold Abelson", 657);
    
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(l3);
        System.out.println("------------------------------");
        Livro.NomeDaBiblioteca = "IFSMG";
        
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(l3);
    }
    
}
