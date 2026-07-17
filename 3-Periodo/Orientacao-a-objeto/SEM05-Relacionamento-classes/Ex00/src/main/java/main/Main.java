package main;
import Classes.Carro;
import Classes.Motorista;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        
        Carro c1 = new Carro("Sedan" , 210, "Preto");
       
        Motorista motorista = new Motorista();
        motorista.setNome("Cristian");
        motorista.setCarro(c1);
        
        motorista.dirigir();
        
        
    }
}
