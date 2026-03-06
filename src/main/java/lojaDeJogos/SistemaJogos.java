package lojaDeJogos;

import java.util.Collection;

public interface SistemaJogos {
    void cadastrarJogo(Jogo jogo) throws JogoJaExisteException;
    Collection<Jogo> pesquisarJogo(String titulo) throws JogoNaoEncontradoException;
    void removerJogo(String titulo, String plataforma) throws JogoNaoEncontradoException;
}