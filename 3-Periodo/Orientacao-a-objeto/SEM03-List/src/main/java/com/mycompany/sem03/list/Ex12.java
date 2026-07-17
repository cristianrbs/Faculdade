package com.mycompany.sem03.list;
import java.util.Scanner;
import Classes.Musica;
import java.util.ArrayList;
import java.util.List;

public class Ex12 {
   public static int imprimeMenu(){
       Scanner ler = new Scanner(System.in);
       
       System.out.print("------------------------------");
       System.out.print("O que deseja fazer");
       System.out.print("------------------------------");
       System.out.print("1 - Adicionar Musica");
       System.out.print("2 - Remover Musica");
       System.out.print("3 - Pesquisar Muisica pelo titulo");
       System.out.print("4 - Pesquisar Muisica pelo artista");
       System.out.print("------------------------------");
       System.out.print("Escolha uma opcao:");
       return ler.nextInt();
   }
   
   public static void main(String[] args){
       List<Musica> listaMusica;
       listaMusica = new ArrayList<Musica>();
       Scanner ler = new Scanner(System.in);
       int opcao = 0;

      do{
         opcao = imprimeMenu();
         if(opcao == 1){
            Musica m1 = new Musica();
             m1.preencher();
                listaMusica.add(m1);
            } 
         else if (opcao == 2) {
                System.out.print("Informe o titulo da Musica que deseja remover:");
                String title = ler.nextLine();

                for (Musica m1 : listaMusica) {
                    if (title.equals(m1.getTitulo())) {
                        System.out.println("Musica encontrada");
                        listaMusica.remove(m1);
                    }
                }                
            } else if (opcao == 3) {
                System.out.print("Informe o titulo:");
                String title = ler.nextLine();

                for (Musica m1 : listaMusica) { 
                    if (title.equals(m1.getTitulo())) {
                        System.out.println("Musica encontrada");
                        m1.toString();
                    }
                }                
            } else if (opcao == 4) {              
                System.out.println("Informe o astista:");
                String artista = ler.nextLine();

                for (Musica m1 : listaMusica) {
                    if (artista.equals(m1.getArtista())) {
                        System.out.println("Artista encontrado");
                        m1.toString();
                    }
                }
            }
        } while (opcao != 0);
    }
}
         
      
   

