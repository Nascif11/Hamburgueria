package Padrao.hamburgueria;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes - Builder
 */
public class BuilderTest {

    @Test
    void deveConstruirPedido() {

        Pedido pedido = new PedidoBuilder()
                .comCliente(new Cliente("Lucas"))
                .comLanche(new Hamburguer(new FabricaClassica(), new NaChapa()))
                .comEstado(new Confirmado())
                .comFrete(new FreteMoto())
                .build();

        assertNotNull(pedido);
    }

    @Test
    void pedidoDeveTerCliente() {

        Cliente cliente = new Cliente("Lucas");

        Pedido pedido = new PedidoBuilder()
                .comCliente(cliente)
                .comLanche(new Hamburguer(new FabricaClassica(), new NaChapa()))
                .comEstado(new Confirmado())
                .comFrete(new FreteMoto())
                .build();

        assertEquals(cliente, pedido.getCliente());
    }

    @Test
    void pedidoDeveTerLanche() {

        Lanche lanche = new Hamburguer(new FabricaClassica(), new NaChapa());

        Pedido pedido = new PedidoBuilder()
                .comCliente(new Cliente("Lucas"))
                .comLanche(lanche)
                .comEstado(new Confirmado())
                .comFrete(new FreteMoto())
                .build();

        assertEquals(lanche, pedido.getLanche());
    }

    @Test
    void pedidoDeveTerEstado() {

        Pedido pedido = new PedidoBuilder()
                .comCliente(new Cliente("Lucas"))
                .comLanche(new Hamburguer(new FabricaClassica(), new NaChapa()))
                .comEstado(new Confirmado())
                .comFrete(new FreteMoto())
                .build();

        assertTrue(pedido.getEstado() instanceof Confirmado);
    }

    @Test
    void pedidoDeveTerFrete() {

        Frete frete = new FreteMoto();

        Pedido pedido = new PedidoBuilder()
                .comCliente(new Cliente("Lucas"))
                .comLanche(new Hamburguer(new FabricaClassica(), new NaChapa()))
                .comEstado(new Confirmado())
                .comFrete(frete)
                .build();

        assertEquals(frete, pedido.getFrete());
    }

    @Test
    void deveAplicarDesconto() {

        Pedido pedido = new PedidoBuilder()
                .comCliente(new Cliente("Lucas"))
                .comLanche(new Hamburguer(new FabricaClassica(), new NaChapa()))
                .comEstado(new Confirmado())
                .comFrete(new FreteMoto())
                .comDesconto(10)
                .build();

        assertEquals(10, pedido.getDesconto());
    }

    @Test
    void deveLancarErroSemCliente() {

        assertThrows(IllegalStateException.class,
                () -> new PedidoBuilder()
                        .comLanche(new Hamburguer(new FabricaClassica(), new NaChapa()))
                        .comEstado(new Confirmado())
                        .build());
    }

    @Test
    void deveLancarErroSemLanche() {

        assertThrows(IllegalStateException.class,
                () -> new PedidoBuilder()
                        .comCliente(new Cliente("Lucas"))
                        .comEstado(new Confirmado())
                        .build());
    }


    @Test
    void builderDeveResetar() {

        PedidoBuilder builder = new PedidoBuilder();

        builder.reset();

        assertNotNull(builder);
    }

}
