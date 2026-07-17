package Classes;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorMusica {

    private List<Musica> musicas;
    private FilePersistence filePersistence;
    private SerializadorCSVMusica serializador;

    public GerenciadorMusica(){
        this.musicas = new ArrayList<>();
        this.filePersistence = new FilePersistence();
        this.serializador = new SerializadorCSVMusica();
    }

    //metodo adicioanr musica
    public void adicionarMusica(Musica musica){
        musicas.add(musica);
        System.out.println("Musica adicionada: " + musica.getTitulo());
    }

    //metodo remover musica
    public boolean removerMusica(String titulo){
        for (Musica m : musicas){
            if (m.getTitulo().equalsIgnoreCase(titulo)){
                musicas.remove(m);
                System.out.println("Musica removida: " + titulo);
                return true;
            }
        }
        System.out.println("Musica nao encontrada: " + titulo);
        return false;
    }

    //metodo buscar musica
    public Musica buscarMusica(String titulo){
        for (Musica m : musicas){
            if (m.getTitulo().equalsIgnoreCase(titulo)){
                return m;
            }
        }
        System.out.println("Musica nao encontrada: " + titulo);
        return null;
    }

    //metodo atualizar musica
    public void atualizarMusica(String tituloAtual, Musica musicaNova){
        for (int i = 0; i < musicas.size(); i++){
            if (musicas.get(i).getTitulo().equalsIgnoreCase(tituloAtual)){
                musicas.set(i, musicaNova);
                System.out.println("Musica atualizada: " + tituloAtual);
                return;
            }
        }
        System.out.println("Musica nao encontrada: " + tituloAtual);
    }

    //metodo salar no arquivo
    public void salvarNoArquivo(String caminhoDoArquivo){
        String csv = serializador.toCSV(musicas);
        filePersistence.salvar(caminhoDoArquivo, csv);
    }

    //metodo carregar do arquivo
    public void carregarDoArquivo(String caminhoDoArquivo){
        String csv = filePersistence.carregar(caminhoDoArquivo);
        musicas = serializador.fromCSV(csv);
        System.out.println("Musicas carregadas do arquivo: " + caminhoDoArquivo);
    }

    //toString
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de Musicas");
        
        for (Musica m : musicas){
            sb.append(m).append("\n");
        }
        return sb.toString();
    }
}