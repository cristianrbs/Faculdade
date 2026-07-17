package Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Artista {

    private String nome;
    private List<Album> albuns;

    //construtor com parâmetros
    public Artista(String nome){
        this.nome = nome;
        this.albuns = new ArrayList<>();
    }

    //construtor sem parametro
    public Artista(){
        this.nome = "";
        this.albuns = new ArrayList<>();
    }

    //metodo copiar
    public void copiar(Artista outro){
        this.nome = outro.getNome();
        this.albuns = new ArrayList<>();
        
        for (Album a : outro.getAlbuns()){
            Album novo = new Album();
            novo.copiar(a);
            this.albuns.add(novo);
        }
    }

    //adicionar album
    public void adicionarAlbum(Album albumNovo){
        this.albuns.add(albumNovo);
    }

    //metodo musica a um album especifico pelo nome
    public void adicionarMusica(String nomeAlbum, Musica musica) {
        for (Album a : albuns){
            if (a.getNome().equalsIgnoreCase(nomeAlbum)){
                a.adicionarMusica(musica);
                return;
            }
        }
        System.out.println("Álbum " + nomeAlbum + " não encontrado.");
    }

    //metodo imprimir
    public void imprimir(){
        System.out.println(this);
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Artista{nome = ").append(nome).append(", albuns = ").append("\n");
        for (int i = 0; i < albuns.size(); i++) {
            sb.append(albuns.get(i).toString());
        }
        return sb.toString();
    }

    //getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Album> getAlbuns() {
        return albuns;
    }

    public void setAlbuns(List<Album> albuns) {
        this.albuns = albuns;
    }
    
    //equals e hashcode

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Artista other = (Artista) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return Objects.equals(this.albuns, other.albuns);
    }
}