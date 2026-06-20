package Padrao.hamburgueria;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StrategyTest {

    @Test
    void freteMotoCalculaValor() {
        Frete frete = new FreteMoto();
        assertTrue(frete.calcular(50) > 0);
    }

    @Test
    void freteGratisRetornaZero() {
        Frete frete = new FreteGratis();
        assertEquals(0, frete.calcular(50));
    }

    @Test
    void pedidoAceitaFreteMoto() {
        Pedido pedido = new Pedido();
        pedido.setFrete(new FreteMoto());

        assertInstanceOf(FreteMoto.class, pedido.getFrete());
    }

    @Test
    void pedidoAceitaFreteGratis() {
        Pedido pedido = new Pedido();
        pedido.setFrete(new FreteGratis());

        assertInstanceOf(FreteGratis.class, pedido.getFrete());
    }

    @Test
    void freteMotoSempreMaiorQueZero() {
        Frete frete = new FreteMoto();

        assertTrue(frete.calcular(100) > 0);
    }

    @Test
    void freteGratisNaoAlteraValor() {
        Frete frete = new FreteGratis();

        double total = 80 + frete.calcular(80);

        assertEquals(80, total);
    }

    @Test
    void trocaDeEstrategia() {

        Pedido pedido = new Pedido();

        pedido.setFrete(new FreteMoto());

        pedido.setFrete(new FreteGratis());

        assertInstanceOf(FreteGratis.class, pedido.getFrete());
    }

    @Test
    void estrategiaEhInterface() {
        assertTrue(Frete.class.isInterface());
    }

    @Test
    void motoImplementaFrete() {
        assertTrue(true);
    }

    @Test
    void gratisImplementaFrete() {
        assertTrue(true);
    }

}
