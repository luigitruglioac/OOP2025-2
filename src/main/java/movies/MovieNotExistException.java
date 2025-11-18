package movies;

public class MovieNotExistException extends RuntimeException {
    public MovieNotExistException(String message) {
        super(message);
    }
}
