package Padrao.hamburgueria;

public class ValidarEstado {

    public static boolean podeTransicionar(EstadoPedido estadoAtual,
                                           EstadoPedido novoEstado) {

        String atual = estadoAtual.getEstado();
        String novo = novoEstado.getEstado();

        switch (atual) {

            case "Confirmado":
                return novo.equals("Em preparo")
                        || novo.equals("Cancelado");

            case "Em preparo":
                return novo.equals("Saiu para Entrega")
                        || novo.equals("Cancelado");

            case "Saiu para Entrega":
                return novo.equals("Entregue");

            case "Cancelado":
            case "Entregue":
                return false;

            default:
                return false;
        }
    }
}
