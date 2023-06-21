package dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import java.time.format.DateTimeParseException;


public class Capacitacion {
  private int id;
  private int rut;
  private String dia;
  private String hora;
  private String lugar;
  private int duracion;
  private int cantAsistentes;
  
public Capacitacion() {
	super();
}

public Capacitacion(int id, int rut, String dia, String hora, String lugar, int duracion, int cantAsistentes) {
	super();
	this.id = id;
	this.rut = rut;
	this.dia = dia;
	this.hora = hora;
	this.lugar = lugar;
	this.duracion = duracion;
	this.cantAsistentes = cantAsistentes;
}

public Capacitacion(int id2, int rut2, String lugar2, int cantAsistentes2) {
	// TODO Auto-generated constructor stub
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
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
	this.dia = dia;
}

public String getHora() {
	return hora;
}

public void setHora(String hora) {
	this.hora = hora;
}

public String getLugar() {
	return lugar;
}

public void setLugar(String lugar) {
	this.lugar = lugar;
}

public int getDuracion() {
	return duracion;
}

public void setDuracion(int duracion) {
	this.duracion = duracion;
}

public int getCantAsistentes() {
	return cantAsistentes;
}

public void setCantAsistentes(int cantAsistentes) {
	this.cantAsistentes = cantAsistentes;
}


 
}
