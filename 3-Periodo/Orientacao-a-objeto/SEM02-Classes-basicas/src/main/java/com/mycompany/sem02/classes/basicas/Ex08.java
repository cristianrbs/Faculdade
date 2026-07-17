package com.mycompany.sem02.classes.basicas;
import Classes.Musica;


public class Ex08 {
    public static void main(String[] args) {

       Musica m1 = new Musica("Amigo", "Milton Nascimento", 3.5, 12.00);

        System.out.println(m1.toString());

        m1.tocarMusica();
        m1.desligarMusica();

        Musica m2 = new Musica();
        m2.copiar(m1);
        System.out.println("Cópia da música:");
        System.out.println(m2.toString());
    }
}

