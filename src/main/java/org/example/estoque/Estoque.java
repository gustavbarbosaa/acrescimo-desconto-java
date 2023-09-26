package org.example.estoque;

import lombok.Data;
import org.example.itens.Itens;

import java.util.ArrayList;

@Data
public class Estoque {
    private ArrayList<Itens> itensEmEstoque = new ArrayList<>();

    private String[] nomeItens = {
            "Camisa Nike", "Camisa Adidas", "Camisa Lacoste", "Bone Nike", "Tenis Mizuno",
            "Tenis Asics", "Tenis Nike", "Calça Nike", "Calça Adidas", "Sandália Kenner"
    };
    private Double[] valorItens = { 100.5, 250.0, 50.5, 79.9, 300.4, 100.0, 400.5, 200.0, 500.40, 200.99};
    public void adicionaItensEstoque() {
        for (int i = 0; i < 10; i++) {
            var item = new Itens();
            item.setCodigo(i+1);
            item.setDescricao(nomeItens[i]);
            item.setValor(valorItens[i]);

            itensEmEstoque.add(item);
        }
    }
}
