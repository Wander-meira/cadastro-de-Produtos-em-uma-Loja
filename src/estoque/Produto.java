package estoque;

public class Produto {
    private final String nome;
    private final double preco;
    private final int quantidade;

    // atributos do produto
    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }
    @Override
    public String toString() {
        return nome + " - Preço: R$" + preco + " - Quantidade: " + quantidade;
    }
}
