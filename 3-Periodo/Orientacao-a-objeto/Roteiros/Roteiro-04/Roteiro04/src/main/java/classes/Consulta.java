package classes;

import java.util.Objects;

public class Consulta {
    private Paciente paciente;
    private Medico medico;
    private String dataHora;

    public Consulta(Paciente paciente, Medico medico, String dataHora) {
        this.paciente = paciente;
        this.medico = medico;
        this.dataHora = dataHora;
    }

    public Consulta(){
        this.paciente = null;
        this.medico = null;
        this.dataHora = "";
    }

    @Override
    public String toString() {
        return "Consulta{paciente=" + paciente.getNome() +
               ", medico=" + medico.getNome() +
               ", dataHora=" + dataHora + "}";
    }
    
    
    //equals e hashcode
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.paciente);
        hash = 19 * hash + Objects.hashCode(this.medico);
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
        final Consulta other = (Consulta) obj;
        if (!Objects.equals(this.paciente, other.paciente)) {
            return false;
        }
        return Objects.equals(this.medico, other.medico);
    }

    
   
    //getters e setters
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }  
}