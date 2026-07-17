package Classes;

public class Tecnico {

    private String nome;
    private String nacionalidade;
    private int anoNascimento;

    // Construtor com parâmetros
    public Tecnico(String nome, String nacionalidade, int anoNascimento) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.anoNascimento = anoNascimento;
    }

    // Construtor sem parâmetros
    public Tecnico() {
        this.nome = "";
        this.nacionalidade = "";
        this.anoNascimento = 0;
    }

    // Construtor de cópia
    public Tecnico(Tecnico outro) {
        this.nome = outro.getNome();
        this.nacionalidade = outro.getNacionalidade();
        this.anoNascimento = outro.getAnoNascimento();
    }

    // Método copiar
    public void copiar(Tecnico outro) {
        this.nome = outro.getNome();
        this.nacionalidade = outro.getNacionalidade();
        this.anoNascimento = outro.getAnoNascimento();
    }

    @Override
    public String toString() {
        return "Tecnico{nome=" + nome +
               ", nacionalidade=" + nacionalidade +
               ", anoNascimento=" + anoNascimento + "}";
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    } 
}