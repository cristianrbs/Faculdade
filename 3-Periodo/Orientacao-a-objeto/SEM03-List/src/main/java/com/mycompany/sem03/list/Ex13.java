package com.mycompany.sem03.list;
import java.util.Scanner;
import classes.Filme;
import java.util.ArrayList;
import java.util.List;

public class Ex13 {
   public static int imprimeMenu(){
       Scanner ler = new Scanner(System.in);
       
       System.out.print("------------------------------");
       System.out.print("O que deseja fazer");
       System.out.print("------------------------------");
       System.out.print("1 - Adicionar Filme");
       System.out.print("2 - Remover Filme");
       System.out.print("3 - Pesquisar Filme pelo titulo");
       System.out.print("4 - Pesquisar Filme pelo diretor");
       System.out.print("------------------------------");
       System.out.print("Escolha uma opcao:");
       return ler.nextInt();
   }
   
   public static void main(String[] args){
       List<Filme> listaFilme;
       listaFilme = new ArrayList<Filme>();
       Scanner ler = new Scanner(System.in);
      int opcao = 0;

      do{
         opcao = imprimeMenu();
         if(opcao == 1){
            Filme f1 = new Filme();
             f1.preencher();
                listaFilme.add(f1);
            } 
         else if (opcao == 2) {
                System.out.print("Informe o titulo do Filme que deseja remover:");
                String title = ler.nextLine();

                for (Filme f1 : listaFilme) {
                    if (title.equals(f1.getTitulo())) {
                        System.out.println("Filme encontrado");
                        listaFilme.remove(f1);
                    }
                }                
            } else if (opcao == 3) {
                System.out.print("Informe o titulo:");
                String title = ler.nextLine();

                for (Filme f1 : listaFilme) { 
                    if (title.equals(f1.getTitulo())) {
                        System.out.println("Filme encontrado");
                        f1.toString();
                    }
                }                
            } else if (opcao == 4) {              
                System.out.println("Informe o diretor:");
                String diretor = ler.nextLine();

                for (Filme f1 : listaFilme) {
                    if (diretor.equals(f1.getDiretor())) {
                        System.out.println("Diretor encontrado");
                        f1.toString();
                    }
                }
            }
        } while (opcao != 0);
    }
}