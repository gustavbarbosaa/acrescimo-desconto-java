package org.example.itens;

import lombok.Data;

import java.util.Scanner;

@Data
public class Itens {
    private int codigo;
    private String descricao;
    private double valor;
    private double acrescimo = 0;
    private double desconto = 0;

    public double adicionaAcrescimoValor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o valor do acrescimo: ");
        double valorAcrescido = scanner.nextDouble();
        this.acrescimo = valorAcrescido;

        return valorAcrescido;
    }

    public double adicionaDescontoValor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o valor do desconto: ");
        double descontoItem = scanner.nextDouble();
        this.desconto = descontoItem;

        return descontoItem;
    }
}
