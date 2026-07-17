package Classes;

public class Motorista {
    private String nome;
    private Carro carro;

    //contrutor com parametro
    public Motorista(String nome, Carro carro) {
        this.nome = nome;
        this.carro = carro;
    }

    //construtor sem parametro
    public Motorista(){
        this.nome = "";
        this.carro = new Carro();
    }
    
    //metodo StringBuilde

    @Override
    public String toString() {
        return "Motorista{" + "nome=" + nome + ", carro=" + carro + '}';
    }
    
    //metodo dirigir
    public  void dirigir(){
        System.out.println("Digirindo o carro");
         carro.buzinar();
         carro.abrirPorta();
    }

    //getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    } 
}


