package Padrao.hamburgueria;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes do padrão Singleton
 */
public class SingletonTest {

    @Test
    void deveRetornarMesmaInstancia() {
        GerenciadorPedidos g1 = GerenciadorPedidos.getInstance();
        GerenciadorPedidos g2 = GerenciadorPedidos.getInstance();

        assertSame(g1, g2);
    }

    @Test
    void instanciaNaoPodeSerNula() {
        assertNotNull(GerenciadorPedidos.getInstance());
    }

    @Test
    void deveAdicionarPedido() {
        GerenciadorPedidos gerenciador = GerenciadorPedidos.getInstance();

        gerenciador.adicionarPedido("PED001");

        assertTrue(gerenciador.getPedidos().contains("PED001"));
    }

    @Test
    void deveAdicionarDoisPedidos() {
        GerenciadorPedidos gerenciador = GerenciadorPedidos.getInstance();

        gerenciador.adicionarPedido("PED002");
        gerenciador.adicionarPedido("PED003");

        assertTrue(gerenciador.getPedidos().contains("PED002"));
        assertTrue(gerenciador.getPedidos().contains("PED003"));
    }

    @Test
    void listaPedidosNaoPodeSerNula() {
        GerenciadorPedidos gerenciador = GerenciadorPedidos.getInstance();

        assertNotNull(gerenciador.getPedidos());
    }

    @Test
    void devePersistirInstancia() {
        GerenciadorPedidos g1 = GerenciadorPedidos.getInstance();

        g1.adicionarPedido("PED004");

        GerenciadorPedidos g2 = GerenciadorPedidos.getInstance();

        assertTrue(g2.getPedidos().contains("PED004"));
    }

    @Test
    void deveRetornarListaDePedidos() {
        GerenciadorPedidos gerenciador = GerenciadorPedidos.getInstance();

        List<String> pedidos = gerenciador.getPedidos();

        assertNotNull(pedidos);
    }

    @Test
    void deveAdicionarPedidoComSucesso() {
        GerenciadorPedidos gerenciador = GerenciadorPedidos.getInstance();

        gerenciador.adicionarPedido("PED005");

        assertEquals("PED005",
                gerenciador.getPedidos().get(
                        gerenciador.getPedidos().size() - 1
                ));
    }

    @Test
    void deveConterPedidosNaLista() {
        GerenciadorPedidos gerenciador = GerenciadorPedidos.getInstance();

        gerenciador.adicionarPedido("PED006");

        assertFalse(gerenciador.getPedidos().isEmpty());
    }

    @Test
    void deveCompartilharMesmaListaEntreInstancias() {

        GerenciadorPedidos g1 = GerenciadorPedidos.getInstance();

        GerenciadorPedidos g2 = GerenciadorPedidos.getInstance();

        g1.adicionarPedido("PED007");

        assertTrue(g2.getPedidos().contains("PED007"));
    }

}
