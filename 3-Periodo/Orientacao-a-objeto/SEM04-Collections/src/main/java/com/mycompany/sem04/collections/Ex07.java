package com.mycompany.sem04.collections;
import java.util.HashMap;
import java.util.Map;

public class Ex07 {
    public static void main(String[] args){
        Map<Character, Integer> palavra = new HashMap<>();
        String texto = "hello world";
        
        for(char t: texto.toCharArray()){
            Integer cont = palavra.getOrDefault(t, 0);
            palavra.put(t, cont + 1);
        }
        System.out.println(palavra);
    }
}
