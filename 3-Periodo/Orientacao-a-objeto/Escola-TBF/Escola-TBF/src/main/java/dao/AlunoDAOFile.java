package dao;

import classes.Aluno;
import file.FilePersistence;
import file.ISerializador;
import java.util.List;


public class AlunoDAOFile implements IDao<Aluno> {

    private ISerializador<Aluno> serializador;
    private FilePersistence filePersistence = new FilePersistence();
    private String caminhoArquivo;

    public AlunoDAOFile(String caminhoArquivo, ISerializador<Aluno> serializador) {
        this.caminhoArquivo = caminhoArquivo;
        this.serializador = serializador;
    }

    @Override
    public void save(Aluno aluno) {
        List<Aluno> alunos = findAll();
        alunos.add(aluno);

        String dados = serializador.toFile(alunos);
        filePersistence.saveToFile(dados, caminhoArquivo);
        System.out.println("Aluno salvo com sucesso no arquivo.");
    }

    @Override
    public void delete(String matricula) {
        Aluno alunoExcluir = this.find(matricula);

        if (alunoExcluir != null) {
            List<Aluno> alunos = this.findAll();
            alunos.remove(alunoExcluir);

            String dados = serializador.toFile(alunos);
            filePersistence.saveToFile(dados, caminhoArquivo);
            System.out.println("Aluno removido com sucesso do arquivo.");
        }
    }

    @Override
    public Aluno find(String matricula) {
        List<Aluno> alunos = this.findAll();

        for (Aluno a : alunos) {
            if (a.getMatricula().equals(matricula)) {
                return a;
            }
        }
        return null;
    }

    @Override
    public List<Aluno> findAll() {
        String dados = filePersistence.loadFromFile(caminhoArquivo);
        return serializador.fromFile(dados);
    }

    @Override
    public void update(String matricula, Aluno aluno) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
