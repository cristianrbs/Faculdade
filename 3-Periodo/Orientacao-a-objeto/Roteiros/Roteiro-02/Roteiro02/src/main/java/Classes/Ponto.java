package classes;

import java.util.Scanner;

public class Ponto {
    
    private double x;
    private double y;
    
    //Construtor
    public Ponto(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public Ponto(){
        this.x = 0.0;
        this.y = 0.0;
    }
    
    public void fill(){
        Scanner ler = new Scanner(System.in);
         System.out.print("Informe a coordenada no eixo Ox do ponto: ");
         this.x = ler.nextDouble();
         System.out.print("Informe a coordenada no eixo Oy do ponto: ");
         this.y = ler.nextDouble();
    }

    @Override
    public String toString() {
        return "Ponto[" + x + " , " + y + ']';
    }
    
    public double Determinante(Ponto pB, Ponto pC){
        
        double diagPrinc = this.x * pB.getY() 
                + this.y * pC.getX() 
                + pB.getX() * pC.getY();
        
        double diagSec = pB.getY() * pC.getX()
                + this.x * pC.getY()
                + this.y * pB.getX();
        
        double det = diagPrinc - diagSec;
        
        return det;
    }
    
    public double distanciaDoisPontos(Ponto outro){
        double distancia = 0.0;
        
        double dx = this.x - outro.getX();
        double dy = this.y - outro.getY();
        
        distancia = Math.sqrt(dx*dx + dy*dy);
        return distancia;
    }
    
    //Getters e Setters
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}