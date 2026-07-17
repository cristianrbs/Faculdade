package Classes;
import java.util.Scanner;

public class Casa{
    private String endereco;
    private double area;
    private int num_quartos;
    private double preco;
    
    public Casa(String endereco, double area, int num_quartos, double preco){
        this.endereco = endereco;
        this.area = area;
        this.num_quartos = num_quartos;
        this.preco = preco;
    }
    
    public Casa(){
        this.endereco = "";
        this.area = 0.00;
        this.num_quartos = 0;
        this.preco = 0.00;
    }
    
    public void preencher(){
        Scanner ler = new Scanner(System.in);
        
        System.out.println("Preencha os dados da casa: ");
        System.out.print("Endereco: ");
        this.endereco = ler.next();
        System.out.print("Area: ");
        this.area = ler.nextInt();
        System.out.print("Numero de quartos: ");
        this.num_quartos = ler.nextInt();
        System.out.print("Preco: ");
        this.preco = ler.nextDouble();
    }
    
    @Override
    public String toString(){
        return "Casa {Endereco:  " + this.endereco 
                + ", Area: " + this.area 
                + ",  Numero de quartos: " + this.num_quartos 
                + ", Preco: " + this.preco + "}";
    }
    
    public double calcularPrecoPorM2(){
        double precoPorM2 = 0;
        
        precoPorM2 = this.area / this.preco;
        
        return precoPorM2;
    }
    
    public String exibirResumo() {
      return "Casa {Endereco:  " + this.endereco 
                + ", Area: " + this.area 
                + ",  Numero de quartos: " + this.num_quartos
                + ", Preco por m2: " + calcularPrecoPorM2()
                + ", Preco: " + this.preco + "}";
                
    }
    
    //Setters
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    public void setArea(double area){
        this.area = area;
    }
    public void setNum_quartos(int num_quartos){
        this.num_quartos = num_quartos;
    }
    public void setPreco(double preco){
        this.preco = preco;
    }
    
    //Getters
    public String getEndereco(){
        
        return this.endereco;
    }
    public double getArea(){
        return this.area;
    }
    public int getNum_quartos(){
        return this.num_quartos;
    }
    public double getPreco(){
        return this.preco;
    }
    
    public void copiar(Casa outro){
        this.endereco = outro.getEndereco();
        this.area = outro.getArea();
        this.num_quartos = outro.getNum_quartos();
        this.preco = outro.getPreco();
    }
}
