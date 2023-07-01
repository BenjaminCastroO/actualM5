package model.service;
import model.dto.*;
import model.implementacionDao.CapacitacionDAO;

import java.util.List;


public class CapacitacionService {
	private CapacitacionDAO capacitaciondao = new CapacitacionDAO();
	
	public List<Capacitacion> findAll(){
		return capacitaciondao.read();
	}
	
	public Capacitacion findOne(int id) {
		return capacitaciondao.read(id);
	}
	
	public void create(Capacitacion c) {
		capacitaciondao.create(c);
	}
	
	public void update(Capacitacion c) {
		capacitaciondao.update(c);
	}
	
	public void delete(int id) {
		capacitaciondao.delete(id);
	}
}
