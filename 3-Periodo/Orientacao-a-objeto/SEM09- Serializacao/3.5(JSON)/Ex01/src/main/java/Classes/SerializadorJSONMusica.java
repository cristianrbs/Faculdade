package Classes;

import java.util.ArrayList;
import java.util.List;

public class SerializadorJSONMusica {

    //metodo toJSON
    public String toJSON(List<Musica> musicas){
        StringBuilder sb = new StringBuilder();
        sb.append("\n");

        for (int i = 0; i < musicas.size(); i++){
            Musica m = musicas.get(i);
            sb.append("  {\n");
            sb.append("    \"titulo\": \"").append(m.getTitulo()).append("\",\n");
            sb.append("    \"artista\": \"").append(m.getArtista()).append("\",\n");
            sb.append("    \"duracao\": ").append(m.getDuracao()).append(",\n");
            sb.append("    \"preco\": ").append(m.getPreco()).append("\n");
            sb.append("  }");

            if (i < musicas.size() - 1){
                sb.append(",");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    //metodo fromJSON
    public List<Musica> fromJSON(String data){
        List<Musica> musicas = new ArrayList<>();
        String[] blocos = data.split("\\{");

        for (int i = 1; i < blocos.length; i++){
            String bloco = blocos[i];

            String titulo = extrairValor(bloco, "titulo");
            String artista = extrairValor(bloco, "artista");
            int duracao = Integer.parseInt(extrairValor(bloco, "duracao"));
            double preco = Double.parseDouble(extrairValor(bloco, "preco"));

            musicas.add(new Musica(titulo, artista, duracao, preco));
        }
        return musicas;
    }

    //metodo extrair valor
    private String extrairValor(String bloco, String campo){
        String chave = "\"" + campo + "\":";
        int inicio = bloco.indexOf(chave) + chave.length();
        int fim = bloco.indexOf("\n", inicio);
        return bloco.substring(inicio, fim)
                    .replace("\"", "")
                    .replace(",", "")
                    .trim();
    }
}