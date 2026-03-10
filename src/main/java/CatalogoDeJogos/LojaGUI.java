package CatalogoDeJogos;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

public class LojaGUI extends JFrame {
    JLabel linha1, linha2;
    JButton btCadastrar, btPesquisar, btRemover;
    private LojaGerente loja = new LojaGerente();

    public LojaGUI() {
        ImageIcon iconeOriginal = new ImageIcon("src/img/5847540.png");
        Image imagemAjustada = iconeOriginal.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon iconeFinal = new ImageIcon(imagemAjustada);


        setTitle("CATÁLOGO DE JOGOS");
        setSize(1000, 600);
        setLocation(150, 150);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.BLACK);
        getContentPane().setLayout(new GridLayout(5, 2));


        Dimension tamanhoBotao = new Dimension(300, 50);
        Font fonteBotao = new Font("Georgia", Font.BOLD, 14);
        Color corFundo = new Color(50, 50, 50);


        btCadastrar = new JButton("CADASTRAR JOGO NO CATÁLOGO");

        btCadastrar.setForeground(Color.LIGHT_GRAY);
        btCadastrar.setBackground(corFundo);
        btCadastrar.setFont(fonteBotao);
        btCadastrar.setPreferredSize(tamanhoBotao);
        btCadastrar.setFocusPainted(false);

        btCadastrar.addActionListener(e -> {
            try {
                String titulo = JOptionPane.showInputDialog("Título do Jogo:");
                String genero = JOptionPane.showInputDialog("Gênero do Jogo");
                String plataforma = JOptionPane.showInputDialog("Plataforma:");
                double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor:"));

                Jogo novoJogo = new Jogo(titulo, genero, plataforma, valor);
                loja.cadastrarJogo(novoJogo);
                JOptionPane.showMessageDialog(this, "Jogo cadastrado!");
            } catch (JogoJaExisteException ex) {
                JOptionPane.showMessageDialog(this, "Jogo já cadastrado");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Erro: Digite um número válido para o valor.");
            }
        });


        btPesquisar = new JButton("PESQUISAR JOGO");
        btPesquisar.setForeground(Color.LIGHT_GRAY);
        btPesquisar.setBackground(corFundo);
        btPesquisar.setFont(fonteBotao);
        btPesquisar.setPreferredSize(tamanhoBotao);
        btPesquisar.setFocusPainted(false);

        btPesquisar.addActionListener(e -> {
            try {
                String pesquisa = JOptionPane.showInputDialog("Qual o título do jogo?");
                Collection<Jogo> encontrado = loja.pesquisarJogo(pesquisa);
                for (Jogo j : encontrado) {
                    JOptionPane.showMessageDialog(this, j.toString());
                }
            } catch (JogoNaoEncontradoException ex) {
                JOptionPane.showMessageDialog(this, "Jogo não encontrado no catálogo");
            }
        });

        // 3. Botão Remover
        btRemover = new JButton("REMOVER JOGO DO CATÁLOGO");
        btRemover.setForeground(Color.LIGHT_GRAY);
        btRemover.setBackground(corFundo);
        btRemover.setFont(fonteBotao);
        btRemover.setPreferredSize(tamanhoBotao);
        btRemover.setFocusPainted(false);

        btRemover.addActionListener(e -> {
            try {
                String titulo = JOptionPane.showInputDialog("Qual o título do jogo?");
                String plataforma = JOptionPane.showInputDialog("Qual a plataforma do jogo?");
                loja.removerJogo(titulo, plataforma);
                JOptionPane.showMessageDialog(this, "Jogo removido do Catálogo");
            } catch (JogoNaoEncontradoException ex) {
                JOptionPane.showMessageDialog(this, "Jogo não encontrado no catálogo");
            }
        });


        linha1 = new JLabel("SEJA BEM VINDO AO CATÁLOGO", JLabel.CENTER);
        linha1.setForeground(Color.WHITE);
        linha1.setFont(new Font("Arial", Font.ITALIC, 20));
        linha2 = new JLabel(iconeFinal, JLabel.CENTER);


        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p1.setBackground(Color.BLACK);
        p1.add(btCadastrar);

        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p2.setBackground(Color.BLACK);
        p2.add(btPesquisar);

        JPanel p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p3.setBackground(Color.BLACK);
        p3.add(btRemover);


        getContentPane().add(linha1);
        getContentPane().add(linha2);
        getContentPane().add(p1);
        getContentPane().add(p2);
        getContentPane().add(p3);

        setVisible(true);
    }

    public static void main(String[] args) {
        new LojaGUI();
    }
}