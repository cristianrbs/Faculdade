package valid;

import classes.Disciplina;
import exceptions.DisciplinaException;

public class ValidacaoDisciplina {

    public Disciplina validacao(String codigo, String nome, String cargaHoraria, String professorResponsavel) {
        Disciplina d = new Disciplina();

        if (codigo == null || codigo.isEmpty()) {
            throw new DisciplinaException("Error - Campo vazio: 'código'.");
        }
        d.setCodigo(codigo);

        if (nome == null || nome.isEmpty()) {
            throw new DisciplinaException("Error - Campo vazio: 'nome'.");
        }
        d.setNome(nome);

        if (cargaHoraria == null || cargaHoraria.isEmpty()) {
            throw new DisciplinaException("Error - Campo vazio: 'carga horária'.");
        }

        if (!cargaHoraria.matches("[0-9]+")) {
            throw new DisciplinaException("Error - Valor inválido no campo 'carga horária'.");
        }

        int valorCarga = Integer.parseInt(cargaHoraria);
        if (valorCarga <= 0) {
            throw new DisciplinaException("Error - 'carga horária' deve ser maior que zero.");
        }
        d.setCargaHoraria(valorCarga);

        if (professorResponsavel == null || professorResponsavel.isEmpty()) {
            throw new DisciplinaException("Error - Campo vazio: 'professor responsável'.");
        }
        d.setProfessorResponsavel(professorResponsavel);

        return d;
    }
}
