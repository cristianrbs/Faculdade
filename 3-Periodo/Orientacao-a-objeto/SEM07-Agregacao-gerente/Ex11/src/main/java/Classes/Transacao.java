package Classes;

import java.util.Objects;

public class Transacao {
    private String id;
    private String tipoTransacao;
    private double valor;
    private String data;
    private Conta contaAssociada;
    
    //metodo construtor sem parametro
    public Transacao(){
        this.id = "";
        this.tipoTransacao = "";
        this.valor = 0.0;
        this.data = "";
        this.contaAssociada  = null;
    }

    //metodo construtor com parametro
    public Transacao(String id, String tipoTransacao, double valor, String data, Conta contaAssociada) {
        this.id = id;
        this.tipoTransacao = tipoTransacao;
        this.valor = valor;
        this.data = data;
        this.contaAssociada = contaAssociada;
    }
    
    
    //metodo copiar 
    public void copiar(Transacao outro){
        this.id = outro.getId();
        this.tipoTransacao = outro.getTipoTransacao();
        this.valor = outro.getValor();
        this.data = outro.getData();
        this.contaAssociada = outro.getContaAssociada();
    }
    
    //toString
    @Override
    public String toString() {
        return "Transacao{" + "id = " + id 
                + ", tipoTransacao = " + tipoTransacao 
                + ", valor = " + valor 
                + ", data = " + data 
                + ", contas = " + contaAssociada +'}';
    }
    
    //getters e setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(String tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Conta getContaAssociada() {
        return contaAssociada;
    }

    public void setContaAssociada(Conta contaAssociada) {
        this.contaAssociada = contaAssociada;
    }
    
    //equal e hashcode
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Transacao other = (Transacao) obj;
        return Objects.equals(this.id, other.id);
    } 
}
