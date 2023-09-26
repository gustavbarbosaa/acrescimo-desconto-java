package org.example;

import org.example.carrinho.Carrinho;
import org.example.estoque.Estoque;
import org.example.itens.Itens;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class Main {
    private static void inserirItemCarrinho(@NotNull Carrinho carrinho, Estoque itensEstoque) {
         carrinho.adicionarItemAoCarrinho(itensEstoque);
    }

    private static void acrescimoDeItem(Itens item, @NotNull Carrinho carrinho) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o codigo do item a ser feito o acrescimo: ");
        int codigoItem = scanner.nextInt();

        for (Itens valor : carrinho.getCarrinho()) {
            if (codigoItem == valor.getCodigo()) {
                double valorAcrescido = item.adicionaAcrescimoValor();
                valor.setAcrescimo(valorAcrescido);
                valor.setValor(valor.getValor() + valorAcrescido);
                System.out.println(valor);
            } else {
                System.out.println("Item não se encontra no carrinho");
            }
        }
    }

    private static void descontoDeItem(Itens item, @NotNull Carrinho carrinho) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o codigo do item a ser feito o desconto: ");
        int codigoItem = scanner.nextInt();

        for (Itens valor : carrinho.getCarrinho()) {
            if (codigoItem == valor.getCodigo()) {
                double valorDesconto = item.adicionaDescontoValor();
                valor.setDesconto(valorDesconto);
                valor.setValor(valor.getValor() - valorDesconto);
                System.out.println(valor);
            } else {
                System.out.println("Item não se encontra no carrinho");
            }
        }
    }

    private static void acrescimoTotal(@NotNull Carrinho carrinho) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um valor total para ser dividido de forma igual e somado entre todos os itens do estoque: ");
        double valorTotalAcrescido = scanner.nextDouble();
        double valorPorItem = valorTotalAcrescido / carrinho.getCarrinho().size();

        for (Itens valor : carrinho.getCarrinho()) {
            valor.setValor(valor.getValor() + valorPorItem);
        }
        System.out.println(carrinho.getCarrinho());
    }

    private static void descontoTotal(@NotNull Carrinho carrinho) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um valor total para ser dividido de forma igual e subtraido entre todos os itens do estoque: ");
        double valorTotalDescontado = scanner.nextDouble();
        double valorPorItem = valorTotalDescontado / carrinho.getCarrinho().size();

        for (Itens valor : carrinho.getCarrinho()) {
            valor.setValor(valor.getValor() - valorPorItem);
        }
        System.out.println(carrinho.getCarrinho());
    }

    private static void somaTotalDosItensDoCarrinho(@NotNull Carrinho carrinho) {
        double somaTotalDosItensDoCarrinho = 0;

        for (Itens valor : carrinho.getCarrinho()) {
            double somaDoValorGeral = valor.getValor() + valor.getAcrescimo() - valor.getDesconto();

            somaTotalDosItensDoCarrinho += somaDoValorGeral;
        }
        System.out.println("Valor da soma total de itens do carrinho: " + somaTotalDosItensDoCarrinho);
    }

    private static void somaTotalDosAcrescimosDoCarrinho(@NotNull Carrinho carrinho) {
        double somaTotalDosAcrescimosDoCarrinho = 0;

        for (Itens valor : carrinho.getCarrinho()) {
            double somaDoValorGeral = valor.getAcrescimo();

            somaTotalDosAcrescimosDoCarrinho += somaDoValorGeral;
        }
        System.out.println("Valor da soma total dos acrescimos do carrinho: " + somaTotalDosAcrescimosDoCarrinho);
    }

    private static void somaTotalDosDescontosDoCarrinho(@NotNull Carrinho carrinho) {
        double somaTotalDosDescontosDoCarrinho = 0;

        for (Itens valor : carrinho.getCarrinho()) {
            double somaDoValorGeral = valor.getDesconto();

            somaTotalDosDescontosDoCarrinho += somaDoValorGeral;
        }
        System.out.println("Valor da soma total dos acrescimos do carrinho: " + somaTotalDosDescontosDoCarrinho);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        var carrinho = new Carrinho();
        var item = new Itens();

        var estoque = new Estoque();
        System.out.println("Itens disponíveis: ");
        estoque.adicionaItensEstoque();

        System.out.println("Seja bem vindo ao sistema!");
        System.out.println("----------------------------");
        boolean continuarPrograma = true;

        while (continuarPrograma) {
            System.out.println("Menu de opções: ");
            System.out.println("1-Inserir item ao carrinho");
            System.out.println("2-Acréscimo de item");
            System.out.println("3-Desconto de item");
            System.out.println("4-Acréscimo total");
            System.out.println("5-Desconto total");
            System.out.println("6-Finalizar venda");
            System.out.print("Digite um número das opções acima: ");
            int opcaoMenu = scanner.nextInt();

            switch (opcaoMenu) {
                case 1:
                    inserirItemCarrinho(carrinho, estoque);
                    break;
                case 2:
                    acrescimoDeItem(item, carrinho);
                    break;
                case 3:
                    descontoDeItem(item, carrinho);
                    break;
                case 4:
                    acrescimoTotal(carrinho);
                    break;
                case 5:
                    descontoTotal(carrinho);
                    break;
                case 6:
                    somaTotalDosItensDoCarrinho(carrinho);
                    somaTotalDosAcrescimosDoCarrinho(carrinho);
                    somaTotalDosDescontosDoCarrinho(carrinho);
                    System.out.println("Programa finalizado!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
            System.out.print("Deseja continuar no programa? (S/N) - ");
            String continuar = scanner.next();

            if (continuar.equalsIgnoreCase("s")) {
                System.out.println(carrinho.getCarrinho().toString());
            } else {
                continuarPrograma = false;

                System.out.println(carrinho.getCarrinho());
                System.out.println("Programa finalizado!");
            }
        }
    }
}