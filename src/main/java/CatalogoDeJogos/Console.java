package CatalogoDeJogos;

import java.util.Objects;

public class Console {
    String nome, cor, estadoConserva;
    double valor;

    public Console(String nome, String cor, String estadoConserva, double valor){
        this.nome = nome;
        this.cor = cor;
        this.estadoConserva = estadoConserva;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getEstadoConserva() {
        return estadoConserva;
    }

    public void setEstadoConserva(String estadoConserva) {
        this.estadoConserva = estadoConserva;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Console console = (Console) o;
        return Double.compare(valor, console.valor) == 0 && Objects.equals(nome, console.nome) && Objects.equals(cor, console.cor) && Objects.equals(estadoConserva, console.estadoConserva);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cor, estadoConserva, valor);
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " | Cor: " + cor + " | Estado: " + estadoConserva + " | Valor: " + valor;
    }
}
