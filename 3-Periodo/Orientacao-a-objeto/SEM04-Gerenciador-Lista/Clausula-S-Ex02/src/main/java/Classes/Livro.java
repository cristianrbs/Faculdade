
package Classes;


public class Livro {
    private String titulo;
    private String autor;
    private int paginas;
    public static String NomeDaBiblioteca;

    public Livro(String titulo, String autor, int paginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
        NomeDaBiblioteca = "Havard";
    }
    
    public Livro(){
        this.titulo = "";
        this.autor = "";
        this.paginas = 0;
        NomeDaBiblioteca = "Havard";
    }

    @Override
    public String toString() {
        return "Livro:" + "titulo=" + titulo + ", autor=" + autor + ", paginas=" + paginas + ", biblioteca=" + NomeDaBiblioteca;
    } 
}
