
package com.mycompany.sem04.collections;
import java.util.LinkedList;
import java.util.Queue;

public class Ex01 {
    public static void main(String[] args){
        Queue<String> fila = new LinkedList<>();
        
        fila.add("Cristian");
        fila.add("Rubens");
        fila.add("Oliveira");
        fila.add("Carmo");
        fila.add("Bastiao");
        
        while (!fila.isEmpty()) {
        String pessoa = fila.poll();
        String aguardando = fila.peek();
        
        System.out.println("Atendendo: " + pessoa);
        
        if (aguardando != null) {
            System.out.println("Aguardando: " + aguardando);
        } 
        else {
            System.out.println("Fila vazia: " + fila.isEmpty());
         }
       }
    }
}
