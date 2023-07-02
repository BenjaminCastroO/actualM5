package model.service;
import model.dto.*;
import model.implementacionDao.VisitaDAO;

import java.util.List;


public class VisitaService {
	private VisitaDAO visitaDao = new VisitaDAO();
	
	public List<Visita> findAll(){
		return visitaDao.read();
	}
	
	public Visita findOne(int id) {
		return visitaDao.read(id);
	}
	
	public void create(Visita v) {
		visitaDao.create(v);
	}
	
	public void update(Visita v) {
		visitaDao.update(v);
	}
	
	public void delete(int id) {
		visitaDao.delete(id);
	}
}
