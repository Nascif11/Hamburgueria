package Padrao.hamburgueria;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes - Facade
 */
public class FacadeTest {

    @Test
    void facadeNaoPodeSerNula() {

        CentralPedidos facade =
                new CentralPedidos();

        assertNotNull(facade);
    }

    @Test
    void deveCriarPedidoPelaFacade() {

        CentralPedidos facade =
                new CentralPedidos();

        Pedido pedido =
                facade.fazerPedido(
                        new Cliente("Lucas"),
                        new Hamburguer(new FabricaClassica(), new NaChapa()),
                        new FreteMoto());

        assertNotNull(pedido);
    }

    @Test
    void pedidoCriadoTemCliente() {

        Cliente cliente = new Cliente("Lucas");

        Pedido pedido =
                new CentralPedidos().fazerPedido(
                        cliente,
                        new Hamburguer(new FabricaClassica(), new NaChapa()),
                        new FreteMoto());

        assertEquals(cliente, pedido.getCliente());
    }

    @Test
    void pedidoCriadoTemEstadoInicial() {

        Pedido pedido =
                new CentralPedidos().fazerPedido(
                        new Cliente("Lucas"),
                        new Hamburguer(new FabricaClassica(), new NaChapa()),
                        new FreteMoto());

        assertTrue(
                pedido.getEstado() instanceof Confirmado);
    }

    @Test
    void deveObterStatus() {

        CentralPedidos facade =
                new CentralPedidos();

        Pedido pedido =
                facade.fazerPedido(
                        new Cliente("Lucas"),
                        new Hamburguer(new FabricaClassica(), new NaChapa()),
                        new FreteMoto());

        assertNotNull(facade.obterStatus(pedido));
    }


    @Test
    void listaPedidosNaoPodeSerNula() {

        assertNotNull(
                new CentralPedidos().obterTodosPedidos());
    }

    @Test
    void facadeUsaSingleton() {

        CentralPedidos facade =
                new CentralPedidos();

        assertNotNull(facade);
    }

}