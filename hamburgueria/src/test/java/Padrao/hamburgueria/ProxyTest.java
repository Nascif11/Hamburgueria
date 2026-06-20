package Padrao.hamburgueria;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProxyTest {

    @Test
    void confirmadoPodeIrParaPreparo() {

        assertTrue(
                ValidarEstado.podeTransicionar(
                        new Confirmado(),
                        new EmPreparo()
                )
        );
    }

    @Test
    void confirmadoPodeCancelar() {

        assertTrue(
                ValidarEstado.podeTransicionar(
                        new Confirmado(),
                        new Cancelado()
                )
        );
    }

    @Test
    void preparoPodeEntregar() {

        assertTrue(
                ValidarEstado.podeTransicionar(
                        new EmPreparo(),
                        new SaiuParaEntrega()
                )
        );
    }

    @Test
    void preparoPodeCancelar() {

        assertTrue(
                ValidarEstado.podeTransicionar(
                        new EmPreparo(),
                        new Cancelado()
                )
        );
    }

    @Test
    void saiuEntregaPodeEntregar() {

        assertTrue(
                ValidarEstado.podeTransicionar(
                        new SaiuParaEntrega(),
                        new Entregue()
                )
        );
    }

    @Test
    void entregueNaoPodeCancelar() {

        assertFalse(
                ValidarEstado.podeTransicionar(
                        new Entregue(),
                        new Cancelado()
                )
        );
    }

    @Test
    void canceladoNaoPodePreparar() {

        assertFalse(
                ValidarEstado.podeTransicionar(
                        new Cancelado(),
                        new EmPreparo()
                )
        );
    }

    @Test
    void entregueNaoPodeVoltar() {

        assertFalse(
                ValidarEstado.podeTransicionar(
                        new Entregue(),
                        new Confirmado()
                )
        );
    }

    @Test
    void proxyExiste() {

    }

    @Test
    void metodoEhEstatico() {

        assertDoesNotThrow(() ->
                ValidarEstado.podeTransicionar(
                        new Confirmado(),
                        new EmPreparo()
                )
        );
    }

}
