
package notificacao;

import classes.Cliente;

public class EnviadorTelegram implements IEnviadorMensagem {

    @Override
    public void enviarMensagem(Cliente c, String mensagem) {
        System.out.println("Enviando mensagem para " + c.getNome()
        + " por Telegram atraves do numero de telefone " + c.getTelefone() + ": "
        + mensagem);
    }  
}
