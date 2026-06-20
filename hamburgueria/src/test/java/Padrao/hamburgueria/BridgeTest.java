package Padrao.hamburgueria;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes do padrão Bridge
 */
public class BridgeTest {

    @Test
    void deveCriarHamburguerNaChapa() {

        Lanche lanche =
                new Hamburguer(new FabricaClassica(), new NaChapa());

        assertNotNull(lanche);
    }

    @Test
    void deveCriarHamburguerNoForno() {

        Lanche lanche =
                new Hamburguer(new FabricaClassica(), new NoForno());

        assertNotNull(lanche);
    }

    @Test
    void deveCriarWrapNaChapa() {

        Lanche lanche =
                new Wrap(new FabricaGourmet(), new NaChapa());

        assertNotNull(lanche);
    }

    @Test
    void deveCriarWrapNoForno() {

        Lanche lanche =
                new Wrap(new FabricaGourmet(), new NoForno());

        assertNotNull(lanche);
    }

    @Test
    void descricaoNaoPodeSerNula() {

        Lanche lanche =
                new Hamburguer(new FabricaClassica(), new NaChapa());

        assertNotNull(lanche.descricao());
    }

    @Test
    void precoMaiorQueZero() {

        Lanche lanche =
                new Hamburguer(new FabricaClassica(), new NaChapa());

        assertTrue(lanche.preco() > 0);
    }

    @Test
    void modoNaChapaNaoPodeSerNulo() {

        assertNotNull(new NaChapa());
    }

    @Test
    void modoNoFornoNaoPodeSerNulo() {

        assertNotNull(new NoForno());
    }

    @Test
    void fabricaPodeSerClassica() {

        FabricaIngredientes fabrica =
                new FabricaClassica();

        assertNotNull(fabrica);
    }

    @Test
    void fabricaPodeSerGourmet() {

        FabricaIngredientes fabrica =
                new FabricaGourmet();

        assertNotNull(fabrica);
    }

}