package Padrao.hamburgueria;

public class PedidoBuilder {

    private Pedido pedido;

    public PedidoBuilder() {
        this.pedido = new Pedido();
    }

    public Pedido build() {
        return pedido;
    }
}
