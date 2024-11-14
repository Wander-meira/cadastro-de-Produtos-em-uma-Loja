package estoque;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaCadastro extends JFrame {
    private Estoque estoque;

    public JanelaCadastro() {
        estoque = new Estoque();

        // configs da janela
        setTitle("Cadastro de Produtos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // JPanel central para os campos de entrada e botões
        JPanel painelCentral = new JPanel(new GridLayout(4, 2, 5, 5));

        // campos de entrada
        JLabel labelNome = new JLabel("Nome do Produto:");
        JTextField campoNome = new JTextField();

        JLabel labelPreco = new JLabel("Preço:");
        JTextField campoPreco = new JTextField();

        JLabel labelQuantidade = new JLabel("Quantidade:");
        JTextField campoQuantidade = new JTextField();

        JButton botaoCadastrar = new JButton("Cadastrar Produto");
        JButton botaoVerificarEstoque = new JButton("Verificar Estoque");

        // Add componentes ao painel central
        painelCentral.add(labelNome);
        painelCentral.add(campoNome);
        painelCentral.add(labelPreco);
        painelCentral.add(campoPreco);
        painelCentral.add(labelQuantidade);
        painelCentral.add(campoQuantidade);
        painelCentral.add(botaoCadastrar);
        painelCentral.add(botaoVerificarEstoque);

        // alinhando o  painel central ao centro da janela
        add(painelCentral, BorderLayout.CENTER);

        // Msg de sucesso do cadastro
        JLabel mensagemSucesso = new JLabel("", SwingConstants.CENTER);
        mensagemSucesso.setForeground(Color.GREEN);
        add(mensagemSucesso, BorderLayout.SOUTH);

        // Func para cadastrar
        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = campoNome.getText();
                double preco = Double.parseDouble(campoPreco.getText());
                int quantidade = Integer.parseInt(campoQuantidade.getText());

                Produto produto = new Produto(nome, preco, quantidade);
                estoque.adicionarProduto(produto);

                // Limpar campos e exibir mensagem de sucesso
                campoNome.setText("");
                campoPreco.setText("");
                campoQuantidade.setText("");
                mensagemSucesso.setText("Seu produto foi cadastrado com sucesso!");
            }
        });

        // Func para verificar o estoque
        botaoVerificarEstoque.addActionListener(new ActionListener() {
            @Override
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
