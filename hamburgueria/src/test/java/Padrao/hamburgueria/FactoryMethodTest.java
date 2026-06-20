package Padrao.hamburgueria;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes - Factory Method
 */
public class FactoryMethodTest {

    @Test
    void deveCriarHamburguer() {
        LancheFactory factory = new HamburguerFactory();
        Lanche lanche = factory.criarLanche();

        assertNotNull(lanche);
    }

    @Test
    void deveCriarWrap() {
        LancheFactory factory = new WrapFactory();
        Lanche lanche = factory.criarLanche();

        assertNotNull(lanche);
    }

    @Test
    void deveRetornarHamburguer() {
        LancheFactory factory = new HamburguerFactory();

        assertTrue(factory.criarLanche() instanceof Hamburguer);
    }

    @Test
    void deveRetornarWrap() {
        LancheFactory factory = new WrapFactory();

        assertTrue(factory.criarLanche() instanceof Wrap);
    }

    @Test
    void hamburguerNaoPodeSerNulo() {
        assertNotNull(new HamburguerFactory().criarLanche());
    }

    @Test
    void wrapNaoPodeSerNulo() {
        assertNotNull(new WrapFactory().criarLanche());
    }

    @Test
    void deveCriarHamburguerComDescricao() {

        Lanche lanche = new HamburguerFactory().criarLanche();

        assertNotNull(lanche.descricao());
    }

    @Test
    void deveCriarWrapComDescricao() {

        Lanche lanche = new WrapFactory().criarLanche();

        assertNotNull(lanche.descricao());
    }

    @Test
    void precoHamburguerMaiorQueZero() {

        Lanche lanche = new HamburguerFactory().criarLanche();

        assertTrue(lanche.preco() > 0);
    }

    @Test
    void precoWrapMaiorQueZero() {

        Lanche lanche = new WrapFactory().criarLanche();

        assertTrue(lanche.preco() > 0);
    }

}
