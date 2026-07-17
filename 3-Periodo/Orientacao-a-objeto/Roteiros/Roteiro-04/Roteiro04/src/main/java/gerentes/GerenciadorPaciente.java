package gerentes;

import classes.Paciente;
import file.*;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorPaciente {
    private List<Paciente> pacientes;
    private FilePersistence filePersistence;
    private SerializacaoCSVPaciente serializador;

    public GerenciadorPaciente(){
        this.pacientes = new ArrayList<>();
        this.filePersistence = new FilePersistence();
        this.serializador = new SerializacaoCSVPaciente();
    }

    public void adicionarPaciente(Paciente p){
        pacientes.add(p); 
    }

    public boolean removerPaciente(String cpf){
        for (Paciente p : pacientes){
            if (p.getCpf().equals(cpf)){
                pacientes.remove(p);
                return true;
            }
        }
        return false;
    }

    public List<Paciente> getPacientes(){ 
        return pacientes; 
    }

    public void saveToFile(String caminho){
        filePersistence.saveToFile(caminho, serializador.toCSV(pacientes));
    }

    public void loadFromFile(String caminho){
        pacientes = serializador.fromCSV(filePersistence.loadFromFile(caminho));
    }
}