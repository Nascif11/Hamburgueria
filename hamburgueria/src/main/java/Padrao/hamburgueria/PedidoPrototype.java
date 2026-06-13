package Padrao.hamburgueria;

public class PedidoPrototype
        implements Cloneable {

    private String lanche;

    public PedidoPrototype(String lanche) {
        this.lanche = lanche;
    }

    public String getLanche() {
        return lanche;
    }

    @Override
    public PedidoPrototype clone() {

        try {
            return (PedidoPrototype) super.clone();
        }
        catch(CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
