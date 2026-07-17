package controller;

import dao.IDao;
import classes.Aluno;
import valid.ValidacaoAluno;
import java.util.List;


public class AlunoController {

    private IDao<Aluno> repositorio;

    public AlunoController(IDao<Aluno> repositorio) {
        this.repositorio = repositorio;
    }

    public void adicionarAluno(String matricula, String nome, String curso, String idade) {
        ValidacaoAluno valid = new ValidacaoAluno();
        Aluno novoAluno = valid.validacao(matricula, nome, curso, idade);

        repositorio.save(novoAluno);
    }

    public void removerAluno(String matricula) {
        repositorio.delete(matricula);
    }

    public Aluno buscarAluno(String matricula) {
        return repositorio.find(matricula);
    }

    public List<Aluno> listarAlunos() {
        return repositorio.findAll();
    }

    public void atualizarAluno(String matriculaAntiga, String nome, String curso, String idade) {
        removerAluno(matriculaAntiga);
        adicionarAluno(matriculaAntiga, nome, curso, idade);
    }
}
