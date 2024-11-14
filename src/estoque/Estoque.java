package estoque;
import java.util.ArrayList;

public class Estoque {
    private final ArrayList<Produto> produtos;

    // inicia lista de produtos
    public Estoque() {
        produtos = new ArrayList<>();
    }

    // adding um produto à lista
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    // obter a lista de produtos
    public ArrayList<Produto> getProdutos() {
        return produtos;
    }
}
