package Classes;

import java.util.ArrayList;
import java.util.List;

public class Gerenciador {

    private List<Artista> artistas;

    public Gerenciador(){
        this.artistas = new ArrayList<>();
    }

    //adicionar artista
    public void adicionarArtista(Artista artista){
        this.artistas.add(artista);
    }

    //artista com mais albuns
    public Artista artistaComMaisAlbuns(){
        Artista maior = null;
        for (Artista a : artistas){
            if (maior == null || a.getAlbuns().size() > maior.getAlbuns().size()){
                maior = a;
            }
        }
        return maior;
    }

    //album com mais musicas
    public Album albumComMaisMusicas(){
        Album maior = null;
        
        for (Artista a : artistas) {
            for (Album al : a.getAlbuns()){
                if (maior == null || al.getMusicas().size() > maior.getMusicas().size()){
                    maior = al;
                }
            }
        }
        return maior;
    }
}