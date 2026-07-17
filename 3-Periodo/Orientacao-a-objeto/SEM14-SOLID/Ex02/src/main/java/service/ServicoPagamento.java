
package service;

import classes.Cliente;
import notificacao.IProcessadorPagamento;

public class ServicoPagamento {
    private IProcessadorPagamento processadorPag;
    
    //contrutor com parametro
    public ServicoPagamento(IProcessadorPagamento processadorPag) {
        this.processadorPag = processadorPag;
    }
    
    void realizarPagamento(Cliente c){
        processadorPag.processarPagamento(c);
    }
}
