package service;

import java.util.ArrayList;
import java.util.List;

import dto.Capacitacion;

public class CapacitacionService {
private List<Capacitacion> capacitacionList = new ArrayList<Capacitacion>();
	
	public CapacitacionService() {
		capacitacionList.add(new Capacitacion(1, 111111,"12/03/2022","12:00", "Quintero", 4, 20));
		capacitacionList.add(new Capacitacion(2, 222222,"12/03/2022","12:00","Quilpue", 5, 13));
		capacitacionList.add(new Capacitacion(3, 333333, "12/03/2022", "12:00","Valparaiso", 6, 23));
	}
	public void agregarCapacitacion(Capacitacion capacitacion) {
        capacitacionList.add(capacitacion);
    }
	
	public List<Capacitacion> findAll(){
		return capacitacionList;	
	}
	
	public Capacitacion findOne(int id) {	
		return capacitacionList.stream().filter(s -> s.getId() == id).findFirst().orElse(null);	
	}
	
	public boolean save(int id, int rut, String dia, String hora, String lugar,
            int duracion, int cantAsistentes) {	
		Capacitacion capacitacion = findOne(id);
		capacitacion.setRut(rut);
		capacitacion.setDia(dia);
		capacitacion.setHora(hora);
		capacitacion.setLugar(lugar);
		capacitacion.setDuracion(duracion);
		capacitacion.setCantAsistentes(cantAsistentes);
		return true;	
	}
}
