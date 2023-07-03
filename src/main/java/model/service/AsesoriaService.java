package model.service;
import model.dto.*;
import model.implementacionDao.AsesoriaDAO;

import java.util.List;


public class AsesoriaService {
	private AsesoriaDAO asesoriaDao = new AsesoriaDAO();
	
	public List<Asesoria> findAll(){
		return asesoriaDao.read();
	}
	
	public Asesoria findOne(int id) {
		return asesoriaDao.read(id);
	}
	
	public void create(Asesoria a) {
		asesoriaDao.create(a);
	}
	
	public void update(Asesoria a) {
		asesoriaDao.update(a);
	}
	
	public void delete(int id) {
		asesoriaDao.delete(id);
	}
}
