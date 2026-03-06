package livraria;

import javax.xml.crypto.Data;
import java.util.Objects;

public class DataSimples {
    private int dia;
    private int mes;
    private int ano;

    public DataSimples(int dia, int mes, int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    @Override
    public String toString(){
        return String.format("dia:" + dia + "mes: " + mes + "ano: " + ano);

    }

    @Override
    public int hashCode() {
        return Objects.hash(dia, mes, ano);
    }

    @Override
    public boolean equals(Object o){
        if(o == null  || getClass() != o.getClass()) return false;
        DataSimples data = (DataSimples) o;
        return Objects.equals(dia, data.dia) && Objects.equals(mes, data.mes) && Objects.equals(ano, data.ano);
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
