package Padrao.hamburgueria;

import Padrao.hamburgueria.Lanche;

public abstract class LancheDecorator extends Lanche {

    protected Lanche lanche;

    public LancheDecorator(Lanche lanche) {
        super(lanche.fabrica, lanche.modo);
        this.lanche = lanche;
    }
}