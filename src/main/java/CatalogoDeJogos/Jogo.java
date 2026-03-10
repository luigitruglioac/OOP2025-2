package CatalogoDeJogos;

import java.io.Serializable;

public class Jogo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String titulo;
    private String genero;
    private String plataforma;
    private double valor;

    public Jogo(String titulo, String genero, String plataforma, double valor) {
        this.titulo = titulo;
        this.genero = genero;
        this.plataforma = plataforma;
        this.valor = valor;
    }

    public String getTitulo() { return titulo; }
    public String getGenero() { return genero; }
    public String getPlataforma() { return plataforma;}
    public double getValor() { return valor;}

    @Override
    public String toString() {
        return "Título: " + titulo + " | Gênero: " + genero + " | Plataforma: " + plataforma + " | Valor: " + valor;
    }
}