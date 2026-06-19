package Padrao.hamburgueria;

import java.time.LocalDateTime;

/**
 * Padrão Facade
 * Fornece interface simplificada para operações complexas
 * Coordena: GerenciadorPedidos, Cozinha, Cliente
 */
public class CentralPedidos {

    private GerenciadorPedidos gerenciador;
    private Cozinha cozinha;

    public CentralPedidos() {
        this.gerenciador = GerenciadorPedidos.getInstance();
        this.cozinha = new Cozinha();
    }

    // ===== OPERAÇÕES DO FACADE =====

    /**
     * Operação completa: fazer pedido
     * Valida, cria e registra o pedido
     */
    public Pedido fazerPedido(Cliente cliente, Lanche lanche, Frete frete) {
        return fazerPedido(cliente, lanche, frete, 0);
    }

    /**
     * Operação completa: fazer pedido com desconto
     */
    public Pedido fazerPedido(Cliente cliente, Lanche lanche, Frete frete, double desconto) {
        if (cliente == null || lanche == null || frete == null) {
            throw new IllegalArgumentException("Cliente, lanche e frete são obrigatórios");
        }
        Pedido pedido = new PedidoBuilder()
                .comCliente(cliente)
                .comLanche(lanche)
                .comEstado(new Confirmado())
                .comFrete(frete)
                .comDesconto(desconto)
                .build();
        cliente.setUltimoPedido(pedido);

        gerenciador.adicionarPedido(pedido.getId());
        return pedido;
    }

    /**
     * Iniciar preparo do pedido
     */
    public void prepararPedido(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido não pode ser nulo");
        }

        if (!ValidarEstado.podeTransicionar(pedido.getEstado(), new EmPreparo())) {
            throw new IllegalStateException(
                    "Pedido não pode ser preparado no estado: " + pedido.getEstado().getEstado()
            );
        }
        if (pedido.getLanche() instanceof Hamburguer) {
            cozinha.prepararHamburguer();
        } else if (pedido.getLanche() instanceof Wrap) {
            cozinha.prepararWrap();
        }

        cozinha.executar(new PrepararPedidoCommand(pedido));
        pedido.notificar();
    }

    /**
     * Marcar como saído para entrega
     */
    public void sairParaEntrega(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido não pode ser nulo");
        }

        if (!ValidarEstado.podeTransicionar(pedido.getEstado(), new SaiuParaEntrega())) {
            throw new IllegalStateException("Pedido não pode sair para entrega");
        }

        pedido.setEstado(new SaiuParaEntrega());
        pedido.notificar();
    }

    /**
     * Entregar pedido
     */
    public void entregarPedido(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido não pode ser nulo");
        }

        if (!ValidarEstado.podeTransicionar(pedido.getEstado(), new Entregue())) {
            throw new IllegalStateException("Pedido não pode ser entregue");
        }

        cozinha.executar(new EntregarPedidoCommand(pedido));
        pedido.setDataEntrega(LocalDateTime.now());
        enviarMensagem(" Pedido " + pedido.getId() + " entregue com sucesso!");
        pedido.notificar();
    }

    /**
     * Cancelar pedido
     */
    public void cancelarPedido(Pedido pedido, String motivo) {
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido não pode ser nulo");
        }

        if (!ValidarEstado.podeTransicionar(pedido.getEstado(), new Cancelado())) {
            throw new IllegalStateException(
                    "Pedido no estado '" + pedido.getEstado().getEstado() + "' não pode ser cancelado"
            );
        }

        pedido.setEstado(new Cancelado());
        pedido.notificar();
    }

    /**
     * Obter status do pedido
     */
    public String obterStatus(Pedido pedido) {
        if (pedido == null) {
            return "Pedido inválido";
        }

        return String.format(
                "Pedido %s | Estado: %s | Total: R$ %.2f",
                pedido.getId(),
                pedido.getEstado().getEstado(),
                pedido.calcularTotal()
        );
    }

    /**
     * Obter todos os pedidos registrados
     */
    public java.util.List<String> obterTodosPedidos() {
        return gerenciador.getPedidos();
    }

    /**
     * Enviar mensagem (log)
     */
    private void enviarMensagem(String msg) {
        System.out.println("[CENTRAL] " + msg);
    }



}

