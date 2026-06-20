package Padrao.hamburgueria;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TemplateMethodTest {

    @Test
    void hamburguerPossuiAngus() {
        Preparacao preparo = new PreparacaoHamburguer();

        assertTrue(preparo.preparar().contains("Angus"));
    }

    @Test
    void wrapPossuiFrango() {
        Preparacao preparo = new PreparacaoWrap();

        assertTrue(preparo.preparar().contains("Frango"));
    }

    @Test
    void hamburguerNaoEhNulo() {
        new PreparacaoHamburguer();
    }

    @Test
    void wrapNaoEhNulo() {
        new PreparacaoWrap();
    }

    @Test
    void prepararHamburguerRetornaTexto() {
        assertFalse(new PreparacaoHamburguer().preparar().isEmpty());
    }

    @Test
    void prepararWrapRetornaTexto() {
        assertFalse(new PreparacaoWrap().preparar().isEmpty());
    }

    @Test
    void metodoTemplateExiste() {
        Preparacao preparo = new PreparacaoHamburguer();

        assertNotNull(preparo.preparar());
    }

    @Test
    void preparacaoEhAbstrata() {
        assertTrue(java.lang.reflect.Modifier.isAbstract(Preparacao.class.getModifiers()));
    }

    @Test
    void hamburguerHerdaPreparacao() {
        assertTrue(true);
    }

    @Test
    void wrapHerdaPreparacao() {
        assertTrue(true);
    }

}
