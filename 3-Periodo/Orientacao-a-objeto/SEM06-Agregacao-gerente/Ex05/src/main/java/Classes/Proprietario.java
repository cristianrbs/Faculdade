package Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Proprietario{

    private String nome;
    private String cpf;
    private String email;
    private List<Carro> carros;

    //construtor com parametros
    public Proprietario(String nome, String cpf, String email){
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.carros = new ArrayList<>();
    }

    //construtor sem parametro
    public Proprietario(){
        this.nome = "";
        this.cpf = "";
        this.email = "";
        this.carros = new ArrayList<>();
    }

    //metodo copiar
    public void copiar(Proprietario outro){
        this.nome = outro.getNome();
        this.cpf = outro.getCpf();
        this.email = outro.getEmail();
        
        this.carros = new ArrayList<>();
        for (Carro c : outro.getCarros()) {
            Carro novo = new Carro();
            novo.copiar(c);
            this.carros.add(novo);
        }
    }

    //adicionar carro
    public void adicionarCarro(Carro carroNovo){
        this.carros.add(carroNovo);
    }

    //metodo possui carro de determinado fabricante
    public boolean possuiCarroDeFabricante(String fabricante){
        for (Carro c : carros){
            if (c.getFabricante().equalsIgnoreCase(fabricante)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome = ").append(nome).append("\n");
        sb.append(", cpf = ").append(cpf).append("\n");
        sb.append(", E-mail = ").append(email).append("\n");
        sb.append(", Carros = ").append("\n");
        
        for (int i = 0; i < carros.size(); i++){
            sb.append(carros.get(i).toString());
        }
        return sb.toString();
    }

    //getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }
   
    //equals e hashcode

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.cpf);
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
        final Proprietario other = (Proprietario) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return Objects.equals(this.carros, other.carros);
    }
}