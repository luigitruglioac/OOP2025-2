package gerenciaProfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaGerenciaProfsMap implements SistemaGerenciaProfs {
    private Map<Integer, Professor> professoresMap;
    private Map<Integer, Disciplina> disciplinasMap;

    public SistemaGerenciaProfsMap() {
        this.professoresMap = new HashMap<>();
        this.disciplinasMap = new HashMap<>();
    }

    @Override
    public void cadastraProfessor(int matriculaProf, String nome) throws ProfessorJaExisteException {
        // Verifica se já existe
        if (this.professoresMap.containsKey(matriculaProf)) {
            throw new ProfessorJaExisteException("ERRO: PROFESSOR JÁ CADASTRADO");
        }
        Professor novoProf = new Professor(nome, matriculaProf);
        this.professoresMap.put(matriculaProf, novoProf);
    }

    @Override
    public void cadastraDisciplina(String nomeDisciplina, int codigoDisciplina, int matriculaProfessor, List<Horario> horarios) throws DisciplinaJaExisteException {
        if (this.disciplinasMap.containsKey(codigoDisciplina)) {
            throw new DisciplinaJaExisteException("ERRO: DISCIPLINA JÁ CADASTRADA");
        }
        Disciplina novaDisciplina = new Disciplina(nomeDisciplina, codigoDisciplina, matriculaProfessor, horarios);
        this.disciplinasMap.put(codigoDisciplina, novaDisciplina);
    }

    @Override
    public List<String> consultaNomesDisciplinasDoProfessor(int matriculaProf) {
        List<String> nomesDisciplinas = new ArrayList<>();

        for (Disciplina d : this.disciplinasMap.values()) {
            if (d.getMatriculaProf() == matriculaProf) {
                nomesDisciplinas.add(d.getNome());
            }
        }
        return nomesDisciplinas;
    }

    @Override
    public List<Horario> consultaHorariosDeAulaDoProfessor(int matriculaProf) throws ProfessorInexistenteException {
        if (!this.professoresMap.containsKey(matriculaProf)) {
            throw new ProfessorInexistenteException("ERRO: PROFESSOR NÃO CADASTRADO");
        }

        List<Horario> horariosAula = new ArrayList<>();
        for (Disciplina d : this.disciplinasMap.values()) {
            if (d.getMatriculaProf() == matriculaProf) {
                horariosAula.addAll(d.getHorarios());
            }
        }
        return horariosAula;
    }

    @Override
    public Disciplina pesquisaDisciplina(int codigoDisciplina) throws DisciplinaInexistenteException {
        if (!this.disciplinasMap.containsKey(codigoDisciplina)) {
            throw new DisciplinaInexistenteException("ERRO: A DISCIPLINA NÃO EXISTE");
        }
        return this.disciplinasMap.get(codigoDisciplina);
    }

    @Override
    public Professor pesquisaProfessor(int matriculaProfessor) throws ProfessorInexistenteException {
        if (!this.professoresMap.containsKey(matriculaProfessor)) {
            throw new ProfessorInexistenteException("ERRO: PROFESSOR NÃO EXISTE");
        }
        return this.professoresMap.get(matriculaProfessor);
    }
}