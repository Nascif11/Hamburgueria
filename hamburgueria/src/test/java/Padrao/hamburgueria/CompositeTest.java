package Padrao.hamburgueria;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes do padrão Composite
 */
public class CompositeTest {

    @Test
    void deveCriarProduto() {

        Produto produto =
                new Produto("Burger",20);

        assertNotNull(produto);
    }

    @Test
    void deveCriarCombo() {

        Combo combo =
                new Combo("Combo");

        assertNotNull(combo);
    }

    @Test
    void comboInicialValeZero() {

        Combo combo =
                new Combo("Combo");

        assertEquals(0, combo.getPreco());
    }

    @Test
    void deveAdicionarProdutoAoCombo() {

        Produto p =
                new Produto("Burger",20);

        Combo combo =
                new Combo("Combo");

        combo.adicionar(p);

    }

    @Test
    void deveAdicionarDoisProdutos() {

        Combo combo =
                new Combo("Combo");

        combo.adicionar(new Produto("Burger",20));
        combo.adicionar(new Produto("Batata",10));

        assertEquals(30, combo.getPreco());
    }

    @Test
    void comboPodeReceberTresProdutos() {

        Combo combo =
                new Combo("Combo");

        combo.adicionar(new Produto("Burger",20));
        combo.adicionar(new Produto("Batata",10));
        combo.adicionar(new Produto("Refri",8));

        assertEquals(38, combo.getPreco());
    }

    @Test
    void produtoTemNome() {

        Produto p =
                new Produto("Burger",20);

        assertEquals("Burger", p.getNome());
    }

    @Test
    void produtoTemPreco() {

        Produto p =
                new Produto("Burger",20);

        assertEquals(20, p.getPreco());
    }

    @Test
    void comboTemNome() {

        Combo combo =
                new Combo("Combo Família");

        assertEquals("Combo Família", combo.getNome());
    }

    @Test
    void visitorPodeVisitarProduto() {

        Produto produto =
                new Produto("Burger",20);

        Visitor visitor =
                new RelatorioPrecoVisitor();

        assertNotNull(produto.aceitar(visitor));
    }

}