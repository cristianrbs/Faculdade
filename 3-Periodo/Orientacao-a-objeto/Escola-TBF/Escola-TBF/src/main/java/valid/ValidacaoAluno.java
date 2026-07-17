package valid;

import classes.Aluno;
import exceptions.AlunoException;


public class ValidacaoAluno {

    public Aluno validacao(String matricula, String nome, String curso, String idade) {
        Aluno a = new Aluno();

        if (matricula == null || matricula.isEmpty()) {
            throw new AlunoException("Error - Campo vazio: 'matrícula'.");
        }
        a.setMatricula(matricula);

        if (nome == null || nome.isEmpty()) {
            throw new AlunoException("Error - Campo vazio: 'nome'.");
        }
        a.setNome(nome);

        if (curso == null || curso.isEmpty()) {
            throw new AlunoException("Error - Campo vazio: 'curso'.");
        }
        a.setCurso(curso);

        if (idade == null || idade.isEmpty()) {
            throw new AlunoException("Error - Campo vazio: 'idade'.");
        }

        if (!idade.matches("[0-9]+")) {
            throw new AlunoException("Error - Valor inválido no campo 'idade'.");
        }

        int valorIdade = Integer.parseInt(idade);
        if (valorIdade <= 0) {
            throw new AlunoException("Error - 'idade' deve ser maior que zero.");
        }
        a.setIdade(valorIdade);

        return a;
    }
}
