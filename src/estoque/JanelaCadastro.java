package estoque;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaCadastro extends JFrame {
    private Estoque estoque;

    public JanelaCadastro() {
        estoque = new Estoque();

        // configs do Frame cadastro
        setTitle("Cadastro de Produtos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel para os campos de entrada e botões
        JPanel painelCentral = new JPanel();
        painelCentral.setLayout(new GridLayout(4, 2, 5, 5));

        // Criação dos campos de entrada e botões
        JLabel labelNome = new JLabel("Nome do Produto:");
        JTextField campoNome = new JTextField();

        JLabel labelPreco = new JLabel("Preço:");
        JTextField campoPreco = new JTextField();

        JLabel labelQuantidade = new JLabel("Quantidade:");
        JTextField campoQuantidade = new JTextField();

        JButton botaoCadastrar = new JButton("Cadastrar Produto");
        JButton botaoVerificarEstoque = new JButton("Verificar Estoque");

        // Adding componentes ao painel
        painelCentral.add(labelNome);
        painelCentral.add(campoNome);
        painelCentral.add(labelPreco);
        painelCentral.add(campoPreco);
        painelCentral.add(labelQuantidade);
        painelCentral.add(campoQuantidade);
        painelCentral.add(botaoCadastrar);
        painelCentral.add(botaoVerificarEstoque);

        // Adding panel à janela
        add(painelCentral, BorderLayout.CENTER);

        // Msg de sucesso
        JLabel mensagemSucesso = new JLabel("", SwingConstants.CENTER);
        mensagemSucesso.setForeground(Color.GREEN);
        add(mensagemSucesso, BorderLayout.SOUTH);

        // actions do botão de cadastro
        botaoCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = campoNome.getText();
                double preco = 0;
                int quantidade = 0;

                try {
                    preco = Double.parseDouble(campoPreco.getText());
                    quantidade = Integer.parseInt(campoQuantidade.getText());
                } catch (NumberFormatException ex) {
                    mensagemSucesso.setText("Erro: Verifique os valores de preço e quantidade.");
                    return;
                }

                Produto produto = new Produto(nome, preco, quantidade);
                estoque.adicionarProduto(produto);

                // clean ao apertar o botão
                campoNome.setText("");
                campoPreco.setText("");
                campoQuantidade.setText("");
                mensagemSucesso.setText("Produto cadastrado com sucesso!");
            }
        });

        // action do botão verificar estoque
        botaoVerificarEstoque.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JanelaEstoque janelaEstoque = new JanelaEstoque(estoque);
                janelaEstoque.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        JanelaCadastro janela = new JanelaCadastro();
        janela.setVisible(true);
    }
}
