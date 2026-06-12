package Padrao.hamburgueria;

import java.util.ArrayList;
import java.util.List;

public class Combo extends ItemCardapio {

    private List<ItemCardapio> itens;

    public Combo(String nome) {
        super(nome);
        this.itens = new ArrayList<>();
    }

    public void adicionar(ItemCardapio item) {
        itens.add(item);
    }

    @Override
    public double getPreco() {

        double total = 0;

        for(ItemCardapio item : itens) {
            total += item.getPreco();
        }

        return total;
    }
}
