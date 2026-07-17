package tableModel;

import classes.Professor;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class TMCadProfessor extends AbstractTableModel {

    private List<Professor> lista;

    private final int COL_CODIGO = 0;
    private final int COL_NOME = 1;
    private final int COL_ESPECIALIZACAO = 2;
    private final int COL_CARGA_HORARIA = 3;

    public TMCadProfessor(List<Professor> lstProfessores) {
        this.lista = lstProfessores;
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
        Professor aux = new Professor();
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
                case COL_ESPECIALIZACAO:
                    return aux.getEspecializacao();
                case COL_CARGA_HORARIA:
                    return aux.getCargaHoraria();
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
            case COL_ESPECIALIZACAO:
                return "Especialização";
            case COL_CARGA_HORARIA:
                return "Carga Horária";
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
