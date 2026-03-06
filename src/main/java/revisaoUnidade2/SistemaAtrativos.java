package revisaoUnidade2;

import java.util.List;
public interface SistemaAtrativos {
    void cadastraAtrativo(AtrativoTuristico atrativo) throws AtrativoException;

    AtrativoTuristico pesquisaAtrativo(String nome) throws AtrativoException;

    List<AtrativoTuristico> pesquisaAtrativosDoTipo(TipoAtrativo tipo);

    List<String> pesquisaSitesComMaisInformacoesSobreAtrativo(String nomeAtrativo) throws AtrativoException;

    int contaAtrativosDoTipo(TipoAtrativo tipo);

    boolean existeAtrativo(String nome);
}
