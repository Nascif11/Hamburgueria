package Padrao.hamburgueria;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ObserverTest {

    @Test
    void clienteRecebeAtualizacao() {

        Pedido pedido = new Pedido();

        Cliente cliente = new Cliente("Lucas");

        pedido.addObserver(cliente);

        pedido.notificar();

        assertNotNull(cliente.getStatus());
    }

    @Test
    void clientePodeSerObservador() {

        Cliente cliente =
                new Cliente("Lucas");

        assertNotNull(cliente);
    }

    @Test
    void pedidoPodeReceberObserver() {

        Pedido pedido =
                new Pedido();

        pedido.addObserver(
                new Cliente("Lucas"));

        assertEquals(1,
                pedido.countObservers());
    }

    @Test
    void doisClientesRecebemNotificacao() {

        Pedido pedido = new Pedido();

        Cliente c1 = new Cliente("Lucas");
        Cliente c2 = new Cliente("Maria");

        pedido.addObserver(c1);
        pedido.addObserver(c2);

        pedido.notificar();

        assertNotNull(c1.getStatus());
        assertNotNull(c2.getStatus());
    }

    @Test
    void removerObserver() {

        Pedido pedido = new Pedido();

        Cliente cliente = new Cliente("Lucas");

        pedido.addObserver(cliente);

        pedido.deleteObserver(cliente);

        assertEquals(0,
                pedido.countObservers());
    }

    @Test
    void pedidoPodeNotificar() {

        Pedido pedido =
                new Pedido();

        assertDoesNotThrow(
                pedido::notificar);
    }

    @Test
    void clienteTemNome() {

        Cliente cliente =
                new Cliente("Lucas");

        assertNotNull(cliente.getNome());
    }

    @Test
    void pedidoPodeTerVariosObservers() {

        Pedido pedido = new Pedido();

        pedido.addObserver(new Cliente("A"));
        pedido.addObserver(new Cliente("B"));
        pedido.addObserver(new Cliente("C"));

        assertEquals(3,
                pedido.countObservers());
    }

    @Test
    void notificarSemObserverNaoDaErro() {

        Pedido pedido = new Pedido();

        assertDoesNotThrow(
                pedido::notificar);
    }

    @Test
    void observerRecebeMensagem() {

        Pedido pedido = new Pedido();

        Cliente cliente = new Cliente("Lucas");

        pedido.addObserver(cliente);

        pedido.notificar();

        assertTrue(
                cliente.getStatus().contains("Lucas"));
    }

}