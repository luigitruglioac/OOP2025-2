package livraria;

import java.util.*;

public class MeuSistemaVendasLivraria implements SistemaVendasLivraria{

    private Map<String, Livros> livrosMap;
    private Map<String, Vendas> vendasMap;

    public MeuSistemaVendasLivraria(){
        this.livrosMap = new HashMap<>();
        this.vendasMap = new HashMap<>();
    }

    public void cadastrarLivro(String codigoLivro, String tituloLivro, CategoriaLivro categoria) throws LivroJaExisteException{
        if(livrosMap.containsKey(codigoLivro)){
            throw new LivroJaExisteException("Livro já registrado");
        }

        Livros novoLivro = new Livros(codigoLivro, tituloLivro, categoria);
        this.livrosMap.put(codigoLivro, novoLivro);
    }

    public void cadastrarVenda(String codigoVenda, String codigoLivro, DataSimples dataVenda,
                               double precoUnitario, int quantUnidades) throws VendaJaExisteException, LivroInexistenteException{
        if(vendasMap.containsKey(codigoVenda)){
            throw new VendaJaExisteException("venda já existe");
        }
        if (!livrosMap.containsKey(codigoLivro)){
            throw new LivroInexistenteException("livro inexistente");
        }
        Vendas novaVenda = new Vendas(codigoVenda, codigoLivro, dataVenda, precoUnitario, quantUnidades);
        this.vendasMap.put(codigoVenda, novaVenda);
    }

    public Vendas pesquisarVenda(String codigoVenda) throws VendaInexistenteException{
        if(!vendasMap.containsKey(codigoVenda)){
            throw new VendaInexistenteException("Venda inexistente");
        }
        return this.vendasMap.get(codigoVenda);
    }

    public Collection<Vendas> pesquisarVendasDoDia(DataSimples dataVenda){
        Collection<Vendas> vendasDoDia = new ArrayList<>();
        for(Vendas v : this.vendasMap.values()){
            if(v.getDataVenda().equals(dataVenda)){
                vendasDoDia.add(v);
            }
        }
        return vendasDoDia;
    }

    public Collection<Vendas> pesquisarVendasDoLivro(String codigoLivro) throws LivroInexistenteException{
        Collection<Vendas> vendasLivro = new ArrayList<>();

        if(!this.livrosMap.containsKey(codigoLivro)){
            throw new LivroInexistenteException("Livro inexistente");
        }
        for(Vendas vl : this.vendasMap.values()){
            if(vl.getCodigoLivro().equals(codigoLivro)) {
                vendasLivro.add(vl);
            }
        }
        return vendasLivro;
    }

    public double calculaValorTotalDasVendas(){
        double valorTotal=0;
        for(Vendas v : this.vendasMap.values()){
            valorTotal += v.getPrecoUnitario() * v.getQuantUnidades();
        }
        return valorTotal;
    }

    public double calculaValorTotalDasVendasDoLivro(String codigoLivro) throws LivroInexistenteException{
        if(!this.livrosMap.containsKey(codigoLivro)){
            throw new LivroInexistenteException("Livro inexistente");
        }
        double valorTotalLivro=0;
        for(Vendas v : this.vendasMap.values()){
            if(v.getCodigoLivro().equals(codigoLivro)){
                valorTotalLivro += v.getPrecoUnitario() * v.getQuantUnidades();
            }
        }
        return valorTotalLivro;
    }










}
