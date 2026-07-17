package com.mycompany.sem04.collections;
import java.util.HashMap;
import java.util.Map;

public class Ex05 {
    public static void main(String[] args){
        Map<String, Integer> jogadores = new HashMap<>();
        
        jogadores.put("Kevin De Bruyne", 17);
        jogadores.put("Haaland", 9);
        jogadores.put("Mohamed Salah", 11);
        
        jogadores.put("Kevin De Bruyne", jogadores.get("Kevin De Bruyne") + 10);
        
        int maiorPontuacao = 0;
        String jogador = "";
        for(Map.Entry<String,Integer> m: jogadores.entrySet()){
            if(m.getValue() > maiorPontuacao){
                maiorPontuacao = m.getValue();
                jogador = m.getKey();
            }
        }
        System.out.println("Jogador com a maior pontuacao: " + jogador + ", " + maiorPontuacao + " pontos");
    }
}
