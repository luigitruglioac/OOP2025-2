package gerenciaProfs;

public class ProfessorInexistenteException extends Exception {
    public ProfessorInexistenteException(String mensagem){
        super(mensagem);
    }
}
