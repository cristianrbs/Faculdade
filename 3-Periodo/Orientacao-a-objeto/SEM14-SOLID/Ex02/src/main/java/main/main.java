
package main;

import classes.Cliente;
import notificacao.*;
import service.ServicoPagamento;

public class main {
    public static void main(String[] args) throws Exception{
        Cliente c1 = new Cliente("Oliveira", "32-7777-7777", "oliveira123@gmail.com");
        Cliente c2 = new Cliente("Carmo", "32-6666-6666", "carmo123@gmail.com");
        
        IProcessadorPagamento processarPag = new ProcessadorPagamentoCartao();
        processarPag.processarPagamento(c1);
        processarPag.processarPagamento(c2);
    }
}
