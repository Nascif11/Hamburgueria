package Padrao.hamburgueria;

public class SistemaHamburgueria {
    private CentralPedidos central;
    private GerenciadorPedidos gerenciador;

    public Pedido fazerPedidoClassico() {
        return null;
    }
    public Pedido fazerPedidoGourmet() {
        return null;
    }
    public double calcularTotal(Pedido pedido) {
        return 0;
    }
    public String obterStatusPedido(String id) {
        return id;
    }

    public String fazerPedidoPremium() {

        FabricaIngredientes fabrica =
                new FabricaGourmet();

        ModoCozimento modo =
                new NaChapa();

        Lanche lanche =
                new Hamburguer(fabrica, modo);

        lanche =
                new ExtraQueijo(lanche);

        Frete frete =
                new FreteMoto();

        double total =
                lanche.preco() +
                        frete.calcular(lanche.preco());

        GerenciadorPedidos
                .getInstance()
                .adicionarPedido(
                        lanche.descricao());

        return "Pedido: " +
                lanche.descricao() +
                " | Total: R$" +
                total;
    }
}
