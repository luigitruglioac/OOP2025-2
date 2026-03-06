package livraria;

import java.util.Objects;

public class Vendas {
    private String codigoVenda;
    private String codigoLivro;
    private DataSimples dataVenda;
    private double precoUnitario;
    private int quantUnidades;


    public Vendas(String codigoVenda, String codigoLivro, DataSimples dataVenda, double precoUnitario, int quantUnidades) {
        this.codigoVenda = codigoVenda;
        this.codigoLivro = codigoLivro;
        this.dataVenda = dataVenda;
        this.precoUnitario = precoUnitario;
        this.quantUnidades = quantUnidades;
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vendas vendas = (Vendas) o;
        return Double.compare(precoUnitario, vendas.precoUnitario) == 0 && quantUnidades == vendas.quantUnidades && Objects.equals(codigoVenda, vendas.codigoVenda) && Objects.equals(codigoLivro, vendas.codigoLivro) && Objects.equals(dataVenda, vendas.dataVenda);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoVenda, codigoLivro, dataVenda, precoUnitario, quantUnidades);
    }

    public String toString(){
        return String.format("codigo livro" + codigoLivro + "codigo venda: " + codigoVenda + "data venda: " +dataVenda + "preco unitario: " + precoUnitario + "quantidade de unidades: " + quantUnidades);
    }

    public String getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(String codigoVenda) {
        this.codigoVenda = codigoVenda;
    }

    public String getCodigoLivro() {
        return codigoLivro;
    }

    public void setCodigoLivro(String codigoLivro) {
        this.codigoLivro = codigoLivro;
    }

    public DataSimples getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(DataSimples dataVenda) {
        this.dataVenda = dataVenda;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public int getQuantUnidades() {
        return quantUnidades;
    }

    public void setQuantUnidades(int quantUnidades) {
        this.quantUnidades = quantUnidades;
    }
}

