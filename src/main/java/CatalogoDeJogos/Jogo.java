package CatalogoDeJogos;

import java.io.Serializable;

public class Jogo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String titulo, genero, plataforma, anoLancamento;
    private double valor;
    private int quantidade;

    public Jogo(String titulo, String genero, String plataforma, double valor, int quantidade, String anoLancamento) {
        this.titulo = titulo;
        this.genero = genero;
        this.plataforma = plataforma;
        this.valor = valor;
        this.quantidade = quantidade;
        this.anoLancamento = anoLancamento;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public int getQuantidade(){
        return quantidade;
    }

    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getGenero() {
        return genero;
    }
    public String getPlataforma() {
        return plataforma;
    }
    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + " | Gênero: " + genero + " | Plataforma: " + plataforma + " | Valor: " + valor + " | Quantidade: " + quantidade+ " | Lançamento: " + anoLancamento;
    }
}