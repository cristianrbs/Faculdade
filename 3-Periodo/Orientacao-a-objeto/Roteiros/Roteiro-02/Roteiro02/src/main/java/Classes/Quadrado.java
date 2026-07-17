package Classes;
import classes.Ponto;
import java.util.Scanner;

public class Quadrado {
    private Ponto p1, p2, p3, p4;
    
    public Quadrado(){
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }
    
    public void fill(){
    Scanner ler = new Scanner(System.in);

    System.out.print("Digite o x do ponto 1: ");
    double x1 = ler.nextDouble();
    System.out.print("Digite o y do ponto 1: ");
    double y1 = ler.nextDouble();
    p1 = new Ponto(x1, y1);

    System.out.print("Digite o x do ponto 2: ");
    double x2 = ler.nextDouble();
    System.out.print("Digite o y do ponto 2: ");
    double y2 = ler.nextDouble();
    p2 = new Ponto(x2, y2);

    System.out.print("Digite o x do ponto 3: ");
    double x3 = ler.nextDouble();
    System.out.print("Digite o y do ponto 3: ");
    double y3 = ler.nextDouble();
    p3 = new Ponto(x3, y3);

    System.out.print("Digite o x do ponto 4: ");
    double x4 = ler.nextDouble();
    System.out.print("Digite o y do ponto 4: ");
    double y4 = ler.nextDouble();
    p4 = new Ponto(x4, y4);
    }
    
    public void imprimir(){
        System.out.println("  P1: (" + p1.getX() + ", " + p1.getY() + ")");
        System.out.println("  P2: (" + p2.getX() + ", " + p2.getY() + ")");
        System.out.println("  P3: (" + p3.getX() + ", " + p3.getY() + ")");
        System.out.println("  P4: (" + p4.getX() + ", " + p4.getY() + ")");
    }
    
    public double distancia(Ponto a, Ponto b){
        double distancia =  Math.sqrt(Math.pow(b.getX() - a.getX(), 2) + Math.pow(b.getY() - a.getY(), 2));
        return distancia;
    }
    
    public double area(){
        double lado = distancia(p1,p2);
        double area = lado * lado;
        return area;
    }
    
    public double perimetro(){
        double perimetro = distancia(p1,p2) * 4;
        return perimetro;
    }
    
    public boolean isQuadrado(){
        double lado1 = distancia(p1, p2);
        double lado2 = distancia(p2, p3);
        double lado3 = distancia(p3, p4);
        double lado4 = distancia(p4, p1);

        double diagonal1 = distancia(p1, p3);
        double diagonal2 = distancia(p2, p4);

        boolean ladosIguais = false;
        if((lado1 == lado2) && (lado2 == lado3) && (lado3 == lado4)){
            ladosIguais = true;
        }
        
        boolean diagonaisIguais = false;
        if(diagonal1 == diagonal2){
            diagonaisIguais = true;
        }

        boolean anguloReto = false;
        if(Math.round(Math.pow(diagonal1, 2)) == Math.round(Math.pow(lado1, 2) + Math.pow(lado2, 2))){
            anguloReto = true;
        }
        return ladosIguais && diagonaisIguais && anguloReto;
    }

    public Ponto getP1(){
        return p1;
    }

    public void setP1(Ponto p1){
        this.p1 = p1;
    }

    public Ponto getP2(){
        return p2;
    }

    public void setP2(Ponto p2){
        this.p2 = p2;
    }

    public Ponto getP3(){
        return p3;
    }

    public void setP3(Ponto p3) {
        this.p3 = p3;
    }

    public Ponto getP4() {
        return p4;
    }

    public void setP4(Ponto p4) {
        this.p4 = p4;
    }
}
