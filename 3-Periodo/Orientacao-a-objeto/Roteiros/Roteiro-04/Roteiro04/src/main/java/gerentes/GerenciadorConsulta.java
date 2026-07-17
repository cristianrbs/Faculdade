package gerentes;

import classes.Consulta;
import file.*;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorConsulta {

    private List<Consulta> consultas;
    private FilePersistence filePersistence;
    private SerializacaoCSVConsulta serializador;

    public GerenciadorConsulta() {
        this.consultas = new ArrayList<>();
        this.filePersistence = new FilePersistence();
        this.serializador = new SerializacaoCSVConsulta();
    }

    public void adicionarConsulta(Consulta c) {
        consultas.add(c);
        System.out.println("Consulta agendada com sucesso!");
    }

    public boolean removerConsulta(Consulta c) {
        if (!consultas.contains(c)) {
            System.out.println("Consulta não encontrada.");
            return false;
        }
        consultas.remove(c);
        System.out.println("Consulta removida com sucesso!");
        return true;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void salvarNoArquivo(String caminho) {
        filePersistence.saveToFile(serializador.toCSV(consultas), caminho);
    }

    public void carregarDoArquivo(String caminho) {
        consultas = serializador.fromCSV(filePersistence.loadFromFile(caminho));
    }

    @Override
    public String toString() {
        if (consultas.isEmpty()) return "Nenhuma consulta agendada.";
        StringBuilder sb = new StringBuilder();
        for (Consulta c : consultas) {
            sb.append(c).append("\n");
        }
        return sb.toString();
    }
}