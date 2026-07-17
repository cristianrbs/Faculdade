
package notificacao;

import classes.Cliente;

public class ProcessadorPagamentoBoleto implements IProcessadorPagamento{
    
    @Override
    public void processarPagamento(Cliente c) {
        System.out.println("Processando pagamento por meio de boleto de " + c.getNome());
    }
}
