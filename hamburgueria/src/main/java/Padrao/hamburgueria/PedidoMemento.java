package Padrao.hamburgueria;

public class PedidoMemento {

    private final EstadoPedido estado;

    public PedidoMemento(EstadoPedido estado) {
        this.estado = estado;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

}