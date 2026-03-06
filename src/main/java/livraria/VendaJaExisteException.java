package livraria;

public class VendaJaExisteException extends RuntimeException {
    public VendaJaExisteException(String message) {
        super(message);
    }
}
