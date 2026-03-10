package CatalogoDeJogos;

public class JogoJaExisteException extends RuntimeException {
    public JogoJaExisteException(String message) {
        super(message);
    }
}
