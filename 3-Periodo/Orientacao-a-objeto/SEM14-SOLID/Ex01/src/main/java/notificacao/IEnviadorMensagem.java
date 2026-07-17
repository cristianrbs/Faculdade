
package notificacao;
import classes.Cliente;

public interface IEnviadorMensagem {
    void enviarMensagem(Cliente c, String mensagem);
}
