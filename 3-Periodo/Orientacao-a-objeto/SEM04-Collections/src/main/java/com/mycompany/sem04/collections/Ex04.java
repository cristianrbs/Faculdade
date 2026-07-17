package com.mycompany.sem04.collections;
import java.util.HashSet;
import java.util.Set;
        
public class Ex04 {
    public static void main(String[] args){
        Set<String> lista = new HashSet<>();
        lista.add("Ana");
        lista.add("Bruno");
        lista.add("Ana");
        lista.add("Carlos");
        lista.add("Bruno");
        lista.add("Diana");
        
        for(String l: lista){
            System.out.println(l);
        }
        System.out.println("-----------------------");
        System.out.println("Total de alunos: " + lista.size());
        
        boolean existe = lista.contains("Carlos");
        if(existe == true){
            System.out.println("-----------------------");
            System.out.println("Carlos esta na lista de chamadas");
        }
        else{
            System.out.println("Nao esta na lista de chamadas");
        }
    }
     
}
