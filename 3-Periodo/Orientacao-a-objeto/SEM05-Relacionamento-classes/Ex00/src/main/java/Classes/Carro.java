package Classes;

import java.util.Objects;


public class Carro {
    private String modelo;
    private int ano;
    private String cor;

    //construtor com parametro
    public Carro(String modelo, int ano, String cor) {
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
    }
    
    //construtor sem parametro
    public Carro(){
        this.modelo = "";
        this.ano = 0;
        this.cor = "";
    }

    // metodo toString
    @Override
    public String toString() {
        return "Carro{" + "modelo=" + modelo + ", ano=" + ano + ", cor=" + cor + '}';
    }
    
    //construtor de copia
    public Carro(Carro outro){
        this.modelo = outro.getModelo();
        this.ano = outro.getAno();
        this.cor = outro.getCor();
    }
    
    //metodo copiar 
    public void copiar(Carro outro){
        this.modelo = outro.getModelo();
        this.ano = outro.getAno();
        this.cor = outro.getCor();
    }
    
    //metodo buzinar
    public void buzinar(){
        System.out.println("POOOOMMMMM");
    }
    
    //metodo abrir porta 
    public void abrirPorta(){
        System.out.println("Porta aberta");
    }

    //getter e setters 
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    //hascode e equals 
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.modelo);
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
        final Carro other = (Carro) obj;
        if (this.ano != other.ano) {
            return false;
        }
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        return Objects.equals(this.cor, other.cor);
    }
}
