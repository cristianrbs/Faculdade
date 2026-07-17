package Classes;

public class Time {

    private String nome;
    private String cidade;
    private int anoFundacao;
    private Tecnico tecnico;

    // Construtor com parâmetros
    public Time(String nome, String cidade, int anoFundacao, Tecnico tecnico) {
        this.nome = nome;
        this.cidade = cidade;
        this.anoFundacao = anoFundacao;
        this.tecnico = tecnico;
    }

    // Construtor sem parâmetros
    public Time(){
        this.nome = "";
        this.cidade = "";
        this.anoFundacao = 0;
        this.tecnico = new Tecnico();
    }

    // Construtor de cópia
    public Time(Time outro) {
        this.nome = outro.getNome();
        this.cidade = outro.getCidade();
        this.anoFundacao = outro.getAnoFundacao();
        this.tecnico = new Tecnico(outro.getTecnico());
    }

    // Método copiar
    public void copiar(Time outro) {
        this.nome = outro.getNome();
        this.cidade = outro.getCidade();
        this.anoFundacao = outro.getAnoFundacao();
        this.tecnico = new Tecnico(outro.getTecnico());
    }

    // Escala um novo técnico
    public void escalarTecnico(Tecnico t) {
        this.tecnico = new Tecnico(t);
        System.out.println("Tecnico " + t.getNome() + " escalado para o " + this.nome + "!");
    }

    @Override
    public String toString() {
        String tecnicoInfo = (tecnico != null) ? tecnico.toString() : "Sem tecnico";
        return "Time{nome=" + nome +
               ", cidade=" + cidade +
               ", anoFundacao=" + anoFundacao +
               ", tecnico=" + tecnicoInfo + "}";
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getAnoFundacao() {
        return anoFundacao;
    }

    public void setAnoFundacao(int anoFundacao) {
        this.anoFundacao = anoFundacao;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    } 
}