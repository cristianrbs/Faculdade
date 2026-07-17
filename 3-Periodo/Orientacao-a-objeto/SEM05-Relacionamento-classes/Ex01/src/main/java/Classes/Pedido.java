package Classes;

import java.util.ArrayList;
import java.util.List;


public class Pedido {
    private String numero;
    private String data;
    private double quantidade;
    private List<Produto> produto;
    
    //contrutor com parametro 
    public Pedido(String numero, String data, double quantidade, Produto produto) {
        this.numero = numero;
        this.data = data;
        this.quantidade = quantidade;
        this.produto = new ArrayList<>();
        this.produto.add(produto);
    }
    
    //construtor sem parametro
    public Pedido(){
        this.numero = "";
        this.data = "";
        this.quantidade = 0.0;
        this.produto = new ArrayList<>();
    }
    
    //metodo toString
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("Numero do pedido: ").append(this.numero).append("\n");
        sb.append("Data: ").append(this.data).append("\n");
        sb.append("Quantidade: ").append(this.quantidade).append("\n");
        
        for(int i = 0; i < produto.size(); i++){
            sb.append(produto.get(i).toString());
        }
        return sb.toString();
    }
    
    //contrutor de copia
    public Pedido(Pedido outro){
        this.numero = outro.getNumero();
        this.data = outro.getData();
        this.quantidade = outro.getQuantidade();
        
        this.produto = new ArrayList<>();
        for(Produto produto_i : outro.getProduto()){
            Produto novo = new Produto();
            novo.copiar(produto_i);
            this.produto.add(novo);
        }
    }
    
    //metodo copiar 
    public void copiar(Pedido outro){
        this.numero = outro.getNumero();
        this.data = outro.getData();
        this.quantidade = outro.getQuantidade();
        
        this.produto = new ArrayList<>();
        for(Produto produto_i : outro.getProduto()){
            Produto novo = new Produto();
            novo.copiar(produto_i);
            this.produto.add(novo);
        }
    }
    
    //metodo calcularTotal
    public double calcularTotal(){
        double total = 0;
        for(Produto p : produto){
            total+= p.getPreco();
        }
        return total;
    }
    
    //getters setters
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public List<Produto> getProduto() {
        return produto;
    }

    public void setProduto(List<Produto> produto) {
        this.produto = produto;
    }   
}
