package amigosecreto;

import javax.swing.JOptionPane;

public class TestaSistemaAmigoGUI {

    public static void main(String[] args) {

        SistemaAmigo sistema = new SistemaAmigo();

        String quantTexto = JOptionPane.showInputDialog("quantia de amigos");
        int quantAmigos = Integer.parseInt(quantTexto);

        for (int k = 0; k < quantAmigos; k++) {
            String nome = JOptionPane.showInputDialog("nome do amigo " + (k + 1) + ":");
            String email = JOptionPane.showInputDialog("email do amigo " + (k + 1) + ":");

            try {
                sistema.cadastraAmigo(nome, email);
            } catch (AmigoJaExisteException e) {
                JOptionPane.showMessageDialog(null, "erro: " + e.getMessage());
                k--;
            }
        }

        for (int k = 0; k < quantAmigos; k++) {
            String emailPessoa = JOptionPane.showInputDialog("Sorteio " + (k + 1) + "\nQuem tirou o papel? (Email):");
            String emailSorteado = JOptionPane.showInputDialog("Quem essa pessoa tirou? (Email):");

            try {
                sistema.configuraAmigoSecretoDe(emailPessoa, emailSorteado);
            } catch (AmigoInexistenteException e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                k--;
            }
        }

        String remetente = JOptionPane.showInputDialog("--- Mensagem para Todos ---\nDigite o email do remetente:");
        String texto = JOptionPane.showInputDialog("Digite o texto da mensagem:");

        int respostaAnonima = JOptionPane.showConfirmDialog(null, "A mensagem é anônima?", "Opções", JOptionPane.YES_NO_OPTION);
        boolean ehAnonima = (respostaAnonima == JOptionPane.YES_OPTION);

        sistema.enviarMensagemParaTodos(texto, remetente, ehAnonima);

    }
}