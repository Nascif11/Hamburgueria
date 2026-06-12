package Padrao.hamburgueria;

public class AvaliacaoTexto implements IAvaliacaoPedido {

    private String avaliacao;

    @Override
    public String getAvaliacao() {
        return avaliacao;
    }

    @Override
    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }
}
