
package service;

import classes.Cliente;
import notificacao.IEnviadorMensagem;

public class ProcessadorMensagem {
    private IEnviadorMensagem enviador;
    
    // contrutor com parametro
    public ProcessadorMensagem(IEnviadorMensagem enviador) {
        this.enviador = enviador;
    }
    
    void processar(Cliente c, String mensagem){
        enviador.enviarMensagem(c, mensagem);
    }
}
