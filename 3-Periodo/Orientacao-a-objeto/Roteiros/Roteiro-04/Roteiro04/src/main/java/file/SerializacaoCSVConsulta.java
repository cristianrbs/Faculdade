package file;

import classes.*;
import java.util.ArrayList;
import java.util.List;

public class SerializacaoCSVConsulta {

    public String toCSV(List<Consulta> consultas) {
        String csv = "Paciente;Medico;DataHora;\n";
        for (Consulta c : consultas) {
            csv += c.getPaciente().getNome() + ";"
                 + c.getMedico().getNome() + ";"
                 + c.getDataHora() + ";\n";
        }
        return csv;
    }

    public List<Consulta> fromCSV(String data) {
        List<Consulta> consultas = new ArrayList<>();

        String[] linhas = data.split("\n");
        for (int i = 1; i < linhas.length; i++) {
            String[] partes = linhas[i].split(";");
            if (partes.length >= 3) {
                Paciente p = new Paciente();
                p.setNome(partes[0]);

                Medico m = new Medico();
                m.setNome(partes[1]);

                Consulta c = new Consulta(p, m, partes[2]);
                consultas.add(c);
            }
        }
        return consultas;
    }
}