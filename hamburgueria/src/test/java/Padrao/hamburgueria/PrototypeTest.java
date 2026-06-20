package Padrao.hamburgueria;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes do padrão Prototype
 */
public class PrototypeTest {

    @Test
    void deveClonarPedido() {
        Pedido pedido = new Pedido();
        Pedido copia = pedido.clone();

        assertNotSame(pedido, copia);
    }

    @Test
    void cloneNaoPodeSerNulo() {
        Pedido pedido = new Pedido();

        assertNotNull(pedido.clone());
    }

    @Test
    void cloneDeveManterCliente() {
        Cliente cliente = new Cliente("Lucas");

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);

        Pedido clone = pedido.clone();

        assertEquals(cliente, clone.getCliente());
    }

    @Test
    void cloneDeveManterLanche() {
        Lanche lanche = new Hamburguer(new FabricaClassica(), new NaChapa());

        Pedido pedido = new Pedido();
        pedido.setLanche(lanche);

        Pedido clone = pedido.clone();

        assertEquals(lanche, clone.getLanche());
    }

    @Test
    void cloneDeveResetarDataEntrega() {
        Pedido pedido = new Pedido();

        Pedido clone = pedido.clone();

        assertNull(clone.getDataEntrega());
    }

    @Test
    void cloneDeveFicarConfirmado() {
        Pedido pedido = new Pedido();

        Pedido clone = pedido.clone();

        assertTrue(clone.getEstado() instanceof Confirmado);
    }

    @Test
    void cloneMantemDesconto() {
        Pedido pedido = new Pedido();
        pedido.setDesconto(15);

        Pedido clone = pedido.clone();

        assertEquals(15, clone.getDesconto());
    }

    @Test
    void cloneMantemFrete() {
        Pedido pedido = new Pedido();
        pedido.setFrete(new FreteMoto());

        Pedido clone = pedido.clone();

        assertNotNull(clone.getFrete());
    }

    @Test
    void cloneMantemClienteMesmoObjeto() {
        Cliente cliente = new Cliente("Lucas");

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);

        Pedido clone = pedido.clone();

        assertSame(cliente, clone.getCliente());
    }

}