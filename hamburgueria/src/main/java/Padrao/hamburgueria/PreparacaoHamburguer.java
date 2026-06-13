package Padrao.hamburgueria;

public class PreparacaoHamburguer extends Preparacao {

    @Override
    protected String abrirBase() {
        return "Pão brioche";
    }

    @Override
    protected String adicionarRecheio() {
        return "Carne Angus";
    }

    @Override
    protected String finalizar() {
        return "Hambúrguer pronto";
    }
}
