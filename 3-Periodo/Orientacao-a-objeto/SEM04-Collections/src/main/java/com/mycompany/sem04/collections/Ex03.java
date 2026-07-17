package com.mycompany.sem04.collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;


public class Ex03 {
    public static void main(String[] args){
        Stack<String> paginas = new Stack<>();
        Set<String> historico = new HashSet<>();
        
        System.out.println("-----------------------");
        System.out.println("Historico de navegacao");
        System.out.println("-----------------------");
        paginas.push("Sigaa.com");
        paginas.push("Notion.com");
        paginas.push("You Tube.com");
        paginas.push("GitHub.com");
        System.out.println("-----------------------");
        
        System.out.println("Voltar");
        System.out.println("-----------------------");
        
        while(!paginas.isEmpty()){
            String navegacao = paginas.pop();
            historico.add(navegacao);
        }
        System.out.println("Sites visitados:" + historico);
    }
}
