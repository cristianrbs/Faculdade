package classes;
import classes.Ponto;

public class Triangulo {
    
    private Ponto p1;
    private Ponto p2;
    private Ponto p3;
    
    public Triangulo(){
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public Triangulo(Ponto p1, Ponto p2, Ponto p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }
    
    public void imprimir(){
        System.out.println("Os Pontos são:");
        System.out.println("Ponto A: " + p1);
        System.out.println("Ponto B: " + p2);
        System.out.println("Ponto C: " + p3);
    }
    
    public boolean isColinear(Ponto pB, Ponto pC){
        if(p1.Determinante(pB, pC) == 0){
            return true;
        }else{
            return false;
        }
    }
    
    public double perimetro(){
        
        if(isColinear(p2, p3)){
            System.out.println("Não tem Perímetro.");
            return 0;
        }
        
        double distAB = p1.distanciaDoisPontos(p2);
        double distBC = p2.distanciaDoisPontos(p3);
        double distAC = p3.distanciaDoisPontos(p1);
        
        return distAB + distBC + distAC;
    }
    
    public String tipo(){
        
        if(isColinear(p2, p3)){
            return "Não é um Triângulo!";
        }
        
        double distAB = p1.distanciaDoisPontos(p2);
        double distBC = p2.distanciaDoisPontos(p3);
        double distAC = p3.distanciaDoisPontos(p1);
        
        if(distAB == distBC && distBC == distAC){
            return "Equilátero";
        }else if(distAB == distBC || distBC == distAC){
            return "Isósceles";
        }else{
            return "Escaleno";
        }
    }
    
    public double area(Ponto pB, Ponto pC){
        double det = p1.Determinante(pB, pC);
        
        double areaTriang = 0.0;
        if(det != 0){
            areaTriang = Math.abs(det)/2.0;
        }
        return areaTriang;
    }
}
