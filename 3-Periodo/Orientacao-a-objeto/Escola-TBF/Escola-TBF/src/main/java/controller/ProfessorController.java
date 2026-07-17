package controller;

import dao.IDao;
import classes.Professor;
import valid.ValidacaoProfessor;
import java.util.List;

public class ProfessorController {

    private IDao<Professor> repositorio;

    public ProfessorController(IDao<Professor> repositorio) {
        this.repositorio = repositorio;
    }

    public void adicionarProfessor(String codigo, String nome, String especializacao, String cargaHoraria) {
        ValidacaoProfessor valid = new ValidacaoProfessor();
        Professor novoProfessor = valid.validacao(codigo, nome, especializacao, cargaHoraria);

        repositorio.save(novoProfessor);
    }

    public void removerProfessor(String codigo) {
        repositorio.delete(codigo);
    }

    public Professor buscarProfessor(String codigo) {
        return repositorio.find(codigo);
    }

    public List<Professor> listarProfessores() {
        return repositorio.findAll();
    }

    public void atualizarProfessor(String codigoAntigo, String nome, String especializacao, String cargaHoraria) {
        removerProfessor(codigoAntigo);
        adicionarProfessor(codigoAntigo, nome, especializacao, cargaHoraria);
    }
}
