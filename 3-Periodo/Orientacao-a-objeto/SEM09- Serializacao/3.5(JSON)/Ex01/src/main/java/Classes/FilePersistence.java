package Classes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilePersistence {

    //metodo salvar
    public void salvar(String caminho, String conteudo){
        try {
            Files.writeString(Paths.get(caminho), conteudo);
            System.out.println("Arquivo salvo em: " + caminho);
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }

    //metodo carregar
    public String carregar(String caminho){
        try {
            return Files.readString(Paths.get(caminho));
        } catch (IOException e) {
            System.out.println("Erro ao carregar arquivo: " + e.getMessage());
            return "";
        }
    }
}