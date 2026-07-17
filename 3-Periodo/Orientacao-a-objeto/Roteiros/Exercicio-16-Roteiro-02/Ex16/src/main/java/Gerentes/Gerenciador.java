
package Gerentes;

import Classes.Passageiro;
import Classes.Voo;
import java.util.ArrayList;
import java.util.List;

public class Gerenciador {
    private List<Voo> voos;
    private List<Passageiro> passageiros;
    private List<String> escalas;
    
    public Gerenciador(){
        this.voos = new ArrayList<>();
        this.passageiros = new ArrayList<>();
        this.escalas = new ArrayList<>();
    }
    
    public void adicionarVoos(Voo novoVoo){
        if(voos.contains(novoVoo)){
            System.out.println("Esse Voo já existe!");
        }else{
            voos.add(novoVoo);
        }
    }
    
    public void removerVoos(Voo voo){
        if(!voos.contains(voo)){
            System.out.println("Esse Voo não existe!");
        }else{
            voos.remove(voo);
        }
    }
    
    //metodo adicionar passageiros
    public void adicionarPassageiros(Passageiro passageiroNovo){
        if(passageiros.contains(passageiroNovo)){
            System.out.println("Passageiro ja existe");
        }
        else{
            passageiros.add(passageiroNovo);
        }
    }
    
    //metodo remover passageiros
    public void removerPassageiros(Passageiro CPF){
        if(!passageiros.contains(CPF)){
            System.out.println("Passageiro nao existe");
        }
        else{
            passageiros.remove(CPF);
        }
    }
    
    //metodo adicionar escalas
    public void adicionarEscalas(String escalaNova){
        if(escalas.contains(escalaNova)){
            System.out.println("Escala ja existe");
        }
        else{
            escalas.add(escalaNova);
        }
    }
    
    //metodo remover escalas
    public void removerEscalas(String escala){
        if(!escalas.contains(escala)){
            System.out.println("Escala nao existe");
        }
        else{
            escalas.remove(escala);
        }
    }
    
    //metodo verificar se o voo está abaixo da capacidade mínima.
    public void verificarCapacidade() {
        if (passageiros.size() < 5) {
            System.out.println("Voo abaixo da capacidade minima.");
        } 
        else {
            System.out.println("Voo acima da capacidade minima.");
        }
    }
    
    public void iniciarVoo(Voo numVoo){
        if(!voos.contains(numVoo)){
            System.out.println("Voo não encontrado!");
        }else if(numVoo.getEstadoDoVoo().equalsIgnoreCase("Voando")){
            System.out.println("O voo " + numVoo.getNumVoo() + "já está voando.");
            return;
        }else if(numVoo.getEstadoDoVoo().equalsIgnoreCase("Concluído")){
            System.out.println("O voo" + numVoo.getNumVoo() + "já foi concluído.");
            return;
        }
    
        numVoo.alterarEstado("Voando");
    }
}
