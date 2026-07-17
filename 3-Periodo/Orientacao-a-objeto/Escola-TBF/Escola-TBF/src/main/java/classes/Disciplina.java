package classes;

import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "disciplina")
@XmlAccessorType(XmlAccessType.FIELD)
public class Disciplina {

    private String codigo;
    private String nome;
    private int cargaHoraria;
    private String professorResponsavel;

    public Disciplina() {
        this.codigo = "";
        this.nome = "";
        this.cargaHoraria = 0;
        this.professorResponsavel = "";
    }

    public Disciplina(String codigo, String nome, int cargaHoraria, String professorResponsavel) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.professorResponsavel = professorResponsavel;
    }

    public Disciplina(Disciplina outro) {
        this.codigo = outro.getCodigo();
        this.nome = outro.getNome();
        this.cargaHoraria = outro.getCargaHoraria();
        this.professorResponsavel = outro.getProfessorResponsavel();
    }

    public void copiar(Disciplina outro) {
        this.codigo = outro.getCodigo();
        this.nome = outro.getNome();
        this.cargaHoraria = outro.getCargaHoraria();
        this.professorResponsavel = outro.getProfessorResponsavel();
    }

    @Override
    public String toString() {
        return "Disciplina{ codigo=" + getCodigo() + ", nome=" + getNome()
                + ", cargaHoraria=" + getCargaHoraria()
                + ", professorResponsavel=" + getProfessorResponsavel() + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.codigo);
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
        final Disciplina other = (Disciplina) obj;
        return Objects.equals(this.codigo, other.codigo);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getProfessorResponsavel() {
        return professorResponsavel;
    }

    public void setProfessorResponsavel(String professorResponsavel) {
        this.professorResponsavel = professorResponsavel;
    }
}
