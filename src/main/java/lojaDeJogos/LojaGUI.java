package lojaDeJogos;
import javax.swing.*;
import java.awt.*;

public class LojaGUI extends JFrame {
    private LojaGerente loja = new LojaGerente();

    public LojaGUI() {
        setTitle("Minha Loja de Jogos");
        setSize(400, 250);
        setLocation(150, 150);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(Color.lightGray);

        setLayout(new GridLayout(3, 1, 10, 10));

        JButton btnAdd = new JButton("CADASTRAR JOGO");
        JButton btnVer = new JButton("PESQUISAR JOGO");
        JButton btnDel = new JButton("REMOVER JOGO");


        btnAdd.addActionListener(e -> {
            String nome = JOptionPane.showInputDialog("Nome do jogo:");
            String plat = JOptionPane.showInputDialog("Plataforma:");
            String gen = JOptionPane.showInputDialog("Gênero:");

            if (nome != null && plat != null) {
                try {
                    loja.cadastrarJogo(new Jogo(nome, gen, plat));
                    JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
                } catch (Exception erro) {
                    JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage());
                }
            }
        });

        btnVer.addActionListener(e -> {
            String busca = JOptionPane.showInputDialog("Qual nome do jogo?");
            try {
                var resultado = loja.pesquisarJogo(busca);
                JOptionPane.showMessageDialog(null, "Encontrado: " + resultado);
            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, "Não achei: " + erro.getMessage());
            }
        });


        btnDel.addActionListener(e -> {
            String nomeRemover = JOptionPane.showInputDialog("Nome para remover:");
            String platRemover = JOptionPane.showInputDialog("Plataforma:");
            try {
                loja.removerJogo(nomeRemover, platRemover);
                JOptionPane.showMessageDialog(null, "Removido!");
            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, "Erro ao remover: " + erro.getMessage());
            }
        });


        add(btnAdd);
        add(btnVer);
        add(btnDel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new LojaGUI();
    }
}