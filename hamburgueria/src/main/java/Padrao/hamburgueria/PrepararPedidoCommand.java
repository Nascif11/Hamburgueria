package Padrao.hamburgueria;

public class PrepararPedidoCommand
        implements PedidoCommand {

    private Pedido pedido;

    public PrepararPedidoCommand(
            Pedido pedido) {

        this.pedido = pedido;
    }

    @Override
    public void executar() {

        pedido.setEstado(
                new EmPreparo()
        );
    }
}
