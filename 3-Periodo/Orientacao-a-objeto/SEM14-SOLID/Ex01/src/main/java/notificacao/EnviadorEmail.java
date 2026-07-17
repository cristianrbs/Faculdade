
package notificacao;

import classes.Cliente;
        
public class EnviadorEmail implements IEnviadorMensagem {

    @Override
    public void enviarMensagem(Cliente c, String mensagem) {
        System.out.println("Enviando mensagem para " + c.getNome()
        + " por Email atraves do email " + c.getEmail()+ ": "
        + mensagem);
    }  
}
