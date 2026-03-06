package revisaoUnidade2;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaAtrativoMap implements SistemaAtrativos {
    private Map<String, AtrativoTuristico> atrativosMap;

    public SistemaAtrativoMap() {
        this.atrativosMap = new HashMap<>();
    }

    @Override
    public void cadastraAtrativo(AtrativoTuristico atrativo) throws AtrativoException {
        if (atrativosMap.containsKey(atrativo.getNome())) {
            throw new AtrativoException("ERRO");
        } else {
            atrativosMap.put(atrativo.getNome(), atrativo);
        }
    }

    @Override
    public AtrativoTuristico pesquisaAtrativo(String nome) throws AtrativoException {
        if(atrativosMap.get(nome) == null){
            throw new AtrativoException("ERRO: ATRATIVO NAO EXISTE");
        }
        return atrativosMap.get(nome);
    }

    @Override
    public List<AtrativoTuristico> pesquisaAtrativosDoTipo(TipoAtrativo tipo) {
        List<AtrativoTuristico> atrativoTipo = new ArrayList<>();

        for(AtrativoTuristico a : atrativosMap.values()){
            if(a.ehDoTipo(tipo)){
                atrativoTipo.add(a);
            }

        }
        return atrativoTipo;
    }

    @Override
    public List<String> pesquisaSitesComMaisInformacoesSobreAtrativo(String nomeAtrativo) throws AtrativoException{
        List<String> pesquisaSite = new ArrayList<>();
        AtrativoTuristico skp = atrativosMap.get(nomeAtrativo);
        if(skp== null){
            throw new AtrativoException("ERRO: ATRATIVO NÃO EXISTE");
        }
        return skp.getSitesParaMaisInfo();
    }


    public int contaAtrativosDoTipo(TipoAtrativo tipo){
        int contador = 0;
        for(AtrativoTuristico lz : atrativosMap.values()){
            if(lz.ehDoTipo(tipo)){
                contador++;
            }
        }
        return contador;

    }

    public boolean existeAtrativo(String nome){
        if(atrativosMap.containsKey(nome)){
            return true;
        }
        return false;
    }

}
