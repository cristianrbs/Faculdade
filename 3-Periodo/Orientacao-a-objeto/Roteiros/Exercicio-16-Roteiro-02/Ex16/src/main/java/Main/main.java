
package Main;

import Classes.Aeroporto;
import Classes.Passageiro;
import Classes.Voo;
import Classes.SistemaFidelidade;
import Gerentes.Gerenciador;


public class main {
    public static void main(String[] args) {
        Gerenciador gerencia = new Gerenciador();
        
        Aeroporto aeroporto = new Aeroporto("Aeroporto Internacional de Brasília", "Brasília");
        Voo voo1 = new Voo("BR001", "New York", 100, "Voando");
        Passageiro passageiro1 = new Passageiro("João Silva", "12345678900");

        // Adicionando escalas ao voo
        gerencia.adicionarEscalas("Miami");
        gerencia.adicionarEscalas("Orlando");

        gerencia.adicionarVoos(voo1);
        gerencia.adicionarPassageiros(passageiro1);

        // Passageiro acumula pontos após completar um voo
        passageiro1.getFidelidades().adicionarPontos(500);

        // Iniciar voo
        gerencia.iniciarVoo(voo1);

        // Verificar voos com prejuízo
        aeroporto.VoosComPrejuizo();
        }
   }

