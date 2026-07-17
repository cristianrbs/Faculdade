package Classes;

import java.util.Objects;


public class Conta {
    private String id;
    private String titular;
    private double saldo;
    
    //metodo construtor sem parametro
    public Conta(){
         this.id = "";
         this.titular = "";
         this.saldo = 0.0;
    }

    //metodo construtor com parametro
    public Conta(String id, String titularDaConta, double saldoDaConta) {
        this.id = id;
        this.titular = titularDaConta;
        this.saldo = saldoDaConta;
    }
    
    //metodo copiar
    public void copiar(Conta outro){
        this.id = outro.getId();
        this.saldo = outro.getSaldo();
        this.titular = outro.getTitular();
    }
    
    //metodo saque 
    public void saque(double valor){
        if (valor <= 0) {
            System.out.println("Valor inválido para saque.");
        } 
        else {
            this.saldo -= valor;
        }
}
    
    //metodo deposito
    public void deposito(double valor){
        if (valor <= 0) {
            System.out.println("Valor inválido para depósito.");
        } 
        else {
            this.saldo += valor;
        }
    }
    
    //metodo atualizar saldo apos transação
    public double atualizarSaldo(){
        return this.saldo;
    }
    
    //metodo toString
    @Override
    public String toString() {
        return "Conta{" + "id = " + id 
                + ", titularDaConta = " + titular 
                + ", saldoDaConta = " + saldo + '}';
    }
    
    //getters e setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    //equal e hashcode
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Conta other = (Conta) obj;
        return Objects.equals(this.id, other.id);
    }
}
