package livraria;

public class VendaInexistenteException extends RuntimeException {
    public VendaInexistenteException(String message) {
        super(message);
    }
}
