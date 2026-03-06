package livraria;

import java.util.Objects;

public class Livros {

    private String codigo;
    private String titulo;
    private CategoriaLivro categoria;

    public Livros(String codigo, String titulo, CategoriaLivro categoria) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public CategoriaLivro getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaLivro categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Livros livros = (Livros) o;
        return Objects.equals(codigo, livros.codigo) && Objects.equals(titulo, livros.titulo) && Objects.equals(categoria, livros.categoria);
    }

    public String toString() {
        return String.format("código: " + codigo + " titulo: " + titulo + " categoria: ");
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, titulo, categoria);
    }

}

