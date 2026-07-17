
package main;

import classes.Cliente;
import notificacao.*;
import service.ProcessadorMensagem;

public class main {
    public static void main(String[] args) throws Exception{
        Cliente c1 = new Cliente("Cristian", "32-9999-9999", "cristian123@gmail.com");
        Cliente c2 = new Cliente("Rubens", "32-8888-8888", "rubens123@gmail.com");
        
        IEnviadorMensagem  enviador = new EnviadorEmail();
        enviador.enviarMensagem(c1, "sua compra foi realizada com sucesso");
        enviador.enviarMensagem(c2, "sua compra foi realizada com sucesso");
    }
}
