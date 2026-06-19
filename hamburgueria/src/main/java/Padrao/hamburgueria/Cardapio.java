package Padrao.hamburgueria;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Padrão Iterator
 * Permite iterar sobre itens do cardápio sem expor sua estrutura interna
 */

// ===== INTERFACE ITERATOR =====

interface IteradorCardapio extends Iterator<ItemCardapio> {
    boolean temProximo();
    ItemCardapio proximo();
}

// ===== IMPLEMENTAÇÃO DO ITERATOR =====

class IteradorCardapioImpl implements IteradorCardapio {

    private List<ItemCardapio> itens;
    private int indice = 0;

    public IteradorCardapioImpl(List<ItemCardapio> itens) {
        this.itens = itens;
    }

    @Override
    public boolean temProximo() {
        return indice < itens.size();
    }

    @Override
    public ItemCardapio proximo() {
        if (!temProximo()) {
            throw new IndexOutOfBoundsException("Fim do cardápio");
        }
        return itens.get(indice++);
    }

    @Override
    public boolean hasNext() {
        return temProximo();
    }

    @Override
    public ItemCardapio next() {
        return proximo();
    }

    /**
     * Resetar iterador
     */
    public void resetar() {
        indice = 0;
    }
}

// ===== CARDÁPIO (ITERABLE) =====

public class Cardapio implements Iterable<ItemCardapio> {

    private List<ItemCardapio> itens = new ArrayList<>();

    /**
     * Adicionar item ao cardápio
     */
    public void adicionar(ItemCardapio item) {
        if (item == null) {
            throw new IllegalArgumentException("Item não pode ser nulo");
        }
        itens.add(item);
    }

    /**
     * Remover item
     */
    public void remover(ItemCardapio item) {
        itens.remove(item);
    }

    /**
     * Obter item por índice
     */
    public ItemCardapio obter(int indice) {
        return itens.get(indice);
    }

    /**
     * Tamanho do cardápio
     */
    public int tamanho() {
        return itens.size();
    }

    /**
     * Obter todos os itens
     */
    public List<ItemCardapio> obterTodos() {
        return new ArrayList<>(itens);
    }

    /**
     * Filtrar itens por nome
     */
    public List<ItemCardapio> filtrarPorNome(String nome) {
        List<ItemCardapio> resultado = new ArrayList<>();
        for (ItemCardapio item : itens) {
            if (item instanceof Produto) {
                Produto p = (Produto) item;
                if (p.getNome().toLowerCase().contains(nome.toLowerCase())) {
                    resultado.add(item);
                }
            } else if (item instanceof Combo) {
                Combo c = (Combo) item;
                if (c.getNome().toLowerCase().contains(nome.toLowerCase())) {
                    resultado.add(item);
                }
            }
        }
        return resultado;
    }

    /**
     * Filtrar itens por preço máximo
     */
    public List<ItemCardapio> filtrarPorPreco(double precoMaximo) {
        List<ItemCardapio> resultado = new ArrayList<>();
        for (ItemCardapio item : itens) {
            if (item.getPreco() <= precoMaximo) {
                resultado.add(item);
            }
        }
        return resultado;
    }

    @Override
    public Iterator<ItemCardapio> iterator() {
        return new IteradorCardapioImpl(itens);
    }

    /**
     * Obter iterador customizado
     */
    public IteradorCardapio obterIterador() {
        return new IteradorCardapioImpl(itens);
    }

    public void exibir() {


        if (itens.isEmpty()) {
            System.out.println("Cardápio vazio");
        } else {
            int contador = 1;
            for (ItemCardapio item : this) {
                if (item instanceof Produto) {
                    Produto p = (Produto) item;
                    System.out.printf("%d. %s - R$ %.2f\n", contador, p.getNome(), p.getPreco());
                } else if (item instanceof Combo) {
                    Combo c = (Combo) item;
                    System.out.printf("%d. %s (COMBO) - R$ %.2f\n", contador, c.getNome(), c.getPreco());
                }
                contador++;
            }
        }

    }

    /**
     * Exibir com visitor (usando padrão Visitor)
     */
    public void exibirComVisitor(Visitor visitor) {

        for (ItemCardapio item : this) {
            System.out.println(item.aceitar(visitor));
        }


    }
}