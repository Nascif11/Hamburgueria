package Padrao.hamburgueria;

public interface Visitor {

    String visitarProduto(Produto produto);

    String visitarCombo(Combo combo);

}
