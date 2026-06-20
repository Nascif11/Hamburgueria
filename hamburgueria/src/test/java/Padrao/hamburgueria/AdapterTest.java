package Padrao.hamburgueria;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes do padrão Adapter
 */
public class AdapterTest {

    @Test
    void deveConverterExcelente() {

        AvaliacaoTexto texto = new AvaliacaoTexto();
        texto.setAvaliacao("Excelente");

        AvaliacaoAdapter adapter = new AvaliacaoAdapter(texto);

        adapter.salvarAvaliacao();

        assertEquals(10f, adapter.getNota());
    }

    @Test
    void deveConverterBom() {

        AvaliacaoTexto texto = new AvaliacaoTexto();
        texto.setAvaliacao("Bom");

        AvaliacaoAdapter adapter = new AvaliacaoAdapter(texto);

        adapter.salvarAvaliacao();

    }

    @Test
    void deveConverterRegular() {

        AvaliacaoTexto texto = new AvaliacaoTexto();
        texto.setAvaliacao("Regular");

        AvaliacaoAdapter adapter = new AvaliacaoAdapter(texto);

        adapter.salvarAvaliacao();


    }

    @Test
    void deveConverterRuim() {

        AvaliacaoTexto texto = new AvaliacaoTexto();
        texto.setAvaliacao("Ruim");

        AvaliacaoAdapter adapter = new AvaliacaoAdapter(texto);

        adapter.salvarAvaliacao();


    }

    @Test
    void deveRecuperarTexto() {

        AvaliacaoTexto texto = new AvaliacaoTexto();

        AvaliacaoAdapter adapter = new AvaliacaoAdapter(texto);

        adapter.setNota(10);

    }

    @Test
    void adapterNaoPodeSerNulo() {

        assertNotNull(new AvaliacaoAdapter(new AvaliacaoTexto()));
    }

    @Test
    void notaPodeSerAlterada() {

        AvaliacaoAdapter adapter =
                new AvaliacaoAdapter(new AvaliacaoTexto());

        adapter.setNota(7);


    }

    @Test
    void avaliacaoNaoPodeSerNula() {

        IAvaliacaoPedido avaliacao = new AvaliacaoTexto();

        assertNotNull(avaliacao);
    }

    @Test
    void textoInicialPodeSerNulo() {

        AvaliacaoTexto texto = new AvaliacaoTexto();

        assertNull(texto.getAvaliacao());
    }

    @Test
    void deveSalvarEAvaliar() {

        Cliente cliente = new Cliente("Lucas");

        cliente.setAvaliacao("Excelente");

    }

}