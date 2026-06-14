package Padrao.hamburgueria;


import java.util.Observable;

public class Pedido extends Observable implements Cloneable {

    private Cliente cliente;
    private Lanche lanche;
    private EstadoPedido estado;

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    @Override
    public Pedido clone() {
        try {
            return (Pedido) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizarPedido() {
        setChanged();
        notifyObservers();
    }

    public void notificar() {
        atualizarPedido();
    }
}