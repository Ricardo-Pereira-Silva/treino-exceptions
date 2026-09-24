package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
    private Integer numeroQuarto;
    private Date  entrada;
    private Date saida;

    public Reserva(Integer numeroQuarto, Date entrada, Date saida) {
        this.numeroQuarto = numeroQuarto;
        this.entrada = entrada;
        this.saida = saida;
    }

    public static SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public Date getEntrada() {
        return entrada;
    }

    public Date getSaida() {
        return saida;
    }

    public long diarias() {

        long diferenca = saida.getTime() - entrada.getTime();
        return TimeUnit.DAYS.convert(diferenca,TimeUnit.MILLISECONDS);
    }

    public void atualizaDados(Date chegada, Date partida) {

        this.entrada = chegada;
        this.saida = partida;
    }

    @Override
    public String toString() {
        return  "Suite "
                +numeroQuarto
                +", chegada: "
                +formataData.format(entrada)
                +", partida: "
                +formataData.format(saida)
                +", "
                +diarias()
                +" diarias";
    }
}
