package org.example.carrinho;

import lombok.Data;
import org.example.estoque.Estoque;
import org.example.itens.Itens;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Scanner;

@Data
public class Carrinho {
    private ArrayList<Itens> carrinho = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public int informeCodigoItemEstoque() {
        System.out.print("Digite o codigo do item que deseja inserir: ");
        return scanner.nextInt();
    }

    public void adicionarItemAoCarrinho(@NotNull Estoque listaEstoque) {
        int codigo = informeCodigoItemEstoque();

        for (Itens valor : listaEstoque.getItensEmEstoque()) {
            if (codigo == valor.getCodigo()) {
                carrinho.add(valor);
            }
        }
        System.out.println(carrinho);
        System.out.println("Item cadastrado!");
    }
}
