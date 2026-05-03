package Padrao.hamburgueria;

public class FabricaClassica implements FabricaIngredientes {
    public String criarPao() { return "Pão tradicional"; }
    public String criarCarne() { return "Carne bovina"; }
    public String criarMolho() { return "Ketchup"; }
}