package Classes;
import java.util.Scanner;

public class Musica{
    private String titulo;
    private String artista;
    private double duracao;
    private double preco;
    
    public Musica(String titulo, String artista, double duracao, double preco){
        this.titulo = titulo;
        this.artista = artista;
        this.duracao = duracao;
        this.preco = preco;
    }
    
    public Musica(){
        this.titulo = "";
        this.artista = "";
        this.duracao = 0.0;
        this.preco = 0.0;
    }
    public void preencher(){
        Scanner ler = new Scanner(System.in);
        
        System.out.println("Preencha os dados da musica: ");
        
        System.out.print("Digite o nome da musica: ");
        this.titulo = ler.next();
        System.out.print("Digite o nome do artista da musica: ");
        this.artista = ler.next();
        System.out.print("Digite o tempo de duracao: ");
        this.duracao = ler.nextDouble();
        System.out.print("Digite o valor da musica: ");
        this.preco = ler.nextDouble();
    
    }
    
    

    @Override
    public String toString(){
        return "Musica {Titulo:  " + this.titulo 
                + ", Artista: " + this.artista 
                + ",  Duração: " + this.duracao 
                + ", Preco: " + this.preco + "}";
    }
    
        public void tocarMusica(){
            System.out.print("A musica " + this.titulo + " esta tocando!");
        }
        public void desligarMusica(){
            System.out.print("O titulo " + this.titulo + " foi interrompido.");
        }
        
        public void setTitulo(String titulo){
            this.titulo = titulo;
        }
        public String getTitulo(){
            return this.titulo;
        }
        
        public void setArtista(String artista){
            this.artista = artista;
        }
        public String getArtista(){
            return this.artista;
        }
        
        public void setDuracao(double duracao){
            this.duracao = duracao;
        }
        public double getDuracao(){
            return this.duracao;
        }
        
        public void setPreco(double preco){
            this.preco = preco;
        }
        public double getPreco(){
            return this.preco;
        }     

    public void copiar(Musica outro){
        this.titulo = outro.getTitulo();
        this.artista = outro.getArtista();
        this.duracao = outro.getDuracao();
        this.preco = outro.getPreco();
    }
}
