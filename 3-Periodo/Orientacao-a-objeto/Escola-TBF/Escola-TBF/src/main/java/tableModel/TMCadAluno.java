package tableModel;

import classes.Aluno;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class TMCadAluno extends AbstractTableModel {

    private List<Aluno> lista;

    private final int COL_MATRICULA = 0;
    private final int COL_NOME = 1;
    private final int COL_CURSO = 2;
    private final int COL_IDADE = 3;

    public TMCadAluno(List<Aluno> lstAlunos) {
        this.lista = lstAlunos;
    }

    @Override
    public int getRowCount() {
        return this.lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Aluno aux = new Aluno();
        if (lista.isEmpty()) {
            return aux;
        } else {
            aux = lista.get(rowIndex);

            switch (columnIndex) {
                case -1:
                    return aux;
                case COL_MATRICULA:
                    return aux.getMatricula();
                case COL_NOME:
                    return aux.getNome();
                case COL_CURSO:
                    return aux.getCurso();
                case COL_IDADE:
                    return aux.getIdade();
                default:
                    break;
            }
        }
        return aux;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case COL_MATRICULA:
                return "Matrícula";
            case COL_NOME:
                return "Nome";
            case COL_CURSO:
                return "Curso";
            case COL_IDADE:
                return "Idade";
            default:
                break;
        }
        return "";
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        return String.class;
    }
}
