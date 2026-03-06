package livraria;

import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class testaCadastroEPesquisaDeVendas{
    @Test
    public void testaCadastroEPesquisaDeVendas(){
        MeuSistemaVendasLivraria sistema = new MeuSistemaVendasLivraria();
        try {
            sistema.cadastrarLivro("L001", "Eu, Robô", CategoriaLivro.FICCAO_CIENTIFICA);
            sistema.cadastrarLivro("L002", "Java para iniciantes", CategoriaLivro.TECNICO);
            sistema.cadastrarVenda("V001", "L001", new DataSimples(23, 4, 2025), 50, 10);

            sistema.cadastrarVenda("L090", "L001", new DataSimples(24, 4, 2025), 60,2);
            Collection<Vendas> vendasL001 = sistema.pesquisarVendasDoLivro("L001");
            double valorT = sistema.calculaValorTotalDasVendas();

            assertEquals(2, vendasL001.size());
            assertEquals(600, valorT);



        } catch (LivroJaExisteException | VendaJaExisteException | LivroInexistenteException e){
            fail("não deveria lançar exceção");
        }
    }



}
