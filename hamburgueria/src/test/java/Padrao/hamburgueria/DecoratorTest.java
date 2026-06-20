package Padrao.hamburgueria;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes - Decorator
 */
public class DecoratorTest {

    @Test
    void deveCriarHamburguer() {
        Lanche lanche = new Hamburguer(new FabricaClassica(), new NaChapa());
        assertNotNull(lanche);
    }

    @Test
    void deveAdicionarQueijo() {
        Lanche lanche = new Hamburguer(new FabricaClassica(), new NaChapa());
        lanche = new ExtraQueijo(lanche);

        assertTrue(lanche.descricao().contains("Queijo"));
    }

    @Test
    void precoComQueijoMaior() {
        Lanche normal = new Hamburguer(new FabricaClassica(), new NaChapa());

        Lanche queijo = new ExtraQueijo(
                new Hamburguer(new FabricaClassica(), new NaChapa()));

        assertTrue(queijo.preco() > normal.preco());
    }

    @Test
    void deveEmpilharDecorators() {
        Lanche lanche = new Hamburguer(new FabricaClassica(), new NaChapa());

        lanche = new ExtraQueijo(lanche);
        lanche = new ExtraQueijo(lanche);

        assertTrue(lanche.descricao().contains("Queijo"));
    }

    @Test
    void descricaoNaoPodeSerNula() {
        Lanche lanche = new ExtraQueijo(
                new Hamburguer(new FabricaClassica(), new NaChapa()));

        assertNotNull(lanche.descricao());
    }

    @Test
    void precoMaiorQueZero() {
        Lanche lanche = new ExtraQueijo(
                new Hamburguer(new FabricaClassica(), new NaChapa()));

        assertTrue(lanche.preco() > 0);
    }

    @Test
    void decoratorEhLanche() {
        Lanche lanche = new ExtraQueijo(
                new Hamburguer(new FabricaClassica(), new NaChapa()));

        assertTrue(true);
    }

    @Test
    void deveAdicionarDoisQueijos() {

        Lanche lanche =
                new ExtraQueijo(
                        new ExtraQueijo(
                                new Hamburguer(
                                        new FabricaClassica(),
                                        new NaChapa())));

        assertTrue(lanche.preco() > 0);
    }

    @Test
    void descricaoAumenta() {

        Lanche normal =
                new Hamburguer(new FabricaClassica(), new NaChapa());

        Lanche queijo =
                new ExtraQueijo(
                        new Hamburguer(new FabricaClassica(), new NaChapa()));

        assertTrue(
                queijo.descricao().length() >
                        normal.descricao().length());
    }

    @Test
    void deveCriarDecorator() {

        new ExtraQueijo(
                new Hamburguer(
                        new FabricaClassica(),
                        new NaChapa()));
    }

}
