package classes;
import java.util.Scanner;


public class Filme{
    private String titulo;
    private String diretor;
    private double duracao;
    private double preco;
    
    public Filme(){
        this.titulo = "";
        this.diretor = "";
        this.duracao = 0.0;
        this.preco = 0.0;
    }
    public void preencher(){
        
        Scanner ler = new Scanner(System.in);
        
        System.out.println("Preencha os dados do filme: ");
        
        System.out.print("Digite o título do filme: ");
        this.titulo = ler.next();
        System.out.print("Digite o nome do diretor: ");
        this.diretor = ler.next();
        System.out.print("Digite o tempo de duração: ");
        this.duracao = ler.nextDouble();
        System.out.print("Digite o preço do filme: ");
        this.preco = ler.nextDouble();
    
}
    public void copiar(Filme outra){
        this.titulo = outra.getTitulo();
        this.diretor = outra.getDiretor();
        this.duracao = outra.getDuracao();
        this.preco = outra.getPreco();
    }
    
   
    @Override
    public String toString(){
        return "Filme {Titulo:  " + this.titulo 
                + ", Diretor: " + this.diretor 
                + ",  Duração: " + this.duracao 
                + ", Preço: " + this.preco + "}";
    }
            
        public void setTitulo(String titulo){
            this.titulo = titulo;
        }
        public String getTitulo(){
            return this.titulo;
        }
        
        public void setDiretor(String diretor){
            this.diretor = diretor;
        }
        public String getDiretor(){
            return this.diretor;
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
        
}