package main;

import Classes.Banco;
import Classes.Conta;
import Classes.Transacao;

public class Main {
    public static void main(String[] args) {

        Banco banco = new Banco("Nubank");

        Conta conta1 = new Conta("1", "Cristian", 1500.0);
        Conta conta2 = new Conta("2", "Rubens", -300.0);

        
        banco.adicionar(conta1);
        banco.adicionar(conta2);
        
        Transacao t1 = new Transacao("01", "Deposito", 500.0, "2024-01-10", conta1);
        Transacao t2 = new Transacao("02", "Saque", 300.0, "2024-01-11", conta2);
        

        
        banco.adicionar(t1);
        banco.adicionar(t2);

        System.out.println("------------------------------");
        System.out.println("Contas do Banco");
        banco.listarContas();

        System.out.println("------------------------------");
        System.out.println("Transacoes do Banco");
        banco.listarTransacoes();

        System.out.println("------------------------------");
        System.out.println("Conta com maior saldo: " + banco.maiorSaldo().getTitular()
                + " | Saldo: " + banco.maiorSaldo().getSaldo());
        System.out.println("Conta com menor saldo: " + banco.menorSaldo().getTitular()
                + " | Saldo: " + banco.menorSaldo().getSaldo());

        System.out.println("------------------------------");
        System.out.println("Devedores e Credores");
        banco.totalDevedores();
        banco.totalCredores();

        System.out.println("------------------------------");
        System.out.println("Operacoes na Conta Cristian");
        conta1.deposito(200.0);
        System.out.println("Apos deposito de R$200: " + conta1.getSaldo());
        conta1.saque(100.0);
        System.out.println("Apos saque de R$100: " + conta1.getSaldo());

        System.out.println("------------------------------");
        System.out.println("Apos Remover Conta Rubens");
        banco.remover(conta2);
        banco.remover(t2);
        banco.listarContas();
    }
}