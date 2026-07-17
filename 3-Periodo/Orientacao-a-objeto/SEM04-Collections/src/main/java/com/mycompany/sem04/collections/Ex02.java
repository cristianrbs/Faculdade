package com.mycompany.sem04.collections;
import java.util.HashMap;
import java.util.Map;

public class Ex02 {
    public static void main(String[] args){
        Map<String, Double> produtos = new HashMap<>();
        
        produtos.put("Cereal", 15.00);
        produtos.put("Biscoito", 5.50);
        produtos.put("Margarina", 5.69);
        produtos.put("Esponja", 2.08);
        
        for(Map.Entry<String,Double>caixa: produtos.entrySet()){
            System.out.println("Produto: " + caixa.getKey() +
                               ", preco: " + caixa.getValue());
        }
        produtos.put("Biscoito", 6.00);
        
        if(produtos.containsKey("Cereal")){
            produtos.remove("Cereal");
        }
        else{
            System.out.println("Esse produto nao existe");
        }
        
        System.out.println("------------------------------");
        System.out.println("Apos alteracoes:");
        for (Map.Entry<String, Double> caixa : produtos.entrySet()){
            System.out.println("Produto: " + caixa.getKey() +
                               ", preco: " + caixa.getValue());
}
    }
}
