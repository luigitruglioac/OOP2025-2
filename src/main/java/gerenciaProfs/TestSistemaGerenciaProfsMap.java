package gerenciaProfs;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestSistemaGerenciaProfsMap {
    @Test
    public void TestCadastraProfessor() {
        SistemaGerenciaProfsMap sistema = new SistemaGerenciaProfsMap();

        //  i) Cadastrar o professor chamado “José” de matrícula 111.
        //ii) Consultar disciplinas de José e verificar que a lista está vazia (tamanho=0).
        try {
            sistema.cadastraProfessor(111, "José");
            List<String> disciplinasList = sistema.consultaNomesDisciplinasDoProfessor(111);
            System.out.println(disciplinasList);
            assertTrue(disciplinasList.isEmpty());

        } catch (ProfessorJaExisteException e) {
            fail("ERRO: PROFESSOR JÁ EXISTE");
        }


        //Cadastrar  a  disciplina  “POO”,  de  código  22,  alocada  ao  professor  José,  e  cujas  aulas  são  na  TERÇA  10-12 e  TERÇA  13-15.

        List<Horario> disciplinaHorarios = new ArrayList<>();
        disciplinaHorarios.add(new Horario(DiaDaSemana.TERÇA,10, 12));
        disciplinaHorarios.add(new Horario(DiaDaSemana.TERÇA,13, 15));

        try{
            sistema.cadastraDisciplina("POO", 22, 111, disciplinaHorarios);

        } catch (DisciplinaJaExisteException e){
            fail("ERRO: DISCIPLINA JÁ CADASTRADA");
        }

        // Consultar disciplinas de José e verificar que a lista tem apenas um elemento, que  é “POO”.
            List<String> discs = sistema.consultaNomesDisciplinasDoProfessor(111);
            assertEquals("POO",discs.get(0));


        // vi) Consultar horários de José e verificar se sua lista de horários está correta e tem os horarios de POO



        try{
            List<Horario> horarios = sistema.consultaHorariosDeAulaDoProfessor(111);
            assertEquals(2,horarios.size());

            assertEquals(disciplinaHorarios, horarios);


        } catch(ProfessorInexistenteException e){
            fail("ERRO: PROFESSOR NÃO CADASTRADO");
        }




    }


}
