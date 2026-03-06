package revisaoUnidade2;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class SistemaAtrativosMapTest {

    @Test
    public void test() {
        // CORREÇÃO: O nome da classe deve ser SistemaAtrativoMap (singular)
        SistemaAtrativoMap sistema = new SistemaAtrativoMap();

        String descricao = "Praia em João Pessoa com vários bares, restaurantes e hoteis";
        AtrativoTuristico atrativo1 = new AtrativoTuristico("Praia de Manaíra",
                descricao, TipoAtrativo.PRAIA, new ArrayList<>());

        String urlEsperada = "https://paraondeir.blog/praia-de-manaira/";
        atrativo1.adicionaSiteMaisInfo(urlEsperada);

        try {
            sistema.cadastraAtrativo(atrativo1);

            AtrativoTuristico atrativoAchado = sistema.pesquisaAtrativo("Praia de Manaíra");

            assertEquals(descricao, atrativoAchado.getDescricao());
            assertTrue(atrativoAchado.getSitesParaMaisInfo().contains(urlEsperada));

        } catch (AtrativoException e) {
            fail("Não deveria lançar exceção aqui: " + e.getMessage());
        }

        int contagemPraia = sistema.contaAtrativosDoTipo(TipoAtrativo.PRAIA);
        int contagemMuseu = sistema.contaAtrativosDoTipo(TipoAtrativo.MUSEU);

        assertEquals(0, contagemMuseu);
        assertEquals(1, contagemPraia);
    }
}