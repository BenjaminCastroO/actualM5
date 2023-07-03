package model.service;
import model.dto.*;
import model.implementacionDao.AsistenteDAO;

import java.util.List;


public class AsistenteService {
	private AsistenteDAO asistenteDao = new AsistenteDAO();
	
	public List<Asistente> findAll(){
		return asistenteDao.read();
	}
	
	public Asistente findOne(int id) {
		return asistenteDao.read(id);
	}
	
	public void create(Asistente a) {
		asistenteDao.create(a);
	}
	
	public void update(Asistente a) {
		asistenteDao.update(a);
	}
	
	public void delete(int id) {
		asistenteDao.delete(id);
	}
}
