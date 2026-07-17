package file;

import classes.Disciplina;
import java.util.ArrayList;
import java.util.List;

public class SerializadorCSVDisciplina implements ISerializador<Disciplina> {

    @Override
    public String toFile(List<Disciplina> disciplinas) {
        String csv = "Codigo;Nome;CargaHoraria;ProfessorResponsavel;\n";
        for (Disciplina d : disciplinas) {
            csv += d.getCodigo() + ";"
                    + d.getNome() + ";"
                    + d.getCargaHoraria() + ";"
                    + d.getProfessorResponsavel() + ";\n";
        }
        return csv;
    }

    @Override
    public List<Disciplina> fromFile(String data) {
        List<Disciplina> disciplinas = new ArrayList<>();

        String[] linhas = data.split("\n");
        for (int i = 1; i < linhas.length; i++) {
            String[] partes = linhas[i].split(";");
            if (partes.length >= 4) {
                Disciplina d = new Disciplina();
                d.setCodigo(partes[0]);
                d.setNome(partes[1]);
                d.setCargaHoraria(Integer.parseInt(partes[2]));
                d.setProfessorResponsavel(partes[3]);

                disciplinas.add(d);
            }
        }
        return disciplinas;
    }
}
