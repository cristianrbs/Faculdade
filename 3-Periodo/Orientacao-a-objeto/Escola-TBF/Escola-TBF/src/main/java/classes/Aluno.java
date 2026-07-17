package classes;

import java.util.Objects;

public class Aluno {

    private String matricula;
    private String nome;
    private String curso;
    private int idade;

    public Aluno() {
        this.matricula = "";
        this.nome = "";
        this.curso = "";
        this.idade = 0;
        
    }

    public Aluno(String matricula, String nome, String curso, int idade) {
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
        this.idade = idade;
    }

    public Aluno(Aluno outro) {
        this.matricula = outro.getMatricula();
        this.nome = outro.getNome();
        this.curso = outro.getCurso();
        this.idade = outro.getIdade();
    }

    public void copiar(Aluno outro) {
        this.matricula = outro.getMatricula();
        this.nome = outro.getNome();
        this.curso = outro.getCurso();
        this.idade = outro.getIdade();
    }

    @Override
    public String toString() {
        return "Aluno{ matricula=" + getMatricula() + ", nome=" + getNome()
                + ", curso=" + getCurso() + ", idade=" + getIdade() + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.matricula);
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
        final Aluno other = (Aluno) obj;
        return Objects.equals(this.matricula, other.matricula);
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
