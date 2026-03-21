package CatalogoDeJogos;

import javax.swing.*;
import java.util.*;
import java.io.IOException;

public class LojaGerente implements SistemaJogos {
    private Map<String, List<Jogo>> jogosMap = new HashMap<>();
    private GravadorDeDados gravador = new GravadorDeDados();

    @Override
    public void cadastrarJogo(Jogo jogo) {
        String chave = jogo.getTitulo().toLowerCase();
        jogosMap.putIfAbsent(chave, new ArrayList<>());
        List<Jogo> lista = jogosMap.get(chave);

        for (Jogo j : lista) {
            if (j.getPlataforma().equalsIgnoreCase(jogo.getPlataforma())) {
                j.setQuantidade(j.getQuantidade() + jogo.getQuantidade()); // seta a quantidade pra quantidade de cópias do jogo + a que já tinha
                return;
            }
        }
        lista.add(jogo);
    }

    @Override
    public Collection<Jogo> pesquisarJogo(String titulo) throws JogoNaoEncontradoException {
        String termo = titulo.toLowerCase().trim();
        List<Jogo> encontrados = new ArrayList<>();

        for(String n : jogosMap.keySet()){
            if(n.startsWith(titulo.toLowerCase()) || n.contains(titulo)){
                encontrados.addAll(jogosMap.get(n));
            }
        }
        if(encontrados.isEmpty()){
            throw new JogoNaoEncontradoException("Este jogo não esta no estoque");
        }
        return encontrados;
    }


    @Override
    public void removerJogo(String titulo, String plataforma) throws JogoNaoEncontradoException {
        String chave = titulo.toLowerCase();
        if (!jogosMap.containsKey(chave)) throw new JogoNaoEncontradoException("Jogo inexistente.");

        List<Jogo> lista = jogosMap.get(chave);
        Jogo alvo = null;
        for (Jogo j : lista) {
            if (j.getPlataforma().equalsIgnoreCase(plataforma)) { //garante que o jogo a ser removido é o da plataforma
                alvo = j;
                break;
            }
        }

        if (alvo == null) throw new JogoNaoEncontradoException("Plataforma não encontrada.");

        int qtdRemover = Integer.parseInt(JOptionPane.showInputDialog("Quantas unidades remover? (Disponível: " + alvo.getQuantidade() + ")"));

        if (qtdRemover >= alvo.getQuantidade()) {
            lista.remove(alvo);
        } else {
            alvo.setQuantidade(alvo.getQuantidade() - qtdRemover);
        }

        if (lista.isEmpty()) jogosMap.remove(chave);
    }

    @Override
    public List<Jogo> lancamento(String lancamento) throws JogoNaoEncontradoException {

        List<Jogo> lancamentos = jogosMap.values().stream() // Pega as listas
                .flatMap(List::stream)
                .filter(j -> j.getAnoLancamento().equals(lancamento))
                .toList();

        if (lancamentos.isEmpty()) throw new JogoNaoEncontradoException("Nenhum jogo do ano " + lancamento + " no estoque.");

        return lancamentos;
    }

    public void salvar() throws IOException { gravador.gravar(this.jogosMap); }
    public void recuperar() throws IOException { this.jogosMap = gravador.recuperar(); }
}
