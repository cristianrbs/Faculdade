package dao;

import classes.Disciplina;
import file.FilePersistence;
import file.ISerializador;
import java.util.List;


public class DisciplinaDAOFile implements IDao<Disciplina> {

    private ISerializador<Disciplina> serializador;
    private FilePersistence filePersistence = new FilePersistence();
    private String caminhoArquivo;

    public DisciplinaDAOFile(String caminhoArquivo, ISerializador<Disciplina> serializador) {
        this.caminhoArquivo = caminhoArquivo;
        this.serializador = serializador;
    }

    @Override
    public void save(Disciplina disciplina) {
        List<Disciplina> disciplinas = findAll();
        disciplinas.add(disciplina);

        String dados = serializador.toFile(disciplinas);
        filePersistence.saveToFile(dados, caminhoArquivo);
        System.out.println("Disciplina salva com sucesso no arquivo.");
    }

    @Override
    public void delete(String codigo) {
        Disciplina disciplinaExcluir = this.find(codigo);

        if (disciplinaExcluir != null) {
            List<Disciplina> disciplinas = this.findAll();
            disciplinas.remove(disciplinaExcluir);

            String dados = serializador.toFile(disciplinas);
            filePersistence.saveToFile(dados, caminhoArquivo);
            System.out.println("Disciplina removida com sucesso do arquivo.");
        }
    }

    @Override
    public Disciplina find(String codigo) {
        List<Disciplina> disciplinas = this.findAll();

        for (Disciplina d : disciplinas) {
            if (d.getCodigo().equals(codigo)) {
                return d;
            }
        }
        return null;
    }

    @Override
    public List<Disciplina> findAll() {
        String dados = filePersistence.loadFromFile(caminhoArquivo);
        return serializador.fromFile(dados);
    }

    @Override
    public void update(String codigo, Disciplina disciplina) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
