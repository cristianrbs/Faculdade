package gerentes;

import classes.Medico;
import file.*;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorMedico {
    private List<Medico> medicos;
    private FilePersistence filePersistence;
    private SerializacaoCSVMedico serializador;

    public GerenciadorMedico(){
        this.medicos = new ArrayList<>();
        this.filePersistence = new FilePersistence();
        this.serializador = new SerializacaoCSVMedico();
    }

    public void adicionarMedico(Medico m){ 
        medicos.add(m); 
    }

    public boolean removerMedico(String crm){
        for (Medico m : medicos){
            if (m.getCrm().equals(crm)){
                medicos.remove(m);
                return true;
            }
        }
        return false;
    }

    public List<Medico> getMedicos(){
        return medicos; 
    }

    public void saveToFile(String caminho){
        filePersistence.saveToFile(caminho, serializador.toCSV(medicos));
    }

    public void loadFromFile(String caminho){
        medicos = serializador.fromCSV(filePersistence.loadFromFile(caminho));
    }
}