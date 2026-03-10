package CatalogoDeJogos;

public class TestaLoja {
    public static void main(String[] args) {
        LojaGerente loja = new LojaGerente();
        try {
            loja.cadastrarJogo(new Jogo("Majin", "Adventure", "Xbox360", 360));
            System.out.println("Pesquisa: " + loja.pesquisarJogo("Majin"));
            loja.salvar();
            System.out.println("Dados salvos com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}