package livraria;

public class LivroInexistenteException extends RuntimeException {
    public LivroInexistenteException(String message) {
        super(message);
    }
}
