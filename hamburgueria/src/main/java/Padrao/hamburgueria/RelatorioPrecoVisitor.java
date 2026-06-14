package Padrao.hamburgueria;

public class RelatorioPrecoVisitor
        implements Visitor {

    @Override
    public String visitarProduto(Produto produto) {
        return "Produto: "
                + produto.getNome()
                + " - R$ "
                + produto.getPreco();
    }

    @Override
    public String visitarCombo(Combo combo) {
        return "Combo: "
                + combo.getNome()
                + " - R$ "
                + combo.getPreco();
    }
}