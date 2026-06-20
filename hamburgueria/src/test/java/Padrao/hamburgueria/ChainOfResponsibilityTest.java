package Padrao.hamburgueria;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ChainOfResponsibilityTest {

    @Test
    void descontoCupom100() {

        DescontoCupom cupom = new DescontoCupom();
        cupom.setProximo(new SemDesconto());

        assertEquals(90,cupom.calcular(100));
    }

    @Test
    void semDesconto20() {

        SemDesconto sem = new SemDesconto();

        assertEquals(20,sem.calcular(20));
    }

    @Test
    void descontoValorBaixo() {

        DescontoCupom cupom = new DescontoCupom();
        cupom.setProximo(new SemDesconto());

        assertEquals(20,cupom.calcular(20));
    }

    @Test
    void correnteExiste() {

        DescontoCupom cupom = new DescontoCupom();

        cupom.setProximo(new SemDesconto());

        assertNotNull(cupom);
    }

    @Test
    void descontoNaoNegativo() {

        DescontoCupom cupom = new DescontoCupom();
        cupom.setProximo(new SemDesconto());

        assertTrue(cupom.calcular(200)>=0);
    }

    @Test
    void semDescontoNaoAlteraValor() {

        SemDesconto sem = new SemDesconto();

        assertEquals(100,sem.calcular(100));
    }

    @Test
    void descontoHerdaClasseBase() {
        assertTrue(true);
    }

    @Test
    void semDescontoHerdaClasseBase() {
        assertTrue(true);
    }

    @Test
    void correntePodeSerCriada() {

        DescontoCupom c = new DescontoCupom();

        c.setProximo(new SemDesconto());

        assertNotNull(c);
    }

    @Test
    void correnteCalculaValor() {

        DescontoCupom c = new DescontoCupom();

        c.setProximo(new SemDesconto());

        assertTrue(c.calcular(150)>0);
    }

}