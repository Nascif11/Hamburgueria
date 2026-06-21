package Padrao.hamburgueria;

import java.util.Observable;
import java.time.LocalDateTime;


public class Pedido extends Observable implements Cloneable {

    private String id;
    private Cliente cliente;
    private Lanche lanche;
    private EstadoPedido estado;
    private Frete frete;
    private double desconto;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataEntrega;

    public Pedido() {
        this.id = "PED_" + System.currentTimeMillis();
        this.dataCriacao = LocalDateTime.now();
        this.desconto = 0;
        this.estado = new Confirmado();
    }


    public String getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Lanche getLanche() {
        return lanche;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public Frete getFrete() {
        return frete;
    }

    public double getDesconto() {
        return desconto;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public LocalDateTime getDataEntrega() {
        return dataEntrega;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setLanche(Lanche lanche) {
        this.lanche = lanche;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public void setFrete(Frete frete) {
        this.frete = frete;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public void setDataEntrega(LocalDateTime dataEntrega) {
        this.dataEntrega = dataEntrega;
    }


    @Override
    public Pedido clone() {
        try {
            Pedido pedidoClonado = (Pedido) super.clone();
            pedidoClonado.id = "PED_" + System.currentTimeMillis();
            pedidoClonado.dataCriacao = LocalDateTime.now();
            pedidoClonado.dataEntrega = null;
            pedidoClonado.estado = new Confirmado();
            return pedidoClonado;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Erro ao clonar pedido", e);
        }
    }
    public PedidoMemento salvar() {
        return new PedidoMemento(this.estado);
    }

    public void restaurar(PedidoMemento memento) {
        this.estado = memento.getEstado();
    }

    public void atualizarPedido() {
        setChanged();
        notifyObservers("Pedido " + id + " atualizado para: " + estado.getEstado());
    }

    public void notificar() {
        atualizarPedido();
    }

    public double calcularTotal() {
        if (lanche == null || frete == null) {
            return 0;
        }

        double total = lanche.preco();
        total += frete.calcular(total);
        total -= desconto;

        return Math.max(total, 0);
    }



    @Override
    public String toString() {
        return String.format(
                "Pedido[ID=%s, Cliente=%s, Lanche=%s, Estado=%s, Total=R$%.2f, Data=%s]",
                id,
                cliente != null ? cliente.getNome() : "N/A",
                lanche != null ? lanche.descricao() : "N/A",
                estado != null ? estado.getEstado() : "N/A",
                calcularTotal(),
                dataCriacao
        );
    }


}