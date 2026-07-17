package file;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class FilePersistence {

    public void saveToFile(String texto, String filePath){
        try {
            FileWriter arq = new FileWriter(filePath);
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.print(texto);
            arq.close();
        } catch (Exception e){
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }

    public String loadFromFile(String filePath){
        String conteudoLido = "";
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("\\Z");
            while (scanner.hasNext()){
                conteudoLido += scanner.next();
            }
            scanner.close();
        } catch (Exception e){
            System.out.println("Erro ao carregar arquivo: " + e.getMessage());
        }
        return conteudoLido;
    }
}