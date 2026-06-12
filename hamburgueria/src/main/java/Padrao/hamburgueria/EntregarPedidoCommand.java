package Padrao.hamburgueria;

public class EntregarPedidoCommand
        implements PedidoCommand {

    private Pedido pedido;

    public EntregarPedidoCommand(
            Pedido pedido) {

        this.pedido = pedido;
    }

    @Override
    public void executar() {

        pedido.setEstado(
                new Entregue()
        );
    }
}
