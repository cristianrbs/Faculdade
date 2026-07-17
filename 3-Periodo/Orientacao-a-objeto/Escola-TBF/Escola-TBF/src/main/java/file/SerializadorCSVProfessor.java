package file;

import classes.Professor;
import java.util.ArrayList;
import java.util.List;


public class SerializadorCSVProfessor implements ISerializador<Professor> {

    @Override
    public String toFile(List<Professor> professores) {
        String csv = "Codigo;Nome;Especializacao;CargaHoraria;\n";
        for (Professor p : professores) {
            csv += p.getCodigo() + ";"
                    + p.getNome() + ";"
                    + p.getEspecializacao() + ";"
                    + p.getCargaHoraria() + ";\n";
        }
        return csv;
    }

    @Override
    public List<Professor> fromFile(String data) {
        List<Professor> professores = new ArrayList<>();

        String[] linhas = data.split("\n");
        for (int i = 1; i < linhas.length; i++) {
            String[] partes = linhas[i].split(";");
            if (partes.length >= 4) {
                Professor p = new Professor();
                p.setCodigo(partes[0]);
                p.setNome(partes[1]);
                p.setEspecializacao(partes[2]);
                p.setCargaHoraria(Integer.parseInt(partes[3]));

                professores.add(p);
            }
        }
        return professores;
    }
}
