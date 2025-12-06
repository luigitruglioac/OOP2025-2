package amigosecreto;

import java.util.ArrayList;
import java.util.List;

public class TestaSistemaAmigo {
    public static void main(String[]args) throws AmigoNaoSorteadoException, AmigoInexistenteException {
        SistemaAmigo sistema = new SistemaAmigo();

        try{
            sistema.cadastraAmigo("Luíza", "lulu@metallica.com");
            sistema.cadastraAmigo("Luigi", "luigibahia@uol.com");
            System.out.println("Operação realizada com sucesso!");

        } catch (AmigoJaExisteException e){
            System.out.println("Erro no cadastro" + e.getMessage());
        }

        try{
            sistema.configuraAmigoSecretoDe("lulu@metallica.com","luigibahia@uol.com");
            sistema.configuraAmigoSecretoDe("luigibahia@uol.com","lulu@metallica.com");

        } catch(AmigoInexistenteException e){
            System.out.println("Erro ao configurar" + e.getMessage());
        }

        sistema.enviarMensagemParaAlguem("-.-","lulu@metallica.com","luigibahia@uol.com",true);
        sistema.enviarMensagemParaTodos("...","lulu@metallica.com",true);

        List<Mensagem> anm = sistema.pesquisaMensagensAnonimas();
        for(Mensagem m : anm){
            System.out.println(m.getTextoCompletoAExibir());
        }
        try{
            String search = sistema.pesquisaAmigoSecretoDe("luigibahia@uol.com");
            if (search.equals("lulu@metallica.com")){
                System.out.println("Ok");
            }
        } catch (AmigoInexistenteException | AmigoNaoSorteadoException e){
            System.out.println("Erro:" + e.getMessage());
        }









    }
}
