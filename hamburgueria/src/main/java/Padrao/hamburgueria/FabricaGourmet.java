package Padrao.hamburgueria;

public class FabricaGourmet implements FabricaIngredientes {
    public String criarPao() { return "Pão brioche"; }
    public String criarCarne() { return "Carne angus"; }
    public String criarMolho() { return "Molho especial"; }
}