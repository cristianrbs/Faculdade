
package notificacao;

import classes.Cliente;

public class ProcessadorPagamentoCartao implements IProcessadorPagamento {

    @Override
    public void processarPagamento(Cliente c) {
        System.out.println("Processando pagamento por meio do cratao de " + c.getNome());
    }
}
