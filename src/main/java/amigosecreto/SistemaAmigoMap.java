package amigosecreto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaAmigoMap {

    private List<Mensagem> mensagens;
    private Map<String, Amigo> amigos;

    public SistemaAmigoMap() {
        this.mensagens = new ArrayList<>();
        this.amigos = new HashMap<>();
    }

    public void cadastraAmigo(String nome, String email) throws AmigoJaExisteException {
        if (this.amigos.containsKey(email)) {
            throw new AmigoJaExisteException("Amigo já existe: " + email);
        }
        Amigo novoAmigo = new Amigo(nome, email);
        this.amigos.put(email, novoAmigo);
    }

    public Amigo pesquisaAmigo(String email) throws AmigoInexistenteException {
        Amigo a = this.amigos.get(email);
        if (a == null) {
            throw new AmigoInexistenteException("Amigo não encontrado: " + email);
        }
        return a;
    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean ehAnonima) {
        MensagemParaTodos msg = new MensagemParaTodos(texto, emailRemetente, ehAnonima);
        this.mensagens.add(msg);
    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean ehAnonima) {
        MensagemParaAlguem msg = new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, ehAnonima);
        this.mensagens.add(msg);
    }

    public List<Mensagem> pesquisaMensagensAnonimas() {
        List<Mensagem> anonimas = new ArrayList<>();
        for (Mensagem m : this.mensagens) {
            if (m.ehAnonima()) {
                anonimas.add(m);
            }
        }
        return anonimas;
    }

    public List<Mensagem> pesquisaTodasAsMensagens() {
        return this.mensagens;
    }

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException {
        Amigo pessoa = pesquisaAmigo(emailDaPessoa);
        if (!this.amigos.containsKey(emailAmigoSorteado)) {
            throw new AmigoInexistenteException("Amigo sorteado não existe: " + emailAmigoSorteado);
        }
        pessoa.setEmailAmigoSorteado(emailAmigoSorteado);
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException {
        Amigo pessoa = pesquisaAmigo(emailDaPessoa);
        String sorteado = pessoa.getEmailAmigoSorteado();

        if (sorteado == null) {
            throw new AmigoNaoSorteadoException("Amigo não sorteado para: " + emailDaPessoa);
        }
        return sorteado;
    }
}