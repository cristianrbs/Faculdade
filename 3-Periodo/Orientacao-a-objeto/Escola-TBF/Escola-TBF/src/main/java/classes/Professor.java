package classes;

import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "professor")
@XmlAccessorType(XmlAccessType.FIELD)
public class Professor {

    private String codigo;
    private String nome;
    private String especializacao;
    private int cargaHoraria;

    public Professor() {
        this.codigo = "";
        this.nome = "";
        this.especializacao = "";
        this.cargaHoraria = 0;
    }

    public Professor(String codigo, String nome, String especializacao, int cargaHoraria) {
        this.codigo = codigo;
        this.nome = nome;
        this.especializacao = especializacao;
        this.cargaHoraria = cargaHoraria;
    }

    public Professor(Professor outro) {
        this.codigo = outro.getCodigo();
        this.nome = outro.getNome();
        this.especializacao = outro.getEspecializacao();
        this.cargaHoraria = outro.getCargaHoraria();
    }

    public void copiar(Professor outro) {
        this.codigo = outro.getCodigo();
        this.nome = outro.getNome();
        this.especializacao = outro.getEspecializacao();
        this.cargaHoraria = outro.getCargaHoraria();
    }

    @Override
    public String toString() {
        return "Professor{ codigo=" + getCodigo() + ", nome=" + getNome()
                + ", especializacao=" + getEspecializacao()
                + ", cargaHoraria=" + getCargaHoraria() + '}';
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
        final Professor other = (Professor) obj;
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

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
}
