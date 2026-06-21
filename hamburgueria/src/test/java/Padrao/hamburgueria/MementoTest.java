package Padrao.hamburgueria;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MementoTest {

    @Test
    void deveSalvarEstado() {

        Pedido pedido = new Pedido();
        pedido.setEstado(new Confirmado());

        PedidoMemento m = pedido.salvar();

        assertEquals(
                "Confirmado",
                m.getEstado().getEstado()
        );
    }

    @Test
    void deveRestaurarEstado() {

        Pedido pedido = new Pedido();

        pedido.setEstado(new Confirmado());

        PedidoMemento m = pedido.salvar();

        pedido.setEstado(new Entregue());

        pedido.restaurar(m);

        assertEquals(
                "Confirmado",
                pedido.getEstado().getEstado()
        );
    }

    @Test
    void historicoSalvaEstados() {

        Pedido pedido = new Pedido();

        pedido.setEstado(new Confirmado());

        HistoricoPedido h = new HistoricoPedido();

        h.salvar(pedido);

        assertEquals(
                1,
                h.tamanho()
        );
    }

    @Test
    void historicoPodeRestaurar() {

        Pedido pedido = new Pedido();

        pedido.setEstado(new Confirmado());

        HistoricoPedido h = new HistoricoPedido();

        h.salvar(pedido);

        pedido.setEstado(new Cancelado());

        h.restaurar(pedido,0);

        assertEquals(
                "Confirmado",
                pedido.getEstado().getEstado()
        );
    }

    @Test
    void salvaDoisEstados() {

        Pedido pedido = new Pedido();

        HistoricoPedido h = new HistoricoPedido();

        pedido.setEstado(new Confirmado());
        h.salvar(pedido);

        pedido.setEstado(new EmPreparo());
        h.salvar(pedido);

        assertEquals(
                2,
                h.tamanho()
        );
    }

    @Test
    void restauraPrimeiroEstado() {

        Pedido pedido = new Pedido();

        HistoricoPedido h = new HistoricoPedido();

        pedido.setEstado(new Confirmado());

        h.salvar(pedido);

        pedido.setEstado(new EmPreparo());

        h.salvar(pedido);

        h.restaurar(pedido,0);

        assertEquals(
                "Confirmado",
                pedido.getEstado().getEstado()
        );
    }

    @Test
    void restauraSegundoEstado() {

        Pedido pedido = new Pedido();

        HistoricoPedido h = new HistoricoPedido();

        pedido.setEstado(new Confirmado());

        h.salvar(pedido);

        pedido.setEstado(new EmPreparo());

        h.salvar(pedido);

        h.restaurar(pedido,1);

        assertEquals(
                "Em preparo",
                pedido.getEstado().getEstado()
        );
    }

    @Test
    void tamanhoInicialZero() {

        HistoricoPedido h = new HistoricoPedido();

        assertEquals(0,h.tamanho());
    }

    @Test
    void salvarNaoRetornaNulo() {

        Pedido pedido = new Pedido();

        pedido.setEstado(new Confirmado());

        assertNotNull(
                pedido.salvar()
        );
    }

    @Test
    void restaurarNaoLancaErro() {

        Pedido pedido = new Pedido();

        pedido.setEstado(new Confirmado());

        PedidoMemento m = pedido.salvar();

        assertDoesNotThrow(() ->
                pedido.restaurar(m)
        );
    }

}