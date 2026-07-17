package com.mycompany.sem04.collections;
import java.util.HashMap;
import java.util.Map;

public class Ex08 {
    public static void main(String[] args){
        HashMap<Integer, String> map = new HashMap<>();
        HashMap<String, Integer> invercao = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        
        
        for(Map.Entry<Integer,String> m: map.entrySet()){
            invercao.put(m.getValue(), m.getKey());
        }
        System.out.println(invercao);
    }
}
