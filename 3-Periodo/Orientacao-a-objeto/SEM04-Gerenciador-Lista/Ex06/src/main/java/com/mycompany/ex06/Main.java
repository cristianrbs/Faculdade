package com.mycompany.ex06;
import Classes.ControleDeEstoque;
import Classes.Produto;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ControleDeEstoque gerente = new ControleDeEstoque();
        Scanner ler = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("------------------------------");
            System.out.println("Gerenciador de Estoque");
            System.out.println("------------------------------");
            System.out.println("1. Adicionar produto");
            System.out.println("2. Remover produto");
            System.out.println("3. Atualizar quantidade");
            System.out.println("4. Listar produtos");
            System.out.println("5. Buscar produto");
            System.out.println("0. Sair");
            System.out.println("------------------------------");
            System.out.print("Escolha uma opcao: ");
            opcao = ler.nextInt();
            ler.nextLine();

            if (opcao == 1) {
                System.out.print("Codigo do produto: ");
                String codigoProduto = ler.nextLine();
                System.out.print("Nome do produto: ");
                String nomeProduto = ler.nextLine();
                System.out.print("Quantidade: ");
                int quantidadeEmEstoque = ler.nextInt();
                ler.nextLine();

                Produto novoProduto = new Produto();
                novoProduto.setCodigoProduto(codigoProduto);
                novoProduto.setNomeProduto(nomeProduto);
                novoProduto.setQuantidadeEmEstoque(quantidadeEmEstoque);
                gerente.adicionarProduto(novoProduto);

            } 
            else if (opcao == 2) {
                System.out.print("Codigo do produto para remover: ");
                String codigoProduto = ler.nextLine();
                gerente.removerProduto(codigoProduto);

            } 
            else if (opcao == 3) {
                System.out.print("Codigo do produto: ");
                String codigoProduto = ler.nextLine();
                System.out.print("Nova quantidade: ");
                int novaQuantidade = ler.nextInt();
                ler.nextLine();
                gerente.atualizarQuantidade(codigoProduto, novaQuantidade);

            } 
            else if (opcao == 4) {
                gerente.listarProdutos();

            } 
            else if (opcao == 5) {
                System.out.print("Codigo do produto a buscar: ");
                String codigoProduto = ler.nextLine();
                Produto encontrado = gerente.buscarProdutos(codigoProduto);
                System.out.println(encontrado);

            } 
            else if (opcao == 0) {
                System.out.println("Encerrado o sistema");

            } 
            else {
                System.out.println("Opcao invalida. Tente novamente.");
            }

        } 
        while (opcao != 0);
    }
}