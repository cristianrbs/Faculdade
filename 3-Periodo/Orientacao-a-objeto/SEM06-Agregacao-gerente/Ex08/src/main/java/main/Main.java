package main;

import Classes.Artista;
import Classes.Album;
import Classes.Musica;
import Classes.Gerenciador;

public class Main {
    public static void main(String[] args) {

        Artista artista1 = new Artista("kayblack");
        Album album1 = new Album("Misterioa", 2024);
        Album album2 = new Album("Contradicoes", 2023);

        artista1.adicionarAlbum(album1);
        artista1.adicionarAlbum(album2);

        Musica musica1 = new Musica("Segredo", 1.44);
        Musica musica2 = new Musica("Melhor so", 3.49);

        artista1.adicionarMusica("FKAY", musica1);
        artista1.adicionarMusica("FKAY", musica2);

        Gerenciador gerenciador = new Gerenciador();
        gerenciador.adicionarArtista(artista1);

        Artista artistaComMaisAlbuns = gerenciador.artistaComMaisAlbuns();
        System.out.println("Artista com mais álbuns: " + artistaComMaisAlbuns.getNome());

        Album albumComMaisMusicas = gerenciador.albumComMaisMusicas();
        System.out.println("Álbum com mais músicas: " + albumComMaisMusicas.getNome());

        System.out.println("------------------------------");
        System.out.println("Detalhes");
        System.out.println(artista1);
    }
}