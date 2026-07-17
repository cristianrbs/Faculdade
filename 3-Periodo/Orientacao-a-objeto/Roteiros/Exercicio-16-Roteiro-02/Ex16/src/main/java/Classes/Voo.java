
package Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Voo {
    private String numVoo;
    private String destino;
    private int capacidadeMaxima;
    private List<Passageiro> passageiros;
    private List<String> escalas;
    private String estadoDoVoo;
    
    //metodo construtor sem parametro
    public Voo(){
        this.numVoo = "";
        this.capacidadeMaxima = 0;
        this.passageiros = new ArrayList<>();
        this.escalas = new ArrayList<>();
        this.estadoDoVoo = "Aguardando decolagem";
    }
    
    //metodo construtor com parametro
    public Voo(String numVoo, String destino, int capacidadeMaxima, String estadoDoVoo) {
        this.numVoo = numVoo;
        this.destino = destino;
        this.capacidadeMaxima = capacidadeMaxima;
        this.passageiros = new ArrayList<>();
        this.escalas = new ArrayList<>();
        this.estadoDoVoo = estadoDoVoo;
    }
    
    //metodo alterar o estado do voo
    public void alterarEstado(String novoEstado){
        if (novoEstado.equalsIgnoreCase("Aguardando decolagem") || novoEstado.equalsIgnoreCase("Voando") ||novoEstado.equalsIgnoreCase("Concluído")){
                this.estadoDoVoo = novoEstado;
                System.out.println("Estado do voo alterado para: " + novoEstado);
        } 
        else {
            System.out.println("Estado inválido. Use: 'Aguardando decolagem', 'Voando' ou 'Concluído'.");
        }
    }
    
    //metodo toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Numero do Voo: ").append(this.numVoo).append("\n");
        sb.append("Destino: ").append(this.destino).append("\n");
        sb.append("Capacidade maxima: ").append(this.capacidadeMaxima).append("\n");
        sb.append("Lista de Passageiros: ").append(this.passageiros).append("\n");
        sb.append("Lista de escalas: ").append(this.escalas).append("\n");
        sb.append("Estado do Voo: ").append(this.estadoDoVoo).append("\n");
        
        for(int i = 0; i < passageiros.size(); i++){
            sb.append(passageiros.get(i).toString());        
        }
        for(int i = 0; i < escalas.size(); i++){
            sb.append(escalas.get(i).toString());
        }
        return sb.toString();
    }
    
    //getters e setters
    public String getNumVoo() {
        return numVoo;
    }

    public void setNumVoo(String numVoo) {
        this.numVoo = numVoo;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public List<Passageiro> getPassageiros() {
        return passageiros;
    }

    public void setPassageiros(List<Passageiro> passageiros) {
        this.passageiros = passageiros;
    }

    public List<String> getEscalas() {
        return escalas;
    }

    public void setEscalas(List<String> escalas) {
        this.escalas = escalas;
    }

    public String getEstadoDoVoo() {
        return estadoDoVoo;
    }

    public void setEstadoDoVoo(String estadoDoVoo) {
        this.estadoDoVoo = estadoDoVoo;
    }
    
    //equal e hashcode
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.numVoo);
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
        final Voo other = (Voo) obj;
        return Objects.equals(this.numVoo, other.numVoo);
    }
}
