package dao;

import classes.Professor;
import file.FilePersistence;
import file.ISerializador;
import java.util.List;

public class ProfessorDAOFile implements IDao<Professor> {

    private ISerializador<Professor> serializador;
    private FilePersistence filePersistence = new FilePersistence();
    private String caminhoArquivo;

    public ProfessorDAOFile(String caminhoArquivo, ISerializador<Professor> serializador) {
        this.caminhoArquivo = caminhoArquivo;
        this.serializador = serializador;
    }

    @Override
    public void save(Professor professor) {
        List<Professor> professores = findAll();
        professores.add(professor);

        String dados = serializador.toFile(professores);
        filePersistence.saveToFile(dados, caminhoArquivo);
        System.out.println("Professor salvo com sucesso no arquivo.");
    }

    @Override
    public void delete(String codigo) {
        Professor professorExcluir = this.find(codigo);

        if (professorExcluir != null) {
            List<Professor> professores = this.findAll();
            professores.remove(professorExcluir);

            String dados = serializador.toFile(professores);
            filePersistence.saveToFile(dados, caminhoArquivo);
            System.out.println("Professor removido com sucesso do arquivo.");
        }
    }

    @Override
    public Professor find(String codigo) {
        List<Professor> professores = this.findAll();

        for (Professor p : professores) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public List<Professor> findAll() {
        String dados = filePersistence.loadFromFile(caminhoArquivo);
        return serializador.fromFile(dados);
    }

    @Override
    public void update(String codigo, Professor professor) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
