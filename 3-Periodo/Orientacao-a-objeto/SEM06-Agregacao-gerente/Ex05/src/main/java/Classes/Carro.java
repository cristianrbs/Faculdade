package Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Carro{

    private String fabricante;
    private String modelo;
    private String cor;
    private List<Roda> rodas;

    //construtor com parametro
    public Carro(String fabricante, String modelo, String cor){
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.cor = cor;
        this.rodas = new ArrayList<>();
    }

    //construtor sem parametro
    public Carro(){
        this.fabricante = "";
        this.modelo = "";
        this.cor = "";
        this.rodas = new ArrayList<>();
    }

    //metodo copiar
    public void copiar(Carro outro){
        this.fabricante = outro.getFabricante();
        this.modelo = outro.getModelo();
        this.cor = outro.getCor();
        
        this.rodas = new ArrayList<>();
        for (Roda r : outro.getRodas()){
            Roda nova = new Roda();
            nova.copiar(r);
            this.rodas.add(nova);
        }
    }

    //adicionar roda
    public void adicionarRoda(Roda rodaNova){
        this.rodas.add(rodaNova);
    }
    
    //metodos imprimir
    public void imprimir(){
        System.out.println(this);
    }

    //metodo toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Fabricante = ").append(fabricante).append("\n");
        sb.append(", Modelo = ").append(modelo).append("\n");
        sb.append(", cor = ").append(cor).append("\n");
        sb.append(", Rodas = ").append("\n");
        
        for (int i = 0; i < rodas.size(); i++){
            sb.append(rodas.get(i).toString());
        }
        return sb.toString();
    }

    //getters e setters
    public String getFabricante(){
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public List<Roda> getRodas() {
        return rodas;
    }

    public void setRodas(List<Roda> rodas) {
        this.rodas = rodas;
    }
    
    //equails e hashcode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.fabricante);
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
        if (!Objects.equals(this.fabricante, other.fabricante)) {
            return false;
        }
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        if (!Objects.equals(this.cor, other.cor)) {
            return false;
        }
        return Objects.equals(this.rodas, other.rodas);
    }
}