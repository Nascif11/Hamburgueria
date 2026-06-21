package Padrao.hamburgueria;

import java.util.ArrayList;
import java.util.List;

public class HistoricoPedido {

    private final List<PedidoMemento> historico = new ArrayList<>();

    public void salvar(Pedido pedido) {
        historico.add(pedido.salvar());
    }

    public void restaurar(Pedido pedido, int indice) {

        if (indice < 0 || indice >= historico.size()) {
            throw new IllegalArgumentException("Índice inválido");
        }

        pedido.restaurar(historico.get(indice));
    }

    public int tamanho() {
        return historico.size();
    }

}