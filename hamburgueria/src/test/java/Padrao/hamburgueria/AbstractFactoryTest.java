package Padrao.hamburgueria;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes - Abstract Factory
 */
public class AbstractFactoryTest {

    @Test
    void deveCriarPaoClassico() {

        FabricaIngredientes fabrica = new FabricaClassica();

        assertNotNull(fabrica.criarPao());
    }

    @Test
    void deveCriarCarneClassica() {

        FabricaIngredientes fabrica = new FabricaClassica();

        assertNotNull(fabrica.criarCarne());
    }

    @Test
    void deveCriarMolhoClassico() {

        FabricaIngredientes fabrica = new FabricaClassica();

        assertNotNull(fabrica.criarMolho());
    }

    @Test
    void deveCriarPaoGourmet() {

        FabricaIngredientes fabrica = new FabricaGourmet();

        assertNotNull(fabrica.criarPao());
    }

    @Test
    void deveCriarCarneGourmet() {

        FabricaIngredientes fabrica = new FabricaGourmet();

        assertNotNull(fabrica.criarCarne());
    }

    @Test
    void deveCriarMolhoGourmet() {

        FabricaIngredientes fabrica = new FabricaGourmet();

        assertNotNull(fabrica.criarMolho());
    }

    @Test
    void ingredientesClassicosDevemSerDiferentesDosGourmet() {

        FabricaIngredientes c = new FabricaClassica();
        FabricaIngredientes g = new FabricaGourmet();

        assertNotEquals(c.criarCarne(), g.criarCarne());
    }

    @Test
    void paoNaoPodeSerVazio() {

        FabricaIngredientes fabrica = new FabricaClassica();

        assertFalse(fabrica.criarPao().isEmpty());
    }

    @Test
    void carneNaoPodeSerVazia() {

        FabricaIngredientes fabrica = new FabricaGourmet();

        assertFalse(fabrica.criarCarne().isEmpty());
    }

    @Test
    void molhoNaoPodeSerVazio() {

        FabricaIngredientes fabrica = new FabricaGourmet();

        assertFalse(fabrica.criarMolho().isEmpty());
    }

}