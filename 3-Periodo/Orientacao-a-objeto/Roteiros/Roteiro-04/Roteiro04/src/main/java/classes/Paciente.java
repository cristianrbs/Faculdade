package classes;

import java.util.Objects;

public class Paciente {
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String historicoMedico;

    public Paciente(String nome, String cpf, String dataNascimento, String historicoMedico) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.historicoMedico = historicoMedico;
    }

    public Paciente(){
        this.nome = "";
        this.cpf = "";
        this.dataNascimento = "";
        this.historicoMedico = "";
    }

    @Override
    public String toString() {
        return nome + " (CPF: " + cpf + ")";
    }

    //equals e hashcode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.nome);
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
        final Paciente other = (Paciente) obj;
        return Objects.equals(this.nome, other.nome);
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

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getHistoricoMedico() {
        return historicoMedico;
    }

    public void setHistoricoMedico(String historicoMedico) {
        this.historicoMedico = historicoMedico;
    } 
}