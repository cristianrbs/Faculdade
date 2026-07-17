package main;

import Classes.GerenciadorMusica;
import Classes.Musica;

public class Main {

    public static void main(String[] args) {
        testeSerializacaoJSONMusica();
    }

    public static void testeSerializacaoJSONMusica() {

        GerenciadorMusica gerenciadorMusica = new GerenciadorMusica();

        Musica musica1 = new Musica("Bohemian Rhapsody", "Queen", 354, 1.29);
        Musica musica2 = new Musica("Menino da porteira", "Sergio Reis", 245, 1.15);
        Musica musica3 = new Musica("Amigo", "Milton Nascimento", 270, 0.99);

        gerenciadorMusica.adicionarMusica(musica1);
        gerenciadorMusica.adicionarMusica(musica2);
        gerenciadorMusica.adicionarMusica(musica3);

        System.out.println("Lista antes de salvar");
        System.out.println(gerenciadorMusica);


        String caminhoDoArquivo = "musicas.json";
        gerenciadorMusica.salvarNoArquivo(caminhoDoArquivo);


        System.out.println("Carregando do arquivo");
        gerenciadorMusica.carregarDoArquivo(caminhoDoArquivo);

        System.out.println("Lista apos carregar do arquivo");
        System.out.println(gerenciadorMusica);
    }
}