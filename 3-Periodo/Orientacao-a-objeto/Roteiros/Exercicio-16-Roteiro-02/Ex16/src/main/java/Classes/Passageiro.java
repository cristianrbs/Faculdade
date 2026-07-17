package Classes;

import java.util.Objects;


public class Passageiro {
    private String nome;
    private String CPF;
    private SistemaFidelidade fidelidade;
    
    //metodo construtor sem parametro
    public Passageiro(){
        this.nome = "";
        this.CPF = "";
        this.fidelidade = new SistemaFidelidade();
    }
    
    //metodo construtor com parametro
    public Passageiro(String nome, String CPF) {
        this.nome = nome;
        this.CPF = CPF;
        this.fidelidade = new SistemaFidelidade();
    }
    
    //toString
    @Override
    public String toString() {
        return "Passageiros{" + "nome = " + nome 
                + ", CPF = " + CPF 
                + ", fidelidades = " + fidelidade 
                + '}';
    }
    
    //getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public SistemaFidelidade getFidelidades() {
        return fidelidade;
    }

    public void setFidelidades(SistemaFidelidade fidelidades) {
        this.fidelidade = fidelidades;
    }
    
    //equal e hashcode
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.CPF);
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
        final Passageiro other = (Passageiro) obj;
        return Objects.equals(this.CPF, other.CPF);
    }  
}
