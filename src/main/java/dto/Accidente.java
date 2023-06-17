package dto;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Accidente {
    private int idAccidente;
    private int rut;
    private String dia;
    private String hora;
    private String lugar;
    private String origen;
    private String consecuencias;

    public Accidente() {
    }

    public Accidente(int idAccidente, int rut, String dia, String hora, String lugar, String origen, String consecuencias) {
        setIdAccidente(idAccidente);
        this.rut = rut;
        setDia(dia);
        setHora(hora);
        setLugar(lugar);
        setOrigen(origen);
        setConsecuencias(consecuencias);
    }


    public int getIdAccidente() {
        return idAccidente;
    }

    public void setIdAccidente(int idAccidente) {
        if (idAccidente < 0)
            throw new IllegalArgumentException("El id interno del Accidente " +
                    "debe ser mayor a cero.");
        this.idAccidente = idAccidente;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);  // no permite fechas inválidas
        try {
            this.dia = String.valueOf((Date) dateFormat.parse(dia));
        } catch (ParseException e) {
            throw new IllegalArgumentException("La fecha de nacimiento debe estar en el formato DD/MM/AAAA.");
        }


    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        DateTimeFormatter tiempo = DateTimeFormatter.ofPattern("HH:mm");
        try {
            this.hora = String.valueOf((LocalTime) tiempo.parse(hora));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("La Hora debe estar ingresada en el " +
                    "formato HH:mm ");
        }
    }

    public String getLugar() {

        return lugar;
    }

    public void setLugar(String lugar) {
        if (!(lugar.length() >= 10 && lugar.length() <= 50))
            throw new IllegalArgumentException("El lugar ingresado debe tener " +
                    "como mínimo 10 caracteres y 50 como máximo. Ingrese de nuevo.");

        this.lugar = lugar;
    }

    public String getOrigen() {

        return origen;
    }

    public void setOrigen(String origen) {
        if (!(origen.length()  <= 100))
            throw new IllegalArgumentException("El Origen Ingresado debe tener " +
                    "como máximo 100 caracteres. Ingrese de nuevo.");
        this.origen = origen;
    }

    public String getConsecuencias() {
        return consecuencias;
    }

    public void setConsecuencias(String consecuencias) {
        if (!(consecuencias.length()  <= 100))
            throw new IllegalArgumentException("La(s) Consecuencia(s) Ingresada debe tener " +
                    "como máximo 100 caracteres. Ingrese de nuevo.");
        this.consecuencias = consecuencias;
    }

    @Override
    public String toString() {
        return "Accidente{" +
                "idAccidente=" + idAccidente +
                ", rut=" + rut +
                ", dia='" + dia + '\'' +
                ", hora='" + hora + '\'' +
                ", lugar='" + lugar + '\'' +
                ", origen='" + origen + '\'' +
                ", consecuencias='" + consecuencias + '\'' +
                '}';
    }
}
