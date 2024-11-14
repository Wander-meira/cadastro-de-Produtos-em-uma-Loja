package estoque;
import javax.swing.*;
import java.awt.*;

public class JanelaEstoque extends JFrame {

    public JanelaEstoque(Estoque estoque) {
        // Configs da janela de estoque
        setTitle("Estoque Atual");
        setSize(300, 200);
        setLayout(new BorderLayout());

        JTextArea areaProdutos = new JTextArea();
        areaProdutos.setEditable(false);

        // adding produtos do estoque
        for (Produto produto : estoque.getProdutos()) {
            areaProdutos.append(produto.toString() + "\n");
        }

        add(new JScrollPane(areaProdutos), BorderLayout.CENTER);
    }
}
