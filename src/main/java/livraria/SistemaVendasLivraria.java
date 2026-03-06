package livraria;
import java.util.Collection;
public interface SistemaVendasLivraria {
    public Vendas pesquisarVenda(String codigoVenda) throws VendaInexistenteException;

    public void cadastrarLivro(String codigoLivro, String tituloLivro,
                               CategoriaLivro categoria) throws LivroJaExisteException;

    public void cadastrarVenda(String codigoVenda, String codigoLivro,
                               DataSimples dataVenda, double precoUnitario, int quantUnidades)
            throws VendaJaExisteException, LivroInexistenteException;

    public Collection<Vendas> pesquisarVendasDoDia(DataSimples dataVenda);

    public Collection<Vendas> pesquisarVendasDoLivro(String codigoLivro)
            throws LivroInexistenteException;

    public double calculaValorTotalDasVendas();

    public double calculaValorTotalDasVendasDoLivro(String codigoLivro)
            throws LivroInexistenteException;
}