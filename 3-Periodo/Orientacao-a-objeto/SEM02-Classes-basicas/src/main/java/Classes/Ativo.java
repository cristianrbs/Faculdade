package Classes;
import java.util.Scanner;

public class Ativo {
    private String nomeEmpresa;
    private double precoAcao;
    private double qtdAcoes;
    private double variacaoDiaria;
    
    public Ativo(String nomeEmpresa, double precoAcao, double qtdAcoes, double variacaoDiaria){
        this.nomeEmpresa = nomeEmpresa;
        this.precoAcao = precoAcao;
        this.qtdAcoes = qtdAcoes;
        this.variacaoDiaria = variacaoDiaria;
    }
    
    public Ativo(){
        this.nomeEmpresa = "";
        this.precoAcao = 0.00;
        this.qtdAcoes = 0.00;
        this.variacaoDiaria = 0.00;
    }
    
    public void preencher(){
        Scanner ler = new Scanner(System.in);
        
        System.out.println("Preencha os dados do Ativo: ");
        
        System.out.print("Nome da Empresa: ");
        this.nomeEmpresa = ler.next();
        System.out.print("Preco da acao: ");
        this.precoAcao = ler.nextDouble();
        System.out.print("Quantidade de acoes: ");
        this.qtdAcoes = ler.nextDouble();
        System.out.print("Variacao diaria: ");
        this.variacaoDiaria = ler.nextDouble();
    }
    
    @Override
    public String toString(){
        return "Ativo {Nome da Empresa:  " + this.nomeEmpresa 
                + ", Preco da acao: " + this.precoAcao 
                + ",  Quantidade de acoes: " + this.qtdAcoes 
                + ", Variacao diaria: " + this.variacaoDiaria + "}";
    }
    
     public double calcularPosicaoDoAtivo() {
        double PosicaoDoAtivo = 0;
        PosicaoDoAtivo = this.precoAcao * this.qtdAcoes;
        return PosicaoDoAtivo;
    }
     
    public String exibirResumo() {
      return "Ativo {Nome da Empresa:  " + this.nomeEmpresa 
                + ", Preco da acao: " + this.precoAcao 
                + ",  Quantidade de acoes: " + this.qtdAcoes
                + ", Preco por m2: " + calcularPosicaoDoAtivo()
                + ", Variacao diaria: " + this.variacaoDiaria + "}";
                
    }
    
    //Setters
    public void setNomeEmpresa(String nomeEmpresa){
        this.nomeEmpresa = nomeEmpresa;
    }
    public void setPrecoAcao(double precoAcao){
        this.precoAcao = precoAcao;
    }
    public void setQtdAcao(double atdAcoes){
        this.qtdAcoes = qtdAcoes;
    }
    public void setVaricaoDiaria(double variacaoDiaria){
        this.variacaoDiaria = variacaoDiaria;
    }
    
    //Getters
    public String getNomeEmpresa(){
        return this.nomeEmpresa;
    }
    public double getPrecoAcao(){
        return this.precoAcao;
    }
    public double getQtdAcoes(){
        return this.qtdAcoes;
    }
    public double getVariacaiDiaria(){
        return this.variacaoDiaria;
    }
    
    public void copiar(Ativo outro){
        this.nomeEmpresa = outro.getNomeEmpresa();
        this.precoAcao = outro.getPrecoAcao();
        this.qtdAcoes = outro.getQtdAcoes();
        this.variacaoDiaria = outro.getVariacaiDiaria();
    }
}
