package Padrao.hamburgueria;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorPedidos {

    private static GerenciadorPedidos instance;
    private List<String> pedidos = new ArrayList<>();

    private GerenciadorPedidos() {}

    public static GerenciadorPedidos getInstance() {
        if (instance == null) {
            instance = new GerenciadorPedidos();
        }
        return instance;
    }

    public void adicionarPedido(String pedido) {
        pedidos.add(pedido);
    }

    public List<String> getPedidos() {
        return pedidos;
    }
}