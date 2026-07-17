package com.mycompany.sem04.collections;
import java.util.HashMap;
import java.util.Map;

public class Ex06 {
    public static void main (String[] srgs){
        Map<String, Integer> frutas = new HashMap<>();
        String[] palavras = {"maca", "banana", "cereja", "maca", "banana", "maca"};
        
        for(String p: palavras){
            Integer cont = frutas.getOrDefault(p, 0);
            frutas.put(p, cont + 1);
        }
        System.out.println(frutas);
    }
}
