package controller;

import dao.IDao;
import classes.Disciplina;
import valid.ValidacaoDisciplina;
import java.util.List;


public class DisciplinaController {

    private IDao<Disciplina> repositorio;

    public DisciplinaController(IDao<Disciplina> repositorio) {
        this.repositorio = repositorio;
    }

    public void adicionarDisciplina(String codigo, String nome, String cargaHoraria, String professorResponsavel) {
        ValidacaoDisciplina valid = new ValidacaoDisciplina();
        Disciplina novaDisciplina = valid.validacao(codigo, nome, cargaHoraria, professorResponsavel);

        repositorio.save(novaDisciplina);
    }

    public void removerDisciplina(String codigo) {
        repositorio.delete(codigo);
    }

    public Disciplina buscarDisciplina(String codigo) {
        return repositorio.find(codigo);
    }

    public List<Disciplina> listarDisciplinas() {
        return repositorio.findAll();
    }

    public void atualizarDisciplina(String codigoAntigo, String nome, String cargaHoraria, String professorResponsavel) {
        removerDisciplina(codigoAntigo);
        adicionarDisciplina(codigoAntigo, nome, cargaHoraria, professorResponsavel);
    }
}
