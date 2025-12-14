package gerenciaProfs;

public class Horario {
    private int horaInicio;
    private int horaFim;
    private DiaDaSemana dia;

    public Horario(DiaDaSemana dia, int horaInicio, int horaFim){
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public int getHoraFim() {
        return horaFim;
    }

    public DiaDaSemana getDia(){
        return this.dia;
    }
}