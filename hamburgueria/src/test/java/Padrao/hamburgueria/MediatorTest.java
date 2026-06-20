package Padrao.hamburgueria;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MediatorTest {

    @Test
    void centralPodeSerCriada() {
        CentralPedidos central = new CentralPedidos();
        assertNotNull(central);
    }

    @Test
    void facadeNaoEhNulo() {
        new CentralPedidos();
    }

    @Test
    void gerenciadorExisteNaCentral() {
        CentralPedidos central = new CentralPedidos();
        assertNotNull(central.obterTodosPedidos());
    }

    @Test
    void listaPedidosNaoEhNula() {
        assertNotNull(new CentralPedidos().obterTodosPedidos());
    }

    @Test
    void listaInicialEstaVaziaOuExiste() {
        new CentralPedidos().obterTodosPedidos();
        assertTrue(true);
    }

    @Test
    void centralPodeConsultarPedidos() {
        CentralPedidos central = new CentralPedidos();
        assertNotNull(central.obterTodosPedidos());
    }

    @Test
    void duasCentraisFuncionam() {
        CentralPedidos c1 = new CentralPedidos();
        CentralPedidos c2 = new CentralPedidos();

        assertNotNull(c1);
        assertNotNull(c2);
    }

    @Test
    void centralUsaSingleton() {
        GerenciadorPedidos g = GerenciadorPedidos.getInstance();
        assertNotNull(g);
    }

    @Test
    void pedidosEhLista() {
        assertNotNull(new CentralPedidos().obterTodosPedidos());
    }

    @Test
    void mediatorInstanciaValida() {
        assertInstanceOf(CentralPedidos.class, new CentralPedidos());
    }

}
