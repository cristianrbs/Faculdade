package main;

import Classes.Tecnico;
import Classes.Time;
import java.util.Scanner;

public class Main{

    public static Time criarTime(Scanner ler) {
        Time time = new Time();

        System.out.print("Nome do time: ");
        time.setNome(ler.nextLine());

        System.out.print("Cidade: ");
        time.setCidade(ler.nextLine());

        System.out.print("Ano de fundação: ");
        time.setAnoFundacao(ler.nextInt());
        ler.nextLine();

        Tecnico t = new Tecnico();
        System.out.print("Nome do técnico: ");
        t.setNome(ler.nextLine());

        System.out.print("Nacionalidade do técnico: ");
        t.setNacionalidade(ler.nextLine());

        System.out.print("Ano de nascimento do técnico: ");
        t.setAnoNascimento(ler.nextInt());
        ler.nextLine();

        time.escalarTecnico(t);
        return time;
    }

    public static void main(String[] args){

        Tecnico t1 = new Tecnico("Dorival Junior", "Brasileiro", 1962);
        Tecnico t2 = new Tecnico("Abel Ferreira", "Portugues", 1978);

        Time time1 = new Time("Flamengo", "Rio de Janeiro", 1895, t1);
        time1.escalarTecnico(t1);

        Time time2 = new Time("Palmeiras", "Sao Paulo", 1914, t2);
        time2.escalarTecnico(t2);

        System.out.println("------------------------------");
        System.out.println(time1);
        System.out.println(time2);

        
        Tecnico t3 = new Tecnico("Tite", "Brasileiro", 1961);
        time1.escalarTecnico(t3);

        System.out.println("------------------------------");
        System.out.println("Depois da troca:");
        System.out.println(time1);
        System.out.println(time2); 

        
        Scanner leitor = new Scanner(System.in);
        System.out.println("------------------------------");
        System.out.println("Cadastrar novo time");
        Time time3 = criarTime(leitor);
        System.out.println(time3);
    }
}