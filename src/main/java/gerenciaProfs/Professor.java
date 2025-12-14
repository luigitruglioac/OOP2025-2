package gerenciaProfs;

public class Professor {
    private String nome;
    private int matricula;

    public Professor(String nome, int matricula){
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public int getMatricula() {
        return matricula;
    }
}
