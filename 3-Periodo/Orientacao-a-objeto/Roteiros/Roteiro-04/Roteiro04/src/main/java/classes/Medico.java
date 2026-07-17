package classes;

import java.util.Objects;

public class Medico {
    private String nome;
    private String crm;
    private String especialidade;
    private String horariosDisponiveis;

    public Medico(String nome, String crm, String especialidade, String horariosDisponiveis) {
        this.nome = nome;
        this.crm = crm;
        this.especialidade = especialidade;
        this.horariosDisponiveis = horariosDisponiveis;
    }

    public Medico() {
        this.nome = "";
        this.crm = "";
        this.especialidade = "";
        this.horariosDisponiveis = "";
    }

    @Override
    public String toString() {
        return nome + " - " + especialidade + " (CRM: " + crm + ")";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    
    //equals e hashcode
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
        final Medico other = (Medico) obj;
        return Objects.equals(this.nome, other.nome);
    }

    
  
    //getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getHorariosDisponiveis() {
        return horariosDisponiveis;
    }

    public void setHorariosDisponiveis(String horariosDisponiveis) {
        this.horariosDisponiveis = horariosDisponiveis;
    }  
}