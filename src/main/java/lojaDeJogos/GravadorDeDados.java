package lojaDeJogos;

import java.io.*;
import java.util.*;

public class GravadorDeDados {
    private String arquivo = "jogos.dat";

    public void gravar(Map<String, List<Jogo>> dados) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(dados);
        }
    }

    @SuppressWarnings("unchecked")
    public Map<String, List<Jogo>> recuperar() throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (Map<String, List<Jogo>>) ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new IOException("Erro ao ler dados.", e);
        }
    }
}
