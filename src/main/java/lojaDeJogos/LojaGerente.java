package lojaDeJogos;

import java.util.*;
import java.io.IOException;

public class LojaGerente implements SistemaJogos {
    private Map<String, List<Jogo>> jogosMap = new HashMap<>();
    private GravadorDeDados gravador = new GravadorDeDados();

    @Override
    public void cadastrarJogo(Jogo jogo) throws JogoJaExisteException {
        String chave = jogo.getTitulo().toLowerCase();
        jogosMap.putIfAbsent(chave, new ArrayList<>());

        List<Jogo> lista = jogosMap.get(chave);
        for (Jogo j : lista) {
            if (j.getPlataforma().equalsIgnoreCase(jogo.getPlataforma())) {
                throw new JogoJaExisteException("Jogo já cadastrado nesta plataforma.");
            }
        }
        lista.add(jogo);
    }

    @Override
    public Collection<Jogo> pesquisarJogo(String titulo) throws JogoNaoEncontradoException {
        List<Jogo> encontrados = jogosMap.get(titulo.toLowerCase());
        if (encontrados == null || encontrados.isEmpty()) {
            throw new JogoNaoEncontradoException("Jogo não encontrado.");
        }
        return encontrados;
    }

    @Override
    public void removerJogo(String titulo, String plataforma) throws JogoNaoEncontradoException {
        String chave = titulo.toLowerCase();
        if (!jogosMap.containsKey(chave)) throw new JogoNaoEncontradoException("Título inexistente.");

        boolean removido = jogosMap.get(chave).removeIf(j -> j.getPlataforma().equalsIgnoreCase(plataforma));
        if (!removido) throw new JogoNaoEncontradoException("Plataforma não encontrada para este jogo.");

        if (jogosMap.get(chave).isEmpty()) jogosMap.remove(chave);
    }

    public void salvar() throws IOException { gravador.gravar(this.jogosMap); }
    public void recuperar() throws IOException { this.jogosMap = gravador.recuperar(); }
}
