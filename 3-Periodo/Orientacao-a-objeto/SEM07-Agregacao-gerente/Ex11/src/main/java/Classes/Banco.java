
package Classes;

import java.util.ArrayList;
import java.util.List;


public class Banco {
    private String nome;
    private List<Conta> contas;
    private List<Transacao> transacoes;
    
    //metodo construtor sem parametro
    public Banco(){
        this.nome = "";
        this.contas = new ArrayList<>();
        this.transacoes = new ArrayList<>();
    }

    //metodo construtor com parametro
    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
        this.transacoes = new ArrayList<>();
    }
    
    //toString
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(nome).append("\n");
        sb.append("contas: ").append(contas).append("\n");
        sb.append("Transacoes: ").append(transacoes).append("\n");
        
        for(int i = 0; i < contas.size(); i++){
            sb.append(contas.get(i).toString());
        }
        
        for(int i = 0; i < transacoes.size(); i++){
            sb.append(transacoes.get(i).toString());
        }
        return sb.toString();
    }
    
    //metodo listar contas
    public void listarContas(){
        if (contas.isEmpty()){
            System.out.println("Nenhuma conta cadastrada");
        }
        
        for (Conta c : contas){
            System.out.println(c);
        }
    }
    
    //metodo listas transacoes
    public void listarTransacoes(){
        if (transacoes.isEmpty()) {
            System.out.println("Nenhuma transação cadastrada.");
        }
        
        for (Transacao t : transacoes) {
            System.out.println(t);
        }   
    }
    
    //metodo adicionar contas
    public void adicionar(Conta contaNova){
        if(contas.contains(contaNova)){
            System.out.println("conta ja existe");
        }
        else{
            contas.add(contaNova);
        }
    }
    
    //metodo remover contas
    public void remover(Conta id){
        if(!contas.contains(id)){
            System.out.println("Conta nao existe");
        }
        else{
            contas.remove(id);
        }
    }
    
    //metodo adicionar transacoes
    public void adicionar(Transacao transacaoNova){
        transacoes.add(transacaoNova);
    }
    
    //metodo remover transacoes
    public void remover(Transacao id){
        transacoes.remove(id);
    }
    
    //metodo conta com maior saldo
    public Conta maiorSaldo(){
        Conta maior = null;
        
        for(Conta c: contas){
            if(maior == null ||c.getSaldo() > maior.getSaldo()){
                maior = c;
            }
        }
        return maior;
    }
    
    //metodo conta com menor saldo
    public Conta menorSaldo(){
        Conta menor = null;
        
        for(Conta c: contas){
            if(menor == null ||c.getSaldo() < menor.getSaldo() || c.getSaldo() < 0){
                menor = c;
            }
        }
        return menor;
    }
    
    //metodo total de devedores do banco
    public void totalDevedores(){
        int totalClientes = 0;
        double totalSaldos = 0;
        
        for(Conta c : contas){
            if(c.getSaldo() < 0){
                totalClientes ++;
                totalSaldos += c.getSaldo();
            }
        }
        System.out.println("Total de clientes: " + totalClientes);
        System.out.println("somatorio dos saldos: " + totalSaldos);
    }
    
    //metodo total de credores do banco 
     public void totalCredores(){
        int totalClientes = 0;
        double totalSaldos = 0;
        
        for(Conta c : contas){
            if(c.getSaldo() > 0){
                totalClientes ++;
                totalSaldos += c.getSaldo();
            }
        }
        System.out.println("Total de clientes: " + totalClientes);
        System.out.println("somatorio dos saldos: " + totalSaldos);
    }
}
