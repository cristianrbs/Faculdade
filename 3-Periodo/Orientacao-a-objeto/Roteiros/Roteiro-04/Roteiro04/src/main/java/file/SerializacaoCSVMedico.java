package file;

import classes.Medico;
import java.util.ArrayList;
import java.util.List;

public class SerializacaoCSVMedico {

    public String toCSV(List<Medico> medicos) {
        String csv = "Nome;CRM;Especialidade;HorariosDisponiveis;\n";
        for (Medico m : medicos) {
            csv += m.getNome() + ";"
                 + m.getCrm() + ";"
                 + m.getEspecialidade() + ";"
                 + m.getHorariosDisponiveis() + ";\n";
        }
        return csv;
    }

    public List<Medico> fromCSV(String data) {
        List<Medico> medicos = new ArrayList<>();

        String[] linhas = data.split("\n");
        for (int i = 1; i < linhas.length; i++) {
            String[] partes = linhas[i].split(";");
            if (partes.length >= 4) {
                Medico m = new Medico();
                m.setNome(partes[0]);
                m.setCrm(partes[1]);
                m.setEspecialidade(partes[2]);
                m.setHorariosDisponiveis(partes[3]);

                medicos.add(m);
            }
        }
        return medicos;
    }
}