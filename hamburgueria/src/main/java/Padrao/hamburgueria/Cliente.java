package Padrao.hamburgueria;

import org.jspecify.annotations.Nullable;

import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer {

    private String nome;
    private String status;

    private IAvaliacaoPedido avaliacao;
    private AvaliacaoAdapter adapter;
    private Pedido ultimoPedido;

    public Pedido repetirUltimoPedido() {
        if (ultimoPedido == null)
            throw new IllegalStateException("Nenhum pedido anterior");
        return ultimoPedido.clone();
    }
    public void setUltimoPedido(Pedido pedido) {
        this.ultimoPedido = pedido;
    }


    public Cliente(String nome) {
        this.nome = nome;

        avaliacao = new AvaliacaoTexto();
        adapter = new AvaliacaoAdapter(avaliacao);
    }

    public void setAvaliacao(String avaliacaoTexto) {
        avaliacao.setAvaliacao(avaliacaoTexto);
        adapter.salvarAvaliacao();
    }




    public String getAvaliacao() {
        return adapter.recuperarAvaliacao();
    }

    public float getNota() {
        return adapter.getNota();
    }
    public String getNome() {
        return nome;
    }

    @Override
    public void update(Observable o, Object arg) {
        status = nome + " recebeu atualização: " + o.toString();
    }

    public String getStatus() {
        return status;
    }

}