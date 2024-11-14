package estoque;
import javax.swing.*;
import java.awt.*;

public class JanelaEstoque extends JFrame {

    public JanelaEstoque(Estoque estoque) {
        // Configs do Frame
        setTitle("Estoque Atual");
        setSize(700, 200);
        setLayout(new BorderLayout());

        // texto para mostrar os prods
        JTextArea areaProdutos = new JTextArea();
        areaProdutos.setEditable(false);

        // Add os produtos na área de texto
        for (Produto produto : estoque.getProdutos()) {
            areaProdutos.append(produto.toString() + "\n");
        }

        // Add a área de texto dentro de um painel
        JScrollPane painelRolagem = new JScrollPane(areaProdutos);
        add(painelRolagem, BorderLayout.CENTER);
    }
}
