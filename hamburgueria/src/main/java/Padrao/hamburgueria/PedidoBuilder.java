package Padrao.hamburgueria;

public class PedidoBuilder {

    private Pedido pedido;

    public PedidoBuilder() {
        this.pedido = new Pedido();
    }

    /**
     * Define o cliente do pedido
     */
    public PedidoBuilder comCliente(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não pode ser nulo");
        }
        this.pedido.setCliente(cliente);
        return this;
    }

    /**
     * Define o lanche do pedido
     */
    public PedidoBuilder comLanche(Lanche lanche) {
        if (lanche == null) {
            throw new IllegalArgumentException("Lanche não pode ser nulo");
        }
        this.pedido.setLanche(lanche);
        return this;
    }

    /**
     * Define o estado inicial do pedido
     */
    public PedidoBuilder comEstado(EstadoPedido estado) {
        if (estado == null) {
            throw new IllegalArgumentException("Estado não pode ser nulo");
        }
        this.pedido.setEstado(estado);
        return this;
    }

    /**
     * Define a estratégia de frete
     */
    public PedidoBuilder comFrete(Frete frete) {
        if (frete == null) {
            throw new IllegalArgumentException("Frete não pode ser nulo");
        }
        this.pedido.setFrete(frete);
        return this;
    }

    /**
     * Define desconto do pedido
     */
    public PedidoBuilder comDesconto(double desconto) {
        if (desconto < 0) {
            throw new IllegalArgumentException("Desconto não pode ser negativo");
        }
        this.pedido.setDesconto(desconto);
        return this;
    }

    /**
     * Constrói o pedido com validações
     */
    public Pedido build() {
        validar();
        return pedido;
    }

    /**
     * Valida se todos os campos obrigatórios foram preenchidos
     */
    private void validar() {
        if (pedido.getCliente() == null) {
            throw new IllegalStateException("Cliente é obrigatório");
        }
        if (pedido.getLanche() == null) {
            throw new IllegalStateException("Lanche é obrigatório");
        }
        if (pedido.getEstado() == null) {
            throw new IllegalStateException("Estado é obrigatório");
        }
    }

    /**
     * Reseta o builder para criar novo pedido
     */
    public PedidoBuilder reset() {
        this.pedido = new Pedido();
        return this;
    }
}