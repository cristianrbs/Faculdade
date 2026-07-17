package valid;

import classes.Professor;
import exceptions.ProfessorException;

public class ValidacaoProfessor {

    public Professor validacao(String codigo, String nome, String especializacao, String cargaHoraria) {
        Professor p = new Professor();

        if (codigo == null || codigo.isEmpty()) {
            throw new ProfessorException("Error - Campo vazio: 'código'.");
        }
        p.setCodigo(codigo);

        if (nome == null || nome.isEmpty()) {
            throw new ProfessorException("Error - Campo vazio: 'nome'.");
        }
        p.setNome(nome);

        if (especializacao == null || especializacao.isEmpty()) {
            throw new ProfessorException("Error - Campo vazio: 'especialização'.");
        }
        p.setEspecializacao(especializacao);

        if (cargaHoraria == null || cargaHoraria.isEmpty()) {
            throw new ProfessorException("Error - Campo vazio: 'carga horária'.");
        }

        if (!cargaHoraria.matches("[0-9]+")) {
            throw new ProfessorException("Error - Valor inválido no campo 'carga horária'.");
        }

        int valorCarga = Integer.parseInt(cargaHoraria);
        if (valorCarga <= 0) {
            throw new ProfessorException("Error - 'carga horária' deve ser maior que zero.");
        }
        p.setCargaHoraria(valorCarga);

        return p;
    }
}
