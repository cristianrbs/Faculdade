package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FilePersistence {

    public void saveToFile(String texto, String filePath) {
        try {
            FileWriter arq = new FileWriter(filePath);
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.print(texto);
            gravarArq.close();
            arq.close();
        } catch (IOException ex) {
            Logger.getLogger(FilePersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String loadFromFile(String filePath) {
        String conteudoLido = "";
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file, "UTF-8");

            scanner.useDelimiter("\\Z"); // lê até o final do arquivo
            while (scanner.hasNext()) {
                conteudoLido += scanner.next();
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FilePersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conteudoLido;
    }
}
