package tableModel;

import classes.Disciplina;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class TMCadDisciplina extends AbstractTableModel {

    private List<Disciplina> lista;

    private final int COL_CODIGO = 0;
    private final int COL_NOME = 1;
    private final int COL_CARGA_HORARIA = 2;
    private final int COL_PROFESSOR = 3;

    public TMCadDisciplina(List<Disciplina> lstDisciplinas) {
        this.lista = lstDisciplinas;
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
        Disciplina aux = new Disciplina();
        if (lista.isEmpty()) {
            return aux;
        } else {
            aux = lista.get(rowIndex);

            switch (columnIndex) {
                case -1:
                    return aux;
                case COL_CODIGO:
                    return aux.getCodigo();
                case COL_NOME:
                    return aux.getNome();
                case COL_CARGA_HORARIA:
                    return aux.getCargaHoraria();
                case COL_PROFESSOR:
                    return aux.getProfessorResponsavel();
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
            case COL_CODIGO:
                return "Código";
            case COL_NOME:
                return "Nome";
            case COL_CARGA_HORARIA:
                return "Carga Horária";
            case COL_PROFESSOR:
                return "Professor Responsável";
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
