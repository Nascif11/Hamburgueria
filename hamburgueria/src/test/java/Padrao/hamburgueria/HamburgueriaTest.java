package Padrao.hamburgueria;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HamburgueriaTest {



    @Test
    void deveRetornarMesmaInstanciaSingleton() {

        GerenciadorPedidos g1 =
                GerenciadorPedidos.getInstance();

        GerenciadorPedidos g2 =
                GerenciadorPedidos.getInstance();

        assertSame(g1, g2);
    }



    @Test
    void deveCriarIngredientesClassicos() {

        FabricaIngredientes fabrica =
                new FabricaClassica();

        assertNotNull(fabrica.criarPao());
        assertNotNull(fabrica.criarCarne());
        assertNotNull(fabrica.criarMolho());
    }



    @Test
    void deveCriarHamburguer() {

        LancheFactory factory =
                new HamburguerFactory();

        Lanche lanche =
                factory.criarLanche();

        assertEquals(
                "Hambúrguer",
                lanche.descricao()
        );
    }



    @Test
    void deveAssociarModoCozimento() {

        Lanche hamburguer =
                new Hamburguer(
                        new FabricaClassica(),
                        new NaChapa()
                );

        assertNotNull(hamburguer);
    }



    @Test
    void deveAdicionarQueijo() {

        Lanche lanche =
                new Hamburguer(
                        new FabricaClassica(),
                        new NaChapa()
                );

        lanche =
                new ExtraQueijo(lanche);

        assertTrue(
                lanche.descricao()
                        .contains("Queijo")
        );
    }



    @Test
    void deveCalcularFrete() {

        Frete frete =
                new FreteMoto();

        assertTrue(
                frete.calcular(10) > 0
        );
    }



    @Test
    void deveAlterarEstadoPedido() {

        Pedido pedido = new Pedido();

        pedido.setEstado(
                new EmPreparo()
        );

        assertEquals(
                "Em preparo",
                pedido.getEstado().getEstado()
        );
    }



    @Test
    void deveExecutarComandoPrepararPedido() {

        Pedido pedido =
                new Pedido();

        PedidoCommand command =
                new PrepararPedidoCommand(pedido);

        command.executar();

        assertEquals(
                "Em preparo",
                pedido.getEstado().getEstado()
        );
    }



    @Test
    void deveNotificarCliente() {

        Pedido pedido =
                new Pedido();

        Cliente cliente =
                new Cliente("Lucas");

        pedido.addObserver(cliente);

        pedido.notificar();

    }



    @Test
    void deveConverterAvaliacaoTextoParaNota() {

        AvaliacaoTexto avaliacao =
                new AvaliacaoTexto();

        avaliacao.setAvaliacao(
                "Excelente"
        );

        AvaliacaoAdapter adapter =
                new AvaliacaoAdapter(avaliacao);

        adapter.salvarAvaliacao();

        assertEquals(
                10.0f,
                adapter.getNota()
        );
    }



    @Test
    void deveCalcularPrecoCombo() {

        Produto burger =
                new Produto(
                        "X-Burger",
                        20
                );

        Produto batata =
                new Produto(
                        "Batata",
                        10
                );

        Combo combo =
                new Combo(
                        "Combo Família"
                );

        combo.adicionar(burger);
        combo.adicionar(batata);

        assertEquals(
                30,
                combo.getPreco()
        );
    }



    @Test
    void deveAplicarDescontoCupom() {

        DescontoCupom cupom =
                new DescontoCupom();

        SemDesconto semDesconto =
                new SemDesconto();

        cupom.setProximo(semDesconto);

        double valorFinal =
                cupom.calcular(100.0);

        assertEquals(
                90.0,
                valorFinal
        );
    }

    @Test
    void deveRetornarValorOriginal() {

        DescontoCupom cupom =
                new DescontoCupom();

        SemDesconto semDesconto =
                new SemDesconto();

        cupom.setProximo(semDesconto);

        double valorFinal =
                cupom.calcular(20.0);

        assertEquals(
                20.0,
                valorFinal
        );
    }



    @Test
    void devePrepararHamburguerTemplate() {

        PreparacaoHamburguer preparo =
                new PreparacaoHamburguer();

        assertTrue(
                preparo.preparar()
                        .contains("Angus")
        );
    }



    @Test
    void deveClonarPedido() {

        Pedido pedido =
                new Pedido();

        Pedido copia =
                pedido.clone();

        assertNotSame(
                pedido,
                copia
        );
    }



    @Test
    void deveConstruirPedido() {

        Pedido pedido =
                new PedidoBuilder()
                        .build();

        assertNotNull(pedido);
    }



    @Test
    void deveEnviarMensagemMediator() {

        CentralPedidos central =
                new CentralPedidos();

        assertNotNull(central);
    }



    @Test
    void deveFazerPedidoFacade() {

        SistemaHamburgueria facade =
                new SistemaHamburgueria();

        assertNotNull(facade);
    }



    @Test
    void deveGerarRelatorioVisitor() {

        Produto produto =
                new Produto(
                        "X-Burger",
                        25
                );

        Visitor visitor =
                new RelatorioPrecoVisitor();

        assertTrue(
                produto.aceitar(visitor)
                        .contains("X-Burger")
        );
    }
}
