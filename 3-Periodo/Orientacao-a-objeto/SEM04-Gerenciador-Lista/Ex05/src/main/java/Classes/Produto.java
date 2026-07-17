package Classes;
import java.util.Scanner;
import java.util.Objects;

public class Produto {
    private String codigoProduto;
    private String nomeProduto;
    private int quantidadeEmEstoque;

    public Produto(String codigoProduto, String nomeProduto, int quantidadeEmEstoque) {
        this.codigoProduto = codigoProduto;
        this.nomeProduto = nomeProduto;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }
    
    public Produto(){
        this.codigoProduto = "";
        this.nomeProduto = "";
        this.quantidadeEmEstoque = 0;
    }
    
    public void fill(){
        Scanner ler  = new Scanner(System.in);
        
        System.out.print("Codigo do produto : ");
        this.codigoProduto = ler.nextLine();

        System.out.print("Nome do produto: ");
        this.nomeProduto = ler.nextLine();

        System.out.print("Quantidade em estoque");
        this.quantidadeEmEstoque = ler.nextInt();
    }

    @Override
    public String toString() {
        return "Produto{" + "codigoProduto=" + codigoProduto + ", nomeProduto=" + nomeProduto + ", quantidadeEmEstoque=" + quantidadeEmEstoque + '}';
    }
    

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }
    
    public void copiar(Produto outro){
        this.codigoProduto = outro.getCodigoProduto();
        this.nomeProduto = outro.getNomeProduto();
        this.quantidadeEmEstoque = outro.getQuantidadeEmEstoque();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.codigoProduto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (this.codigoProduto != other.codigoProduto) {
            return false;
        }
        if (this.quantidadeEmEstoque != other.quantidadeEmEstoque) {
            return false;
        }
        return Objects.equals(this.nomeProduto, other.nomeProduto);
    }
    
}
