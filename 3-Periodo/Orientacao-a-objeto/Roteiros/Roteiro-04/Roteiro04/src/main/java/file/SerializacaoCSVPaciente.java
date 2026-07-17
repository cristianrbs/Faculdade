package file;

import classes.Paciente;
import java.util.ArrayList;
import java.util.List;

public class SerializacaoCSVPaciente {

    public String toCSV(List<Paciente> pacientes) {
        String csv = "Nome;CPF;DataNascimento;HistoricoMedico;\n";
        for (Paciente p : pacientes) {
            csv += p.getNome() + ";"
                 + p.getCpf() + ";"
                 + p.getDataNascimento() + ";"
                 + p.getHistoricoMedico() + ";\n";
        }
        return csv;
    }

    public List<Paciente> fromCSV(String data) {
        List<Paciente> pacientes = new ArrayList<>();

        String[] linhas = data.split("\n");
        for (int i = 1; i < linhas.length; i++) {
            String[] partes = linhas[i].split(";");
            if (partes.length >= 4) {
                Paciente p = new Paciente();
                p.setNome(partes[0]);
                p.setCpf(partes[1]);
                p.setDataNascimento(partes[2]);
                p.setHistoricoMedico(partes[3]);

                pacientes.add(p);
            }
        }
        return pacientes;
    }
}