package Padrao.hamburgueria;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StateTest {

    @Test
    void estadoConfirmado() {
        assertEquals("Confirmado",
                new Confirmado().getEstado());
    }

    @Test
    void estadoEmPreparo() {
        assertEquals("Em preparo",
                new EmPreparo().getEstado());
    }

    @Test
    void estadoSaiuEntrega() {
        assertEquals("Saiu para Entrega",
                new SaiuParaEntrega().getEstado());
    }

    @Test
    void estadoEntregue() {
        assertEquals("Entregue",
                new Entregue().getEstado());
    }

    @Test
    void estadoCancelado() {
        assertEquals("Cancelado",
                new Cancelado().getEstado());
    }

    @Test
    void confirmarParaPreparo() {

        assertTrue(
                ValidarEstado.podeTransicionar(
                        new Confirmado(),
                        new EmPreparo()));
    }

    @Test
    void preparoParaEntrega() {

        assertTrue(
                ValidarEstado.podeTransicionar(
                        new EmPreparo(),
                        new SaiuParaEntrega()));
    }

    @Test
    void entregaParaEntregue() {

        assertTrue(
                ValidarEstado.podeTransicionar(
                        new SaiuParaEntrega(),
                        new Entregue()));
    }

    @Test
    void entregueNaoPodeCancelar() {

        assertFalse(
                ValidarEstado.podeTransicionar(
                        new Entregue(),
                        new Cancelado()));
    }

    @Test
    void canceladoNaoPodePreparar() {

        assertFalse(
                ValidarEstado.podeTransicionar(
                        new Cancelado(),
                        new EmPreparo()));
    }

}
