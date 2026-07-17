package Classes;

public class Musica {

    private String titulo;
    private String artista;
    private int duracao;
    private double preco;

    //construtor com parametro
    public Musica(String titulo, String artista, int duracao, double preco) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracao = duracao;
        this.preco = preco;
    }
    

    //construtor sem parametro
    public Musica(){
        this.titulo = "";
        this.artista = "";
        this.duracao = 0;
    }
    //metodo copiar
    public void copiar(Musica outro){
        this.artista = outro.getArtista();
        this.duracao = outro.getDuracao();
        this.titulo = outro.getTitulo();
    }

    //toString
    @Override
    public String toString() {
        return "Musica{" + "titulo=" + titulo 
                + ", artista=" + artista 
                + ", duracao=" + duracao 
                + ", preco=" + preco + '}';
    }
        

    //getter e setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}