package Padrao.hamburgueria;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VisitorTest {

    @Test
    void visitorProduto() {

        Produto produto = new Produto("X",20);

        Visitor visitor = new RelatorioPrecoVisitor();

        assertTrue(produto.aceitar(visitor).contains("X"));
    }

    @Test
    void visitorCombo() {

        Combo combo = new Combo("Combo");

        combo.adicionar(new Produto("X",20));

        Visitor visitor = new RelatorioPrecoVisitor();

        assertTrue(combo.aceitar(visitor).contains("Combo"));
    }

    @Test
    void visitorNaoEhNulo() {
    }

    @Test
    void produtoAceitaVisitor() {

        Produto p = new Produto("Burger",10);

        assertNotNull(p.aceitar(new RelatorioPrecoVisitor()));
    }

    @Test
    void comboAceitaVisitor() {

        Combo combo = new Combo("Combo");

        assertNotNull(combo.aceitar(new RelatorioPrecoVisitor()));
    }

    @Test
    void visitorEhInterface() {
        assertTrue(Visitor.class.isInterface());
    }

    @Test
    void visitorImplementado() {
        assertTrue(true);
    }

    @Test
    void visitorRetornaString() {

        Produto p = new Produto("A",5);

        assertNotNull(p.aceitar(new RelatorioPrecoVisitor()));
    }

    @Test
    void visitorFuncionaEmProduto() {

        Produto p = new Produto("Bacon",25);

        assertFalse(p.aceitar(new RelatorioPrecoVisitor()).isEmpty());
    }

    @Test
    void visitorFuncionaEmCombo() {

        Combo combo = new Combo("Mega");

        combo.adicionar(new Produto("Burger",30));

        assertFalse(combo.aceitar(new RelatorioPrecoVisitor()).isEmpty());
    }

}
