package Classes;

import java.util.HashMap;
import Classes.Produto;
import java.util.Map;


public class ControleDeEstoque {
    private HashMap<String, Produto> estoque;
    
    public ControleDeEstoque(){
        this.estoque = new HashMap<>();
    }
    
    public void adicionarProduto(Produto produtos){
        String codigo = produtos.getCodigoProduto();
        
        if(estoque.containsKey(codigo)){
            System.out.println("Esse produto ja existe no estoque");
        }
        estoque.put(codigo,produtos);
        System.out.println("Produto adicionado");
    }
    
    public void removerProduto(String codigoProduto){
        for (Map.Entry<String, Produto> e : estoque.entrySet()) {
            String key = e.getKey();
            
            if(key.equals(codigoProduto)){
                estoque.remove(key);
                System.out.println("Produto removido");
            }
            System.out.println("Produto nao existe em estoque");
        }
    }
    
    public void atualizarQuantidade(String codigoProduto, int novaQuantidade){       
        Produto produtos = estoque.get(codigoProduto);
        
        if(estoque.containsKey(codigoProduto)){
            produtos.setQuantidadeEmEstoque(novaQuantidade);
            System.out.println("Quantidade atualizada"); 
        }
        System.out.println("produto nao existe em estoque");
    }
    
    public void listarProdutos(){
        if(estoque.isEmpty()){
            System.out.println("Estoque vazio");
        }
        for (Produto p : estoque.values()) {
                System.out.println(p);
            }
    }
    
    public Produto buscarProdutos(String codigoProduto){
        Produto produtos = estoque.get(codigoProduto);
        
        if(estoque.equals(codigoProduto)){
            return produtos;
        }
        return null;
    }
}
