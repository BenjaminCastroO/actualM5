package model.service;
import model.dto.*;
import model.implementacionDao.ProfesionalDAO;

import java.util.List;


public class ProfesionalService {
	private ProfesionalDAO profesionalDao = new ProfesionalDAO();
	
	public List<Profesional> findAll(){
		return profesionalDao.read();
	}
	
	public Profesional findOne(int id) {
		return profesionalDao.read(id);
	}
	
	public void create(Profesional p) {
		profesionalDao.create(p);
	}
	
	public void update(Profesional p) {
		profesionalDao.update(p);
	}
	
	public void delete(int id) {
		profesionalDao.delete(id);
	}
}
