package estoque;

public class Produto {
    private String nome;
    private double preco;
    private int quantidade;

    // atributos do produto
    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    // get infos dos produtos
    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return nome + " - Preço: R$" + preco + " - Quantidade: " + quantidade;
    }
}
