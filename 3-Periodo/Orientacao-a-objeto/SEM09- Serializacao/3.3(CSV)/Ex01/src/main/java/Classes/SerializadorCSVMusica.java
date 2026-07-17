package Classes;

import java.util.ArrayList;
import java.util.List;

public class SerializadorCSVMusica {

    //metodo toCSV
    public String toCSV(List<Musica> musicas){
        StringBuilder sb = new StringBuilder();
        sb.append("titulo;artista;duracao;preco");

        for (Musica m : musicas){
            sb.append("Titulo: ").append(m.getTitulo()).append("\n");
            sb.append("Artista: ").append(m.getArtista()).append("\n");
            sb.append("Duracao: ").append(m.getDuracao()).append("\n");
            sb.append("Preco: ").append(m.getPreco()).append("\n");
        }
        return sb.toString();
    }

    //metodo fromCSV
    public List<Musica> fromCSV(String data){
        List<Musica> musicas = new ArrayList<>();
        String[] linhas = data.split("\n");

        for (int i = 1; i < linhas.length; i++){ 
            String linha = linhas[i].trim();
            if (linha.isEmpty()) continue;

            String[] campos = linha.split(";");
            String titulo = campos[0];
            String artista = campos[1];
            int duracao = Integer.parseInt(campos[2]);
            double preco = Double.parseDouble(campos[3]);

            musicas.add(new Musica(titulo, artista, duracao, preco));
        }
        return musicas;
    }
}