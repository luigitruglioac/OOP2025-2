package lojaDeJogos;

import java.io.Serializable;

public class Jogo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String titulo;
    private String genero;
    private String plataforma;

    public Jogo(String titulo, String genero, String plataforma) {
        this.titulo = titulo;
        this.genero = genero;
        this.plataforma = plataforma;
    }

    public String getTitulo() { return titulo; }
    public String getGenero() { return genero; }
    public String getPlataforma() { return plataforma; }

    @Override
    public String toString() {
        return "Título: " + titulo + " | Gênero: " + genero + " | Plataforma: " + plataforma;
    }
}